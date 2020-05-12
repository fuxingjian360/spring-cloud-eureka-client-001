package designmodel.observer;

import java.util.Observable;
import java.util.Observer;

public class MyObserverable extends Observable {

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    public synchronized void setChanged() {
        System.err.println("XXXX");
        super.setChanged();
    }
}
