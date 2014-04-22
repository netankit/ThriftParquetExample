package gen.example;

import org.apache.thrift.TDeserializer;
import org.apache.thrift.TException;
import org.apache.thrift.TSerializer;

public class TestThrift {
	public static void main(String args[]) {

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
		System.out.println("SERIALIZATION");
		System.out.println("------------------");
		// This serialized object can be send to any platform
		// Deserializing it in the destination platform
		// will give thrift file compatible for the destination platform
		System.out.println("Serialized Thrift Object : " + empDtl);

		// Deserializing thrift object
		TDeserializer deserializer = new TDeserializer();
		Employee empNew = new Employee();
		// deserializer.deserialize(thrift object, byte array);
		// When you deserialize the byte array is converted to the
		// thrift object that is passed as a parameter to this method
		try {
			deserializer.deserialize(empNew, empDtl);
		} catch (TException e) {
			e.printStackTrace();
		}
		System.out.println("\nDE-SERIALIZATION");
		System.out.println("------------------");
		// Printing the deserialized thrift file
		System.out.println("Deserialized Thrift Object" + empNew);
	}
}