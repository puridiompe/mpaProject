package com.puridiompe.mpa.dataaccess.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.puridiompe.mpa.dataaccess.ImagenDao;
import com.puridiompe.mpa.movil.domain.persistence.Imagen;
import com.puridiompe.mpa.movil.repository.persistence.ImagenRepository;

public class ImagenDaoImpl implements ImagenDao{
	
	@Autowired
	private ImagenRepository imagenRepository;
	
	@Transactional(value = "movilTransactionManager")
	@Override
	public void setImagen (String tipoEntidad, String nombre, String tipo, Integer tamanho){
		
		Imagen imagen = new Imagen();
		
		imagen.setTipoEntidad(tipoEntidad);
		imagen.setNombre(nombre);
		imagen.setTipo(tipo);
		imagen.setTamanho(tamanho);
		
		imagenRepository.save(imagen);
		
	}

}
