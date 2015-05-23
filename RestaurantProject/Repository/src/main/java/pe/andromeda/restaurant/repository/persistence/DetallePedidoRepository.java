/**
 * 
 */
package pe.andromeda.restaurant.repository.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;

import pe.andromeda.restaurant.domain.persistence.Pedido;

/**
 * @author
 *
 */
public interface DetallePedidoRepository extends
		PagingAndSortingRepository<Pedido, Integer> {

}
