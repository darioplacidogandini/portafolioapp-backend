package com.dariogandini.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "projects")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String projectName;
    private String description;
    private String projectURL;
    private String sourceCode;
    private String projectLogo;

    public Projects() {}

    public Projects(long id, String projectName, String description, 
    String projectURL, String sourceCode, String projectLogo) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.projectURL = projectURL;
        this.sourceCode = sourceCode;
        this.projectLogo = projectLogo;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "project-name")
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "project-URL")
    public String getProjectURL() {
        return projectURL;
    }

    public void setProjectURL(String projectURL) {
        this.projectURL = projectURL;
    }

    @Column(name = "source-code")
    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Column(name = "project-logo")
    public String getProjectLogo() {
        return projectLogo;
    }
    public void setProjectLogo(String projectLogo) {
        this.projectLogo = projectLogo;
    }

    
}
