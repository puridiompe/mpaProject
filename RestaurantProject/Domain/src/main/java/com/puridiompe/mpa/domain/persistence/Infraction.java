package com.puridiompe.mpa.domain.persistence;

import java.math.BigDecimal;

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
@Table(name = "INFRACTION")
public class Infraction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_INFRACTION", nullable = false, unique = true)
	private Integer idInfraction;
	
	@Column(name = "CODE", length = 10)
	private String code;
	
	@Column(name = "DESCRIPTION", length = 255)
	private String description;
	
	@Column(name = "GRAVITY", length = 25)
	private String gravity;
	
	@Column(name = "AMOUNT", precision = 10, scale = 5)
	private BigDecimal amount;
	
	@Column(name = "DISCOUNT", precision = 10, scale = 5)
	private BigDecimal discount;
	
	@Column(name = "PENALTY", length = 255)
	private String penalty;
	
	@Column(name ="SCORES")
	private Integer scores;
	
	@Column(name = "PREVENTIVE_MEASURE", length = 100)
	private String preventiveMeasure;

	
	/**
	 * Default Constructor
	 */
	public Infraction() {
		
	}


	/**
	 * Getters and Setters
	 * @return
	 */
	public Integer getIdInfraction() {
		return idInfraction;
	}


	public void setIdInfraction(Integer idInfraction) {
		this.idInfraction = idInfraction;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getGravity() {
		return gravity;
	}


	public void setGravity(String gravity) {
		this.gravity = gravity;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public BigDecimal getDiscount() {
		return discount;
	}


	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}


	public String getPenalty() {
		return penalty;
	}


	public void setPenalty(String penalty) {
		this.penalty = penalty;
	}


	public Integer getScores() {
		return scores;
	}


	public void setScores(Integer scores) {
		this.scores = scores;
	}


	public String getPreventiveMeasure() {
		return preventiveMeasure;
	}


	public void setPreventiveMeasure(String preventiveMeasure) {
		this.preventiveMeasure = preventiveMeasure;
	}
	
}
