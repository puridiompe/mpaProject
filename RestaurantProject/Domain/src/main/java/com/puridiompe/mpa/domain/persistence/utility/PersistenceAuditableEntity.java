/**
 * 
 */
package com.puridiompe.mpa.domain.persistence.utility;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * @author Puridiom-PE
 *
 */
@MappedSuperclass
@EntityListeners(value = { AuditEntityListener.class })
@SuppressWarnings("serial")
public abstract class PersistenceAuditableEntity<T> extends
		PersistableEntity<T> {

	// @Column(name = "CREATED_BY", nullable = false)
	// private String createdBy;
	//
	// @Column(name = "CREATED_DATE", nullable = false)
	// private Date createdDate;
	//
	// @Column(name = "LAST_CHANGED_BY", nullable = false)
	// private String lastChangedBy;
	//
	// @Column(name = "LAST_CHANGED_DATE", nullable = false)
	// private Date lastChangedDate;

	@Column(name = "\"estado\"", nullable = false)
	private String estado;

	@Column(name = "\"fecCre\"", nullable = false)
	private Date fecCre;

	@Column(name = "\"fecMod\"", nullable = true)
	private Date fecMod;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	// /**
	// * @return the createdBy
	// */
	// public String getCreatedBy() {
	// return createdBy;
	// }
	//
	// /**
	// * @param createdBy
	// * the createdBy to set
	// */
	// protected void setCreatedBy(String createdBy) {
	// this.createdBy = createdBy;
	// }
	//
	// /**
	// * @return the createdDate
	// */
	// public Date getCreatedDate() {
	// return createdDate;
	// }
	//
	// /**
	// * @param createdDate
	// * the createdDate to set
	// */
	// protected void setCreatedDate(Date createdDate) {
	// this.createdDate = createdDate;
	// }
	//
	// /**
	// * @return the lastChangedBy
	// */
	// public String getLastChangedBy() {
	// return lastChangedBy;
	// }
	//
	// /**
	// * @param lastChangedBy
	// * the lastChangedBy to set
	// */
	// protected void setLastChangedBy(String lastChangedBy) {
	// this.lastChangedBy = lastChangedBy;
	// }
	//
	// /**
	// * @return the lastChangedDate
	// */
	// public Date getLastChangedDate() {
	// return lastChangedDate;
	// }
	//
	// /**
	// * @param lastChangedDate
	// * the lastChangedDate to set
	// */
	// protected void setLastChangedDate(Date lastChangedDate) {
	// this.lastChangedDate = lastChangedDate;
	// }

}
