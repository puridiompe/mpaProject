/**
 * 
 */
package pe.andromeda.restaurant.business.pedidos.dto;

import java.util.List;

/**
 * @author
 *
 */
public class PedidoDto {

	private Integer id;

	private ClienteDto cliente;

	private String comentario;

	private List<ProductoSolicitadoDto> productos;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the cliente
	 */
	public ClienteDto getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
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
	 * @return the productos
	 */
	public List<ProductoSolicitadoDto> getProductos() {
		return productos;
	}

	/**
	 * @param productos
	 *            the productos to set
	 */
	public void setProductos(List<ProductoSolicitadoDto> productos) {
		this.productos = productos;
	}

}
