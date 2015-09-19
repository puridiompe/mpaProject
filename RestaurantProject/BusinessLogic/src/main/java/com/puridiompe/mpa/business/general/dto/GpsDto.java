package com.puridiompe.mpa.business.general.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.puridiompe.mpa.common.type.Datetime;

public class GpsDto {
	
	 private Integer idGps;
	 
	 private String imei;
	 	 	 
	 private String txnUtcTime;
	 	 
	 private String activeVoidIndicator;
	 	 
	 private BigDecimal latitude;
	 	 
	 private BigDecimal longitude;
	 	 
	 private String speed;
	 	 
	 private String trackAngle;
	 	 
	 private Datetime date;
	 	 
	 private String magneticVariarion;
	 	 
	 private String checksum;
	 	 
	 private BigInteger timestamp;
	 	 
	 private Integer estimate;
	 
	 private Integer usuarioId;
	 
	 private GpsInspectorDto gpsInspector;
	 
	 
	 public GpsDto(){
		 gpsInspector = new GpsInspectorDto();
		 
	 }
	 

	public Integer getIdGps() {
		return idGps;
	}

	public void setIdGps(Integer idGps) {
		this.idGps = idGps;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getTxnUtcTime() {
		return txnUtcTime;
	}

	public void setTxnUtcTime(String txnUtcTime) {
		this.txnUtcTime = txnUtcTime;
	}

	public String getActiveVoidIndicator() {
		return activeVoidIndicator;
	}

	public void setActiveVoidIndicator(String activeVoidIndicator) {
		this.activeVoidIndicator = activeVoidIndicator;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getTrackAngle() {
		return trackAngle;
	}

	public void setTrackAngle(String trackAngle) {
		this.trackAngle = trackAngle;
	}

	public Datetime getDate() {
		return date;
	}

	public void setDate(Datetime date) {
		this.date = date;
	}

	public String getMagneticVariarion() {
		return magneticVariarion;
	}

	public void setMagneticVariarion(String magneticVariarion) {
		this.magneticVariarion = magneticVariarion;
	}

	public String getChecksum() {
		return checksum;
	}

	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}

	public BigInteger getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(BigInteger timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getEstimate() {
		return estimate;
	}

	public void setEstimate(Integer estimate) {
		this.estimate = estimate;
	}


	public Integer getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}


	public GpsInspectorDto getGpsInspector() {
		return gpsInspector;
	}


	public void setGpsInspector(GpsInspectorDto gpsInspector) {
		this.gpsInspector = gpsInspector;
	}


}