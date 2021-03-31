package com.fbv.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "actividades")
public class Actividad extends PanacheEntity{
    
    @Column(nullable = false)
    public String nombre;

    @Column
    public boolean utilizaQuimico;

}
