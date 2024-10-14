package org.example.model.monstres;

import org.example.model.Plateau;

import java.util.Random;

public class Mascotte extends Monstre {
    public Mascotte(String nom, int pointVie, int pointForce) {
        super(nom, pointVie, pointForce);
    }

    @Override
    public void joueSonTour(Plateau plateau) {
        Monstre monstreAllieRandom = plateau.getMonstresChampionJouant().get(new Random().nextInt(plateau.getMonstresChampionJouant().size()));
        this.getLogger().info(this.getNom() + " boost le monstre " + monstreAllieRandom.getNom());
        monstreAllieRandom.setPointForce(monstreAllieRandom.getPointForce() + 2);
    }
}
