package com.puridiompe.mpa.common.type;

/**
 * 
 * @author Lucho
 *
 */
public enum ReclamoState {
	RECIBIDO("R"), ENPROCESO("P"), ARCHIVADO("A");
	
	private final String typeValue;
	
	private ReclamoState(final String typeValue){
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
