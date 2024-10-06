package classes;

import java.util.Collection;

/**
 * Provides sophisticated management of listeners wanting to subscribe to some event source, which does not
 * want to implement management itself.
 * @param <L> the type of the listener to manage
 */
public abstract class ListenerManagement<L> {

    public void addListener(L listener) {
        if (listeners().contains(listener)) {
            return;
        }
        listeners().add(listener);
        System.out.println("Listener added: " + listener);
    }


    public void removeListener(L listener) {
        listeners().remove(listener);
        System.out.println("Listener removed: " + listener);
    }


    protected abstract Collection<? super L> listeners();

}
