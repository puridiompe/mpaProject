package com.puridiompe.mpa.business.general.dto;


/**
 * 
 * @author Lucho
 *
 */

public class DeviceDto {
	
	 private Integer idDevice;	 
	 
	 private String codigo;
	 
	 private String name;
	 	 
	 private String mobileNumber;
	 	 
	 private String simNumber;
	 	 
	 private String active;
	 	 
	 private Float latitudeUser;
	 
	 
	 public DeviceDto(){
		 
	 }


	public Integer getIdDevice() {
		return idDevice;
	}


	public void setIdDevice(Integer idDevice) {
		this.idDevice = idDevice;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
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