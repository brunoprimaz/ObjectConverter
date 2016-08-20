package br.com.objectConverter.enums;

public enum ValueTypeEnum {
	PROPERTY, LIST_PROPERTY, LIST;

	public boolean isList() {
		return this == LIST;
	}
	
	public boolean isListProperty() {
		return this == LIST;
	}
}
