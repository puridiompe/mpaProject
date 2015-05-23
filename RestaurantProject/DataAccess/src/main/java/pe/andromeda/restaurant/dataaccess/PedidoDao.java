/**
 * 
 */
package pe.andromeda.restaurant.dataaccess;

import java.util.List;

import pe.andromeda.restaurant.business.pedidos.dto.ClienteDto;
import pe.andromeda.restaurant.business.pedidos.dto.PedidoDto;

/**
 * @author
 *
 */
public interface PedidoDao {

	public void savePedido(PedidoDto pedido);

	public List<PedidoDto> getPedidosCliente(ClienteDto cliente);
}
