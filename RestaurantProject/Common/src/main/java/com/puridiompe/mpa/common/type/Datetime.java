/**
 * 
 */
package com.puridiompe.mpa.common.type;

import java.util.Date;

/**
 * @author
 *
 */
@SuppressWarnings("serial")
public class Datetime extends Date {

	public Datetime() {
		super();
	}

	public Datetime(Date date) {
		super(date.getTime());
	}
}
