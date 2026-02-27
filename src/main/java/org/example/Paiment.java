package org.example;

import java.time.LocalDate;

public class Paiment {
    private int id;
    private double montant;
    private LocalDate date;

    public Paiment(int id, double montant, LocalDate date) {
        this.id = id;
        this.montant = montant;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
