/**
 * 
 */
package pe.andromeda.restaurant.business.pedidos;

import pe.andromeda.restaurant.business.exception.BusinessException;
import pe.andromeda.restaurant.business.pedidos.dto.PedidoDto;

/**
 * @author
 *
 */
public interface GestionarPedidoBusiness {

	public void generarNuevoPedido(PedidoDto pedido) throws BusinessException;
}
