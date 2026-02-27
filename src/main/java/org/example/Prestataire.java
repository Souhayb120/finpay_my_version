package org.example;

public class Prestataire {
    private int id;
    private String nom;
    private String adress;

    public Prestataire(int id, String nom, String adress) {
        this.id = id;
        this.nom = nom;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
