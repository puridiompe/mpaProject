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
	 
	 @Column(name = "\"imei\"", length = 20, unique = true, nullable = false)
	 private String imei;
	 
	 @Column(name = "\"name\"", length = 255, nullable = true)	 
	 private String name;
	 
	 @Column(name = "\"mobile_number\"", length = 20, nullable = true)
	 private String mobileNumber;
	 
	 @Column(name = "\"sim_number\"", length = 20, nullable = true)
	 private String simNumber;
	 
	 @Column(name = "\"active\"", length = 1, nullable = true)
	 private String active;
	 
	 @Column(name = "\"latitude_user\"", length = 30, nullable = true)
	 private String latitudeUser;
	 
	 @Column(name = "\"usuario_id\"", length = 30, nullable = true)
	 private Integer usuarioId;
	 
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

	public String getLatitudeUser() {
		return latitudeUser;
	}

	public void setLatitudeUser(String latitudeUser) {
		this.latitudeUser = latitudeUser;
	}	 
	
	public Integer getUsarioId() {
		return usuarioId;
	}

	public void setUsarioId(Integer usarioId) {
		this.usuarioId = usarioId;
	}

}