package com.ctr.iii.servicio.web.agentes;

import com.ctr.iii.servicio.web.dto.DatosCierreDto;

/**
 *
 * @author RuDDy
 */

public class Mensaje implements java.io.Serializable {

	private String message = new String("");
	private String receiver = new String("");
	private DatosCierreDto datosCierre = new DatosCierreDto();

	public String getMessage() {
		return message;
	}

	public void setMessage(String str) {
		message = str;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public Mensaje() {

	}

	public DatosCierreDto getDatosCierre() {
		return datosCierre;
	}

	public void setDatosCierre(DatosCierreDto datosCierre) {
		this.datosCierre = datosCierre;
	}

	@Override
	public String toString() {
		return "Mensaje [message=" + message + ", receiver=" + receiver + ", datosCierre=" + datosCierre + "]";
	}

}
