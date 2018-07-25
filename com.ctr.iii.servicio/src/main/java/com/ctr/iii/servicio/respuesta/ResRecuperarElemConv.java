package com.ctr.iii.servicio.respuesta;

import java.util.List;

import com.ctr.iii.dominio.ElemConviccionCierre;

public class ResRecuperarElemConv extends UtilResultadoBase {

	List<ElemConviccionCierre> elementos;

	public ResRecuperarElemConv() {
	}

	public ResRecuperarElemConv(List<ElemConviccionCierre> elementos) {
		this.elementos = elementos;
	}

	public List<ElemConviccionCierre> getElementos() {
		return elementos;
	}

	public void setElementos(List<ElemConviccionCierre> elementos) {
		this.elementos = elementos;
	}

	@Override
	public String toString() {
		return "ResRecuperarElemConv [elementos=" + elementos + "]";
	}

}
