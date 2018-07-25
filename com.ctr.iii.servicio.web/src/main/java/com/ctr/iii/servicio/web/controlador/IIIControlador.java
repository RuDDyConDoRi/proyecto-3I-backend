package com.ctr.iii.servicio.web.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ctr.iii.servicio.ICasosServicio;
import com.ctr.iii.servicio.respuesta.ResDatosCierre;
import com.ctr.iii.servicio.respuesta.ResRecuperarCasos;
import com.ctr.iii.servicio.respuesta.ResRecuperarElemConv;
import com.ctr.iii.servicio.respuesta.Utilidades;
import com.ctr.iii.servicio.solicitud.SolRecuperarCasos;
import com.ctr.iii.servicio.solicitud.SolRecuperarElemConv;
import com.ctr.iii.servicio.web.agentes.Accion;
import com.ctr.iii.servicio.web.agentes.AccionEnviarMensaje;
import com.ctr.iii.servicio.web.agentes.Mensaje;
import com.ctr.iii.servicio.web.config.FileMeta;
import com.ctr.iii.servicio.web.dto.CasoPP;
import com.ctr.iii.servicio.web.dto.DatosCierreDto;

import jade.util.leap.Properties;
import jade.wrapper.gateway.JadeGateway;

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

	@RequestMapping(value = "/iniciar/agente", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<CasoPP> iniciarAgente() {
		logger.info("Ingresa||iniciarAgente");

		JadeGateway.init("com.ctr.iii.servicio.web.agentes.AgenteControlPlazosProcesales",
				new jade.util.leap.Properties());

		List<CasoPP> casosPP = new ArrayList<CasoPP>();
		casosPP.add(new CasoPP(1, "Corrupcion", "COD-C001-23042018", "Rigoberto Rigus"));
		casosPP.add(new CasoPP(2, "Robo", "COD-R001-21042018", "Romer Vale"));
		casosPP.add(new CasoPP(3, "Racismo", "COD-RA01-20042018", "Juan Mark"));
		casosPP.add(new CasoPP(4, "Discriminacion", "COD-D001-22042018", "Joe Huarachi"));
		casosPP.add(new CasoPP(5, "Asesinato", "COD-A001-20042018", "Maure Lozano"));

		// String nombreAccion = request.getParameter("accion");

		CasoPP casoPP = new CasoPP();
		casoPP.setCodigoCaso("CASO-001");
		// request.getParameter("caso"));
		// usuario.setContrase�a(request.getParameter("contrasena"));
		// mandamos el usuario al agente GateWayAgent de JADE
		try {
			JadeGateway.execute(casoPP);
		} catch (Exception e) {
			e.printStackTrace();
		}

		casosPP.add(casoPP);

		logger.info("Sale||iniciarAgente");
		return casosPP;
	}

	@RequestMapping(value = "/agente/cierre", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResDatosCierre iniciarAgenteCierre(@RequestBody SolRecuperarElemConv solicitud) {
		logger.info("Ingresa||iniciarAgenteCierre");

		ResDatosCierre resultado = new ResDatosCierre();
		ResRecuperarElemConv elementosCierre = casosServicio.recuperarElemConv(solicitud);
		logger.info("========> " + solicitud.getAtributos().length + " == " + solicitud.getTabla().length);

		Hashtable acciones = new Hashtable();
		acciones.put("enviarmensaje", new AccionEnviarMensaje());

		Properties propiedades = new Properties();
		propiedades.setProperty("container", "Main-Container");
		// enlace con el agente GateWay de JADE
		JadeGateway.init("com.ctr.iii.servicio.web.agentes.AgenteCierreGateWay", propiedades);

		DatosCierreDto datosCierre = new DatosCierreDto();
		List<String> nombreAtri = new ArrayList<String>();
		for (int i = 0; i < solicitud.getAtributos().length; i++) {
			nombreAtri.add(solicitud.getAtributos()[i]);
		}
		datosCierre.setAtributos(nombreAtri);

		List<List<String>> tabla = new ArrayList<List<String>>();
		String[][] tablaDatos = solicitud.getTabla();
		for (int i = 0; i < tablaDatos.length; i++) {
			List<String> lista = new ArrayList<String>();
			for (int j = 0; j < tablaDatos[i].length; j++) {
				lista.add(tablaDatos[i][j]);
			}
			tabla.add(lista);
		}

		datosCierre.setTabla(tabla);

		Mensaje mensaje = new Mensaje();
		mensaje.setDatosCierre(datosCierre);

		Accion accion = (Accion) acciones.get("enviarmensaje");
		if (accion != null) {
			accion.enviar(mensaje, datosCierre);

			resultado.setAtributos(Utilidades.aCadenas(mensaje.getMessage().split(";")[1], ","));
			resultado.setValores(Utilidades.aDouble(mensaje.getMessage().split(";")[2].replaceAll("}]", "}"), ","));
			resultado.setRespuesta(mensaje.getMessage());
			resultado.setOk(true);
		}

		logger.info("Sale||iniciarAgenteCierre");
		return resultado;
	}
}