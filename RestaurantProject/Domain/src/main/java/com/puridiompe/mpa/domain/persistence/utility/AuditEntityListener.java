/**
 * 
 */
package com.puridiompe.mpa.domain.persistence.utility;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.puridiompe.mpa.common.util.DateUtil;

/**
 * @author Puridiom-PE
 *
 */
public class AuditEntityListener {

	@PrePersist
	public void prePersist(PersistenceAuditableEntity entity) {

//		String currentUser = "admin";
		Date actualDate = DateUtil.getCurrentDate();

//		entity.setCreatedBy(currentUser);
		
		if(entity.getEstado() == null){
			entity.setEstado("1");
		}
		entity.setFecCre(actualDate);

//		entity.setLastChangedBy(currentUser);
		entity.setFecMod(actualDate);

	}

	@PreUpdate
	public void preUpdate(PersistenceAuditableEntity entity) {
//		String currentUser = "admin";
		Date actualDate = DateUtil.getCurrentDate();

//		entity.setLastChangedBy(currentUser);
		entity.setFecMod(actualDate);
	}
}
