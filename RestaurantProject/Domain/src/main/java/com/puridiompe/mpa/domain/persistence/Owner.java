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
@Table(name = "OWNER")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_OWNER", nullable = false, unique = true)
	private Integer idOwner;
	
	@Column(name = "ID_VEHICLE", nullable = false, unique = true)
	private Integer idVehicle;
	
	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "LAST_NAME", length = 100)
	private String lastName;
	
	@Column(name = "DNI")
	private Integer dni;
	
	@Column(name = "TELEPHONE_NUMBER", length = 25)
	private String telephoneNumber;
	
	@Column(name = "CELLPHONE_NUMBER", length = 25)
	private String cellphoneNumber;
	
	@Column(name = "ADDRESS", length = 100)
	private String address;

	/**
	 * Default Constructor
	 */
	public Owner() {

	}

	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(Integer idOwner) {
		this.idOwner = idOwner;
	}

	public Integer getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Integer idVehicle) {
		this.idVehicle = idVehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getCellphoneNumber() {
		return cellphoneNumber;
	}

	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
}
