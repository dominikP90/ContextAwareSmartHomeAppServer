package livesmart.com.dataModel;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Dominik Poppek on 16.12.2016.
 */
@Entity
@Table (name="NOTIFICATION")
public class Notification {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int notificationID;
    private String notificationText;
    private Date timestamp;
    private Severity severity;
    private int deviceID;
    private ArrayList<String> reasons = new ArrayList<>();

    /**
     * @return the notificationID
     */
    public int getNotificationID() {
        return notificationID;
    }
    /**
     * @param notificationID the notificationID to set
     */
    public void setNotificationID(int notificationID) {
        this.notificationID = notificationID;
    }
    /**
     * @return the notificationText
     */
    public String getNotificationText() {
        return notificationText;
    }
    /**
     * @param notificationText the notificationText to set
     */
    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }
    /**
     * @return the severity
     */
    public Severity getSeverity() {
        return severity;
    }
    /**
     * @param severity the severity to set
     */
    public void setSeverity(Severity severity) {
        this.severity = severity;
    }
    
   /**
	 * @return the deviceID
	 */
	public int getDeviceID() {
		return deviceID;
	}
	/**
	 * @param deviceID the deviceID to set
	 */
	public void setDeviceID(int deviceID) {
		this.deviceID = deviceID;
	}
public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public ArrayList<String> getReasons() {
        return reasons;
    }

    public void setReasons(ArrayList<String> reasons) {
        this.reasons = reasons;
    }
}
