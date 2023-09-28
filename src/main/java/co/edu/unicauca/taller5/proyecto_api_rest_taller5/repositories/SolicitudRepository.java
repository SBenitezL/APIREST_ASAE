package co.edu.unicauca.taller5.proyecto_api_rest_taller5.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.taller5.proyecto_api_rest_taller5.models.SolicitudEntity;

@Repository
public class SolicitudRepository {
    private ArrayList<SolicitudEntity> listaSolicitudes;

    public SolicitudRepository()
    {
        this.listaSolicitudes = new ArrayList<SolicitudEntity>();
        this.cargarSolicitudes();
    }

    public List<SolicitudEntity> findAll()
   {
	   System.out.println("Invocando a listar solicitudes");
	   return this.listaSolicitudes;	
   }
	
   public SolicitudEntity findBy(Integer id)
   {
	   System.out.println("Invocando a consultar un solicitud");
		SolicitudEntity objSolicitud=null;
		
		for (SolicitudEntity solicitud : listaSolicitudes) {
			if(solicitud.getId()==id)
			{
				objSolicitud=solicitud;
				break;
			}
		}
		
		return objSolicitud;
	}
	
	public SolicitudEntity save(SolicitudEntity solicitud)	
	{
		 System.out.println("Invocando a almacenar Solicitud");
		 SolicitudEntity objSolicitud=null;
		 if (this.listaSolicitudes.add(solicitud))
		 {
			 objSolicitud=solicitud;
		 }
		 
		 return objSolicitud;
	}
	
	public SolicitudEntity update(Integer id, SolicitudEntity solicitud)
	{
		 System.out.println("Invocando a actualizar un Solicitud");
		 SolicitudEntity objSolicitud=null;
		 
		 for (int i = 0; i < this.listaSolicitudes.size(); i++) {
			if(this.listaSolicitudes.get(i).getId()==id)
			{				
				this.listaSolicitudes.set(i,solicitud);
				objSolicitud=solicitud;
				break;
			}
		}
		 
		 return objSolicitud;
	}
	
	public boolean delete(Integer id)
	{
		System.out.println("Invocando a eliminar una Solicitud, id = " + id);
		boolean bandera=false;
		 
		 for (int i = 0; i < this.listaSolicitudes.size(); i++) {
			if(this.listaSolicitudes.get(i).getId()==id)
			{
				this.listaSolicitudes.remove(i);
				bandera=true;
				break;
			}
		}
		 
		 return bandera;
	}

    private void cargarSolicitudes()
    {
        SolicitudEntity obj1 = new SolicitudEntity(1, new Date(), new Date(),"FIET",3,"La Inocente");
        this.listaSolicitudes.add(obj1);
        SolicitudEntity obj2 = new SolicitudEntity(2, new Date(), new Date(),"FIET",1,"Nunca te supe cuidar");
        this.listaSolicitudes.add(obj2);
        SolicitudEntity obj3 = new SolicitudEntity(3, new Date(), new Date(),"FIET",4,"Llora mas");
        this.listaSolicitudes.add(obj3);
    }

}
