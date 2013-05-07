package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import ch.uzh.ifi.seal.contextmodels.model.Relevance;

public abstract class AbstractJavaElement implements JavaElement {

	protected double relevance = 0;
	private boolean active = false;

	@Override
	public void changeRelevance(double delta) {
		relevance += delta;
		validateRelevance();
	}

	@Override
	public void setRelevance(double relevance) {
		this.relevance = relevance;
		validateRelevance();
	}

	protected void validateRelevance() {
		if (relevance < Relevance.getMinimalRelevancy()) {
			relevance = Relevance.getMinimalRelevancy();
		}
	}

	@Override
	public double getRelevance() {
		return relevance;
	}

	@Override
	public boolean isRelevant() {
		return relevance > Relevance.getRelevancyThreshold();
	}

	@Override
	public boolean isImportant() {
		return relevance > Relevance.getImportanceThreashold();
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

}
