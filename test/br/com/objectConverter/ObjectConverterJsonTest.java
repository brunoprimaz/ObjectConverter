package br.com.objectConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.objectConverter.scenario.ObjectConverterScenarios;

public class ObjectConverterJsonTest {

	private static final String FILE_TEST = "../test.txt";

	private ObjectConverterScenarios scenarios = new ObjectConverterScenarios();;
	private OutputStream outputStream;
	private ObjectConverter jsonConverter;

	@Before
	public void beforeTest() throws FileNotFoundException {
		File file = new File(FILE_TEST);
		if (file.exists()) {
			file.delete();
		}
		this.outputStream = new FileOutputStream(FILE_TEST);
		this.jsonConverter = ObjectConverterFactory.getJsonConverter(outputStream);
	}

	@Test
	public void testFileScenarioTwo() throws IOException {
		jsonConverter.writeObject(scenarios.getClassScenarioTwo());
		Assert.assertEquals("{attributeOne: 0.12, attributeThree: t, attributeTwo: 600}", returnFileResult());
	}
	

	@Test
	public void testFileScenarioOne() throws IOException {
		jsonConverter.writeObject(scenarios.getClassScenarioOne());
		Assert.assertEquals("{attributeFour: [{attributeOne: 0.12, attributeThree: t, attributeTwo: 600, attributeOne: 0.12, attributeThree: t, attributeTwo: 600}], attributeOne: 12.6, attributeThree: O, attributeTwo: 8}", returnFileResult());
	}
	

	@Test
	public void testFileScenarioThree() throws IOException {
		jsonConverter.writeObject(scenarios.getClassScenarioThree());
		Assert.assertEquals("{attributeOne: {attributeOne: 0.12, attributeThree: t, attributeTwo: 600}}", returnFileResult());
	}
	
	@Test
	public void testFileScenarioListClassScenarioTwo() throws IOException {
		jsonConverter.writeObject(scenarios.getListClassScenarioTwo());
		Assert.assertEquals("[{attributeOne: 0.12, attributeThree: t, attributeTwo: 600}, {attributeOne: 0.12, attributeThree: t, attributeTwo: 600}]", returnFileResult());
	}
	
	private String returnFileResult() throws IOException {
		FileInputStream fis = null;
		try {
			final StringBuilder file = new StringBuilder();
			fis = new FileInputStream(FILE_TEST);
			int content;
			while ((content = fis.read()) != -1) {
				file.append((char) content);
			}
			return file.toString();
		} finally {
			fis.close();
		}
	}
}
