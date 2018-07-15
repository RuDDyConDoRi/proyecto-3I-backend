package com.ctr.iii.servicio.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ctr.iii.dao.config.DataConfig;

@Configuration
@Import(DataConfig.class)
@ComponentScan(basePackages = { "com.ctr.iii.servicio", "com.ctr.iii.dao", "com.ctr.iii.dominio" })
public class RootConfig {

}
