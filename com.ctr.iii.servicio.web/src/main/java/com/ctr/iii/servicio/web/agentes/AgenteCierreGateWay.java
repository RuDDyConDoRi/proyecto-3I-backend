package com.ctr.iii.servicio.web.agentes;

import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.gateway.GatewayAgent;

/**
 *
 * @author RuDDyConDoRi
 */

public class AgenteCierreGateWay extends GatewayAgent {

	Mensaje mensaje = null;

	// metodo que se ejecuta cuando se invoca JadeGateWay.execute(objeto) 
	protected void processCommand(java.lang.Object obj) {

		if (obj instanceof Mensaje) {

			mensaje = (Mensaje) obj;

			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			msg.addReceiver(new AID(mensaje.getReceiver(), AID.ISLOCALNAME));
			msg.setContent(mensaje.getMessage());
			System.out.println("====> ATRIBUTOS: " + mensaje.getAtributos() + " === " + mensaje.getTabla());
			msg.addUserDefinedParameter("atributos", mensaje.getAtributos());
			msg.addUserDefinedParameter("tabla", mensaje.getTabla());
			send(msg);
		}

	}

	public void setup() {
		
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {

				ACLMessage msg = receive();

				if ((msg != null) && (mensaje != null)) {
					mensaje.setMessage(msg.getContent());
					mensaje.setDatosCierre(null);
					mensaje.setAtributos(msg.getUserDefinedParameter("Atributos"));
					mensaje.setValores(msg.getUserDefinedParameter("Valores"));
					mensaje.setTabla(null);

					releaseCommand(mensaje);
				} else {
					block();
				}
			}
		});

		super.setup();
	}

}