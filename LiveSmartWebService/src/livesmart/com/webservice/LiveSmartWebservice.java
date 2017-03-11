package livesmart.com.webservice;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;

import livesmart.com.dataAccess.DeviceDAO;
import livesmart.com.dataAccess.HibernateConnector;
import livesmart.com.dataAccess.LoginResponse;
import livesmart.com.dataAccess.SwitchResponse;
import livesmart.com.dataAccess.UserDAO;
import livesmart.com.dataModel.User;

/**
 * 
 */

/**
 * @author Dominik Poppek
 *
 */
@Path("/livesmart")
public class LiveSmartWebservice implements ILiveSmartWebservice{
	
	public LiveSmartWebservice() {}
	
	//TODO always update user.lastupdated -> nn to reload on client side
	
	
	/**
	 * Validate user login
	 */
	@PUT
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResponse login(@FormParam("username") String username,@FormParam("password") String password) {
		LoginResponse lr;
		
		UserDAO userDAO = new UserDAO();
		User userDB = userDAO.getUserByUsername(username);
		if (userDB == null) {
			lr = new LoginResponse("FAILURE", "Unknown Username!", 0);
		} else if (!password.equals(userDB.getUserPassword())) {
			lr = new LoginResponse("FAILURE", "Wrong password, please try again!", 0);
		} else {
			lr = new LoginResponse("SUCCESS", "Login successful!", userDB.getId());
		}
		return lr;
	}
	
	
	/**
	 * Get User by userId
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/user/{userId}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserdataById(@PathParam("userId") int userId) {
		UserDAO userDAO = new UserDAO();
		User userDb = userDAO.getUserByUserId(userId);
		
		return userDb;
	}
	
	/**
	 * Switches on/off device by deviceID
	 * @param deviceId
	 * @return
	 */
	@PUT
	@Path("/device/switch")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public SwitchResponse switchOnOffDeviceById(@FormParam("deviceId") int deviceId, @FormParam("newState") boolean newState) {
		DeviceDAO deviceDAO = new DeviceDAO();
		if (deviceDAO.switchDeviceOnOff(deviceId, newState)) {
			return new SwitchResponse(true, "Successful");
		} else {
			return new SwitchResponse(false, "Not updated");
		}
	}
	
	/**
	 * Switches on/off device by deviceID
	 * @param deviceId
	 * @return
	 */
	@PUT
	@Path("/device/seeker")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public SwitchResponse changeSeekerValueDeviceById(@FormParam("deviceId") int deviceId, @FormParam("newValue") int newValue) {
		DeviceDAO deviceDAO = new DeviceDAO();
		if (deviceDAO.changeSeekerValueDeviceById(deviceId, newValue)) {
			return new SwitchResponse(true, "Successful");
		} else {
			return new SwitchResponse(false, "Not updated");
		}
	}
	
	/**
	 * Register user's FirebaseAPI-Key for messaging
	 */
	@PUT
	@Path("/registerKey")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response registerFirebaseClientKey(@FormParam("userId")int userId,@FormParam("firebaseKey") String firebaseKey) {
		UserDAO userDAO = new UserDAO();
		int result = userDAO.updateUserFirebaseKey(userId, firebaseKey);
		if (result == 1) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
}
