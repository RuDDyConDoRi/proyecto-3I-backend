package com.ctr.iii.servicio.respuesta;

import java.util.ArrayList;
import java.util.List;

public class UtilResultadoBase {

	private boolean ok;
	private List<UtilMensaje> mensajes = new ArrayList<UtilMensaje>();
	private List<String> roles = new ArrayList<String>();

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public List<UtilMensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<UtilMensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UtilResultadoBase [ok=" + ok + ", mensajes=" + mensajes + "]";
	}

}
