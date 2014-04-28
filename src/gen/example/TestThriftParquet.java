package gen.example;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.mapreduce.TaskAttemptID;
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

		// Add the values to the above object
		emp.setId("1");
		emp.setName("Ankit");
		emp.setAddress("Munich, Deutschland");
		emp.setPhoneNumber("11111111");

		// To send this across different platforms like DOTNET etc...
		// this object needs to be serialized
		// The serialized thrift object is nothing but a byte array

		byte[] empDtl = null;
		TSerializer serializer = new TSerializer();
		try {
			empDtl = serializer.serialize(emp);
		} catch (TException e) {
			e.printStackTrace();
		}
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
		ThriftToParquetFileWriter w = new ThriftToParquetFileWriter(
				fileToCreate, ContextUtil.newTaskAttemptContext(conf, taskId),
				protocolFactory, emp.getClass());

		w.write(new BytesWritable(empDtl));
		w.close();

		// Test to check the file was written to Parquet.
		FileSystem fileSystem = fileToCreate.getFileSystem(conf);
		boolean exists = fileSystem.exists(fileToCreate);
		assertEquals(exists, true);

		// Reading back the file just written in Parquet-format
		pr = new ParquetReader(fileToCreate, new GroupReadSupport());
		Object r = pr.read();

		// Parquet File Output.
		String myFileOutput = r.toString();
		System.out.println("My file output is: " + myFileOutput);
		pr.close();

	}

}
