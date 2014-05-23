package gen.example;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.mapreduce.TaskAttemptID;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.junit.Test;

import parquet.hadoop.ParquetReader;
import parquet.hadoop.metadata.CompressionCodecName;
import parquet.hadoop.thrift.ThriftReadSupport;
import parquet.hadoop.thrift.ThriftToParquetFileWriter;
import parquet.hadoop.util.ContextUtil;
import parquet.thrift.SkippableException;
import parquet.thrift.ThriftParquetWriter;

public class TestThriftParquet {
	private ParquetReader<Object> pr;
	Configuration conf = new Configuration();
	Path fileToCreate = new Path("target/emp.parquet");

	/*
	 * The following test allows writing a standard Thrift Object into
	 * ParquetFile.
	 */
	@Test
	public void SimpleThriftWrite() throws IOException, InterruptedException,
			TException, SkippableException {
		// Creating object for thrift generated java file
		Employee emp = new Employee();

		// Add the values to the emp Employee object
		emp.setId("1");
		emp.setName("Ankit");
		emp.setAddress("Munich, Deutschland");
		emp.setPhoneNumber("11111111");

		FileSystem fs = fileToCreate.getFileSystem(conf);
		if (fs.exists(fileToCreate)) {
			fs.delete(fileToCreate, true);
		}

		Class<Employee> BaseClass = (Class<Employee>) emp.getClass();
		ThriftParquetWriter<Employee> thriftParquetWriter = new ThriftParquetWriter<Employee>(
				fileToCreate, BaseClass, CompressionCodecName.UNCOMPRESSED);
		thriftParquetWriter.write(emp);
		thriftParquetWriter.close();

	}

	/*
	 * The following test allows writing a Thrift serialized Object into
	 * ParquetFile.
	 */
	@Test
	public void serializedThriftWrite() throws IOException,
			InterruptedException, TException, SkippableException {

		// Creating object for thrift generated java file
		Employee employeeSerialized = new Employee();

		// Add the values to the emp Employee object
		employeeSerialized.setId("2");
		employeeSerialized.setName("SampleName");
		employeeSerialized.setAddress("India");
		employeeSerialized.setPhoneNumber("222222222");

		// THRIFT SERIALIZED OBJECT
		TSerializer serializer = new TSerializer();
		byte[] employeeSerializedByte = serializer
				.serialize(employeeSerialized);

		// deserialize(employeeSerializedByte);
		Path fileToCreate = new Path("target/emp_serialized.parquet");

		FileSystem fs = fileToCreate.getFileSystem(conf);
		if (fs.exists(fileToCreate)) {
			fs.delete(fileToCreate, true);
		}
		TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
		TaskAttemptID taskId = new TaskAttemptID("local", 0, true, 0, 0);

		// Writing a Thrift serialized object to Parquet.
		// Note: ThriftToParquetFileWriter is the way to go if the thrift is
		// already coming in the form of bytes
		ThriftToParquetFileWriter serializedTPWriteObject = new ThriftToParquetFileWriter(
				fileToCreate, ContextUtil.newTaskAttemptContext(conf, taskId),
				protocolFactory, employeeSerialized.getClass());

		BytesWritable byteWritableObject = new BytesWritable(
				employeeSerializedByte);
		serializedTPWriteObject.write(byteWritableObject);
		serializedTPWriteObject.close();
		System.out.println("FILE WRITE FINISHED");

	}

	/* Reading a Parquet File */
	@Test
	public void readParquet() throws IOException, TException,
			SkippableException {
		Path fileToCreate = new Path("target/emp_serialized.parquet");
		// Test to check the file was written to Parquet. FileSystem
		FileSystem fileSystem = fileToCreate.getFileSystem(conf);
		boolean exists = fileSystem.exists(fileToCreate);
		assertEquals(exists, true);
		read(fileToCreate);
	}

	private void deserialize(byte[] empDtl) throws TException {
		TDeserializer deserializer1 = new TDeserializer();
		Employee empNewObj1 = new Employee();
		deserializer1.deserialize(empNewObj1, empDtl);
	}

	private void read(Path fileToCreate) throws IOException, TException {
		// Reading back the file just written in Parquet-format
		ThriftReadSupport<Employee> readSupport = new ThriftReadSupport<Employee>(
				Employee.class);
		ParquetReader<Employee> parquetReader = new ParquetReader<Employee>(
				fileToCreate, readSupport);
		Employee employee = parquetReader.read();
		parquetReader.close();
		System.out.println("Read Output: " + employee);
		System.out.println("FILE READ FINISHED");
	}

}
