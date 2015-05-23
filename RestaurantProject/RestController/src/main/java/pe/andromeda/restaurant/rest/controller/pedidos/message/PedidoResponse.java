/**
 * 
 */
package pe.andromeda.restaurant.rest.controller.pedidos.message;

import pe.andromeda.restaurant.rest.controller.message.ResponseBody;

/**
 * @author
 *
 */
public class PedidoResponse extends ResponseBody {

	private String cliente;

	private String estado;

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
