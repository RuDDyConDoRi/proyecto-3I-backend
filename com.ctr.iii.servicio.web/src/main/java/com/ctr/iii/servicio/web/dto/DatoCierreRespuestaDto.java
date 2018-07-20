package com.ctr.iii.servicio.web.dto;

/**
 *
 * @author RuDDy
 */
public class DatoCierreRespuestaDto implements java.io.Serializable {

	String[] nombreAtri;
	double[] valoresAtri;

	public DatoCierreRespuestaDto() {
	}

	public DatoCierreRespuestaDto(String[] nombreAtri, double[] valoresAtri) {
		this.nombreAtri = nombreAtri;
		this.valoresAtri = valoresAtri;
	}

	public String[] getNombreAtri() {
		return nombreAtri;
	}

	public void setNombreAtri(String[] nombreAtri) {
		this.nombreAtri = nombreAtri;
	}

	public double[] getValoresAtri() {
		return valoresAtri;
	}

	public void setValoresAtri(double[] valoresAtri) {
		this.valoresAtri = valoresAtri;
	}

	@Override
	public String toString() {
		return "DatoCierreRespuestaDto{" + "nombreAtri=" + nombreAtri + ", valoresAtri=" + valoresAtri + '}';
	}

}