package com.fbv.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "productos")
public class Producto extends PanacheEntity{

    @Column
    public String nombre;

    @Column
    public boolean estado;
    
    @Column
    public byte[] imagen;


    
}
