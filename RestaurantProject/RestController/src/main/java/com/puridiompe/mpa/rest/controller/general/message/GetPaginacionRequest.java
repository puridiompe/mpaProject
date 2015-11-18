
package com.puridiompe.mpa.rest.controller.general.message;

import com.puridiompe.mpa.common.rest.message.RequestBody;

public class GetPaginacionRequest extends RequestBody{

    private int rowStart;
	
	private int rowEnd;
	
	private int rowsTotal;
	
	private int pageSize;
	
	private int pageCount;
	
	private int pagesTotal;

	public int getRowStart() {
		return rowStart;
	}

	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}

	public int getRowEnd() {
		return rowEnd;
	}

	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}

	public int getRowsTotal() {
		return rowsTotal;
	}

	public void setRowsTotal(int rowsTotal) {
		this.rowsTotal = rowsTotal;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPagesTotal() {
		return pagesTotal;
	}

	public void setPagesTotal(int pagesTotal) {
		this.pagesTotal = pagesTotal;
	}
	
}
