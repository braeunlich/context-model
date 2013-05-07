package ch.uzh.ifi.seal.contextmodels.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A simplified and Generic version of {@link java.util.Observable}
 * 
 * @author Christoph Braeunlich
 *
 */
public class Observable<T> {

	List<Observer<T>> listeners = new ArrayList<>();

	/**
	 * Register a display as a listener of the model. All listeners will be 
	 * notified for any changes of the model.
	 *   
	 * @param listener
	 */
	public void registerListener(Observer<T> listener) {
		listeners.add(listener);
	}

	/**
	 * Unregister an observer from the observable.
	 * 
	 * @param listener
	 */
	public void unregisterListener(Observer<T> listener) {
		listeners.remove(listener);
	}

	/**
	 * Tell all listeners that observable has new information. 
	 * @param observable
	 */
	public void notifyListeners(final T observable) {
		for(Observer<T> listener: listeners) {
			listener.update(observable);
		}
	}

	
	
}
