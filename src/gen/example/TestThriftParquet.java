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

import parquet.hadoop.thrift.ThriftToParquetFileWriter;
import parquet.hadoop.util.ContextUtil;

public class TestThriftParquet {
	@Test
	public void myTestImplementation() throws IOException,
			InterruptedException, TException {
		// Creating object for thrift generated java file
		Employee emp = new Employee();

		// Add the values to the above object
		emp.setId("1");
		emp.setName("Ankit");
		emp.setAddress("Munich, Deutchland");
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

		Path fileToCreate = new Path("target/emp.parquet");
		TProtocolFactory protocolFactory = new TCompactProtocol.Factory();
		Configuration conf = new Configuration();
		TaskAttemptID taskId = new TaskAttemptID("local", 0, true, 0, 0);

		// ThriftParquetWriter<TBase<?, ?>> w2 = new
		// ThriftParquetWriter<TBase<?, ?>>(
		// fileToCreate, (Class<TBase<?, ?>>) emp.getClass(),
		// CompressionCodecName.UNCOMPRESSED);

		// w2.write(); // Need to add a Thrift object of type TBase.
		// w2.close();

		ThriftToParquetFileWriter w = new ThriftToParquetFileWriter(
				fileToCreate, ContextUtil.newTaskAttemptContext(conf, taskId),
				protocolFactory, emp.getClass());

		w.write(new BytesWritable(empDtl));
		w.close();

		FileSystem fileSystem = fileToCreate.getFileSystem(conf);
		boolean exists = fileSystem.exists(fileToCreate);
		assertEquals(exists, true);
	}

}
