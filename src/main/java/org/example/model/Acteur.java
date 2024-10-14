package org.example.model;

/**
 * Un Acteur va représenter toutes les entités jouables du jeu (Champion ou Monstre)
 */
public abstract class Acteur {
    private int id;
    private String nom;
    private int pointVie;

    private static int COMPTEUR_ID = 0;

    public Acteur(String nom, int pointVie) {
        this.id = COMPTEUR_ID;
        this.nom = nom;
        this.pointVie = pointVie;
        COMPTEUR_ID ++;
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

    public int getPointVie() {
        return pointVie;
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", nom='" + nom + '\'' +
                ", pointVie=" + pointVie;
    }
}
