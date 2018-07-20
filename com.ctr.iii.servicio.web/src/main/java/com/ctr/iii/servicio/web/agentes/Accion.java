package com.ctr.iii.servicio.web.agentes;

/**
*
* @author RuDDy
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.ctr.iii.servicio.web.dto.DatosCierreDto;

public interface Accion {

	public void enviar(Mensaje response, DatosCierreDto datosCierre);

}