package gen.example;

import parquet.hadoop.thrift.ParquetThriftBytesOutputFormat;
import parquet.hadoop.thrift.ThriftToParquetFileWriter;

public class TestThriftParquet {
	{
		try {

			ThriftToParquetFileWriter testObj = new ThriftToParquetFileWriter(
					null, null, null, null);

			ParquetThriftBytesOutputFormat ptb = new ParquetThriftBytesOutputFormat();

		} catch (Exception e) {
			System.err.println(e);

		}
	}
}
