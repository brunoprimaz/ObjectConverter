package br.com.objectConverter;

import org.junit.Assert;
import org.junit.Test;

import br.com.objectConverter.enums.ValueTypeEnum;

public class JsonContentTest {

	@Test
	public void testWithNameValue(){
		JsonContent jsonContent = new JsonContent(ValueTypeEnum.PROPERTY);
		jsonContent.append("field1", "14");
		jsonContent.append("field2", "19");
		Assert.assertEquals("field1: 14, field2: 19", jsonContent.returnValue());
	}
	
	@Test
	public void testValueTypeList(){
		JsonContent jsonContent1 = new JsonContent(ValueTypeEnum.LIST);
		jsonContent1.append("field1", "14");
		JsonContent jsonContent2 = new JsonContent(ValueTypeEnum.LIST);
		jsonContent2.append("field2", "19");
		jsonContent1.append(jsonContent2);
		Assert.assertEquals("{field1: 14, field2: 19}", jsonContent1.returnValue());
	}
	
	@Test
	public void testWithoutValue(){
		JsonContent jsonContent = new JsonContent(ValueTypeEnum.LIST_PROPERTY);
		Assert.assertEquals("", jsonContent.returnValue());
	}
}
