package com.puridiompe.mpa.sistran.domain.persistence;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author Lucho
 *
 */

@Entity
@Table(name = "\"TrMov_Dispositivo\"")
public class Device {
	

	 @Id
	 @Column(name = "\"idDis\"", unique=true, nullable = false)
	 @SequenceGenerator(name = "device_sequence", sequenceName = "device_device_id_seq", allocationSize = 1)
	 @GeneratedValue(strategy = GenerationType.AUTO, generator = "device_sequence")
	 private Integer idDevice;
	 
	 @Column(name = "\"imei\"", length = 20, unique = true, nullable = false)
	 private String imei;
	 /*
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
	 */
	 @Column(name = "\"fecCre\"", nullable = false)
	 private Date fecCre;
	
	 @Column(name = "\"fecMod\"", nullable = true)
	 private Date fecMod;
	 
	 @Column(name = "\"estado\"", nullable = false)
	 private String  estado;
	 
	 @Column(name = "\"idUsu\"", length = 30, nullable = true)
	 private Integer idUsu;
	 
	 /**
	  * default constructor
	  */
	 
	 public Device(){
		 
	 }
	 
	 /**
	  * setters and getters
	  */

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	 
	 
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
	
	public Date getFecCre() {
		return fecCre;
	}

	public void setFecCre(Date fecCre) {
		this.fecCre = fecCre;
	}

	public Date getFecMod() {
		return fecMod;
	}

	public void setFecMod(Date fecMod) {
		this.fecMod = fecMod;
	}
	
/*
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
	*/
	public Integer getUsarioId() {
		return idUsu;
	}

	public void setUsarioId(Integer usarioId) {
		this.idUsu = usarioId;
	}

}