package com.puridiompe.mpa.sistran.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jboss.logging.annotations.Field;

/**
 * 
 * @author Lucho
 *
 */

@Entity
@Table(name = "\"device\"")
public class Device {
	
	 @Id
	 @Column(name = "\"device_id\"", nullable = false)
	 private Integer idDevice;
	 
	 @Column(name = "\"imei\"", length = 20, unique = true)
	 private String imei;
	 
	 @Column(name = "\"name\"", length = 255)	 
	 private String name;
	 
	 @Column(name = "\"mobile_number\"", length = 20)
	 private String mobileNumber;
	 
	 @Column(name = "\"sim_number\"", length = 20)
	 private String simNumber;
	 
	 @Column(name = "\"active\"", length = 1)
	 private String active;
	 
	 @Column(name = "\"latitude_user\"", length = 6)
	 private Float latitudeUser;
	 
	 /**
	  * default constructor
	  */
	 
	 public Device(){
		 
	 }
	 
	 /**
	  * setters and getters
	  */

	public Integer getIdDevice() {
		return idDevice;
	}

	public void setIdDevice(Integer idDevice) {
		this.idDevice = idDevice;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(String simNumber) {
		this.simNumber = simNumber;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Float getLatitudeUser() {
		return latitudeUser;
	}

	public void setLatitudeUser(Float latitudeUser) {
		this.latitudeUser = latitudeUser;
	}	 
	 

}