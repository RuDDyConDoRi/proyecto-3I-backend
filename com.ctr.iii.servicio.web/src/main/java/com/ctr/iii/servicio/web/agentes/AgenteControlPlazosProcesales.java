package com.ctr.iii.servicio.web.agentes;

import jade.wrapper.gateway.GatewayAgent;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;
import jade.wrapper.gateway.*;
import java.util.Properties;

import com.ctr.iii.servicio.web.dto.CasoPP;

public class AgenteControlPlazosProcesales extends GatewayAgent {
	
	CasoPP casoPP = null;

	protected void processCommand(java.lang.Object obj) {
		// comprobamos que el objeto recibido sea un casoPP
		if (obj instanceof CasoPP) {
			casoPP = (CasoPP) obj;
			System.out.println("--> "+casoPP.getCodigoCaso());
			// comprobamos que el casoPP y contraseña las predefinidas
			if (casoPP.getCodigoCaso().equals("CASO-001")) {
				casoPP.setNro(1);
				casoPP.setResponsable("usuario logeado");
				casoPP.setTipoCaso("Corrupcion");
			} else {
				casoPP.setCodigoCaso(null);
			}
			// devolvemos el objeto casoPP al servlet con la autentificación
			releaseCommand(casoPP);
		}
	}

	public void setup() {
		super.setup();
	}
}
