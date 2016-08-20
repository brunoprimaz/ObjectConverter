package br.com.objectConverter;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.objectConverter.enums.ValueTypeEnum;
import br.com.objectConverter.scenario.ObjectConverterScenarios;

public class ObjectFieldConverterTest {

	private ObjectConverterScenarios scenarios = new ObjectConverterScenarios();;
	
	@Test
	public void testWithList() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<FieldValue> fields = new ObjectFieldConverter().getFields(scenarios.getListClassScenarioTwo());
		Assert.assertEquals(6, fields.size());		
	}

	@Test
	public void testWithObject() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<FieldValue> fields = new ObjectFieldConverter().getFields(scenarios.getClassScenarioTwo());
		Assert.assertEquals(3, fields.size());		
	}
	
	@Test
	public void testWithObjectList() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<FieldValue> fields = new ObjectFieldConverter().getFields(scenarios.getClassScenarioOne());
		Assert.assertEquals(4, fields.size());		
	}
	
	@Test
	public void testObjectWithObject() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		List<FieldValue> fields = new ObjectFieldConverter().getFields(scenarios.getClassScenarioThree());
		Assert.assertEquals(1, fields.size());		
		FieldValue fieldValue = fields.get(0);
		Assert.assertEquals(ValueTypeEnum.LIST_PROPERTY, fieldValue.getValueType());
		Assert.assertEquals(3, ((List) fieldValue.getValue()).size());
	}
}
