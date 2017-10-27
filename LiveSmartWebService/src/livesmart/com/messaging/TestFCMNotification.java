/**
 * 
 */
package livesmart.com.messaging;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.Session;

import livesmart.com.dataAccess.HibernateConnector;
import livesmart.com.dataModel.HumidityDevice;
import livesmart.com.dataModel.MusicDevice;
import livesmart.com.dataModel.Notification;
import livesmart.com.dataModel.Severity;
import livesmart.com.dataModel.StovenDevice;
import livesmart.com.dataModel.User;

/**
 * @author Dominik Poppek
 *
 */
public class TestFCMNotification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FCMNotification fcm = new FCMNotification();
		
		
	    //Get firebaseToken
	    Session tokenSession = HibernateConnector.getInstance().getSession();
	    User u = tokenSession.get(User.class, 1);
	    tokenSession.close();
	    
	        
	    //Send Notifications
	    try {
			fcm.pushFCMNotification(u.getAuthentificationToken(), sendStoveNotif());
			TimeUnit.SECONDS.sleep(2);
			fcm.pushFCMNotification(u.getAuthentificationToken(), sendHumidityNotif());
			TimeUnit.SECONDS.sleep(2);
			fcm.pushFCMNotification(u.getAuthentificationToken(), sendDoorNotif());
			//Close Hibernate after all 
			HibernateConnector.getInstance().closeSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Notification sendStoveNotif() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		/**
		 * Stove left turned on
		 */
		Calendar userLeftHome = Calendar.getInstance();
		userLeftHome.setTimeInMillis(now.getTimeInMillis());
		userLeftHome.add(Calendar.MINUTE, -5);
		
		Calendar stovenTurnedOn = Calendar.getInstance();
		stovenTurnedOn.setTimeInMillis(now.getTimeInMillis());
		stovenTurnedOn.add(Calendar.MINUTE, -10);
        
		Notification n1 = new Notification();
	    n1.setNotificationText("You left the stoven turned on! System turns off stoven (in 3 mins)!");
	    n1.setNotificationID(1);
        n1.setTimestamp(d);
        n1.setSeverity(Severity.criticalAlertTimeToReact);
       //Load Stovendevice 
		Session stoveSession = HibernateConnector.getInstance().getSession();
		stoveSession.beginTransaction();
		StovenDevice sd = (StovenDevice) stoveSession.get(StovenDevice.class, 56);
		stoveSession.close();
        n1.setDeviceID(sd.getDeviceID());
        
        n1.getReasons().add("User left home at: " + userLeftHome.getTime().toString().substring(11, 16));
        n1.getReasons().add("Stoven turned on since: " + stovenTurnedOn.getTime().toString().substring(11, 16));
        
        return n1;
	}
	
	private static Notification sendHumidityNotif() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		 /**
	     * Humidity in livingroom exceeded
	     */
		Notification n2 = new Notification();
		n2.setNotificationText("You need to aerte the bathroom!");
		n2.setNotificationID(2);
		n2.setTimestamp(d);
		n2.setSeverity(Severity.infoAlert);
	    //add device
		Session humiditySession = HibernateConnector.getInstance().getSession();
		humiditySession.beginTransaction();
		HumidityDevice hd = (HumidityDevice) humiditySession.get(HumidityDevice.class, 69);
		humiditySession.close();
		
		n2.setDeviceID(hd.getDeviceID());
		
		n2.getReasons().add("The air humidity of the bathroom exceeded 65% at: " + now.getTime().toString().substring(11, 16));
	   
		return n2;
	}
	
	private static Notification sendDoorNotif() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		/**
		 * Door bell rang + music
		 */
		Calendar userRoom = Calendar.getInstance();
		userRoom.setTimeInMillis(now.getTimeInMillis());
		userRoom.add(Calendar.MINUTE, -12);
		
		Calendar doorRang = Calendar.getInstance();
		doorRang.setTimeInMillis(now.getTimeInMillis());
		doorRang.add(Calendar.MINUTE, -2);
		
		Notification n3 = new Notification();
		n3.setNotificationText("The door bell rang, but nobody reacted! Do you want to check?");
		n3.setNotificationID(2);
		n3.setTimestamp(d);
		n3.setSeverity(Severity.infoAlert);
		//add device
		Session musicSession = HibernateConnector.getInstance().getSession();
		musicSession.beginTransaction();
		MusicDevice md = (MusicDevice) musicSession.get(MusicDevice.class, 64);
		musicSession.close();
		
		
		n3.setDeviceID(md.getDeviceID());
		n3.getReasons().add("Door bell rang at: " + now.getTime().toString().substring(11, 16));
		n3.getReasons().add("The user is in the living room since: " + userRoom.getTime().toString().substring(11, 16));
		n3.getReasons().add("Music volumne in the living room: " + md.getDeviceSeekerValue());
		
		return n3;
	}

}
