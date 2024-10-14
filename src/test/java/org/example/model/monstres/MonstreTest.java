package org.example.model.monstres;

import org.example.model.Plateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MonstreTest {

    @Test
    public void testAttaqueMonstre(){
        Monstre monstre = new Monstre("monstre1", 10, 10);
        Monstre monstre2 = new Protecteur("monstre2", 10, 10);

        //on met manuellement des monstres sur le plateau et on force le premier monstre à jouer
        Plateau plateau = new Plateau(null, null);
        plateau.getMonstresChampionJouant().add(monstre);
        plateau.getMonstresChampionEnAttente().add(monstre2);
        //le monstre doit obligatoirement taper le protecteur vu qu'il protège tout le monde
        monstre.joueSonTour(plateau);

        Assertions.assertEquals(monstre2.getPointVie(), 0, "Les points de vie du monstre attaqué ne sont pas bons, ils devraient valoir 0");
    }
}
