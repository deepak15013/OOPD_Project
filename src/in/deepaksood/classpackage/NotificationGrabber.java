package in.deepaksood.classpackage;

import in.deepaksood.databasehelper.DatabaseHelper;
import in.deepaksood.databasehelper.FileHelper;

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
    private String newPost;

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
    public void notifyObserver(String userEmail) {

        String query = "SELECT friendemail FROM friendlist WHERE email=\""+userEmail+"\"";
        ArrayList<String> observerList = DatabaseHelper.shared().executeSelect(query);

        for(String friends: observerList) {
            FileHelper.shared().addStatus(friends, newPost);
        }

    }

    public void addPost(String userEmail, String newPost) {
        this.newPost = newPost;
        FileHelper.shared().addStatus(userEmail, newPost);
        notifyObserver(userEmail);
    }
}
