package org.example.model;

import org.example.model.capacites.Capacite;
import org.example.model.monstres.Monstre;

import java.util.List;
import java.util.Random;

public class Champion extends Acteur {

    // ici on passe pas directement l'interface capacité, car on veut un champion générique
    // c'est la capacité qui peut être spécifique mais pas le champion
    private Capacite capaciteSpeciale;
    private List<Monstre> monstres;

    public Champion(String nom, int pointVie, Capacite capaciteSpeciale, List<Monstre> monstres) {
        super(nom, pointVie);
        this.capaciteSpeciale = capaciteSpeciale;
        this.monstres = monstres;
    }

    public Capacite getCapaciteSpeciale() {
        return capaciteSpeciale;
    }

    public void setCapaciteSpeciale(Capacite capaciteSpeciale) {
        this.capaciteSpeciale = capaciteSpeciale;
    }

    public List<Monstre> getMonstres() {
        return monstres;
    }

    public void setMonstres(List<Monstre> monstres) {
        this.monstres = monstres;
    }

    public Monstre choisiMonstreAPoserRandom(){
        return this.monstres.isEmpty() ? null : this.monstres.get(new Random().nextInt(this.monstres.size()));
    }

    @Override
    public String toString() {
        return super.toString() +
                ", capaciteSpeciale=" + capaciteSpeciale.afficheNom() +
                ", monstres=" + monstres;
    }
}
