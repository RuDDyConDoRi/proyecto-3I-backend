package com.ctr.iii.servicio;

import com.ctr.iii.servicio.respuesta.ResBuscarPorCodCas;
import com.ctr.iii.servicio.respuesta.ResRecuperarCasos;
import com.ctr.iii.servicio.solicitud.SolBuscarPorCodCas;
import com.ctr.iii.servicio.solicitud.SolRecuperarCasos;

public interface ICasosServicio {
	
	public ResBuscarPorCodCas buscarPorCodCas(SolBuscarPorCodCas solicitud);
	public ResRecuperarCasos recuperarCasos(SolRecuperarCasos solicitud);

}
