/**
 * 
 */
package pe.andromeda.restaurant.domain.persistence;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pe.andromeda.restaurant.domain.persistence.utility.PersistenceAuditableEntity;

/**
 * @author
 *
 */
@Entity
@Table(name = "PEDIDO")
@SuppressWarnings("serial")
public class Pedido extends PersistenceAuditableEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_PEDIDO", nullable = false, unique = true)
	private Integer idPedido;

	@Column(name = "NUMERO", nullable = false, unique = true)
	private Integer numero;

	@Column(name = "COMENTARIO", nullable = true)
	private String comentario;

	@Column(name = "TOTAL", nullable = false)
	private BigDecimal total;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE", nullable = false)
	private Cliente cliente;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "pedido")
	private List<DetallePedido> detalles;

	@Override
	public Integer getId() {
		return idPedido;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	 * @return the total
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * @return the detalles
	 */
	public List<DetallePedido> getDetalles() {
		return detalles;
	}

	/**
	 * @param detalles
	 *            the detalles to set
	 */
	public void setDetalles(List<DetallePedido> detalles) {
		this.detalles = detalles;
	}

}
