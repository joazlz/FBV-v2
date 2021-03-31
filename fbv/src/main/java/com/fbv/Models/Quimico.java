package com.fbv.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;



@Entity
@Table(name = "quimicos")
public class Quimico extends PanacheEntity{

    @Column
    public String nombre;

    @Column
    public boolean estado;
    
    @Column
    public byte[] imagen;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_quimico_id")
    private TipoQuimico tipoQuimico;
}
