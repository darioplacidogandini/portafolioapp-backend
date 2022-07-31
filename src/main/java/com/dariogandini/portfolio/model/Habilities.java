package com.dariogandini.portfolio.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Habilities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String hability;
    String percentage;
    public Habilities(long id, String hability, String percentage) {
        this.id = id;
        this.hability = hability;
        this.percentage = percentage;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "hability")
    public String getHability() {
        return hability;
    }
    public void setHability(String hability) {
        this.hability = hability;
    }

    @Column(name = "percentage")
    public String getPercentage() {
        return percentage;
    }
    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
    
    
}
