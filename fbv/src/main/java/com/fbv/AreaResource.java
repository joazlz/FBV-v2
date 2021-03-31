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

import com.fbv.Models.Area;
import com.fbv.Repository.AreaRepository;


    

@Path("/area")
public class AreaResource {
    
    @Inject
    private AreaRepository areaRepository;


    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Area> all() {
        return areaRepository.getAll();
    }

    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Area> actividad(@QueryParam("id") Long id,
                                @QueryParam("nombre") String nombre) {
        if(id!=null){
            List<Area> ac = new ArrayList<>();
            Area a = areaRepository.buscarId(id);
            if(a!=null){
                ac.add(areaRepository.buscarId(id));
            }
    
            return ac;
        }
        return areaRepository.buscarNombre(nombre);
    }

    @POST
    @Path("/crear")
    @Consumes("application/json")
    @Transactional
    public Response crear(@QueryParam("nombre") String nombre,
                            @QueryParam("utilizaquimico") boolean utilizaQuimico) {
        try {
            Area area = new Area();

            area.nombre = nombre;

            areaRepository.crear(area);

            return Response.ok(area,MediaType.APPLICATION_JSON).build();
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
            Area area = new Area();

            area.id = id;
            area.nombre = nombre;

            areaRepository.actualizar(area);

            return Response.ok(area,MediaType.APPLICATION_JSON).build();
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
            areaRepository.eliminar(id);
            return Response.ok(id,MediaType.APPLICATION_JSON).build();
        }
        catch(PersistenceException pe){
            return Response.serverError().build();
        }
    }



}
