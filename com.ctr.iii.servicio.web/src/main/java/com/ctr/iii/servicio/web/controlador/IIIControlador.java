package com.ctr.iii.servicio.web.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;
import java.util.LinkedList;

import com.ctr.iii.servicio.ICasosServicio;
import com.ctr.iii.servicio.respuesta.ResRecuperarCasos;
import com.ctr.iii.servicio.solicitud.SolRecuperarCasos;
import com.ctr.iii.servicio.web.config.FileMeta;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping(value = "/iii")
public class IIIControlador {

	private static final Logger logger = LoggerFactory.getLogger(IIIControlador.class);

	@Autowired
	ICasosServicio casosServicio;
	
	
	/************************************ CasosServicio ***********************************************************/
	@RequestMapping(value = "/recuperar/casos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResRecuperarCasos recuperarCasos() {
		logger.info("Ingresa||recuperarCasos");

		SolRecuperarCasos solicitud = new SolRecuperarCasos();
		
		logger.info("Solicitud: ", solicitud);
		ResRecuperarCasos resultado = casosServicio.recuperarCasos(solicitud);

		logger.info("Sale||recuperarCasos");
		return resultado;
	}
		
}