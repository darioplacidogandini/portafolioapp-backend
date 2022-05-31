package com.dariogandini.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "acerca")
public class Acerca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String foto;
    private String portada;
    private String nombre;
    private String puesto;

    public Acerca() {

    }

    public Acerca(String foto, String portada, String nombre, String puesto) {
        this.foto = foto;
        this.portada = portada;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "foto")
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Column(name = "portada")
    public String getBanner() {
        return portada;
    }

    public void setBanner(String portada) {
        this.portada = portada;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "puesto")
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
 
}
