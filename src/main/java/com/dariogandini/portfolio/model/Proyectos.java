package com.dariogandini.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String descripcion;
    private String url;
    private String codigoFuente;
    private String logo;

    public Proyectos() {
        
    }

    public Proyectos(String nombre, String descripcion, String url, String codigoFuente, String logo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.codigoFuente = codigoFuente;
        this.logo = logo;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "codigo")
    public String getCodigoFuente() {
        return codigoFuente;
    }

    public void setCodigoFuente(String codigoFuente) {
        this.codigoFuente = codigoFuente;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
