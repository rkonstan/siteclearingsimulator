package com.tdd.observers;

/**
 * Observer (Subscriber) interface - Gives Subjects a common interface to talk to when
 * time comes to update the concrete observers
 */
public interface Observables {
    void update(int width, int height, String command);
}
