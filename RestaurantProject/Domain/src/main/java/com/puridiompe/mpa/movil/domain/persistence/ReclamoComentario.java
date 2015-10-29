package com.puridiompe.mpa.movil.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.puridiompe.mpa.domain.persistence.utility.PersistenceAuditableEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "\"TrMov_RecCom\"")
public class ReclamoComentario extends PersistenceAuditableEntity<Integer>{
	
	@Id
	@Column(name = "\"id\"", unique = true, nullable = false)
	@SequenceGenerator(name = "reclamoComentario_sequence", sequenceName = "\"TrMov_RecDes_id_seq\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "reclamoComentario_sequence")
	private Integer id;
	
	@Column(name = "\"idRec\"", nullable = false)
	private Integer idReclamo;
	
	@Column(name = "\"comentario\"", nullable = false)
	private String comentario;	
	
	public ReclamoComentario (){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdReclamo() {
		return idReclamo;
	}

	public void setIdReclamo(Integer idReclamo) {
		this.idReclamo = idReclamo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
