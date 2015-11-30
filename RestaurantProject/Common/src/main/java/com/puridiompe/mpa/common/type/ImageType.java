package com.puridiompe.mpa.common.type;

/**
 * 
 * @author Lucho
 *
 */
public enum ImageType {
	RECLAMO("REC"), NOTICIA("NOT"), ACTA("ACT");
	
	private final String typeValue;
	
	private ImageType(final String typeValue){
		this.typeValue = typeValue;
	}
	
	protected String getTypeValue(){
		return typeValue;
	}
	
	@Override
	public String toString() {
		return getTypeValue();
	}

}
