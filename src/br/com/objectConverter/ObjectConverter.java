package br.com.objectConverter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class ObjectConverter {

	private OutputStream outputstream;

	protected ObjectConverter(OutputStream outputstream) {
		this.outputstream = outputstream;
	}

	public void writeObject(Iterable objectsToConvert) throws IOException {
		boolean isWriting = false;
		writeInOutpuStream(onInitList());
		System.out.println("Writing outputstream with list");
		for (Object object : objectsToConvert) {
			if (isWriting) {
				writeInOutpuStream(onInitItem());
			}
			writeObject(object);
			isWriting = true;
		}
		writeInOutpuStream(onEndList());
	}

	public void writeObject(Object objectToConvert) throws IOException {
		try {
			System.out.println("Writing outputstream with object");
			String content = convert(new ObjectFieldConverter().getFields(objectToConvert));
			writeInOutpuStream(content);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	private void writeInOutpuStream(String content) throws IOException {
		System.out.println("Writing: " + content.toString());
		for (int index = 0; index < content.length(); index++) {
			System.out.println("writing in OutpuStream");
			outputstream.write(content.charAt(index));
		}
	}

	protected abstract String convert(List objectToFormat);

	protected abstract String onInitItem();

	protected abstract String onEndList();

	protected abstract String onInitList();
}
