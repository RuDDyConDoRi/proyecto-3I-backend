package com.ctr.iii.servicio.web.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FiltroCors implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(FiltroCors.class);

	private static final String[][] headerCors = new String[][] {
			// REQUEST //RESPONSE //DEFAULT
			{ "Origin", "Access-Control-Allow-Origin", null },
			{ "Access-Control-Request-Headers", "Access-Control-Allow-Headers", "Content-Type" },
			{ "Access-Control-Request-Method", "Access-Control-Allow-Method", "POST" }, };
	private static final String[][] headerCorsDefault = new String[][] {
			// RESPONSE //DEFAULT
			{ "Access-Control-Allow-Credentials", "true" }, { "Access-Control-Max-Age", "2" }, };

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		logger.info("doFilterInternal||Ingresa");
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.addHeader("Copyright", "RuCorp");

		// String origin = request.getHeader("Origin");
		String method = request.getMethod();
		for (String[] header : headerCors) {
			String value = request.getHeader(header[0]);
			value = value == null ? header[2] : value;// valor por defecto
			if (value != null) {
				response.setHeader(header[1], value);
			}
		}
		if ("OPTIONS".equals(method)) {
			logger.trace("return pre-fligth");
			for (String[] header : headerCorsDefault) {
				response.setHeader(header[0], header[1]);
			}
			response.setStatus(200);
			return;
		}

		chain.doFilter(req, res);

		logger.info("doFilterInternal||Sale");

	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}

}
