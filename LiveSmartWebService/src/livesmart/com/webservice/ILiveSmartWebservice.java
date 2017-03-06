/**
 * 
 */
package livesmart.com.webservice;

import javax.ws.rs.core.Response;

import livesmart.com.dataAccess.LoginResponse;

/**
 * @author Dominik Poppek
 *
 */
public interface ILiveSmartWebservice {
	
	public LoginResponse login(String username, String password);
	
	public Response registerFirebaseClientKey(int userId, String firebaseKey);
	

}
