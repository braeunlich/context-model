package ch.uzh.ifi.seal.contextmodels.model;

public class Relevance {

	private static double relevancyThreshold = 0;
	private static double importanceThreashold = 2;
	private static double minimalRelevancy = Double.NEGATIVE_INFINITY;
	
	/**
	 * @return the relevancyThreshold
	 */
	public static double getRelevancyThreshold() {
		return Relevance.relevancyThreshold;
	}

	/**
	 * @param relevancyThreshold the relevancyThreshold to set
	 */
	public static void setRelevancyThreshold(double relevancyThreshold) {
		Relevance.relevancyThreshold = relevancyThreshold;
	}

	/**
	 * @return the minimalRelevancy
	 */
	public static double getMinimalRelevancy() {
		return Relevance.minimalRelevancy;
	}

	/**
	 * @param minimalRelevancy the minimalRelevancy to set
	 */
	public static void setMinimalRelevancy(double minimalRelevancy) {
		Relevance.minimalRelevancy = minimalRelevancy;
	}

	public static double getImportanceThreashold() {
		return importanceThreashold;
	}
	
	public static void setImportanceThreashold(double importanceThreashold) {
		Relevance.importanceThreashold = importanceThreashold;
	}

}
