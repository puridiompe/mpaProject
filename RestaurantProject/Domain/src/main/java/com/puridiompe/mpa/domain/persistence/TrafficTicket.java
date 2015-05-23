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
@Table(name = "TRAFFIC_TICKET")
public class TrafficTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_BALLOT", nullable = false, unique = true)
	private Integer idBallot;
	
	@Column(name = "ID_VEHICLE")
	private Integer idVehicle;
	
	@Column(name = "BALLOT_NUMBER", length = 25)
	private String ballotNumber;
	
	@Column(name = "DATE", length = 25)
	private String date;
	
	@Column(name = "ID_INFRACTION")
	private Integer idInfraction;

	
	/**
	 * Default Constructor
	 */
	public TrafficTicket() {
	}


	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdBallot() {
		return idBallot;
	}


	public void setIdBallot(Integer idBallot) {
		this.idBallot = idBallot;
	}


	public Integer getIdVehicle() {
		return idVehicle;
	}


	public void setIdVehicle(Integer idVehicle) {
		this.idVehicle = idVehicle;
	}


	public String getBallotNumber() {
		return ballotNumber;
	}


	public void setBallotNumber(String ballotNumber) {
		this.ballotNumber = ballotNumber;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Integer getIdInfraction() {
		return idInfraction;
	}


	public void setIdInfraction(Integer idInfraction) {
		this.idInfraction = idInfraction;
	}


}
