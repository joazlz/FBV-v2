package com.fbv.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "medidas_derivadas")
public class MedidaDerivada extends PanacheEntity{
    @Column
    public String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medida_basica_id")
    private MedidaBasica medidaBasica;
    
}