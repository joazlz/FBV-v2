package com.fbv.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "estados_herramientas")
public class EstadoHerramienta extends PanacheEntity{
    
    @Column
    public String nombre;
    
}
