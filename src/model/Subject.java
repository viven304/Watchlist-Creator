package model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<AbstractObserver> abstractObserverList;

    public Subject() {
        abstractObserverList = new ArrayList<>();
    }

    public void addObserver(AbstractObserver abstractObserver) {
        abstractObserverList.add(abstractObserver);
    }

    public void removeObserver(AbstractObserver abstractObserver) {
        abstractObserverList.remove(abstractObserver);
    }

    public void notifyObservers(String name) {
        for (AbstractObserver abstractObserver : abstractObserverList) {
            abstractObserver.update(name);
        }
    }
}
