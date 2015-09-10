/**
 * 
 */
package com.puridiompe.mpa.common.security;

/**
 * @author Johnny
 *
 */
public enum SystemModule {

	ADMINISTRACION("ADM", "administracion"), PERMISOS("PER", "permisos"), PAPELETAS(
			"PAP", "papeletas"), INFRACCIONES("INF", "infracciones");

	private final String typeValue;

	private final String name;

	private SystemModule(final String typeValue, final String name) {
		this.typeValue = typeValue;
		this.name = name;
	}

	/**
	 * @return the typeValue
	 */
	protected String getTypeValue() {
		return typeValue;
	}

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	public static SystemModule getByValue(final String typeValue) {
		SystemModule labelType = null;

		for (SystemModule modulo : values()) {
			if (modulo.getTypeValue().equalsIgnoreCase(typeValue)) {
				labelType = modulo;
				break;
			}
		}

		if (labelType == null) {
			// Logger.error(SystemModule.class, "Modulo " + typeValue
			// + " desconocido, no es un valor válido");
		}

		return labelType;
	}

	public static SystemModule getByName(final String name) {
		SystemModule labelType = null;

		for (SystemModule modulo : values()) {
			if (modulo.getName().equalsIgnoreCase(name)) {
				labelType = modulo;
				break;
			}
		}

		if (labelType == null) {
//			Logger.error(SystemModule.class, "Modulo " + name
//					+ " desconocido, no es un valor válido");
		}

		return labelType;
	}

	@Override
	public String toString() {
		return getTypeValue() + "-" + getName();
	}

}
