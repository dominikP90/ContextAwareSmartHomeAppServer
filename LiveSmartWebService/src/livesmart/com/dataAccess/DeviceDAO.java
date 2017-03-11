/**
 * 
 */
package livesmart.com.dataAccess;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import livesmart.com.dataModel.Device;

/**
 * @author Dominik Poppek
 *
 */
public class DeviceDAO {
	/**
	 * Gets device from database via deviceId
	 * @param deviceId
	 * @return
	 */
	public Device getDeviceByDeviceId(int deviceId) {
		Session session = null;
		try{
			session = HibernateConnector.getInstance().getSession();
			Device d = (Device) session.get(Device.class, deviceId);
			
			return d; 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	
	/**
	 * Switch on/off device by deviceId
	 * @param deviceId
	 * @param newState
	 * @return
	 */
	public boolean switchDeviceOnOff(int deviceId, boolean newState) {
		Session session = HibernateConnector.getInstance().getSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Device d = (Device) session.get(Device.class, deviceId);
	         d.setDeviceTrunedOn(newState);
			 session.update(d); 
	         tx.commit();
	         return true;
	      }catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return false;
	      }finally {
	         session.close();
	      }
	}
	
	/**
	 * Switch on/off device by deviceId
	 * @param deviceId
	 * @param newState
	 * @return
	 */
	public boolean changeSeekerValueDeviceById(int deviceId, int newValue) {
		Session session = HibernateConnector.getInstance().getSession();
	    Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         Device d = (Device) session.get(Device.class, deviceId);
	         d.setDeviceSeekerValue(newValue);
			 session.update(d); 
	         tx.commit();
	         return true;
	      }catch (Exception e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	         return false;
	      }finally {
	         session.close();
	      }
	}
}
