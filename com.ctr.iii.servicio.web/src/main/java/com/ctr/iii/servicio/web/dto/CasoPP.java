package com.ctr.iii.servicio.web.dto;

public class CasoPP {

	int nro;
	String tipoCaso;
	String codigoCaso;
	String responsable;

	public CasoPP() {
	}

	public CasoPP(int nro, String tipoCaso, String codigoCaso, String responsable) {
		this.nro = nro;
		this.tipoCaso = tipoCaso;
		this.codigoCaso = codigoCaso;
		this.responsable = responsable;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public String getTipoCaso() {
		return tipoCaso;
	}

	public void setTipoCaso(String tipoCaso) {
		this.tipoCaso = tipoCaso;
	}

	public String getCodigoCaso() {
		return codigoCaso;
	}

	public void setCodigoCaso(String codigoCaso) {
		this.codigoCaso = codigoCaso;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "CasoPP{" + "nro=" + nro + ", tipoCaso=" + tipoCaso + ", codigoCaso=" + codigoCaso + ", responsable="
				+ responsable + '}';
	}

}
