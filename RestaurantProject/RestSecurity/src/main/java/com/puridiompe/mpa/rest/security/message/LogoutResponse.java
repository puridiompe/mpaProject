/**
 * 
 */
package com.puridiompe.mpa.rest.security.message;

import java.util.Date;

import com.puridiompe.mpa.common.rest.message.ResponseBody;

/**
 * @author Johnny
 *
 */
public class LogoutResponse extends ResponseBody {

	private String status;

	private Date lastLogout;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the lastLogout
	 */
	public Date getLastLogout() {
		return lastLogout;
	}

	/**
	 * @param lastLogout
	 *            the lastLogout to set
	 */
	public void setLastLogout(Date lastLogout) {
		this.lastLogout = lastLogout;
	}

}
