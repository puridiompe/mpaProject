/**
 * 
 */
package pe.andromeda.restaurant.repository.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import pe.andromeda.restaurant.domain.persistence.Pedido;

/**
 * @author
 *
 */
public interface PedidoRepository extends
		PagingAndSortingRepository<Pedido, Integer> {

	@Query("from Pedido p where p.cliente.idCliente = ?1")
	public List<Pedido> findPedidosPendientes(Integer idCliente);
}
