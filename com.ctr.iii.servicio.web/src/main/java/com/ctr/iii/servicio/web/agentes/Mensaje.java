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

	private String atributos = new String("");
	private String tabla = new String("");

	private String valores = new String("");

	public Mensaje() {
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public DatosCierreDto getDatosCierre() {
		return datosCierre;
	}

	public void setDatosCierre(DatosCierreDto datosCierre) {
		this.datosCierre = datosCierre;
	}

	public String getAtributos() {
		return atributos;
	}

	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	@Override
	public String toString() {
		return "Mensaje [message=" + message + ", receiver=" + receiver + ", datosCierre=" + datosCierre
				+ ", tabla=" + tabla + ", ;atributos=" + atributos + ";valores=" + valores + "]";
	}

}
