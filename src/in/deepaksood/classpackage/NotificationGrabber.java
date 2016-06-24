package in.deepaksood.classpackage;

import java.util.ArrayList;

/**
 * Created by deepaksood619 on 24/6/16.
 */
public class NotificationGrabber implements Subject {

    private static NotificationGrabber sharedInstance;
    public static NotificationGrabber shared() {
        if(sharedInstance == null) {
            sharedInstance = new NotificationGrabber();
        }
        return sharedInstance;
    }

    private ArrayList<Observer> observers;

    public NotificationGrabber() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        int observerIndex = observers.indexOf(observer);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for(Observer observer: observers) {
            observer.update();
        }

    }
}
