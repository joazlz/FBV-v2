package com.fbv;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fbv.Models.Actividad;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public String hello() {
        Actividad actividad = new Actividad();
            actividad.nombre = "Cosecha";
            actividad.persist();
        return actividad.toString();
    }
}