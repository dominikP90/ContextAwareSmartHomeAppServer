/**
 * 
 */
package livesmart.com.dataAccess;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Dominik Poppek
 * Initalizes Hibernate on LiveSmartWebservice startup
 */
public class HibernateStartUpListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateConnector.getInstance();
	}

}
