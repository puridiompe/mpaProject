package com.puridiompe.mpa.rest.controller.seguridad.message;

import java.util.ArrayList;
import java.util.List;

import com.puridiompe.mpa.business.security.dto.PerfilDto;
import com.puridiompe.mpa.common.rest.message.ResponseBody;


public class ApplicationResponse extends ResponseBody {
	
	private List<String> roles;
	
	public ApplicationResponse(){
		roles= new ArrayList<>();
	}

	public List<String> getRoles() {
		return roles;
	}
	
	
	public void setPerfil(List<PerfilDto> perfiles) {
		roles= new ArrayList<>();
		for (PerfilDto perfil: perfiles){
			this.roles.add(perfil.getAuthority());
		}
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}

