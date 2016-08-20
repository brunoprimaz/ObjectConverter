package br.com.objectConverter.scenario;

import java.util.ArrayList;
import java.util.List;

public class ObjectConverterScenarios {

	public List<ClassScenarioOne> getListClassScenarioOne() {
		List<ClassScenarioOne> scenarios = new ArrayList<ClassScenarioOne>();
		scenarios.add(getClassScenarioOne());
		scenarios.add(getClassScenarioOne());
		return scenarios;
	}

	public List<ClassScenarioTwo> getListClassScenarioTwo() {
		List<ClassScenarioTwo> scenarios = new ArrayList<ClassScenarioTwo>();
		scenarios.add(getClassScenarioTwo());
		scenarios.add(getClassScenarioTwo());
		return scenarios;
	}

	public ClassScenarioOne getClassScenarioOne() {
		ClassScenarioOne scenario = new ClassScenarioOne();
		scenario.setAttributeOne(12.6);
		scenario.setAttributeTwo(8);
		scenario.setAttributeThree('O');
		scenario.setAttributeFour(getListClassScenarioTwo());
		return scenario;
	}

	public ClassScenarioTwo getClassScenarioTwo() {
		ClassScenarioTwo scenario = new ClassScenarioTwo();
		scenario.setAttributeOne(0.12);
		scenario.setAttributeTwo(600);
		scenario.setAttributeThree('t');
		return scenario;
	}

	public ClassScenarioThree getClassScenarioThree() {
		ClassScenarioThree scenario = new ClassScenarioThree();
		scenario.setAttributeOne(getClassScenarioTwo());
		return scenario;
	}
}
