package org.example.model.capacites;

import org.example.model.Plateau;

/**
 * Capacité spécifique du champion: Eradication
 * La déclencher infligera 5 points de dégats au champion adverse
 */
public class CapaciteEradication implements Capacite {
    @Override
    public void declencheCapacite(Plateau p) {
        logger.info("Utilisation de ma capacité spéciale... " + this.afficheNom());
        p.getChampionEnAttente().setPointVie(p.getChampionEnAttente().getPointVie() - 5);
    }

    @Override
    public String afficheNom() {
        return "Eradication !!! ";
    }
}
