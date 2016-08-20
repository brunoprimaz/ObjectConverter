package br.com.objectConverter;

import br.com.objectConverter.enums.ValueTypeEnum;

public class FieldValue {

	private String name;
	private Object value;
	private ValueTypeEnum valueType;

	protected FieldValue() {
	}

	public void setValueType(ValueTypeEnum valueType) {
		this.valueType = valueType;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isListValueType() {
		return this.valueType == ValueTypeEnum.LIST;
	}

	public ValueTypeEnum getValueType() {
		return valueType;
	}

	public boolean isListPropertyValueType() {
		return this.valueType == ValueTypeEnum.LIST_PROPERTY;
	}
}
