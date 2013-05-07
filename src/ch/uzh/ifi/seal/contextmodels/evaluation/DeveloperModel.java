package ch.uzh.ifi.seal.contextmodels.evaluation;

import java.util.ArrayList;
import java.util.List;

import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaField;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaMethod;

public class DeveloperModel {

	List<String> classNames = new ArrayList<>();
	List<String> methodNames = new ArrayList<>();
	List<String> fieldNames = new ArrayList<>();
	
	public static DeveloperModel build() {
		return new DeveloperModel();
	}
	
	public DeveloperModel classNames(String... classes) {
		for(String className: classes) {
			classNames.add(className);
		}
		return this;
	}
	
	public DeveloperModel methodNames(String... methods) {
		for(String methodName: methods) {
			methodNames.add(methodName);
		}
		return this;
	}
	
	public DeveloperModel fieldNames(String... fields) {
		for(String fieldName: fields) {
			fieldNames.add(fieldName);
		}
		return this;
	}
	
	public int numberOfRetrievedClasses() {
		return ContextModel.get().getRelevantClasses().size();
	}
	
	public int numberOfRetrievedMethods() {
		int num = 0;
		for(JavaClass clazz: ContextModel.get().getRelevantClasses()) {
			for(JavaMethod method: clazz.getMethods()) {
				if(method.isRelevant()) {
					num++;
				}
			}
		}
		return num;
	}
	
	public int numberOfRetrievedFields() {
		int num = 0;
		for(JavaClass clazz: ContextModel.get().getRelevantClasses()) {
			for(JavaField field: clazz.getFields()) {
				if(field.isRelevant()) {
					num++;
				}
			}
		}
		return num;
	}
	
	private int numberOfRelevantClasses() {
		return classNames.size();
	}
	
	private int numberOfRelevantAndRetrievedClasses() {
		int num = 0;
		for(JavaClass clazz: ContextModel.get().getRelevantClasses()) {
			if(classNames.contains(clazz.getFullyQualifiedName())) {
				num++;
			}
		}
		return num;
	}
	
	public double getPrecision() {
		return (double)numberOfRelevantAndRetrievedClasses() / numberOfRetrievedClasses();
	}
	
	public double getRecall() {
		return (double)numberOfRelevantAndRetrievedClasses() / numberOfRelevantClasses();
	}
	
}
