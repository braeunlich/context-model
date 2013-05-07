package ch.uzh.ifi.seal.contextmodels.model;

/**
 * A simplified and Generic version of {@link java.util.Observer}
 * 
 * @author Christoph Braeunlich
 *
 */
public interface Observer<T> {
	void update(T observable);
}