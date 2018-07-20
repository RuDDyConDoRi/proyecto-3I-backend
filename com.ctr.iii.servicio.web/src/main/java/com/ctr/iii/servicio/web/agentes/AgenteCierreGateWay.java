package com.ctr.iii.servicio.web.agentes;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;
import jade.wrapper.gateway.*;

/**
 *
 * @author RuDDyConDoRi
 */

public class AgenteCierreGateWay extends GatewayAgent {

	Mensaje mensaje = null;

	// método que se ejecuta cuando se invoca JadeGateWay.execute(objeto) en el
	// servlet
	protected void processCommand(java.lang.Object obj) {

		if (obj instanceof Mensaje) {

			mensaje = (Mensaje) obj;

			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			msg.addReceiver(new AID(mensaje.getReceiver(), AID.ISLOCALNAME));
			msg.setContent(mensaje.getMessage());
			send(msg);
		}

	}

	public void setup() {
		// Es perando por la respuesta de AgenteSaludo
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {

				ACLMessage msg = receive();

				if ((msg != null) && (mensaje != null)) {
					mensaje.setMessage(msg.getContent());
					// se devuelve la respuesta en el objeto mensaje al servlet
					releaseCommand(mensaje);
				} else {
					block();
				}
			}
		});

		super.setup();
	}

}