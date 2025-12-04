package nl.workingtalent.project.laas.models;

import jakarta.persistence.*;

@Entity
public class Admin extends Account {
    
    private String workTitle;

    public Admin() {
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }
}