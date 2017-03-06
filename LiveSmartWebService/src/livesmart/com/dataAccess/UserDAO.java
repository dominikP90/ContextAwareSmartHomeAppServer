/**
 * 
 */
package livesmart.com.dataAccess;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import livesmart.com.dataModel.User;

/**
 * Data access class for user
 * 
 * @author Dominik Poppek
 */
public class UserDAO {

	/**
	 * Gets user from database via username
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		Session session = null;
		try{
			session = HibernateConnector.getInstance().getSession();
			Query query = session.createQuery("select u from User u " + 
			"where userName = '" + username + "'");
			
			User user = (User) query.uniqueResult();
			return user; 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Get user from database via userId
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId) {
		Session session = null;
		try {
			session = HibernateConnector.getInstance().getSession();
			User dbUser = (User) session.get(User.class, userId);
			return dbUser;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Update user's firebaseKey
	 * @param userId
	 * @param firebaseKey
	 * @return
	 */
	public int updateUserFirebaseKey(int userId, String firebaseKey) {
		Session session = null;
		try{
			session = HibernateConnector.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			Query query = session.createQuery("UPDATE User set authentificationToken = '" + firebaseKey + "' " +
											  "WHERE id = " + userId);
			
			int result = query.executeUpdate();
			tx.commit();
			return result; 
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
	}
}
