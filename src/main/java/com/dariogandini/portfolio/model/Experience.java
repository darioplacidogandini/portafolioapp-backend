package com.dariogandini.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "experience")
public class Experience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String empresa;
    private String puesto;
    private String logo;
    private String inicio;
    private String fin;

    public Experience() {

    }

    public Experience(String empresa, String puesto, String logo, String inicio, String fin) {
        this.empresa = empresa;
        this.puesto = puesto;
        this.logo = logo;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "empresa")
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Column(name = "puesto")
    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Column(name = "logo")
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column(name = "inicio")
    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    @Column(name = "fin")
    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
 
}
