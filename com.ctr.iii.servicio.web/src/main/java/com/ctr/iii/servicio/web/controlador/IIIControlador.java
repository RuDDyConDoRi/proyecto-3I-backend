package com.ctr.iii.servicio.web.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.ctr.iii.servicio.ICasosServicio;
import com.ctr.iii.servicio.respuesta.ResRecuperarCasos;
import com.ctr.iii.servicio.solicitud.SolRecuperarCasos;
import com.ctr.iii.servicio.web.agentes.Accion;
import com.ctr.iii.servicio.web.agentes.AccionEnviarMensaje;
import com.ctr.iii.servicio.web.agentes.Mensaje;
import com.ctr.iii.servicio.web.config.FileMeta;
import com.ctr.iii.servicio.web.dto.CasoPP;
import com.ctr.iii.servicio.web.dto.DatosCierreDto;

import jade.util.leap.Properties;
import jade.wrapper.gateway.JadeGateway;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping(value = "/iii")
public class IIIControlador {

	private static final Logger logger = LoggerFactory.getLogger(IIIControlador.class);

	@Autowired
	ICasosServicio casosServicio;
	
	
	/************************************ CasosServicio ***********************************************************/
	@RequestMapping(value = "/recuperar/casos", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResRecuperarCasos recuperarCasos() {
		logger.info("Ingresa||recuperarCasos");

		SolRecuperarCasos solicitud = new SolRecuperarCasos();
		
		logger.info("Solicitud: ", solicitud);
		ResRecuperarCasos resultado = casosServicio.recuperarCasos(solicitud);

		logger.info("Sale||recuperarCasos");
		return resultado;
	}
	
	@RequestMapping(value = "/iniciar/agente", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<CasoPP> iniciarAgente() {
		logger.info("Ingresa||iniciarAgente");
		
		JadeGateway.init("com.ctr.iii.servicio.web.agentes.AgenteControlPlazosProcesales", 
                new jade.util.leap.Properties());
		
		List<CasoPP> casosPP = new ArrayList<CasoPP>();
        casosPP.add(new CasoPP(1, "Corrupcion", "COD-C001-23042018", "Rigoberto Rigus"));
        casosPP.add(new CasoPP(2, "Robo", "COD-R001-21042018", "Romer Vale"));
        casosPP.add(new CasoPP(3, "Racismo", "COD-RA01-20042018", "Juan Mark"));
        casosPP.add(new CasoPP(4, "Discriminacion", "COD-D001-22042018", "Joe Huarachi"));
        casosPP.add(new CasoPP(5, "Asesinato", "COD-A001-20042018", "Maure Lozano"));
        
        //String nombreAccion = request.getParameter("accion");
        
        CasoPP casoPP = new CasoPP();
        casoPP.setCodigoCaso("CASO-001");
        //request.getParameter("caso"));
        //usuario.setContraseña(request.getParameter("contrasena"));
        //mandamos el usuario al agente GateWayAgent de JADE
        try    {
            JadeGateway.execute(casoPP);
        } catch(Exception e) { 
        	e.printStackTrace(); 
        }
        
        casosPP.add(casoPP);
		
		logger.info("Sale||iniciarAgente");
		return casosPP;
	}
		
	@RequestMapping(value = "/agente/cierre", method = RequestMethod.GET, headers = "Accept=application/json")
	public Mensaje iniciarAgenteCierre() {
		logger.info("Ingresa||iniciarAgenteCierre");
		
		Hashtable acciones = null; 
		Properties propiedades = new Properties();
        propiedades.setProperty("container", "Main-Container");

        //creación de la tabla hash que contendrá el objeto AccionEnviarMensaje
        acciones = new Hashtable();

        //insertamos el objeto con clave su clave en la tabla
        acciones.put("enviarmensaje", new AccionEnviarMensaje());
        
        //enlace con el agente GateWay de JADE
        JadeGateway.init("com.ctr.iii.servicio.web.agentes.AgenteCierreGateWay", propiedades);
		
		
        //String nombreAccion = request.getParameter("accion");
        
        String nombreAccion = "enviarmensaje";

        //hacemos que el objeto implemente la interfaz acción
        //para que pueda utilizar los objetos HttpServletRequest y HttpServletResponse
        Mensaje mensaje = new Mensaje();
        DatosCierreDto datosCierre = new DatosCierreDto();
        String[] nombreAtri = {"Ruta", "Empresa", "Tiempo", "Distancia", "Prisa"};
        datosCierre.setAtributos(nombreAtri);
        String[][] tabla = {{"2S", "A", "20", "05", "SI", "SI"},
                {"03", "B", "30", "10", "SI", "NO"},
                {"2S", "A", "10", "15", "SI", "SI"},
                {"4B", "C", "20", "10", "NO", "SI"},
                {"03", "B", "20", "05", "SI", "SI"},
                {"4B", "A", "30", "15", "SI", "NO"},
                {"03", "B", "10", "30", "SI", "NO"}};
        datosCierre.setTabla(tabla);
        
        Accion accion = (Accion) acciones.get(nombreAccion);
        if (accion != null) {
        	//ejecutamos la acción
            accion.enviar(mensaje, datosCierre);
            
            System.out.println("--> "+mensaje.getMessage());
        }
        
		logger.info("Sale||iniciarAgenteCierre");
		return mensaje;
	}
}