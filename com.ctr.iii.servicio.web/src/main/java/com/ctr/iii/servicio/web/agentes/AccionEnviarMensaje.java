package com.ctr.iii.servicio.web.agentes;

import com.ctr.iii.servicio.web.dto.DatosCierreDto;
import jade.wrapper.gateway.JadeGateway;

/**
*
* @author RuDDy
*/

public class AccionEnviarMensaje implements Accion {

	public void enviar(Mensaje response, DatosCierreDto datosCierre){

		// creamos un mensaje con un destinatario y contenido predefinido
		System.out.println("creamos un mensaje con un destinatario y contenido predefinido");
		
		Mensaje mensaje = new Mensaje();
		mensaje.setReceiver("AgenteResolutorCierre");
		mensaje.setMessage("== Agente genere un arbol de desicion para estos datos ==");
		mensaje.setDatosCierre(datosCierre);
		mensaje.setAtributos(datosCierre.getAtributos().toString());
        mensaje.setTabla(datosCierre.getTabla().toString());

		try {
			// accedemos a JADE via JadeGateWay e esperamos la contestacion
			JadeGateway.execute(mensaje);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// creamos la salida
		response.setMessage(mensaje.toString());
		System.out.println("--MENSAJE--> "+ mensaje.toString());

	}

}