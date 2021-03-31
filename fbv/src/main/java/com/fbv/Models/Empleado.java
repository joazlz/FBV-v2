package com.fbv.Models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "empleados")
public class Empleado extends PanacheEntity{
    
    @Column
    public String nombres;
    
    @Column
    public String apellidos;

    @Column(length = 13)
    public Long dpi;

    @Column
    public int[] dpiFoto;
    
    @Column
    public String direccion;

    @Column
    public String genero;
    
    @Column
    public LocalDate comienzoLaboral;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_id")
    private TipoEmpleado tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id")
    private EstadoEmpleado estado;


}
