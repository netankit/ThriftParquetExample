package gen.example;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.TaskAttemptID;
import org.apache.thrift.TBase;
import org.junit.Test;

import parquet.Log;
import parquet.example.data.Group;
import parquet.hadoop.ParquetReader;
import parquet.hadoop.thrift.ParquetThriftBytesOutputFormat;
import parquet.hadoop.thrift.ThriftToParquetFileWriter;
import parquet.hadoop.util.ContextUtil;
import parquet.org.apache.thrift.TException;
import parquet.org.apache.thrift.protocol.TCompactProtocol;
import parquet.org.apache.thrift.protocol.TProtocol;
import parquet.org.apache.thrift.protocol.TProtocolFactory;
import parquet.org.apache.thrift.transport.TIOStreamTransport;

import com.twitter.data.proto.tutorial.thrift.AddressBook;
import com.twitter.data.proto.tutorial.thrift.Name;
import com.twitter.data.proto.tutorial.thrift.Person;
import com.twitter.data.proto.tutorial.thrift.PhoneNumber;

public class TestThriftParquet {
	
	Path myfileToCreate;
	Configuration conf = new Configuration();
	TaskAttemptID taskId = new TaskAttemptID("local", 0, true, 0, 0);

	TaskAttemptContext mytaskAttemptContext = ContextUtil
			.newTaskAttemptContext(conf, taskId);
	TProtocolFactory myprotocolFactory = new TCompactProtocol.Factory();

	Class<? extends TBase<?, ?>> mythriftClass = Employee.class;	
	
	ThriftToParquetFileWriter testObj = new ThriftToParquetFileWriter(
		myfileToCreate, mytaskAttemptContext, myprotocolFactory,
			mythriftClass);

			ParquetThriftBytesOutputFormat ptb = new ParquetThriftBytesOutputFormat();

		 
	}
}
