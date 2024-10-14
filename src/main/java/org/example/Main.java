package org.example;

import org.example.model.Champion;
import org.example.model.Plateau;
import org.example.model.capacites.CapaciteEradication;
import org.example.model.capacites.CapaciteExplosion;
import org.example.model.monstres.Mascotte;
import org.example.model.monstres.Monstre;
import org.example.model.monstres.Protecteur;
import org.example.model.monstres.Soigneur;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ceci est le projet et la propriété intellectuelle de David Dupont, toute modification de ce programme engendrera le paiement d'une bière à son auteur");
        InputStream configFile = Main.class.getClassLoader().getResourceAsStream("./logging.properties");
        try{
            LogManager.getLogManager().readConfiguration(configFile);
        } catch (IOException e){
            e.printStackTrace();
        }

        Monstre monstre = new Monstre("monstre" , 3, 2);
        Monstre protecteur = new Protecteur("protecteur",  5,1);
        Monstre mascotte = new Mascotte("mascotte", 1, 0);
        Monstre soigneur = new Soigneur("soigneur", 3, 3);

        List<Monstre> monstres = new ArrayList<>();
        monstres.add(monstre);
        monstres.add(mascotte);

        List<Monstre> monstresChamp2 = new ArrayList<>();

        monstresChamp2.add(protecteur);
        monstresChamp2.add(soigneur);

        Champion champion = new Champion("explo-man", 30, new CapaciteExplosion(), monstres);
        Champion champion2 = new Champion("le décapiteur", 30, new CapaciteEradication(), monstresChamp2);

        Plateau plateau = new Plateau(champion, champion2);

        boolean championKO = false;
        while(!championKO){
            championKO = plateau.prochainTour();
        }
    }
}