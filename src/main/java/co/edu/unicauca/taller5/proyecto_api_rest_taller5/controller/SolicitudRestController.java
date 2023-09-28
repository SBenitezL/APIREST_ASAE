package co.edu.unicauca.taller5.proyecto_api_rest_taller5.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.taller5.proyecto_api_rest_taller5.services.ISolicitudService;
import co.edu.unicauca.taller5.proyecto_api_rest_taller5.services.DTO.SolicitudDTO;

@RestController
@RequestMapping("/api")
public class SolicitudRestController {
    
    @Autowired
    private ISolicitudService solicitudService;

    @GetMapping("/solicitudes")
    public List<SolicitudDTO> index(){
        return solicitudService.findAll();
    }

    @GetMapping("/solicitudes/{id}")
    public SolicitudDTO show(@PathVariable Integer id)
    {
        SolicitudDTO objSolicitud = null;
        objSolicitud = solicitudService.findBy(id);
        return objSolicitud;
    }    
	
	@PostMapping("/solicitudes")
	public SolicitudDTO create(@RequestBody SolicitudDTO solicitud) {	
		SolicitudDTO objCliente = null;
		objCliente =  solicitudService.save(solicitud);
		return objCliente;
	}
	

	@PutMapping("/solicitudes/{id}")
	public SolicitudDTO update(@RequestBody SolicitudDTO solicitud, @PathVariable Integer id) {
		SolicitudDTO objCliente = null;
		SolicitudDTO clienteActual = solicitudService.findBy(id);
		if(clienteActual!=null)	
		{
			objCliente = solicitudService.update(id,solicitud);
		}
		return objCliente;
	}
	
	
	@DeleteMapping("/solicitudes")
	public Boolean delete(@RequestParam  Integer id) {				
		Boolean bandera=false;
		SolicitudDTO clienteActual = solicitudService.findBy(id);
		if(clienteActual!=null)		
		{
			bandera = solicitudService.delete(id);
		}
		return bandera;
		
	}

}
