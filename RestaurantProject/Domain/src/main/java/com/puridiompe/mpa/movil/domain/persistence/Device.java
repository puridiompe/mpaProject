package com.puridiompe.mpa.movil.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.puridiompe.mpa.domain.persistence.utility.PersistenceAuditableEntity;

/**
 * 
 * @author Lucho
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "\"TrMov_Dispositivo\"")
public class Device extends PersistenceAuditableEntity<Integer> {

	@Id
	@Column(name = "\"idDis\"", unique = true, nullable = false)
	@SequenceGenerator(name = "device_sequence", sequenceName = "\"TrMov_Dispositivo_idDis_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "device_sequence")
	private Integer idDevice;

	@Column(name = "\"imei\"", length = 20, unique = true, nullable = false)
	private String imei;
	/*
	 * @Column(name = "\"name\"", length = 255, nullable = true) private String
	 * name;
	 * 
	 * @Column(name = "\"mobile_number\"", length = 20, nullable = true) private
	 * String mobileNumber;
	 * 
	 * @Column(name = "\"sim_number\"", length = 20, nullable = true) private
	 * String simNumber;
	 * 
	 * @Column(name = "\"active\"", length = 1, nullable = true) private String
	 * active;
	 * 
	 * @Column(name = "\"latitude_user\"", length = 30, nullable = true) private
	 * String latitudeUser;
	 */

	@Column(name = "\"idUsu\"", length = 30, nullable = true)
	private Integer usuarioId;

	/**
	 * default constructor
	 */

	public Device() {

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

	/*
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public String getMobileNumber() { return mobileNumber; }
	 * 
	 * public void setMobileNumber(String mobileNumber) { this.mobileNumber =
	 * mobileNumber; }
	 * 
	 * public String getSimNumber() { return simNumber; }
	 * 
	 * public void setSimNumber(String simNumber) { this.simNumber = simNumber;
	 * }
	 * 
	 * public String getActive() { return active; }
	 * 
	 * public void setActive(String active) { this.active = active; }
	 * 
	 * public String getLatitudeUser() { return latitudeUser; }
	 * 
	 * public void setLatitudeUser(String latitudeUser) { this.latitudeUser =
	 * latitudeUser; }
	 */
	public Integer getUsarioId() {
		return usuarioId;
	}

	public void setUsarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}

}