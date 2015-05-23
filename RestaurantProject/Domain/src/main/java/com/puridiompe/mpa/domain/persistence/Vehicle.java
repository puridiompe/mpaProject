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
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_VEHICLE", nullable = false, unique = true)
	private Integer idVehicle;
	
	@Column(name = "LICENSE_NUMBER", length = 25)
	private String licenseNumber;
	
	@Column(name = "CATEGORY", length = 25)
	private String category;
	
	@Column(name = "BRAND", length = 25)
	private String brand;
	
	@Column(name = "MODEL", length = 50)
	private String model;
	
	@Column(name = "COLOR", length = 25)
	private String color;
	
	
	
	/**
	 * Default Constructor
	 */
	public Vehicle() {
	}




	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdVehicle() {
		return idVehicle;
	}





	public void setIdVehicle(Integer idVehicle) {
		this.idVehicle = idVehicle;
	}





	public String getLicenseNumber() {
		return licenseNumber;
	}





	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public String getBrand() {
		return brand;
	}





	public void setBrand(String brand) {
		this.brand = brand;
	}





	public String getModel() {
		return model;
	}





	public void setModel(String model) {
		this.model = model;
	}





	public String getColor() {
		return color;
	}





	public void setColor(String color) {
		this.color = color;
	}


}


