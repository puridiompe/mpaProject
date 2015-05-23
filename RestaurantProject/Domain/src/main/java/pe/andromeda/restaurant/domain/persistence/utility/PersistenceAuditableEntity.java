/**
 * 
 */
package pe.andromeda.restaurant.domain.persistence.utility;

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

	@Column(name = "CREATED_BY", nullable = false)
	private String createdBy;

	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	@Column(name = "LAST_CHANGED_BY", nullable = false)
	private String lastChangedBy;

	@Column(name = "LAST_CHANGED_DATE", nullable = false)
	private Date lastChangedDate;

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	protected void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	protected void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastChangedBy
	 */
	public String getLastChangedBy() {
		return lastChangedBy;
	}

	/**
	 * @param lastChangedBy
	 *            the lastChangedBy to set
	 */
	protected void setLastChangedBy(String lastChangedBy) {
		this.lastChangedBy = lastChangedBy;
	}

	/**
	 * @return the lastChangedDate
	 */
	public Date getLastChangedDate() {
		return lastChangedDate;
	}

	/**
	 * @param lastChangedDate
	 *            the lastChangedDate to set
	 */
	protected void setLastChangedDate(Date lastChangedDate) {
		this.lastChangedDate = lastChangedDate;
	}

}
