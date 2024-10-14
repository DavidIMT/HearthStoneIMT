package org.example.model.capacites;

import org.example.model.Plateau;

/**
 * Capacité spécifique du champion: Explosion
 * La déclencher entrainera des dégats à tous les monstres ennemis posés sur le plateau
 * ainsi qu'au champion adverse
 */
public class CapaciteExplosion implements Capacite {

    @Override
    public void declencheCapacite(Plateau p) {
        logger.info("Capacité activée.. " + this.afficheNom());
        p.getChampionEnAttente().setPointVie(p.getChampionEnAttente().getPointVie() - 2);
        p.getMonstresChampionEnAttente().forEach((monstre) -> monstre.setPointVie(monstre.getPointVie() - 2));
    }

    @Override
    public String afficheNom() {
        return "Explosion de la mort qui tue";
    }
}
