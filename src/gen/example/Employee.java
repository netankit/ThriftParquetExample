/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package gen.example;

import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class Employee implements
		org.apache.thrift.TBase<Employee, Employee._Fields>,
		java.io.Serializable, Cloneable {
	private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
			"Employee");

	private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"id", org.apache.thrift.protocol.TType.STRING, (short) 1);
	private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"name", org.apache.thrift.protocol.TType.STRING, (short) 2);
	private static final org.apache.thrift.protocol.TField ADDRESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"address", org.apache.thrift.protocol.TType.STRING, (short) 3);
	private static final org.apache.thrift.protocol.TField PHONE_NUMBER_FIELD_DESC = new org.apache.thrift.protocol.TField(
			"phoneNumber", org.apache.thrift.protocol.TType.STRING, (short) 4);

	public String id; // required
	public String name; // required
	public String address; // required
	public String phoneNumber; // required

	/**
	 * The set of fields this struct contains, along with convenience methods
	 * for finding and manipulating them.
	 */
	public enum _Fields implements org.apache.thrift.TFieldIdEnum {
		ID((short) 1, "id"), NAME((short) 2, "name"), ADDRESS((short) 3,
				"address"), PHONE_NUMBER((short) 4, "phoneNumber");

		private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

		static {
			for (_Fields field : EnumSet.allOf(_Fields.class)) {
				byName.put(field.getFieldName(), field);
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, or null if its not
		 * found.
		 */
		public static _Fields findByThriftId(int fieldId) {
			switch (fieldId) {
			case 1: // ID
				return ID;
			case 2: // NAME
				return NAME;
			case 3: // ADDRESS
				return ADDRESS;
			case 4: // PHONE_NUMBER
				return PHONE_NUMBER;
			default:
				return null;
			}
		}

		/**
		 * Find the _Fields constant that matches fieldId, throwing an exception
		 * if it is not found.
		 */
		public static _Fields findByThriftIdOrThrow(int fieldId) {
			_Fields fields = findByThriftId(fieldId);
			if (fields == null)
				throw new IllegalArgumentException("Field " + fieldId
						+ " doesn't exist!");
			return fields;
		}

		/**
		 * Find the _Fields constant that matches name, or null if its not
		 * found.
		 */
		public static _Fields findByName(String name) {
			return byName.get(name);
		}

		private final short _thriftId;
		private final String _fieldName;

		_Fields(short thriftId, String fieldName) {
			_thriftId = thriftId;
			_fieldName = fieldName;
		}

		@Override
		public short getThriftFieldId() {
			return _thriftId;
		}

		@Override
		public String getFieldName() {
			return _fieldName;
		}
	}

	// isset id assignments

	public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
	static {
		Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
				_Fields.class);
		tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData(
				"id", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.FieldValueMetaData(
						org.apache.thrift.protocol.TType.STRING)));
		tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData(
				"name", org.apache.thrift.TFieldRequirementType.DEFAULT,
				new org.apache.thrift.meta_data.FieldValueMetaData(
						org.apache.thrift.protocol.TType.STRING)));
		tmpMap.put(_Fields.ADDRESS,
				new org.apache.thrift.meta_data.FieldMetaData("address",
						org.apache.thrift.TFieldRequirementType.DEFAULT,
						new org.apache.thrift.meta_data.FieldValueMetaData(
								org.apache.thrift.protocol.TType.STRING)));
		tmpMap.put(_Fields.PHONE_NUMBER,
				new org.apache.thrift.meta_data.FieldMetaData("phoneNumber",
						org.apache.thrift.TFieldRequirementType.DEFAULT,
						new org.apache.thrift.meta_data.FieldValueMetaData(
								org.apache.thrift.protocol.TType.STRING)));
		metaDataMap = Collections.unmodifiableMap(tmpMap);
		org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(
				Employee.class, metaDataMap);
	}

	public Employee() {
	}

	public Employee(String id, String name, String address, String phoneNumber) {
		this();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Performs a deep copy on <i>other</i>.
	 */
	public Employee(Employee other) {
		if (other.isSetId()) {
			this.id = other.id;
		}
		if (other.isSetName()) {
			this.name = other.name;
		}
		if (other.isSetAddress()) {
			this.address = other.address;
		}
		if (other.isSetPhoneNumber()) {
			this.phoneNumber = other.phoneNumber;
		}
	}

	@Override
	public Employee deepCopy() {
		return new Employee(this);
	}

	@Override
	public void clear() {
		this.id = null;
		this.name = null;
		this.address = null;
		this.phoneNumber = null;
	}

	public String getId() {
		return this.id;
	}

	public Employee setId(String id) {
		this.id = id;
		return this;
	}

	public void unsetId() {
		this.id = null;
	}

	/**
	 * Returns true if field id is set (has been assigned a value) and false
	 * otherwise
	 */
	public boolean isSetId() {
		return this.id != null;
	}

	public void setIdIsSet(boolean value) {
		if (!value) {
			this.id = null;
		}
	}

	public String getName() {
		return this.name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public void unsetName() {
		this.name = null;
	}

	/**
	 * Returns true if field name is set (has been assigned a value) and false
	 * otherwise
	 */
	public boolean isSetName() {
		return this.name != null;
	}

	public void setNameIsSet(boolean value) {
		if (!value) {
			this.name = null;
		}
	}

	public String getAddress() {
		return this.address;
	}

	public Employee setAddress(String address) {
		this.address = address;
		return this;
	}

	public void unsetAddress() {
		this.address = null;
	}

	/**
	 * Returns true if field address is set (has been assigned a value) and
	 * false otherwise
	 */
	public boolean isSetAddress() {
		return this.address != null;
	}

	public void setAddressIsSet(boolean value) {
		if (!value) {
			this.address = null;
		}
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public Employee setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public void unsetPhoneNumber() {
		this.phoneNumber = null;
	}

	/**
	 * Returns true if field phoneNumber is set (has been assigned a value) and
	 * false otherwise
	 */
	public boolean isSetPhoneNumber() {
		return this.phoneNumber != null;
	}

	public void setPhoneNumberIsSet(boolean value) {
		if (!value) {
			this.phoneNumber = null;
		}
	}

	@Override
	public void setFieldValue(_Fields field, Object value) {
		switch (field) {
		case ID:
			if (value == null) {
				unsetId();
			} else {
				setId((String) value);
			}
			break;

		case NAME:
			if (value == null) {
				unsetName();
			} else {
				setName((String) value);
			}
			break;

		case ADDRESS:
			if (value == null) {
				unsetAddress();
			} else {
				setAddress((String) value);
			}
			break;

		case PHONE_NUMBER:
			if (value == null) {
				unsetPhoneNumber();
			} else {
				setPhoneNumber((String) value);
			}
			break;

		}
	}

	@Override
	public Object getFieldValue(_Fields field) {
		switch (field) {
		case ID:
			return getId();

		case NAME:
			return getName();

		case ADDRESS:
			return getAddress();

		case PHONE_NUMBER:
			return getPhoneNumber();

		}
		throw new IllegalStateException();
	}

	/**
	 * Returns true if field corresponding to fieldID is set (has been assigned
	 * a value) and false otherwise
	 */
	@Override
	public boolean isSet(_Fields field) {
		if (field == null) {
			throw new IllegalArgumentException();
		}

		switch (field) {
		case ID:
			return isSetId();
		case NAME:
			return isSetName();
		case ADDRESS:
			return isSetAddress();
		case PHONE_NUMBER:
			return isSetPhoneNumber();
		}
		throw new IllegalStateException();
	}

	@Override
	public boolean equals(Object that) {
		if (that == null)
			return false;
		if (that instanceof Employee)
			return this.equals((Employee) that);
		return false;
	}

	public boolean equals(Employee that) {
		if (that == null)
			return false;

		boolean this_present_id = true && this.isSetId();
		boolean that_present_id = true && that.isSetId();
		if (this_present_id || that_present_id) {
			if (!(this_present_id && that_present_id))
				return false;
			if (!this.id.equals(that.id))
				return false;
		}

		boolean this_present_name = true && this.isSetName();
		boolean that_present_name = true && that.isSetName();
		if (this_present_name || that_present_name) {
			if (!(this_present_name && that_present_name))
				return false;
			if (!this.name.equals(that.name))
				return false;
		}

		boolean this_present_address = true && this.isSetAddress();
		boolean that_present_address = true && that.isSetAddress();
		if (this_present_address || that_present_address) {
			if (!(this_present_address && that_present_address))
				return false;
			if (!this.address.equals(that.address))
				return false;
		}

		boolean this_present_phoneNumber = true && this.isSetPhoneNumber();
		boolean that_present_phoneNumber = true && that.isSetPhoneNumber();
		if (this_present_phoneNumber || that_present_phoneNumber) {
			if (!(this_present_phoneNumber && that_present_phoneNumber))
				return false;
			if (!this.phoneNumber.equals(that.phoneNumber))
				return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public int compareTo(Employee other) {
		if (!getClass().equals(other.getClass())) {
			return getClass().getName().compareTo(other.getClass().getName());
		}

		int lastComparison = 0;
		Employee typedOther = other;

		lastComparison = Boolean.valueOf(isSetId()).compareTo(
				typedOther.isSetId());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetId()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id,
					typedOther.id);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.valueOf(isSetName()).compareTo(
				typedOther.isSetName());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetName()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name,
					typedOther.name);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.valueOf(isSetAddress()).compareTo(
				typedOther.isSetAddress());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetAddress()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(
					this.address, typedOther.address);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		lastComparison = Boolean.valueOf(isSetPhoneNumber()).compareTo(
				typedOther.isSetPhoneNumber());
		if (lastComparison != 0) {
			return lastComparison;
		}
		if (isSetPhoneNumber()) {
			lastComparison = org.apache.thrift.TBaseHelper.compareTo(
					this.phoneNumber, typedOther.phoneNumber);
			if (lastComparison != 0) {
				return lastComparison;
			}
		}
		return 0;
	}

	@Override
	public _Fields fieldForId(int fieldId) {
		return _Fields.findByThriftId(fieldId);
	}

	@Override
	public void read(org.apache.thrift.protocol.TProtocol iprot)
			throws org.apache.thrift.TException {
		org.apache.thrift.protocol.TField field;
		iprot.readStructBegin();
		while (true) {
			field = iprot.readFieldBegin();
			if (field.type == org.apache.thrift.protocol.TType.STOP) {
				break;
			}
			switch (field.id) {
			case 1: // ID
				if (field.type == org.apache.thrift.protocol.TType.STRING) {
					this.id = iprot.readString();
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
							field.type);
				}
				break;
			case 2: // NAME
				if (field.type == org.apache.thrift.protocol.TType.STRING) {
					this.name = iprot.readString();
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
							field.type);
				}
				break;
			case 3: // ADDRESS
				if (field.type == org.apache.thrift.protocol.TType.STRING) {
					this.address = iprot.readString();
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
							field.type);
				}
				break;
			case 4: // PHONE_NUMBER
				if (field.type == org.apache.thrift.protocol.TType.STRING) {
					this.phoneNumber = iprot.readString();
				} else {
					org.apache.thrift.protocol.TProtocolUtil.skip(iprot,
							field.type);
				}
				break;
			default:
				org.apache.thrift.protocol.TProtocolUtil
						.skip(iprot, field.type);
			}
			iprot.readFieldEnd();
		}
		iprot.readStructEnd();

		// check for required fields of primitive type, which can't be checked
		// in the validate method
		validate();
	}

	@Override
	public void write(org.apache.thrift.protocol.TProtocol oprot)
			throws org.apache.thrift.TException {
		validate();

		oprot.writeStructBegin(STRUCT_DESC);
		if (this.id != null) {
			oprot.writeFieldBegin(ID_FIELD_DESC);
			oprot.writeString(this.id);
			oprot.writeFieldEnd();
		}
		if (this.name != null) {
			oprot.writeFieldBegin(NAME_FIELD_DESC);
			oprot.writeString(this.name);
			oprot.writeFieldEnd();
		}
		if (this.address != null) {
			oprot.writeFieldBegin(ADDRESS_FIELD_DESC);
			oprot.writeString(this.address);
			oprot.writeFieldEnd();
		}
		if (this.phoneNumber != null) {
			oprot.writeFieldBegin(PHONE_NUMBER_FIELD_DESC);
			oprot.writeString(this.phoneNumber);
			oprot.writeFieldEnd();
		}
		oprot.writeFieldStop();
		oprot.writeStructEnd();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Employee(");
		boolean first = true;

		sb.append("id:");
		if (this.id == null) {
			sb.append("null");
		} else {
			sb.append(this.id);
		}
		first = false;
		if (!first)
			sb.append(", ");
		sb.append("name:");
		if (this.name == null) {
			sb.append("null");
		} else {
			sb.append(this.name);
		}
		first = false;
		if (!first)
			sb.append(", ");
		sb.append("address:");
		if (this.address == null) {
			sb.append("null");
		} else {
			sb.append(this.address);
		}
		first = false;
		if (!first)
			sb.append(", ");
		sb.append("phoneNumber:");
		if (this.phoneNumber == null) {
			sb.append("null");
		} else {
			sb.append(this.phoneNumber);
		}
		first = false;
		sb.append(")");
		return sb.toString();
	}

	public void validate() throws org.apache.thrift.TException {
		// check for required fields
	}

	private void writeObject(java.io.ObjectOutputStream out)
			throws java.io.IOException {
		try {
			write(new org.apache.thrift.protocol.TCompactProtocol(
					new org.apache.thrift.transport.TIOStreamTransport(out)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

	private void readObject(java.io.ObjectInputStream in)
			throws java.io.IOException, ClassNotFoundException {
		try {
			read(new org.apache.thrift.protocol.TCompactProtocol(
					new org.apache.thrift.transport.TIOStreamTransport(in)));
		} catch (org.apache.thrift.TException te) {
			throw new java.io.IOException(te);
		}
	}

}
