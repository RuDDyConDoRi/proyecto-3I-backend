package com.ctr.iii.servicio.web.dto;

/**
 *
 * @author RuDDy
 */
public class DatosCierreDto {

	String[] atributos;
	String[][] tabla;

	public DatosCierreDto() {
	}

	public DatosCierreDto(String[] atributos, String[][] tabla) {
		this.atributos = atributos;
		this.tabla = tabla;
	}

	public String[] getAtributos() {
		return atributos;
	}

	public void setAtributos(String[] atributos) {
		this.atributos = atributos;
	}

	public String[][] getTabla() {
		return tabla;
	}

	public void setTabla(String[][] tabla) {
		this.tabla = tabla;
	}

	@Override
	public String toString() {
		return "DatosCierreDto{" + "atributos=" + atributos.toString() + ", tabla=" + tabla.toString() + '}';
	}

}