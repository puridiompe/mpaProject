/**
 * 
 */
package pe.andromeda.restaurant.business.pedidos;

import java.util.List;

import pe.andromeda.restaurant.business.pedidos.dto.ProductoDto;

/**
 * @author
 *
 */
public interface GestionarProductoBusiness {

	public List<ProductoDto> getProductosDisponibles();
}
