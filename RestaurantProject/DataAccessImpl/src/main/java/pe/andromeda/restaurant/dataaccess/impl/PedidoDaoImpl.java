/**
 * 
 */
package pe.andromeda.restaurant.dataaccess.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pe.andromeda.restaurant.business.pedidos.dto.ClienteDto;
import pe.andromeda.restaurant.business.pedidos.dto.PedidoDto;
import pe.andromeda.restaurant.business.pedidos.dto.ProductoSolicitadoDto;
import pe.andromeda.restaurant.dataaccess.PedidoDao;
import pe.andromeda.restaurant.domain.persistence.DetallePedido;
import pe.andromeda.restaurant.domain.persistence.Pedido;
import pe.andromeda.restaurant.repository.persistence.PedidoRepository;

/**
 * @author
 *
 */
@Component
public class PedidoDaoImpl implements PedidoDao {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void savePedido(PedidoDto pedido) {

		Integer numeroPedido = generateNumeroPedido();
		Pedido nuevoPedido = new Pedido();

		nuevoPedido.setNumero(numeroPedido);
		nuevoPedido.setComentario(pedido.getComentario());

		// Add detalles pedido
		List<DetallePedido> detalles = new ArrayList<DetallePedido>();
		DetallePedido nuevoDetalle;

		for (ProductoSolicitadoDto producto : pedido.getProductos()) {

			nuevoDetalle = new DetallePedido();

			nuevoDetalle.setCantidad(producto.getCantidad());
			nuevoDetalle.setDescripcion(producto.getDescripcion());

			detalles.add(nuevoDetalle);
		}

		nuevoPedido.setDetalles(detalles);

		pedidoRepository.save(nuevoPedido);
	}

	@Override
	public List<PedidoDto> getPedidosCliente(ClienteDto cliente) {

		List<Pedido> pedidos = pedidoRepository.findPedidosPendientes(cliente
				.getId());
		
		pedidos.size();

		return null;
	}

	private synchronized Integer generateNumeroPedido() {
		Random randomGenerator = new Random();

		return randomGenerator.nextInt(1000000);
	}

}
