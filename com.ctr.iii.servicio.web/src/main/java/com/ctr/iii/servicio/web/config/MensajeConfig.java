package com.ctr.iii.servicio.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@Profile("webapp")
public class MensajeConfig {

	private static final String MENSAJE_BASE = "classpath:i18n/mensajes";

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

		messageSource.setBasename(MENSAJE_BASE);
		messageSource.setUseCodeAsDefaultMessage(true);

		return messageSource;
	}

}