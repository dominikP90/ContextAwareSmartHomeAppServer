/**
 * 
 */
package livesmart.com.webservice;

import javax.ws.rs.core.Response;

import livesmart.com.dataAccess.LoginResponse;
import livesmart.com.dataAccess.SwitchResponse;
import livesmart.com.dataModel.User;

/**
 * @author Dominik Poppek
 *
 */
public interface ILiveSmartWebservice {
	
	//User
	public LoginResponse login(String username, String password);
	public User getUserdataById(int userId);
	//Device
	public SwitchResponse switchOnOffDeviceById(int deviceId, boolean newState);
	public SwitchResponse changeSeekerValueDeviceById(int deviceId, int newValue);
	
	//Firebase
	public Response registerFirebaseClientKey(int userId, String firebaseKey);
	

}
