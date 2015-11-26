package com.puridiompe.mpa.sistran.repository.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.puridiompe.mpa.movil.domain.persistence.PermisoUrbanoEmpresa;
import com.puridiompe.mpa.sistran.domain.persistence.PermisoOperacionUrbano;

public interface PermisoOperacionUrbanoRepository extends JpaRepository<PermisoOperacionUrbano, Integer>{
	
	
	@Query("select new com.puridiompe.mpa.movil.domain.persistence.PermisoUrbanoEmpresa(f.vehiculo, p.fechaEmision, p.fechaVencimiento, p.observacion, p.numero, e.razonSocial) from  PermisoOperacionUrbano p, Flota f, Empresa e  where f.empresa = e.codigo and p.flota = f.id and f.vehiculo = ?1 order by p.fechaVencimiento desc ") //and r.estado != ?2
	public List<PermisoUrbanoEmpresa> findUrbanoByVehiculo(String vehiculo);
	
	
	
	
	/**
	 * find infracciones by numero
	 * 
	 * @param numero
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.numero = ?1")
	public PermisoOperacionUrbano findByNumero(Integer numero);
	
	/**
	 * find infracciones by liquidacion
	 * 
	 * @param liquidacion
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.liquidacion = ?1")
	public PermisoOperacionUrbano findByLiquidacion(Integer liquidacion);
	
	/**
	 * find infracciones by flota
	 * 
	 * @param flota
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.flota = ?1")
	public PermisoOperacionUrbano findByFlota(Integer flota);
	
	/**
	 * find infracciones by historiaEmpresa
	 * 
	 * @param historiaEmpresa
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.historiaEmpresa = ?1")
	public PermisoOperacionUrbano findByHistoriaEmpresa(Integer historiaEmpresa);
	
	/**
	 * find infracciones by colorEmpresa
	 * 
	 * @param colorEmpresa
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.colorEmpresa = ?1")
	public PermisoOperacionUrbano findByColorEmpresa(String colorEmpresa);
	
	/**
	 * find infracciones by historicoSocial
	 * 
	 * @param historicoSocial
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.historicoSocial = ?1")
	public PermisoOperacionUrbano findByHistoricoSocial(Integer historicoSocial);
	
	/**
	 * find infracciones by historiaVehiculo
	 * 
	 * @param historiaVehiculo
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.historiaVehiculo = ?1")
	public PermisoOperacionUrbano findByHistoriaVehiculo(Integer historiaVehiculo);
	
	/**
	 * find infracciones by historiaProceso
	 * 
	 * @param historiaProceso
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.historiaProceso = ?1")
	public PermisoOperacionUrbano findByHistoriaProceso(Integer historiaProceso);
	
	/**
	 * find infracciones by colorVehiculo
	 * 
	 * @param colorVehiculo
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.colorVehiculo = ?1")
	public PermisoOperacionUrbano findByColorVehiculo(String colorVehiculo);
	
	/**
	 * find infracciones by autorizacion
	 * 
	 * @param autorizacion
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.autorizacion = ?1")
	public PermisoOperacionUrbano findByAutorizacion(Integer autorizacion);
	
	/**
	 * find infracciones by historiaRuta
	 * 
	 * @param historiaRuta
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.historiaRuta = ?1")
	public PermisoOperacionUrbano findByHistoriaRuta(Integer historiaRuta);
	
	/**
	 * find infracciones by certificadoConducirEmitido
	 * 
	 * @param certificadoConducirEmitido
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.certificadoConducirEmitido = ?1")
	public PermisoOperacionUrbano findByCertificadoConducirEmitido(Integer certificadoConducirEmitido);
	
	/**
	 * find infracciones by fechaInicio
	 * 
	 * @param fechaInicio
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.fechaInicio = ?1")
	public PermisoOperacionUrbano findByFechaInicio(Date fechaInicio);
	
	/**
	 * find infracciones by fechaVencimiento
	 * 
	 * @param fechaVencimiento
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.fechaVencimiento = ?1")
	public PermisoOperacionUrbano findByFechaVencimiento(Date fechaVencimiento);
	
	/**
	 * find infracciones by numeroRecibo
	 * 
	 * @param numeroRecibo
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.numeroRecibo = ?1")
	public PermisoOperacionUrbano findByNumeroRecibo(String numeroRecibo);
	
	/**
	 * find infracciones by fechaPago
	 * 
	 * @param fechaPago
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.fechaPago = ?1")
	public PermisoOperacionUrbano findByFechaPago(Date fechaPago);
	
	/**
	 * find infracciones by numeroImpuesto
	 * 
	 * @param numeroImpuesto
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.numeroImpuesto = ?1")
	public PermisoOperacionUrbano findByNumeroImpuesto(Integer numeroImpuesto);
	
	/**
	 * find infracciones by estado
	 * 
	 * @param estado
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.estado = ?1")
	public PermisoOperacionUrbano findByEstado(Integer estado);
	
	/**
	 * find infracciones by usuario
	 * 
	 * @param usuario
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.usuario = ?1")
	public PermisoOperacionUrbano findByUsuario(String usuario);
	
	/**
	 * find infracciones by fechaActivacion
	 * 
	 * @param fechaActivacion
	 * @return
	 */
	@Query("from PermisoOperacionUrbano p where p.fechaActivacion = ?1")
	public PermisoOperacionUrbano findByNumeroFechaActivacion(Date fechaActivacion);
	
	
}
