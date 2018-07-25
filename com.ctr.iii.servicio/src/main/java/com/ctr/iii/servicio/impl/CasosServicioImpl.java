package com.ctr.iii.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctr.iii.dao.CasoDao;
import com.ctr.iii.dao.ElemConviccionCierreDao;
import com.ctr.iii.dominio.Caso;
import com.ctr.iii.dominio.ElemConviccionCierre;
import com.ctr.iii.servicio.ICasosServicio;
import com.ctr.iii.servicio.dto.CasoRecuperadoDto;
import com.ctr.iii.servicio.respuesta.ResBuscarPorCodCas;
import com.ctr.iii.servicio.respuesta.ResRecuperarCasos;
import com.ctr.iii.servicio.respuesta.ResRecuperarElemConv;
import com.ctr.iii.servicio.respuesta.UtilMensaje;
import com.ctr.iii.servicio.respuesta.UtilTipoMensaje;
import com.ctr.iii.servicio.solicitud.SolBuscarPorCodCas;
import com.ctr.iii.servicio.solicitud.SolRecuperarCasos;
import com.ctr.iii.servicio.solicitud.SolRecuperarElemConv;

@Service
@Transactional
public class CasosServicioImpl implements ICasosServicio {

	@Autowired
	CasoDao casosDao;

	@Autowired
	ElemConviccionCierreDao elementosConviccionCierresDao;

	private final static Logger logger = LoggerFactory.getLogger(CasosServicioImpl.class);

	public ResBuscarPorCodCas buscarPorCodCas(SolBuscarPorCodCas solicitud) {
		logger.info("INGRESA || buscarPorCodCas");
		ResBuscarPorCodCas resultado = new ResBuscarPorCodCas();

		try {

		} catch (Exception e) {
			logger.info("Error, No se recuperaron Casos", e);
			resultado.getMensajes()
					.add(new UtilMensaje("No se recuperaron Casos", e.getMessage().toString(), UtilTipoMensaje.ERROR));
			resultado.setOk(false);
		}
		logger.info("SALIR || buscarPorCodCas");
		return resultado;
	}

	public ResRecuperarCasos recuperarCasos(SolRecuperarCasos solicitud) {
		logger.info("INGRESA || recuperarCasos");
		ResRecuperarCasos resultado = new ResRecuperarCasos();
		try {
			List<CasoRecuperadoDto> casosRecuperados = new ArrayList<CasoRecuperadoDto>();

			List<Caso> agencias = (List<Caso>) casosDao.findAll();
			CasoRecuperadoDto casoDto;
			for (Caso caso : agencias) {
				casoDto = new CasoRecuperadoDto();
				casoDto.setCodigoCaso(caso.getCodCas());
				System.out.println("-DENUNCIANTE-> " + caso.getDenunciante());
				System.out.println("-DENUNCIADO-> " + caso.getDenunciado());
				casoDto.setCodigoDenunciante(caso.getDenunciante().getCodPer());
				casoDto.setCodigoDenunciado(caso.getDenunciado().getCodPer());
				casoDto.setDelito(caso.getDelito());
				casoDto.setNumeroArticulo(caso.getNroArt());
				casoDto.setFechaInicio(caso.getFechaIni().toString());
				casoDto.setFechaFin(caso.getFechaFin().toString());

				casosRecuperados.add(casoDto);
			}

			if (casosRecuperados.size() > 0) {
				resultado.setCasosRecuperados(casosRecuperados);
			}
			resultado.setOk(true);
		} catch (Exception e) {
			logger.info("Error, No se recuperaron Casos", e);
			resultado.getMensajes()
					.add(new UtilMensaje("No se recuperaron Casos", e.getMessage().toString(), UtilTipoMensaje.ERROR));
			resultado.setOk(false);
		}

		logger.info("SALIR || recuperarCasos");
		return resultado;
	}

	public ResRecuperarElemConv recuperarElemConv(SolRecuperarElemConv solicitud) {
		logger.info("INGRESA || buscarPorCodCas");

		ResRecuperarElemConv resultado = new ResRecuperarElemConv();
		try {

			List<ElemConviccionCierre> elementos = (List<ElemConviccionCierre>) elementosConviccionCierresDao.findAll();
			resultado.setElementos(elementos);
		} catch (Exception e) {
			logger.info("Error, No se recuperaron Casos", e);
			resultado.getMensajes()
					.add(new UtilMensaje("No se recuperaron Casos", e.getMessage().toString(), UtilTipoMensaje.ERROR));
			resultado.setOk(false);
		}
		logger.info("SALIR || buscarPorCodCas");
		return resultado;
	}
}
