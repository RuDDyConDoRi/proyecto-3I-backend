package com.ctr.iii.servicio.respuesta;

public class UtilMensaje {

	private String codigo;
	private String descripcion;
	private UtilTipoMensaje tipo;
	
	public UtilMensaje() {
	}

	public UtilMensaje(String codigo, String descripcion,
			UtilTipoMensaje tipo) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UtilTipoMensaje getTipo() {
		return tipo;
	}

	public void setTipo(UtilTipoMensaje tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "UtilMensaje [codigo=" + codigo + ", descripcion=" + descripcion
				+ ", tipo=" + tipo + "]";
	}

}
