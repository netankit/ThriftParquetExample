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
import parquet.hadoop.example.GroupReadSupport;
import parquet.hadoop.thrift.ThriftToParquetFileWriter;
import parquet.hadoop.util.ContextUtil;

public class TestThriftParquet {
	private ParquetReader<Object> pr;

	@Test
	public void myTestImplementation() throws IOException,
			InterruptedException, TException {
		// Creating object for thrift generated java file
		Employee emp = new Employee();

		// Add the values to the emp Employee object
		emp.setId("1");
		emp.setName("Ankit");
		emp.setAddress("Munich, Deutschland");
		emp.setPhoneNumber("11111111");

		// To send this across different platforms like DOTNET etc...
		// this object needs to be serialized
		// The serialized thrift object is nothing but a byte array

		byte[] empDtl = null;
		TSerializer serializer = new TSerializer();

		empDtl = serializer.serialize(emp);

		TDeserializer deserializer1 = new TDeserializer();
		Employee empNewObj1 = new Employee();
		// deserializer.deserialize(thrift object, byte array);
		// When you de-serialize the byte array is converted to the
		// thrift object that is passed as a parameter to this method

		deserializer1.deserialize(empNewObj1, empDtl);

		BytesWritable bytesToWrite1 = new BytesWritable(empDtl);

		System.out.println("TEST: Bytes Output:\n" + bytesToWrite1.getBytes());

		System.out.println("TEST: Deserialized Output:\n" + empNewObj1);

		// empDtl : Serialized Thrift Object.

		Configuration conf = new Configuration();
		Path fileToCreate = new Path("target/emp.parquet");
		// Deletes the existing file with the same name if found on the given
		// path in the file system.
		FileSystem fs = fileToCreate.getFileSystem(conf);
		if (fs.exists(fileToCreate)) {
			fs.delete(fileToCreate, true);
		}
		TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
		TaskAttemptID taskId = new TaskAttemptID("local", 0, true, 0, 0);

		// Writing a Thrift serialized object to Parquet.
		// Note: ThriftToParquetFileWriter is the way to go if the thrift is
		// already coming in the form of bytes
		ThriftToParquetFileWriter writeTPObject = new ThriftToParquetFileWriter(
				fileToCreate, ContextUtil.newTaskAttemptContext(conf, taskId),
				protocolFactory, emp.getClass());

		BytesWritable bytesToWrite = new BytesWritable(empDtl);
		System.out.println("BytesToWrite: " + bytesToWrite.getBytes());
		writeTPObject.write(bytesToWrite);
		writeTPObject.close();

		// Test to check the file was written to Parquet.
		FileSystem fileSystem = fileToCreate.getFileSystem(conf);
		boolean exists = fileSystem.exists(fileToCreate);
		assertEquals(exists, true);

		// Reading back the file just written in Parquet-format
		ParquetReader parquetReader = new ParquetReader(fileToCreate,
				new GroupReadSupport());
		Object readObj = parquetReader.read();
		// Parquet File Output.
		String myFileOutput = readObj.toString();
		byte[] output_data = myFileOutput.getBytes();
		System.out.println("\nTEST: File Output (Byte Array):\n" + output_data);
		// Deserializing thrift object
		TDeserializer deserializer = new TDeserializer();
		Employee empNewObj = new Employee();
		// deserializer.deserialize(thrift object, byte array);
		// When you de-serialize the byte array is converted to the
		// thrift object that is passed as a parameter to this method
		deserializer.deserialize(empNewObj, output_data);

		System.out.println("TEST: Deserialized File Output:\n" + empNewObj);
		System.out.println("TEST: End of Output.\n");
		pr.close();

	}

	// @Test
	// public void test() throws Exception {
	//
	// Employee employee = new Employee();
	// employee.setId("1");
	// employee.setName("Ankit");
	// employee.setAddress("Munich, Deutschland");
	// employee.setPhoneNumber("11111111");
	//
	// Configuration conf = new Configuration();
	// Path file = new Path("target/emp.parquet");
	// FileSystem fs = file.getFileSystem(conf);
	// if (fs.exists(file)) {
	// fs.delete(file, true);
	// }
	// TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
	// TaskAttemptID taskId = new TaskAttemptID("local", 0, true, 0, 0);
	//
	// ThriftToParquetFileWriter thriftWriter = new ThriftToParquetFileWriter(
	// file, ContextUtil.newTaskAttemptContext(conf, taskId),
	// protocolFactory, employee.getClass());
	//
	// TSerializer serializer = new TSerializer();
	// byte[] serEmployee = serializer.serialize(employee);
	// BytesWritable bytesWritable = new BytesWritable(serEmployee);
	//
	// System.out.println("bytesWritable = " + bytesWritable);
	//
	// thriftWriter.write(bytesWritable);
	// thriftWriter.close();
	//
	// ParquetReader<Group> parquetReader = new ParquetReader<>(file,
	// new GroupReadSupport());
	// Group group = parquetReader.read();
	//
	// byte[] output_data = group.toString().getBytes();
	// parquetReader.close();
	//
	// TDeserializer deserializer = new TDeserializer();
	// Employee deserEmployee = new Employee();
	// deserializer.deserialize(deserEmployee, output_data);
	//
	// System.out.println("TEST: Deserialized File Output:\n" + deserEmployee);
	// System.out.println("TEST: End of Output.\n");
	//
	// }

	// @Test
	// public void test1() throws Exception {
	//
	// Employee employee = new Employee();
	// employee.setId("1");
	// employee.setName("Ankit");
	// employee.setAddress("Munich, Deutschland");
	// employee.setPhoneNumber("11111111");
	//
	// TSerializer serializer = new TSerializer();
	// byte[] serEmployee = serializer.serialize(employee);
	// BytesWritable bytesWritable = new BytesWritable(serEmployee);
	//
	// System.out.println("bytesWritable = " + bytesWritable);
	//
	// TDeserializer deserializer = new TDeserializer();
	// Employee deserEmployee = new Employee();
	// deserializer.deserialize(deserEmployee, bytesWritable.getBytes());
	//
	// System.out.println("TEST: " + deserEmployee);
	// }
}
