package com.fbv.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.fbv.Models.Actividad;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ActividadRepository implements PanacheRepository<Actividad>{
    
    public void crear(Actividad actividad){
        actividad.persistAndFlush();
    }

    public List<Actividad> getAll(){
        return listAll();
    }

    public Actividad buscarNombre(String nombre){
        return find("nombre", nombre).firstResult();
    }

    public Actividad buscarId(Long id){
        return findById(id);
    }

    public void actualizar(Actividad actividad){
        Actividad up = buscarId(actividad.id);
        up.nombre = actividad.nombre;
    }


}
