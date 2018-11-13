package model;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    Float averagerating;
    List<AbstractObserver> abstractObserverList;

    public Subject() {
        abstractObserverList = new ArrayList<>();
        averagerating = 0f;
    }

    public void addObserver(AbstractObserver abstractObserver) {
        abstractObserverList.add(abstractObserver);
    }

    public void removeObserver(AbstractObserver abstractObserver) {
        abstractObserverList.remove(abstractObserver);
    }

    public void notifyObservers() {
        float sumOfRating = 0.0f;
        float numOfTitles =  abstractObserverList.size();;
        for (AbstractObserver abstractObserver : abstractObserverList) {
            sumOfRating = sumOfRating + abstractObserver.update();
        }
        averagerating = sumOfRating/numOfTitles;
        System.out.println(averagerating + " is the average rating of the titles in this database");
    }
}
