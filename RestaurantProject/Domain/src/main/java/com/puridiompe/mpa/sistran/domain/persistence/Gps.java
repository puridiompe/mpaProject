package com.puridiompe.mpa.sistran.domain.persistence;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author Lucho
 *
 */

@Entity
@Table(name = "\"gps_txn\"")
public class Gps {
	
	 @Id
	 @Column(name = "\"txn_id\"", nullable = false)
	 @GenericGenerator(name = "generator", strategy = "increment")
	 @GeneratedValue(generator = "generator")
	 private Integer idGps;
	 
	 @Column(name = "\"imei\"", length = 20, unique = true)
	 private String imei;
	 
	 @Column(name = "\"txn_utc_time\"", length = 50, nullable = true)	 
	 private String txnUtcTime;
	 
	 @Column(name = "\"active_void_indicator\"", length = 50, nullable = true)
	 private String activeVoidIndicator;
	 
	 @Column(name = "\"latitude\"", nullable = false, updatable = false)
	 private BigDecimal latitude;
	 
	 @Column(name = "\"longitude\"", nullable = false, updatable = false)
	 private BigDecimal longitude;
	 
	 @Column(name = "\"speed\"", length = 50, nullable = true)
	 private String speed;
	 
	 @Column(name = "\"track_angle\"", length = 50, nullable = true)
	 private String trackAngle;
	 
//	 @Generated(GenerationTime.INSERT)	 
	 @Column(name = "\"txn_date\"", nullable = false, updatable = false)
	 private Date date;
	 
	 @Column(name = "\"magnetic_variation\"", length = 50, nullable = true)
	 private String magneticVariarion;
	 
	 @Column(name = "\"checksum\"", length = 50, nullable = true)
	 private String checksum;
	 
	 @Column(name = "\"timestamp\"", nullable = true)
	 private BigInteger timestamp;
	 
	 @Column(name = "\"estimate\"", nullable = true)
	 private Integer estimate;
	 
	 @Column(name = "\"usuario_id\"", nullable = false)
	 private Integer usuarioId;	 
	 
	 /**
	  * default constructor
	  */
	 
	 public Gps(){
		 
	 }
	 
	 /**
	  * setters and getters
	  */
	 

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

}