package com.dariogandini.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "habilidades")
public class Habilidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String habilidad;
    private String porcentaje;

    public Habilidades() {
        
    }

    public Habilidades(String habilidad, String porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "habilidad")
    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

}
