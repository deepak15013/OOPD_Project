package in.deepaksood.classpackage;

/**
 * Created by deepaksood619 on 24/6/16.
 */
public class NotificationObserver implements Observer{

    private static NotificationObserver sharedInstance;
    public static NotificationObserver shared() {
        if(sharedInstance == null) {
            sharedInstance = new NotificationObserver();
        }
        return sharedInstance;
    }

    private static int observerIDTracker = 0;

    private int observerID;

    private Subject notificationGrabber;

    public NotificationObserver() {}

    public NotificationObserver(Subject notificationGrabber) {
        this.notificationGrabber = notificationGrabber;
        this.observerID = ++observerIDTracker;
        notificationGrabber.register(this);
    }

    @Override
    public void update() {

    }
}
