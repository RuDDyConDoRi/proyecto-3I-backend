package com.ctr.iii.servicio.dto;

public class CasoRecuperadoDto {

	String codigoCaso;
	String codigoDenunciante;
	String codigoDenunciado;
	String delito;
	int numeroArticulo;
	String fechaInicio;
	String fechaFin;

	public CasoRecuperadoDto() {
	}

	public CasoRecuperadoDto(String codigoCaso, String codigoDenunciante, 
			String codigoDenunciado, String delito,
			int numeroArticulo, String fechaInicio, String fechaFin) {
		this.codigoCaso = codigoCaso;
		this.codigoDenunciante = codigoDenunciante;
		this.codigoDenunciado = codigoDenunciado;
		this.delito = delito;
		this.numeroArticulo = numeroArticulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getCodigoCaso() {
		return codigoCaso;
	}

	public void setCodigoCaso(String codigoCaso) {
		this.codigoCaso = codigoCaso;
	}

	public String getCodigoDenunciante() {
		return codigoDenunciante;
	}

	public void setCodigoDenunciante(String codigoDenunciante) {
		this.codigoDenunciante = codigoDenunciante;
	}

	public String getCodigoDenunciado() {
		return codigoDenunciado;
	}

	public void setCodigoDenunciado(String codigoDenunciado) {
		this.codigoDenunciado = codigoDenunciado;
	}

	public String getDelito() {
		return delito;
	}

	public void setDelito(String delito) {
		this.delito = delito;
	}

	public int getNumeroArticulo() {
		return numeroArticulo;
	}

	public void setNumeroArticulo(int numeroArticulo) {
		this.numeroArticulo = numeroArticulo;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "CasosRecuperadosDto [codigoCaso=" + codigoCaso 
				+ ", codigoDenunciante=" + codigoDenunciante
				+ ", codigoDenunciado=" + codigoDenunciado + ", delito=" 
				+ delito + ", numeroArticulo=" + numeroArticulo
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" 
				+ fechaFin + "]";
	}

}
