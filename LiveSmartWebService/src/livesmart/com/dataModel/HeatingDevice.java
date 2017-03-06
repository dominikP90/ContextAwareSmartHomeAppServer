package livesmart.com.dataModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Dominik Poppek on 16.12.2016.
 */
@Entity
@DiscriminatorValue("heatingdevice") 
public class HeatingDevice extends Device {

}
