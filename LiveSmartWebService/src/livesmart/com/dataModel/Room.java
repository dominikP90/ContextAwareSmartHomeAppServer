/**
 * 
 */
package livesmart.com.dataModel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Dominik Poppek
 *
 */
@Entity
@Table (name="ROOM")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int roomID;
    private String roomName;
    private String icon_path;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
    private List<Device> deviceList;
    
    public Room() {}
    
    /**
     * Constructor
     * @param roomName
     * @param icon_path
     */
    public Room(String roomName, String icon_path) {
        this.roomName = roomName;
        this.icon_path = icon_path;
    }
    
    
	/**
	 * @return the roomID
	 */
	public int getRoomID() {
		return roomID;
	}
	/**
	 * @param roomID the roomID to set
	 */
	public void setRoomID(int roomID) {
		this.roomID = roomID;
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
	/**
	 * @return the deviceList
	 */
	public List<Device> getDeviceList() {
		return deviceList;
	}
	/**
	 * @param deviceList the deviceList to set
	 */
	public void setDeviceList(ArrayList<Device> deviceList) {
		this.deviceList = deviceList;
	}
	/**
	 * @return the icon_path
	 */
	public String getIcon_path() {
		return icon_path;
	}
	/**
	 * @param icon_path the icon_path to set
	 */
	public void setIcon_path(String icon_path) {
		this.icon_path = icon_path;
	}
}
