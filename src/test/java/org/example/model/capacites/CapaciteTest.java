package org.example.model.capacites;

import org.example.model.Champion;
import org.example.model.Plateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CapaciteTest {

    @Test
    public void testCapaciteEradication(){
        Champion c1 = new Champion("ChampionTest1", 10, new CapaciteEradication(), null);
        Champion c2 = new Champion("ChampionTest2", 10, new CapaciteEradication(), null);

        Plateau p = new Plateau(c1, c2);
        c1.getCapaciteSpeciale().declencheCapacite(p);

        Assertions.assertEquals(c2.getPointVie(), 5, "La capacité spéciale Éradication devrait enlever exactement 5 pv");
    }
}
