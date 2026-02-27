package org.example;

import java.sql.Connection;
import java.time.LocalDate;

public class Facture {
private int id;
private String status;
private LocalDate date;
private double montant;

    public Facture(int id, String status, LocalDate date, double montant) {
        this.id = id;
        this.status = status;
        this.date = date;
        this.montant = montant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
