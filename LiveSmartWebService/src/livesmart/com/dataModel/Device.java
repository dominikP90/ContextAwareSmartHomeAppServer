/**
 * 
 */
package livesmart.com.dataModel;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Dominik Poppek
 *
 */
@Entity
@Table (name="DEVICE")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="deviceTypeDiscriminator", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Device")
public class Device {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int deviceID;
	 private String deviceName;
	 private String deviceMAC;
	 @Enumerated(EnumType.STRING)
	 private DeviceType deviceType;
	 private boolean deviceTrunedOn;
	 private String deviceSeekerName;
	 private int deviceSeekerValue;
	 private String roomName;
	 
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
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * @return the deviceMAC
	 */
	public String getDeviceMAC() {
		return deviceMAC;
	}
	/**
	 * @param deviceMAC the deviceMAC to set
	 */
	public void setDeviceMAC(String deviceMAC) {
		this.deviceMAC = deviceMAC;
	}
	
	/**
	 * @return the deviceType
	 */
	public DeviceType getDeviceType() {
		return deviceType;
	}
	/**
	 * @param deviceType the deviceType to set
	 */
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public boolean isDeviceTrunedOn() {
		return deviceTrunedOn;
	}
	public void setDeviceTrunedOn(boolean deviceTrunedOn) {
		this.deviceTrunedOn = deviceTrunedOn;
	}
	
	/**
	 * @return the deviceSeekerName
	 */
	public String getDeviceSeekerName() {
		return deviceSeekerName;
	}
	/**
	 * @param deviceSeekerName the deviceSeekerName to set
	 */
	public void setDeviceSeekerName(String deviceSeekerName) {
		this.deviceSeekerName = deviceSeekerName;
	}
	/**
	 * @return the deviceSeekerValue
	 */
	public int getDeviceSeekerValue() {
		return deviceSeekerValue;
	}
	/**
	 * @param deviceSeekerValue the deviceSeekerValue to set
	 */
	public void setDeviceSeekerValue(int deviceSeekerValue) {
		this.deviceSeekerValue = deviceSeekerValue;
	}
}