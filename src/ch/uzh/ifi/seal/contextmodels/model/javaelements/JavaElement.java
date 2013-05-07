package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import ch.uzh.ifi.seal.contextmodels.model.Relevance;

public interface JavaElement {

	/**
	 * Changed the Relevance by a delta.
	 * @param delta
	 */
	void changeRelevance(double delta);
	
	void setRelevance(double relevance);
	
	/**
	 * Returns true if the relevance of the element is greater than {@link Relevance#getRelevancyThreshold()}.
	 * 
	 * Other conditions may be defined. E.g. for a relation both the source and the destination must be relevant in order
	 * to make the Relation relevant.
	 * 
	 * @return
	 */
	boolean isRelevant();
	
	/**
	 * Returns true if the relevance of the element is greater than {@link Relevance#getImportanceThreashold()}.
	 * 
	 * @return
	 */
	boolean isImportant();
	
	double getRelevance();
	
	/**
	 * The active element is highlighted in the view.
	 * @return
	 */
	boolean isActive();

	/**
	 * this method should only be called from ContextModel.
	 * @param active
	 */
	void setActive(boolean active);
	
}
