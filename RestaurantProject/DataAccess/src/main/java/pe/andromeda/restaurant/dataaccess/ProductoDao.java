/**
 * 
 */
package pe.andromeda.restaurant.dataaccess;

import java.util.List;

import pe.andromeda.restaurant.business.pedidos.dto.ProductoDto;

/**
 * @author Johnny
 *
 */
public interface ProductoDao {
	
	public List<ProductoDto> findDisponibles();
}
