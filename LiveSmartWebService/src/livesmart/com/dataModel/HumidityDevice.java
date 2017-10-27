/**
 * 
 */
package livesmart.com.dataModel;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Dominik Poppek
 *
 */
@Entity
@DiscriminatorValue("humiditydevice") 
public class HumidityDevice extends Device {
	private int humidity;

	/**
	 * @return the humidity
	 */
	public int getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	
}
