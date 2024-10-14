package org.example.model;

import org.example.model.capacites.CapaciteExplosion;
import org.example.model.monstres.Mascotte;
import org.example.model.monstres.Monstre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChampionTest {

    @Test
    public void testSelectionMonstre(){
        Monstre monstre = new Monstre("monstre" , 3, 2);
        Monstre mascotte = new Mascotte("mascotte", 1, 0);

        List<Monstre> monstres = new ArrayList<>();
        monstres.add(monstre);
        monstres.add(mascotte);

        Champion champion = new Champion("explo-man", 30, new CapaciteExplosion(), monstres);
        Monstre m = champion.choisiMonstreAPoserRandom();
        Assertions.assertNotNull(m, "Le champion possède des cartes, le monstre sélectionné ne devrait pas être null");
    }

    @Test
    public void testSelectionMonstreListeVide(){
        Champion champion = new Champion("explo-man", 30, new CapaciteExplosion(), new ArrayList<>());
        Monstre m = champion.choisiMonstreAPoserRandom();
        Assertions.assertNull(m, "Le champions n'a pas de cartes, le monstre sélectionné devrait être null");
    }
}
