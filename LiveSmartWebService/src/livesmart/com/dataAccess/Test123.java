package livesmart.com.dataAccess;

import java.sql.Timestamp;

import org.hibernate.Session;

import livesmart.com.dataModel.HumidityDevice;
import livesmart.com.dataModel.User;

public class Test123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateConnector.getInstance().getSession();
		 
		HumidityDevice dh = (HumidityDevice) session.get(HumidityDevice.class, 77);
		 
		 session.close();
	}

}
