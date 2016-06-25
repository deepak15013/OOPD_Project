package in.deepaksood.classpackage;

/**
 * Created by deepaksood619 on 24/6/16.
 */
public interface Subject {

    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObserver(String userEmail);
}
