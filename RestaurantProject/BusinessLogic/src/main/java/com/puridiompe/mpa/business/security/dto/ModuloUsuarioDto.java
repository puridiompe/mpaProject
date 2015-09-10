/**
 * 
 */
package com.puridiompe.mpa.business.security.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.puridiompe.mpa.common.security.SystemModule;

/**
 * @author 
 *
 */
public class ModuloUsuarioDto {

	private final UsuarioDto usuario;

	private List<SystemModule> modulos;

	private final Date fechaActualizacion;

	public ModuloUsuarioDto(final UsuarioDto usuario,
			final Date fechaActualizacion) {
		this.usuario = usuario;
		this.modulos = new ArrayList<SystemModule>();
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDto getUsuario() {
		return usuario;
	}

	/**
	 * @return the modulos
	 */
	public List<SystemModule> getModulos() {
		return modulos;
	}

	/**
	 * 
	 * @param modulo
	 * @throws Exception
	 */
	public void addModulo(String modulo) {
		this.modulos.add(SystemModule.getByValue(modulo));
	}

	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

}
