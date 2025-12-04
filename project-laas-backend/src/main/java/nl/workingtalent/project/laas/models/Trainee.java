package nl.workingtalent.project.laas.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Trainee extends Account {
    
    private String specialisation;
    private long assignedPath;
    private List<Long> assignedPathElements;
    private List<Long> loans;
    private List<Long> reservations;

    public Trainee() {
    }
}