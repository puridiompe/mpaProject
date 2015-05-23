/**
 * 
 */
package pe.andromeda.restaurant.business.pedidos.exception;

import pe.andromeda.restaurant.business.exception.BusinessException;

/**
 * @author
 *
 */
@SuppressWarnings("serial")
public class PedidoPendienteException extends BusinessException {

	public PedidoPendienteException(String code, String message) {
		super(code, message);
	}

	public PedidoPendienteException(String code, String message,
			Exception exception) {
		super(code, message, exception);
	}

}
