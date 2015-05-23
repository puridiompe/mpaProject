/**
 * 
 */
package pe.andromeda.restaurant.business.pedidos.dto;

/**
 * @author
 *
 */
public class ProductoSolicitadoDto extends ProductoDto {

	private int cantidad;

	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
