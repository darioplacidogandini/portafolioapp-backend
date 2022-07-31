package com.dariogandini.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;
    private String institution;
    private String date;
    private String duration;
    private String institutionLogo;

    public Education(long id, String title, String institution, 
    String date, String duration, String institutionLogo) {
        this.id = id;
        this.title = title;
        this.institution = institution;
        this.date = date;
        this.duration = duration;
        this.institutionLogo = institutionLogo;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "institution")
    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "duration")
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Column(name = "institution-logo")
    public String getInstitutionLogo() {
        return institutionLogo;
    }

    public void setInstitutionLogo(String institutionLogo) {
        this.institutionLogo = institutionLogo;
    } 
}
