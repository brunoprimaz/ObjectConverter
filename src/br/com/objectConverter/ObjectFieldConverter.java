package br.com.objectConverter;

import static java.util.Arrays.asList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.com.objectConverter.enums.ValueTypeEnum;

public class ObjectFieldConverter {

	protected ObjectFieldConverter() {
	}

	protected List<FieldValue> getFields(Iterable objectToConvert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		List<FieldValue> fields = new LinkedList<FieldValue>();
		for (Object object : objectToConvert) {
			fields.addAll(getFields(object));
		}
		return fields;
	}

	protected List<FieldValue> getFields(Object objectToConvert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Creating fields values");
		List<FieldValue> fields = new LinkedList<FieldValue>();
		if (objectToConvert != null) {
			for (Method method : getMethods(objectToConvert)) {
				method.setAccessible(true);
				if (isAcessibleMethod(method)) {
					FieldValue fieldValue = new FieldValue();
					fieldValue.setName(getNameField(method.getName()));
					setClassValue(method.invoke(objectToConvert), fieldValue);
					fields.add(fieldValue);
				}
			}
		}
		return fields;
	}

	private List<Method> getMethods(Object objectToConvert) {
		System.out.println("Getting sorted methods");
		List<Method> declaredMethods = asList(objectToConvert.getClass().getDeclaredMethods());
		Collections.sort(declaredMethods, new Comparator<Method>() {
			@Override
			public int compare(Method method0, Method method1) {
				return method0.getName().compareTo(method1.getName());
			}
		});
		return declaredMethods;
	}

	private boolean hasMethodAvailable(Object objectToConvert) {
		System.out.println("checks that class has available method");
		for (Method method : objectToConvert.getClass().getDeclaredMethods()) {
			method.setAccessible(true);
			if (isAcessibleMethod(method)) {
				return true;
			}
		}
		return false;
	}

	private boolean isAcessibleMethod(Method method) {
		System.out.println("Verifies that is an acessible method");
		return method.getModifiers() == Modifier.PUBLIC && method.getName().startsWith("get") && method.getParameters().length == 0;
	}

	private String getNameField(String methodName) {
		System.out.println("Getting sorted methods");
		return methodName.substring(3, 4).toLowerCase() + methodName.substring(4, methodName.length());
	}

	private void setClassValue(Object value, FieldValue fieldValue) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("setting value of method");
		if (value instanceof Iterable) {
			fieldValue.setValue(getFields((Iterable) value));
			fieldValue.setValueType(ValueTypeEnum.LIST);
		} else if (hasMethodAvailable(value)) {
			fieldValue.setValue(getFields(value));
			fieldValue.setValueType(ValueTypeEnum.LIST_PROPERTY);
		} else {
			fieldValue.setValue(value);
			fieldValue.setValueType(ValueTypeEnum.PROPERTY);
		}
	}
}
