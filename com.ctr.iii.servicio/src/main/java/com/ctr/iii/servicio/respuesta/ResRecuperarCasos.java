package com.ctr.iii.servicio.respuesta;

import java.util.List;

import com.ctr.iii.servicio.dto.CasoRecuperadoDto;

public class ResRecuperarCasos extends UtilResultadoBase {

	List<CasoRecuperadoDto> casosRecuperados;

	public ResRecuperarCasos() {
	}

	public ResRecuperarCasos(List<CasoRecuperadoDto> casosRecuperados) {
		this.casosRecuperados = casosRecuperados;
	}

	public List<CasoRecuperadoDto> getCasosRecuperados() {
		return casosRecuperados;
	}

	public void setCasosRecuperados(List<CasoRecuperadoDto> casosRecuperados) {
		this.casosRecuperados = casosRecuperados;
	}

	@Override
	public String toString() {
		return "ResRecuperarCasos [casosRecuperados=" + casosRecuperados + "]";
	}

}
