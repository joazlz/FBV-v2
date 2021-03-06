package com.fbv;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public List<Actividad> actividad(@QueryParam("id") Long id,
                                        @QueryParam("nombre") String nombre,
                                        @QueryParam("utilizaquimico") boolean utilizaQuimico) {
        if(id!=null){
            List<Actividad> ac = new ArrayList<>();
            Actividad a = actividadRepository.buscarId(id);
            if(a!=null){
                ac.add(actividadRepository.buscarId(id));
            }
    
            return ac;
        }
        if(nombre!=null){
            return actividadRepository.buscarNombre(nombre);
        }
        return actividadRepository.buscarUtilizaQuimico(utilizaQuimico);
    }

    @POST
    @Path("/crear")
    @Consumes("application/json")
    @Transactional
    public Response crear(@QueryParam("nombre") String nombre,
                            @QueryParam("utilizaquimico") boolean utilizaQuimico) {
        try {
            Actividad actividad = new Actividad();

            actividad.nombre = nombre;
            actividad.utilizaQuimico = utilizaQuimico;

            actividadRepository.crear(actividad);

            return Response.ok(actividad,MediaType.APPLICATION_JSON).build();
        }
        catch(PersistenceException pe){
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/actualizar")
    @Consumes("application/json")
    @Transactional
    public Response actualizar(@QueryParam("id") Long id,
                                @QueryParam("nombre") String nombre,
                                @QueryParam("utilizaquimico") boolean utilizaQuimico) {
        try {
            Actividad actividad = new Actividad();

            actividad.id = id;
            actividad.nombre = nombre;
            actividad.utilizaQuimico = utilizaQuimico;

            actividadRepository.actualizar(actividad);

            return Response.ok(actividad,MediaType.APPLICATION_JSON).build();
        }
        catch(PersistenceException pe){
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response eliminar(@PathParam("id") Long id){
        try {
            actividadRepository.eliminar(id);
            return Response.ok(id,MediaType.APPLICATION_JSON).build();
        }
        catch(PersistenceException pe){
            return Response.serverError().build();
        }
    }



}
