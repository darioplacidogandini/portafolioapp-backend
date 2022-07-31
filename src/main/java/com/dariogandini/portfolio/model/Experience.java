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

    private String company;
    private String job;
    private String start;
    private String end; 
    private String companyLogo;

    public Experience(long id, String company, String job, String start, 
    String end, String companyLogo) {
        this.id = id;
        this.company = company;
        this.job = job;
        this.start = start;
        this.end = end;
        this.companyLogo = companyLogo;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "company")
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "job")
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Column(name = "start")
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }

    @Column(name = "end")
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Column(name = "company-logo")
    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    
}
