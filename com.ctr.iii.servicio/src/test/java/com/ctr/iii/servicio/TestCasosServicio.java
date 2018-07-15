package com.ctr.iii.servicio;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ctr.iii.dao.CasoDao;
import com.ctr.iii.dao.config.DataConfig;
import com.ctr.iii.servicio.respuesta.ResRecuperarCasos;
import com.ctr.iii.servicio.solicitud.SolRecuperarCasos;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataConfig.class })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class TestCasosServicio {

	@Autowired
	CasoDao casosDao;

	@Autowired
	ICasosServicio casosServicio;
	
	private final static Logger logger = LoggerFactory.getLogger(TestCasosServicio.class);

	@Test
	public void recuperarUsuariosTest() {
		logger.info("Ingresa || recuperarUsuariosTest");
		
		// preparamos prueba
		
		SolRecuperarCasos solicitud = new SolRecuperarCasos();
		
		// Ejecutamos la Prueba
		ResRecuperarCasos resultado = casosServicio.recuperarCasos(solicitud);

		// Verificamos los resultados
		Assert.assertTrue(resultado.isOk());
		logger.info("Existen Resultado= " + resultado);

		logger.info("Salir || recuperarUsuariosTest");
	}

}
