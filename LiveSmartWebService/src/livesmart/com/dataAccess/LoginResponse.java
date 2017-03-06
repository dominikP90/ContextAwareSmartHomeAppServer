/**
 * 
 */
package livesmart.com.dataAccess;

/**
 * @author Dominik Poppek
 *
 */
public class LoginResponse {
	
	private String result;
	private String message;
	private int userId;
	
	public LoginResponse(String _result, String _message, int _userId) {
		this.result = _result;
		this.message = _message;
		this.userId = _userId;
	}
	
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
