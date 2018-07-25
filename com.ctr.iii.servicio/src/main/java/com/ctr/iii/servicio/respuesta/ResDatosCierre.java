package com.ctr.iii.servicio.respuesta;

import java.util.List;

public class ResDatosCierre extends UtilResultadoBase {

	List<String> atributos;
	List<Double> valores;
	String respuesta;

	public ResDatosCierre() {
	}

	public List<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<String> atributos) {
		this.atributos = atributos;
	}

	public List<Double> getValores() {
		return valores;
	}

	public void setValores(List<Double> valores) {
		this.valores = valores;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	@Override
	public String toString() {
		return "ResDatosCierre [atributos=" + atributos + ", valores=" + valores + ", respuesta=" + respuesta + "]";
	}

}
