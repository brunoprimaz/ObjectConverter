package br.com.objectConverter;

import java.io.OutputStream;

public final class ObjectConverterFactory {

	private ObjectConverterFactory() {
	}

	public static ObjectConverter getJsonConverter(OutputStream outputstream) {
		return new ObjectConverterJson(outputstream);
	}

}
