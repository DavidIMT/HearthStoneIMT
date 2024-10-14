package org.example.model;

import org.example.model.capacites.CapaciteEradication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlateauTest {

    @Test
    public void testChampionKO(){
        //On force le premier champion à utiliser sa capacité spéciale pour diminuer les pv adverse à 0
        //le combat devrait s'arreter
        Champion champion = new Champion("explo-man", 30, new CapaciteEradication(), new ArrayList<>());
        Champion champion2 = new Champion("le décapiteur", 5, new CapaciteEradication(), new ArrayList<>());
        Plateau plateau = new Plateau(champion, champion2);

        champion.getCapaciteSpeciale().declencheCapacite(plateau);
        Assertions.assertEquals(champion2.getPointVie(), 0, "Les points de vie du monstre attaqué ne sont pas bons, ils devraient valoir 0");
        Assertions.assertTrue(plateau.prochainTour(), "la méthode prochainTour aurait dû renvoyer true car un combattant est KO et le combat est fini");
    }
}
