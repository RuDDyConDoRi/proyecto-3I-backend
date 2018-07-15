package com.ctr.iii.dao;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ctr.iii.dao.config.DataConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DataConfig.class })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class CasosTest {
	
	@Autowired 
	CasoDao casosDao;
		
	private final static Logger logger = LoggerFactory.getLogger(CasosTest.class);
	
	@Test
	public void testProbar() {
		logger.info("testProbar||Ingresa");
		
		logger.info("Casos ====> " + casosDao.findAll());
		
		logger.info("testProbar||Sale");
	}

}
