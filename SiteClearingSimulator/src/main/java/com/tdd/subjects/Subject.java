package com.tdd.subjects;

import com.tdd.observers.Observables;

public interface Subject {

    void registerObserver(Observables observables);
    void removeObserver(Observables observables);
    void notifyObservers(int width, int height, String command);
}
