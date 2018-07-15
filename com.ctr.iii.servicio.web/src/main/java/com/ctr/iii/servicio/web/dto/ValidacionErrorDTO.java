package com.ctr.iii.servicio.web.dto;

import java.util.ArrayList;
import java.util.List;

public class ValidacionErrorDTO {

	private List<ErrorDatoDTO> fieldErrors = new ArrayList<ErrorDatoDTO>();

	public ValidacionErrorDTO() {

	}

	public void addFieldError(String path, String message) {
		ErrorDatoDTO error = new ErrorDatoDTO(path, message);
		fieldErrors.add(error);
	}

	public List<ErrorDatoDTO> getFieldErrors() {
		return fieldErrors;
	}
}
