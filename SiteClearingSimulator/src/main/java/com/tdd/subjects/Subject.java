package com.tdd.subjects;

import com.tdd.observers.Observables;

/**
 * Subject (Publisher) interface - gives concrete Subjects ability to add/remove subscribers
 */
public interface Subject {

    void registerObserver(Observables observables);
    void removeObserver(Observables observables);
    void notifyObservers(int width, int height, String command);
}
