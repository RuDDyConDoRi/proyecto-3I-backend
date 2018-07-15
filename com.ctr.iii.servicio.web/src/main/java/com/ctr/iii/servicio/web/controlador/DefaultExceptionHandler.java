package com.ctr.iii.servicio.web.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ctr.iii.servicio.web.dto.ValidacionErrorDTO;
import com.google.common.collect.Maps;

@ControllerAdvice
public class DefaultExceptionHandler {

	@Autowired
	MessageSource messageSource;

	private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

	@RequestMapping
	@ExceptionHandler({ MissingServletRequestParameterException.class,
			UnsatisfiedServletRequestParameterException.class, HttpRequestMethodNotSupportedException.class,
			ServletRequestBindingException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody Map<String, Object> handleRequestException(Exception ex) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("error", "Request Error");
		map.put("cause", ex.getMessage());
		return map;
	}

	@RequestMapping
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody Map<String, Object> handleValidationException(ConstraintViolationException ex)
			throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("error", "Validation Failure");
		map.put("violations", convertConstraintViolation(ex.getConstraintViolations()));
		return map;
	}

	@RequestMapping
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ValidacionErrorDTO processValidationError(MethodArgumentNotValidException ex)
			throws IOException {
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}

	private ValidacionErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		ValidacionErrorDTO dto = new ValidacionErrorDTO();

		for (FieldError fieldError : fieldErrors) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			dto.addFieldError(fieldError.getField(), localizedErrorMessage);
		}

		return dto;
	}

	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		logger.info("resolveLocalizedErrorMessage||ingresa");
		logger.info("resolveLocalizedErrorMessage|currentLocale:" + currentLocale + "|");
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

		// If the message was not found, return the most accurate field error
		// code instead.
		// You can remove this check if you prefer to get the default error
		// message.
		// if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
		// String[] fieldErrorCodes = fieldError.getCodes();
		// localizedErrorMessage = fieldErrorCodes[0];
		// }

		logger.info("resolveLocalizedErrorMessage||sale");

		return localizedErrorMessage;
	}

	@RequestMapping
	@ExceptionHandler(ObjectRetrievalFailureException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody Map<String, Object> handleValidationException(ObjectRetrievalFailureException ex)
			throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("error", "Entity Not Found");
		map.put("cause", ex.getMessage());
		return map;
	}

	@RequestMapping
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public @ResponseBody Map<String, Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex)
			throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("error", "Data Integrity Error");
		map.put("cause", ex.getCause().getCause().getLocalizedMessage());
		return map;
	}

	@RequestMapping
	@ExceptionHandler(DataAccessException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Map<String, Object> handleDataAccessException(DataAccessException ex) throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("error", "Data Error");
		map.put("cause", ex.getCause().getMessage());
		return map;
	}

	@RequestMapping
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public @ResponseBody Map<String, Object> handleUnsupportedMediaTypeException(HttpMediaTypeNotSupportedException ex)
			throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("error", "Unsupported Media Type");
		map.put("cause", ex.getLocalizedMessage());
		map.put("supported", ex.getSupportedMediaTypes());
		return map;
	}

	@RequestMapping
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody Map<String, Object> handleUncaughtException(Exception ex) throws IOException {
		Map<String, Object> map = Maps.newHashMap();
		map.put("error", "Unknown Error");
		if (ex.getCause() != null) {
			map.put("cause", ex.getCause().getMessage());
		} else {
			map.put("cause", ex.getMessage());
		}
		return map;
	}

	private Map<String, Map<String, Object>> convertConstraintViolation(
			Set<ConstraintViolation<?>> constraintViolations) {
		Map<String, Map<String, Object>> result = Maps.newHashMap();
		for (ConstraintViolation constraintViolation : constraintViolations) {
			Map<String, Object> violationMap = Maps.newHashMap();
			violationMap.put("value", constraintViolation.getInvalidValue());
			violationMap.put("type", constraintViolation.getRootBeanClass());
			violationMap.put("message", constraintViolation.getMessage());
			result.put(constraintViolation.getPropertyPath().toString(), violationMap);
		}
		return result;
	}

	private Map<String, Map<String, Object>> convertConstraintViolation(MethodArgumentNotValidException ex) {
		Map<String, Map<String, Object>> result = Maps.newHashMap();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			Map<String, Object> violationMap = Maps.newHashMap();
			violationMap.put("target", ex.getBindingResult().getTarget());
			violationMap.put("type", ex.getBindingResult().getTarget().getClass());
			violationMap.put("message", error.getDefaultMessage());
			result.put(error.getObjectName(), violationMap);
		}
		return result;
	}

}
