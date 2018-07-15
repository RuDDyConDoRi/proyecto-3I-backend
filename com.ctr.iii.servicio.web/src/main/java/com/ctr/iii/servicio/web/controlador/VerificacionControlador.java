package com.ctr.iii.servicio.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
class VerificacionControlador {

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public String resultadoVerificacion() {
		return "Resultado de verificacion del Servicio REST";
	}

}
