/**
 * 
 */
package livesmart.com.messaging;

import java.util.Date;

import org.hibernate.Session;

import livesmart.com.dataAccess.HibernateConnector;
import livesmart.com.dataModel.Notification;
import livesmart.com.dataModel.Severity;
import livesmart.com.dataModel.StovenDevice;

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
		
		//Load Stovendevice for user Admin
		
		Session session = HibernateConnector.getInstance().getSession();
		session.beginTransaction();
		StovenDevice sd = (StovenDevice) session.get(StovenDevice.class, 56);
		session.close();
		
		//Create Notification
		Notification n1 = new Notification();
	        n1.setNotificationText("You left the stoven turned on! System turns off stoven (in 3 mins)!");
	        n1.setNotificationID(1);
	        n1.setTimestamp(new Date());
	        n1.setSeverity(Severity.criticalAlertTimeToReact);
	        //add device
	        n1.setDeviceID(sd.getDeviceID());
	        n1.getReasons().add("User left home at: " + n1.getTimestamp().getHours() + ":" + n1.getTimestamp().getMinutes());
	        n1.getReasons().add("Stoven turned on since: " + n1.getTimestamp().getHours() + ":" + n1.getTimestamp().getMinutes());
	        
	    //Send Notification
	    try {
			fcm.pushFCMNotification("eaIqR6Q4eE0:APA91bHV-Yl1JDm9xA27e0FE6b7v6cM28lGDww1pJuUYHGDAzhVBFzrM1dkikazvWaCLSce0DNMf_uwaYAcf63Qmgq6aUa_3B28ouCnMTueo2f-DjiTg9nbNxx6_97CzdVQJt_GiNmWN", n1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
