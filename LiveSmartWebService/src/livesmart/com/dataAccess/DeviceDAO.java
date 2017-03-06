/**
 * 
 */
package livesmart.com.dataAccess;

import org.hibernate.Session;

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
}
