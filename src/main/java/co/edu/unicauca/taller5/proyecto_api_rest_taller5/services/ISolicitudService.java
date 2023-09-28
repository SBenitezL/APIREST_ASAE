package co.edu.unicauca.taller5.proyecto_api_rest_taller5.services;

import java.util.List;

import co.edu.unicauca.taller5.proyecto_api_rest_taller5.services.DTO.SolicitudDTO;

public interface ISolicitudService {
    public List<SolicitudDTO> findAll();
    public SolicitudDTO findBy(int id);
    public SolicitudDTO save(SolicitudDTO solicitud);
    public SolicitudDTO update(Integer id, SolicitudDTO solicitud);
    public boolean delete(Integer id);
}
