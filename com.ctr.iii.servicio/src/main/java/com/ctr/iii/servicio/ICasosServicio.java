package com.ctr.iii.servicio;

import com.ctr.iii.servicio.respuesta.ResBuscarPorCodCas;
import com.ctr.iii.servicio.respuesta.ResRecuperarCasos;
import com.ctr.iii.servicio.respuesta.ResRecuperarElemConv;
import com.ctr.iii.servicio.solicitud.SolBuscarPorCodCas;
import com.ctr.iii.servicio.solicitud.SolRecuperarCasos;
import com.ctr.iii.servicio.solicitud.SolRecuperarElemConv;

public interface ICasosServicio {
	
	public ResBuscarPorCodCas buscarPorCodCas(SolBuscarPorCodCas solicitud);
	public ResRecuperarCasos recuperarCasos(SolRecuperarCasos solicitud);
	public ResRecuperarElemConv recuperarElemConv(SolRecuperarElemConv solicitud);

}
