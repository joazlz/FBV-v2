package com.fbv;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fbv.Models.Actividad;
import com.fbv.Repository.ActividadRepository;
    

@Path("/actividad")
public class ActividadResource {
    
    @Inject
    private ActividadRepository actividadRepository;


    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Actividad> all() {
        return actividadRepository.getAll();
    }

    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Actividad actividad(@QueryParam("nombre") String nombre) {
        return actividadRepository.buscarNombre(nombre);
    }

    @POST
    @Path("/crear")
    @Transactional
    public Response crear(@QueryParam("nombre") String nombre) {
        try {
            Actividad actividad = new Actividad();
            actividad.nombre = nombre;
            actividadRepository.crear(actividad);
            return Response.ok(actividad,MediaType.APPLICATION_JSON).build();
        }
        catch(PersistenceException pe){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/actualizar")
    @Transactional
    public Response actualizar(@QueryParam("id") Long id,
                                @QueryParam("nombre") String nombre) {
        try {
            Actividad actividad = new Actividad();
            actividad.id = id;
            actividad.nombre = nombre;
            actividadRepository.actualizar(actividad);
            return Response.ok(actividad,MediaType.APPLICATION_JSON).build();
        }
        catch(PersistenceException pe){
            return Response.serverError().build();
        }
    }




}
