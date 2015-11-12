package com.puridiompe.mpa.common.type;

public enum HistorialReclamoAccion {
	CREACION("CREACION"), CAMBIO_ESTADO("CAMBIO_ESTADO"), COMENTARIO("COMENTARIO");
	
	private final String typeValue;
	
	private HistorialReclamoAccion(final String typeValue){
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
