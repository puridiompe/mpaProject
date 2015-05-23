/**
 * 
 */
package pe.andromeda.restaurant.rest.controller.seguridad;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pe.andromeda.restaurant.rest.controller.message.ResponseMessage;
import pe.andromeda.restaurant.rest.controller.seguridad.message.LoginRequest;
import pe.andromeda.restaurant.rest.controller.seguridad.message.LoginResponse;

/**
 * @author
 *
 */
@RestController
public class AuthenticationController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	, headers = "Accept=application/json", produces = "application/json"
	public @ResponseBody ResponseMessage login(@RequestBody LoginRequest request) {

		LoginResponse response = new LoginResponse();

		response.setUsername(request.getUsername());
		response.setLastLogin(new Date());
		response.setStatus("OK");
		return response;
	}
}
