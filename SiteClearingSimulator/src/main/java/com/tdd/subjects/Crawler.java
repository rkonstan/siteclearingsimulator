package com.tdd.subjects;

import com.tdd.observers.Observables;

import java.util.ArrayList;
import java.util.List;

public class Crawler extends Bulldozer {

    private List<Observables> observablesList;

    public Crawler() {
        observablesList = new ArrayList<>();
    }

    @Override
    public boolean inspectMachine() {
        // Scan outside of machine for damaged parts
        // Check oil and hydraulic fluid leaks
        // Check all door and hood latches lock in place properly
        // Check levels of fuel, oil, engine coolant, transmission oil and hydraulic fluid
        return true;
    }

    @Override
    public boolean warmUpMachine() {
        // let oil lubricate all parts and cooling system to reach operational temperature
        return true;
    }

    @Override
    public void start(int width, int height, String command) {
         notifyObservers(width, height, command);

    }

    @Override
    public void registerObserver(Observables observables) {
        observablesList.add(observables);
    }

    @Override
    public void removeObserver(Observables observables) {
        observablesList.remove(observables);
    }

    @Override
    public void notifyObservers(int width, int height, String command) {

        for (Observables observables : observablesList) {
            observables.update(width, height, command);
        }
    }
}
