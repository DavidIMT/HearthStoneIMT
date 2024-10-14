package org.example.model.monstres;

import org.example.model.Plateau;

import java.util.Random;

public class Soigneur extends Monstre {
    public Soigneur(String nom, int pointVie, int pointForce) {
        super(nom, pointVie, pointForce);
    }

    @Override
    public void joueSonTour(Plateau plateau) {
        Monstre monstreAllieRandom = plateau.getMonstresChampionJouant().get(new Random().nextInt(plateau.getMonstresChampionJouant().size()));
        this.getLogger().info(this.getNom() + " soigne le monstre " + monstreAllieRandom.getNom());
        monstreAllieRandom.setPointVie(monstreAllieRandom.getPointVie() + this.getPointForce());
    }
}
