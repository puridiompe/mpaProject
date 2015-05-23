/**
 * 
 */
package pe.andromeda.restaurant.business.impl.pedidos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.andromeda.restaurant.business.exception.BusinessException;
import pe.andromeda.restaurant.business.pedidos.GestionarPedidoBusiness;
import pe.andromeda.restaurant.business.pedidos.dto.PedidoDto;
import pe.andromeda.restaurant.business.pedidos.exception.PedidoPendienteException;
import pe.andromeda.restaurant.dataaccess.PedidoDao;

/**
 * @author
 *
 */
@Service
public class GestionarPedidoBusinessImpl implements GestionarPedidoBusiness {

	@Autowired
	private PedidoDao pedidoDao;

	@Override
	public void generarNuevoPedido(PedidoDto pedido) throws BusinessException {

		List<PedidoDto> pedidoPendiente = pedidoDao.getPedidosCliente(pedido.getCliente());

		if (pedidoPendiente == null || pedidoPendiente.isEmpty()) {
			pedidoDao.savePedido(pedido);
		} else {
			throw new PedidoPendienteException("00000", "Cliente tiene pedidos pendientes");
		}

	}
}
