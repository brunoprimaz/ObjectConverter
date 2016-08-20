package br.com.objectConverter;

import static br.com.objectConverter.ObjectConverterJson.CLOSE_ELEMENT;
import static br.com.objectConverter.ObjectConverterJson.FIRST_POSITION;
import static br.com.objectConverter.ObjectConverterJson.OPEN_ELEMENT;
import static br.com.objectConverter.ObjectConverterJson.SEPARATOR_FIELD;
import br.com.objectConverter.enums.ValueTypeEnum;

public class JsonContent {

	private StringBuilder content = new StringBuilder();
	private ValueTypeEnum valueType;

	protected JsonContent(ValueTypeEnum valueType) {
		this.valueType = valueType;
	}

	public void append(String value) {
		System.out.println("append value in JsonContent");
		if (content.length() > 0) {
			System.out.println("open braces");
			content.append(SEPARATOR_FIELD);
		}
		content.append(value);
	}

	public void append(JsonContent value) {
		append(value.content.toString());
	}

	public void append(String name, String value) {
		append(name + ObjectConverterJson.SEPARATOR_FIELD_VALUE + value);
	}

	public String returnValue() {
		if (valueType.isList()) {
			System.out.println("open braces");
			content.insert(FIRST_POSITION, OPEN_ELEMENT);
			System.out.println("close braces");
			content.append(CLOSE_ELEMENT);
		}
		System.out.println("Json content: " + content.toString());
		return content.toString();
	}
}
