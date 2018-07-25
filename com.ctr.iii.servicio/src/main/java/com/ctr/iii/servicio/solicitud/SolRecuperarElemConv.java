package com.ctr.iii.servicio.solicitud;

import java.util.Arrays;

public class SolRecuperarElemConv {

	String[] atributos;
	String[][] tabla;

	public SolRecuperarElemConv() {
	}

	public SolRecuperarElemConv(String[] atributos, String[][] tabla) {
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
		return "SolRecuperarElemConv [atributos=" + Arrays.toString(atributos) + ", tabla=" + Arrays.toString(tabla)
				+ "]";
	}

}
