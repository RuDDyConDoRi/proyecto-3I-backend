package com.ctr.iii.servicio.web.agentes;

/**
*
* @author RuDDy
*/

/**
* ***************************************************************
*
* La clase AccionEnviarMensaje sale fuera del servlet y envía el mensaje al
* AgenteGateWay
*
****************************************************************
*/
import jade.wrapper.gateway.JadeGateway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctr.iii.servicio.web.dto.DatosCierreDto;

//import mensaje.Mensaje;

public class AccionEnviarMensaje implements Accion {

	public void enviar(Mensaje response, DatosCierreDto datosCierre){

		// creamos un mensaje con un destinatario y contenido predefinido
		System.out.println("creamos un mensaje con un destinatario y contenido predefinido");
		Mensaje mensaje = new Mensaje();
		mensaje.setReceiver("AgenteCierre");
		mensaje.setMessage("== Agente genere un arbol de desicion para estos datos ==");
		mensaje.setDatosCierre(datosCierre);

		try {
			// accedemos a JADE via JadeGateWay e esperamos la contestación
			JadeGateway.execute(mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// creamos la salida
		// response.setContentType("text/html");
		response.setMessage(mensaje.toString());
		System.out.println("--MENSAJE--> "+ mensaje.toString());

	}

}