/**
 * 
 */
package pe.andromeda.restaurant.rest.controller.pedidos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.andromeda.restaurant.business.exception.BusinessException;
import pe.andromeda.restaurant.business.pedidos.GestionarPedidoBusiness;
import pe.andromeda.restaurant.rest.controller.BaseController;
import pe.andromeda.restaurant.rest.controller.message.RequestMessage;
import pe.andromeda.restaurant.rest.controller.message.ResponseMessage;
import pe.andromeda.restaurant.rest.controller.pedidos.message.PedidoRequest;
import pe.andromeda.restaurant.rest.controller.pedidos.message.PedidoResponse;

/**
 * @author
 *
 */
@RestController
public class RegistroPedidosController extends BaseController {

	@Autowired
	private GestionarPedidoBusiness gestionarPedidoBusiness;

	@RequestMapping(value = "/nuevopedido", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
	public @ResponseBody ResponseMessage<PedidoResponse> registrarNuevoPedido(
			@RequestBody RequestMessage<PedidoRequest> request)
			throws BusinessException {

		PedidoRequest pedidoRequest = request.getBody();

		gestionarPedidoBusiness.generarNuevoPedido(pedidoRequest.getPedido());

		ResponseMessage<PedidoResponse> response = new ResponseMessage<PedidoResponse>();

		PedidoResponse pedidoResponse = new PedidoResponse();

		// pedidoResponse.setCliente(pedidoRequest.getPedido().getCliente().getId());
		pedidoResponse.setEstado("OK");

		response.setBody(pedidoResponse);

		return response;
	}

}
