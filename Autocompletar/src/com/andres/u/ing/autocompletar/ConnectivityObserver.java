package com.andres.u.ing.autocompletar;

/**
 * Interface that must be implemented to receive connection changes
 */
public interface ConnectivityObserver {

    /**
     * Action to be made when the observer is been notified.
     * @param connectionEnabled Whether the connection is enabled or not
     */
    public void manageNotification(boolean connectionEnabled);
}