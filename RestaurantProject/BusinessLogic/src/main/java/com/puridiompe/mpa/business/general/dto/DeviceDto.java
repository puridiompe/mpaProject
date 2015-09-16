package com.puridiompe.mpa.business.general.dto;


/**
 * 
 * @author Lucho
 *
 */

public class DeviceDto {
	
	 private Integer idDevice;	 
	 
	 private String imei;
	 
	 private String name;
	 	 
	 private String mobileNumber;
	 	 
	 private String simNumber;
	 	 
	 private String active;
	 	 
	 private String latitudeUser;
	 
	 private Integer usuarioId;
	 
	 
	 public DeviceDto(){
		 
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
	
	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


}