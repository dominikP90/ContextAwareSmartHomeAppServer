/**
 * 
 */
package livesmart.com.dataAccess;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author Dominik Poppek
 *
 */
public class HibernateConnector {

	private static HibernateConnector hibernateConnector;
	private SessionFactory sessionFactory;
	
	/**
	 * Sets up the SessionFactory
	 */
	private HibernateConnector() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
	 try {
		sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	
	
	/**
	 * Creates a HibernateConnector-Singleton
	 * 
	 * @return instance of HibernateConnector
	 * @throws HibernateException
	 */
    public static synchronized HibernateConnector getInstance() throws HibernateException {
        if (hibernateConnector == null) {
        	hibernateConnector = new HibernateConnector();
        }
 
        return hibernateConnector;
    }
    
    /**
     * Obtains a Session
     * @return
     * @throws HibernateException
     */
    public Session getSession() throws HibernateException {
        Session session = sessionFactory.openSession();
        return session;
    }
    
}
