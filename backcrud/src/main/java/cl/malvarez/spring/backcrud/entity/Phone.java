package cl.malvarez.spring.backcrud.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que representa a la entidad telefono.
 * @author malvarez
 *
 */
@XmlRootElement(name = "phone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Phone {
	private String number;
	private String citycode;
	private String contrycode;
	
	public Phone() {
		super();
	}

	public Phone(String number, String citycode, String contrycode) {
		this.number = number;
		this.citycode = citycode;
		this.contrycode = contrycode;
	}
	
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the citycode
	 */
	public String getCitycode() {
		return citycode;
	}
	/**
	 * @param citycode the citycode to set
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	/**
	 * @return the contrycode
	 */
	public String getContrycode() {
		return contrycode;
	}
	/**
	 * @param contrycode the contrycode to set
	 */
	public void setContrycode(String contrycode) {
		this.contrycode = contrycode;
	}
	
	
}
