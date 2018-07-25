package com.ctr.iii.servicio.web.dto;

import java.util.List;

/**
 *
 * @author RuDDy
 */
public class DatosCierreDto {

	List<String> atributos;
	List<List<String>> tabla;

	public DatosCierreDto() {
	}

	public DatosCierreDto(List<String> atributos, List<List<String>> tabla) {
		this.atributos = atributos;
		this.tabla = tabla;
	}

	public List<String> getAtributos() {
		return atributos;
	}

	public void setAtributos(List<String> atributos) {
		this.atributos = atributos;
	}

	public List<List<String>> getTabla() {
		return tabla;
	}

	public void setTabla(List<List<String>> tabla) {
		this.tabla = tabla;
	}

	@Override
	public String toString() {
		return "DatosCierreDto [atributos=" + atributos + ", tabla=" + tabla + "]";
	}

}