package br.com.objectConverter.scenario;

import java.util.List;

public class ClassScenarioOne {

	private Double attributeOne;
	private Integer attributeTwo;
	private Character attributeThree;
	private List<ClassScenarioTwo> attributeFour;

	public List<ClassScenarioTwo> getAttributeFour() {
		return attributeFour;
	}

	public void setAttributeFour(List<ClassScenarioTwo> attributeFour) {
		this.attributeFour = attributeFour;
	}

	public Double getAttributeOne() {
		return attributeOne;
	}

	public void setAttributeOne(final Double attributeOne) {
		this.attributeOne = attributeOne;
	}

	public Integer getAttributeTwo() {
		return attributeTwo;
	}

	public void setAttributeTwo(final Integer attributeTwo) {
		this.attributeTwo = attributeTwo;
	}

	public Character getAttributeThree() {
		return attributeThree;
	}

	public void setAttributeThree(final Character attributeThree) {
		this.attributeThree = attributeThree;
	}
}
