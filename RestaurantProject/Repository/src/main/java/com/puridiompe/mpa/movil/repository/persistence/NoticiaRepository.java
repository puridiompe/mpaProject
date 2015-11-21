package com.puridiompe.mpa.movil.repository.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

	/**
	 * get all Noticia when estado = 1
	 * 
	 * @param idUsuario
	 * @return
	 */

	@Query("from Noticia p where p.estado = '1' order by p.fecPub desc")
	public List<Noticia> findByEstado(Pageable paging);
	
	@Query("select count (*) from Noticia r ")
	public int findTotalNoticias();
}
