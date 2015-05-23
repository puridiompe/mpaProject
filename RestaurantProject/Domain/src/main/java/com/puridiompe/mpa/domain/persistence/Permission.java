package com.puridiompe.mpa.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author PuridiomPe
 * @version 1.0
 * 
 *
 */

@Entity
@Table(name = "PERMISSION")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PERMISSION", nullable = false, unique = true)
	private Integer idPermission;
	
	@Column(name = "ID_VEHICLE")
	private Integer idVehicle;
	
	@Column(name = "PERMISSION_NUMBER")
	private Integer permissionNumber;
	
	@Column(name = "COMPANY", length = 100)
	private String company;
	
	@Column(name = "DATE_OF_ISSUE", length = 25)
	private String dateOfIssue;
	
	@Column(name = "EXPIRATION_DATE", length = 25)
	private String expirationDate;
	
	@Column(name = "STATE", length = 20)
	private String state;


	/**
	 * Default Constructor
	 */
	public Permission() {
	}


	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdPermission() {
		return idPermission;
	}


	public void setIdPermission(Integer idPermission) {
		this.idPermission = idPermission;
	}


	public Integer getIdVehicle() {
		return idVehicle;
	}


	public void setIdVehicle(Integer idVehicle) {
		this.idVehicle = idVehicle;
	}


	public Integer getPermissionNumber() {
		return permissionNumber;
	}


	public void setPermissionNumber(Integer permissionNumber) {
		this.permissionNumber = permissionNumber;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getDateOfIssue() {
		return dateOfIssue;
	}


	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}


	public String getExpirationDate() {
		return expirationDate;
	}


	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

}
