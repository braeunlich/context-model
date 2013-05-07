package ch.uzh.ifi.seal.contextmodels.ruleengine.impl;

import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;

public interface Task {
	void run(JavaElement element);
}
