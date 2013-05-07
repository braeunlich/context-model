package ch.uzh.ifi.seal.contextmodels.model.javaelements;

import ch.uzh.ifi.seal.contextmodels.model.Relevance;

public class JavaRelation extends AbstractJavaElement {

	private JavaElement sourceElement;
	private JavaElement destinationElement;

	public JavaRelation(JavaElement sourceElement,
			JavaElement destinationElement) {

		this.sourceElement = sourceElement;
		this.destinationElement = destinationElement;
	}

	public JavaElement getSourceElement() {
		return sourceElement;
	}

	public void setSourceElement(JavaElement sourceElement) {
		this.sourceElement = sourceElement;
	}

	public JavaElement getDestinationElement() {
		return destinationElement;
	}

	public void setDestinationElement(JavaElement destinationElement) {
		this.destinationElement = destinationElement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((destinationElement == null) ? 0 : destinationElement
						.hashCode());
		result = prime * result
				+ ((sourceElement == null) ? 0 : sourceElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JavaRelation other = (JavaRelation) obj;
		if (destinationElement == null) {
			if (other.destinationElement != null)
				return false;
		} else if (!destinationElement.equals(other.destinationElement))
			return false;
		if (sourceElement == null) {
			if (other.sourceElement != null)
				return false;
		} else if (!sourceElement.equals(other.sourceElement))
			return false;
		return true;
	}

	@Override
	public boolean isRelevant() {
		if(!sourceElement.isRelevant() || !destinationElement.isRelevant()) {
			return false;
		}
		
		return relevance > Relevance.getRelevancyThreshold();
		
	}

}
