/**
 * 
 */
package com.puridiompe.mpa.domain.persistence.utility;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * @author Puridiom-PE
 *
 */
public class AuditEntityListener {

	@PrePersist
	public void prePersist(PersistenceAuditableEntity entity) {

		String currentUser = "admin";
		Date actualDate = new Date();

		entity.setCreatedBy(currentUser);
		entity.setCreatedDate(actualDate);

		entity.setLastChangedBy(currentUser);
		entity.setLastChangedDate(actualDate);

	}

	@PreUpdate
	public void preUpdate(PersistenceAuditableEntity entity) {
		String currentUser = "admin";
		Date actualDate = new Date();

		entity.setLastChangedBy(currentUser);
		entity.setLastChangedDate(actualDate);
	}
}
