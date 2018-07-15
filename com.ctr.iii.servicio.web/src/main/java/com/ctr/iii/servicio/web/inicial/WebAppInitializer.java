package com.ctr.iii.servicio.web.inicial;

import java.util.Set;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.ctr.iii.servicio.web.config.FiltroCors;
import com.ctr.iii.servicio.web.config.MvcConfig;
import com.ctr.iii.servicio.web.config.RootConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");

		AnnotationConfigWebApplicationContext mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(MvcConfig.class);

		//Register Cors Filter
		addCorsFilter(servletContext);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(
				mvcContext));
		
		dispatcher.setLoadOnStartup(1);
		Set<String> mappingConflicts = dispatcher.addMapping("/");

		if (!mappingConflicts.isEmpty()) {
			for (String s : mappingConflicts) {
				logger.error("Conflicto de mapeo: " + s);
			}
			throw new IllegalStateException("'dispatcher' no puede ser mapeado a '/' en versiones de Tomcat <= 7.0.14");
		}
	}

	private void addCorsFilter(ServletContext container) {
		FilterRegistration.Dynamic fr = container.addFilter("corsFilter",
				new FiltroCors());
		fr.addMappingForUrlPatterns(null, true, "/*");
	}	

}
