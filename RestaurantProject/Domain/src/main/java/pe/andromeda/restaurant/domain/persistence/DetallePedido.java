/**
 * 
 */
package pe.andromeda.restaurant.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pe.andromeda.restaurant.domain.persistence.utility.PersistenceAuditableEntity;

/**
 * @author
 *
 */
@Entity
@Table(name = "DETALLE_PEDIDO")
@SuppressWarnings("serial")
public class DetallePedido extends PersistenceAuditableEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_DETALLE_PEDIDO", nullable = false, unique = true)
	private Integer idDetallePedido;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PEDIDO", nullable = false)
	private Pedido pedido;

	@Column(name = "DESCRIPCION", nullable = false)
	private String descripcion;

	@Column(name = "COMENTARIO", nullable = true)
	private String comentario;

	@Column(name = "CANTIDAD", nullable = false)
	private Integer cantidad;

	@Override
	public Integer getId() {
		return idDetallePedido;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario
	 *            the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
