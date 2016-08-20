package br.com.objectConverter;

import java.io.OutputStream;
import java.util.List;

import br.com.objectConverter.enums.ValueTypeEnum;

public class ObjectConverterJson extends ObjectConverter {

	protected static final String SEPARATOR_FIELD_VALUE = ": ";
	protected static final String SEPARATOR_FIELD = ", ";
	protected static final String OPEN_ELEMENT_LIST = "[";
	protected static final String CLOSE_ELEMENT_LIST = "]";
	protected static final String OPEN_ELEMENT = "{";
	protected static final String CLOSE_ELEMENT = "}";
	protected static final int FIRST_POSITION = 0;

	protected ObjectConverterJson(OutputStream outputStream) {
		super(outputStream);
	}

	protected String convert(List objectsToFormat) {
		System.out.println("convert list to Json");
		return OPEN_ELEMENT + convert(objectsToFormat, ValueTypeEnum.LIST_PROPERTY) + CLOSE_ELEMENT;
	}

	private String convert(List objectsToFormat, ValueTypeEnum valueType) {
		System.out.println("convert list to Json by value type");
		JsonContent content = new JsonContent(valueType);
		for (Object objectToFormat : objectsToFormat) {
			FieldValue fieldValue = (FieldValue) objectToFormat;
			content.append(fieldValue.getName(), getValue(fieldValue));
		}
		return content.returnValue();
	}

	private String getValue(FieldValue fieldValue) {
		System.out.println("gettting field value");
		StringBuilder content = new StringBuilder();
		Object value = fieldValue.getValue();
		if (fieldValue.isListValueType()) {
			System.out.println("print list of objects");
			content.insert(FIRST_POSITION, OPEN_ELEMENT_LIST);
			content.append(convert((List) value, ValueTypeEnum.LIST));
			content.append(CLOSE_ELEMENT_LIST);
		} else if (fieldValue.isListPropertyValueType()) {
			System.out.println("print list of attributes");
			content.insert(FIRST_POSITION, OPEN_ELEMENT);
			content.append(convert((List) value, ValueTypeEnum.LIST_PROPERTY));
			content.append(CLOSE_ELEMENT);
		} else {
			System.out.println("print value with toString() method");
			content.append(value.toString());
		}
		return content.toString();
	}

	@Override
	protected String onInitItem() {
		System.out.println("list item");
		return SEPARATOR_FIELD;
	}

	@Override
	protected String onEndList() {
		System.out.println("ending list");
		return CLOSE_ELEMENT_LIST;
	}

	@Override
	protected String onInitList() {
		System.out.println("starting list");
		return OPEN_ELEMENT_LIST;
	}

}
