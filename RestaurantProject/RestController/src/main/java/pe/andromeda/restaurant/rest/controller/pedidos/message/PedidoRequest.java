/**
 * 
 */
package pe.andromeda.restaurant.rest.controller.pedidos.message;

import pe.andromeda.restaurant.business.pedidos.dto.PedidoDto;
import pe.andromeda.restaurant.rest.controller.message.RequestBody;

/**
 * @author
 *
 */
public class PedidoRequest extends RequestBody {

	private PedidoDto pedido;

	/**
	 * @return the pedido
	 */
	public PedidoDto getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(PedidoDto pedido) {
		this.pedido = pedido;
	}

}
