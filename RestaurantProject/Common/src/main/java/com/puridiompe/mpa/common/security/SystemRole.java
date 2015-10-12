/**
 * 
 */
package com.puridiompe.mpa.common.security;

/**
 * @author Johnny
 *
 */
public enum SystemRole {
	ADMINISTRADOR("ADM"), SUPERVISOR("SUP"), INSPECTOR("INS"), CIUDADANO("CIU");

	private final String typeValue;

	private SystemRole(final String typeValue) {
		this.typeValue = typeValue;
	}

	/**
	 * @return the typeValue
	 */
	protected String getTypeValue() {
		return typeValue;
	}

	public static SystemRole getValue(final String typeValue) throws Exception {
		SystemRole labelType = null;

		for (SystemRole modulo : values()) {
			if (modulo.getTypeValue().equalsIgnoreCase(typeValue)) {
				labelType = modulo;
				break;
			}
		}

		if (labelType == null) {
			throw new Exception("Rol " + typeValue
					+ " desconocido, no es un valor válido");
		}

		return labelType;
	}

	@Override
	public String toString() {
		return getTypeValue();
	}
}
