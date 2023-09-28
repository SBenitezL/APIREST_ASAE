package co.edu.unicauca.taller5.proyecto_api_rest_taller5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import co.edu.unicauca.taller5.proyecto_api_rest_taller5.models.SolicitudEntity;
import co.edu.unicauca.taller5.proyecto_api_rest_taller5.repositories.SolicitudRepository;
import co.edu.unicauca.taller5.proyecto_api_rest_taller5.services.DTO.SolicitudDTO;

@Service
public class SolicitudServiceImpl implements ISolicitudService{
    @Autowired 
    private SolicitudRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SolicitudDTO> findAll() {
        List<SolicitudEntity> solicitudesEntity = this.servicioAccesoBaseDatos.findAll();
        List<SolicitudDTO> solicitudesDTO = this.modelMapper.map(solicitudesEntity, new TypeToken<List<SolicitudDTO>>(){}.getType());
        return solicitudesDTO;
    }

    @Override
    public SolicitudDTO findBy(int id) {
        SolicitudEntity solicitudEntity = this.servicioAccesoBaseDatos.findBy(id);
        SolicitudDTO solicitudDTO = this.modelMapper.map(solicitudEntity, SolicitudDTO.class);
        return solicitudDTO;
    }

    @Override
    public SolicitudDTO save(SolicitudDTO solicitud) {
        SolicitudEntity solicitudEntity = this.modelMapper.map(solicitud, SolicitudEntity.class);
        SolicitudEntity objSolicitudEntity = this.servicioAccesoBaseDatos.save(solicitudEntity);
        SolicitudDTO solicitudDTO = this.modelMapper.map(objSolicitudEntity, SolicitudDTO.class);
        return solicitudDTO;
    }

    @Override
    public SolicitudDTO update(Integer id, SolicitudDTO solicitud) {
        SolicitudEntity solicitudEntity = this.modelMapper.map(solicitud, SolicitudEntity.class);
        SolicitudEntity objSolicitudEntity = this.servicioAccesoBaseDatos.update(id, solicitudEntity);
        SolicitudDTO solicitudDTO = this.modelMapper.map(objSolicitudEntity, SolicitudDTO.class);
        return solicitudDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
