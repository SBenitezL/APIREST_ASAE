package co.edu.unicauca.taller5.proyecto_api_rest_taller5.services.DTO;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class SolicitudDTO {
    private Integer id;
    private Date fechaSolicitud;
    private Date fechaRadicacion;
    private String nombreFacultad;
    private Integer numeroAutores;
    private String tituloTrabajo;

    public SolicitudDTO(){}
}
