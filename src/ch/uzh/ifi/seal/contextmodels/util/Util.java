package ch.uzh.ifi.seal.contextmodels.util;

public class Util {

	public static <T> T checkNotNull(T reference) {
		if(reference == null) {
			throw new NullPointerException();
		}
		return reference;
	}
	
}
