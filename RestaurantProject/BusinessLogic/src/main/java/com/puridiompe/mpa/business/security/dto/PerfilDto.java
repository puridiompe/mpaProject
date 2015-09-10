/**
 * 
 */
package com.puridiompe.mpa.business.security.dto;

import java.util.Date;

import org.springframework.security.core.GrantedAuthority;

import com.puridiompe.mpa.common.security.SystemRole;

/**
 * @author 
 *
 */
@SuppressWarnings("serial")
public class PerfilDto implements GrantedAuthority {

	private final SystemRole rolSistema;

	private final Date fechaActualizacion;

	public PerfilDto(final String rolSistema, final Date fechaActualizacion)
			throws Exception {
		this.rolSistema = SystemRole.getValue(rolSistema);
		this.fechaActualizacion = fechaActualizacion;
	}

	/**
	 * @return the perfil
	 */
	public SystemRole getRol() {
		return rolSistema;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return rolSistema.toString();
	}

}
