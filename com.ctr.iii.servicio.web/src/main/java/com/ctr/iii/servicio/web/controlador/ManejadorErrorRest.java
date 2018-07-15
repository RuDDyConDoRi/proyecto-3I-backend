package com.ctr.iii.servicio.web.controlador;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ctr.iii.servicio.web.dto.ValidacionErrorDTO;

@ControllerAdvice
public class ManejadorErrorRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorErrorRest.class);

	private MessageSource messageSource;

	@Autowired
	public ManejadorErrorRest(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ValidacionErrorDTO processValidationError(MethodArgumentNotValidException ex) {
		LOGGER.debug("manejando los errores de validacion del formr");

		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();

		return processFieldErrors(fieldErrors);
	}

	private ValidacionErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		ValidacionErrorDTO dto = new ValidacionErrorDTO();

		for (FieldError fieldError : fieldErrors) {
			String localizedErrorMessage = resolveLocalizedErrorMessage(fieldError);
			LOGGER.debug("Adicionando el mensaje de error: {} al campo: {}", localizedErrorMessage,
					fieldError.getField());
			dto.addFieldError(fieldError.getField(), localizedErrorMessage);
		}

		return dto;
	}

	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

		// If a message was not found, return the most accurate field error code
		// instead.
		// You can remove this check if you prefer to get the default error
		// message.
		if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
			String[] fieldErrorCodes = fieldError.getCodes();
			localizedErrorMessage = fieldErrorCodes[0];
		}

		return localizedErrorMessage;
	}
}