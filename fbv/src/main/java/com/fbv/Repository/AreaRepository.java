package com.fbv.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.fbv.Models.Area;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AreaRepository implements PanacheRepository<Area>{
    
    public void crear(Area actividad){
        actividad.persistAndFlush();
    }

    public List<Area> getAll(){
        return listAll();
    }

    public List<Area> buscarNombre(String nombre){
        return find("nombre like ?1", "%"+nombre+"%").list();
    }

    public Area buscarId(Long id){
        return findById(id);
    }

    public void eliminar(Long id){
        deleteById(id);
    }

    public void actualizar(Area area){
        Area up = buscarId(area.id);
        up.nombre = area.nombre;
    }


}
