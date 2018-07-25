package com.ctr.iii.servicio.respuesta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RuDDy
 */
public class Utilidades {

	public static List<String> aCadenas(String cadena, String separador) {
		List<String> resultado = new ArrayList<String>();
		String[] datos = prepararCadena(cadena, separador);
		for (int i = 0; i < datos.length; i++) {
			resultado.add(datos[i].replaceAll("\"", ""));
		}
		System.out.println("UTILIDADES: " + resultado);
		return resultado;
	}

	public static List<Double> aDouble(String cadena, String separador) {
		List<Double> resultado = new ArrayList<Double>();
		String[] datos = prepararCadena(cadena, separador);
		for (int i = 0; i < datos.length; i++) {
			resultado.add(Double.parseDouble(datos[i]));
		}
		System.out.println("UTILIDADES: " + resultado);
		return resultado;
	}

	int[] aEnteros(String cadena, String separador) {
		String[] datos = prepararCadena(cadena, separador);
		int[] valores = new int[datos.length];
		for (int i = 0; i < datos.length; i++) {
			valores[i] = Integer.parseInt(datos[i]);
		}
		return valores;
	}

	static String aCadena(String nombre, String[] array) {
		String resultado = "{\"" + nombre + "\":[";
		for (int i = 0; i < array.length; i++) {
			resultado = resultado + "\"" + array[i] + "\"";
			if (i != array.length - 1) {
				resultado = resultado + ",";
			}
		}
		resultado = resultado + "]}";
		return resultado;
	}

	static String[] prepararCadena(String cadena, String separador) {
		cadena = cadena.split(":")[1];
		cadena = cadena.substring(0, cadena.length() - 1);
		cadena = cadena.substring(1, cadena.length() - 1);
		cadena = cadena.replaceAll(" ", "");
		String[] datos = cadena.split(separador);
		return datos;
	}

}
