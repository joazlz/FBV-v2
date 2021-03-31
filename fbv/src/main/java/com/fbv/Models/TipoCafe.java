package com.fbv.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "tipos_cafes")
public class TipoCafe extends PanacheEntity{
    @Column
    public String nombre;

}
