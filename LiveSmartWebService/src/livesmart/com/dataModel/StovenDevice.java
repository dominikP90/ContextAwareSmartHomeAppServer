package livesmart.com.dataModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Dominik Poppek on 05.01.2017.
 */
@Entity
@DiscriminatorValue("stovendevice") 
public class StovenDevice extends Device {

}
