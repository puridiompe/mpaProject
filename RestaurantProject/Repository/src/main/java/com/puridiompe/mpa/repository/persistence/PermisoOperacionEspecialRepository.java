package com.puridiompe.mpa.repository.persistence;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.domain.persistence.Infraction;
import com.puridiompe.mpa.domain.persistence.PermisoOperacionEspecial;

public interface PermisoOperacionEspecialRepository extends JpaRepository<PermisoOperacionEspecial, Integer>{
	
	/**
	 * find infracciones by numeroPermisoOperacion
	 * 
	 * @param numeroPermisoOperacion
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.numeroPermisoOperacion = ?1")
	public PermisoOperacionEspecial findByNumeroPermisoOperacion(Integer numeroPermisoOperacion);
	
	/**
	 * find infracciones by flota
	 * 
	 * @param flota
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.flota = ?1")
	public PermisoOperacionEspecial findByFlota(Integer flota);
	
	/**
	 * find infracciones by vehiculo
	 * 
	 * @param vehiculo
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.vehiculo = ?1")
	public PermisoOperacionEspecial findByVehiculo(String vehiculo);
	
	/**
	 * find infracciones by fechaEmision
	 * 
	 * @param fechaEmision
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.fecEmi = ?1")
	public PermisoOperacionEspecial findByFechaEmision(Date fechaEmision);
	
	/**
	 * find infracciones by fechaVencimiento
	 * 
	 * @param fechaVencimiento
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.fecVen = ?1")
	public PermisoOperacionEspecial findByFechaVencimiento(Date fechaVencimiento);
	
	/**
	 * find infracciones by numeroRecibo
	 * 
	 * @param numeroRecibo
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.numRec = ?1")
	public PermisoOperacionEspecial findByNumeroRecibo(Integer numeroRecibo);
	
	/**
	 * find infracciones by fechaPago
	 * 
	 * @param fechaPago
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.fecPag = ?1")
	public PermisoOperacionEspecial findByFechaPago(Date fechaPago);
	
	/**
	 * find infracciones by numeroImpuesto
	 * 
	 * @param numeroImpuesto
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.numImp = ?1")
	public PermisoOperacionEspecial findByNumeroImpuesto(Integer numeroImpuesto);
	
	/**
	 * find infracciones by tipoOperacion
	 * 
	 * @param tipoOperacion
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.tipOpe = ?1")
	public PermisoOperacionEspecial findByTipoOperacion(String tipoOperacion);
	
	/**
	 * find infracciones by numeroExpediente
	 * 
	 * @param numeroExpediente
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.numExp = ?1")
	public PermisoOperacionEspecial findByNumeroExpediente(String numeroExpediente);
	
	/**
	 * find infracciones by fechaExpiracion
	 * 
	 * @param fechaExpiracion
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.fecExp = ?1")
	public PermisoOperacionEspecial findByFechaExpiracion(Date fechaExpiracion);
	
	/**
	 * find infracciones by estado
	 * 
	 * @param estado
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.estado = ?1")
	public PermisoOperacionEspecial findByEstado(Integer estado);
	
	/**
	 * find infracciones by historiaVehiculo
	 * 
	 * @param historiaVehiculo
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.hisVeh = ?1")
	public PermisoOperacionEspecial findByHistoriaVehiculo(Integer historiaVehiculo);
	
	/**
	 * find infracciones by historiaProceso
	 * 
	 * @param historiaProceso
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.hisPro = ?1")
	public PermisoOperacionEspecial findByHistoriaProceso(Integer historiaProceso);
	
	/**
	 * find infracciones by usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.usuario = ?1")
	public PermisoOperacionEspecial findByUsuario(String usuario);
	
	/**
	 * find infracciones by fechaActivacion
	 * 
	 * @param fechaActivacion
	 * @return
	 */
	@Query("from PermisoOperacionEspecial p where p.fecAct = ?1")
	public PermisoOperacionEspecial findByFechaActivacion(Date fechaActivacion);
	
	
}
