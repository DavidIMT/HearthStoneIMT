package org.example.model.monstres;

import org.example.model.Acteur;
import org.example.model.Plateau;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Monstre extends Acteur implements ActionMonstre {
    private int pointForce;

    Logger logger = Logger.getLogger("org.example.Main");

    public Monstre(String nom, int pointVie, int pointForce) {
        super(nom, pointVie);
        this.pointForce = pointForce;
    }

    public int getPointForce() {
        return pointForce;
    }

    public void setPointForce(int pointForce) {
        this.pointForce = pointForce;
    }

    @Override
    public void joueSonTour(Plateau plateau) {
        Acteur acteurEnnemiRandom; // peut attaquer soit un monstre soit un champion
        // Check s'il y a des protecteurs
        List<Monstre> protecteursAdverses = plateau.getMonstresChampionEnAttente().stream().filter((data) -> data instanceof Protecteur).toList();
        if (!protecteursAdverses.isEmpty()){
            acteurEnnemiRandom = protecteursAdverses.get(new Random().nextInt(protecteursAdverses.size()));
        } else {
            acteurEnnemiRandom = plateau.getChampionEnAttente();
        }
        logger.info(this.getNom() + " attaque le monstre " + acteurEnnemiRandom.getNom());
        acteurEnnemiRandom.setPointVie(acteurEnnemiRandom.getPointVie() - this.pointForce);
    }

    @Override
    public String toString() {
        return super.toString() +
                " pointForce=" + pointForce;
    }

    public Logger getLogger() {
        return logger;
    }
}
