package org.example.model;

import org.example.model.monstres.Monstre;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Plateau {

    // championJouant et championEnAttente sont créé pour gérer les tours de jeu
    // leur valeur alternera entre champion1 et champion2 en fonction du prochain joueur à jouer
    private Champion championJouant;
    private Champion championEnAttente;
    //Ici on gère une liste spécifique au plateau car les champions ont plus de monstres dans leurs mains que sur le plateau
    private List<Monstre> monstresChampionJouant;
    private List<Monstre> monstresChampionEnAttente;

    Logger l = Logger.getLogger("org.example.Main");
    
    public Plateau(Champion champion1, Champion champion2) {
        this.monstresChampionJouant = new ArrayList<>();
        this.monstresChampionEnAttente = new ArrayList<>();

        this.championJouant = champion1;
        this.championEnAttente = champion2;
    }

    public Champion getChampionJouant() {
        return championJouant;
    }

    public void setChampionJouant(Champion championJouant) {
        this.championJouant = championJouant;
    }

    public Champion getChampionEnAttente() {
        return championEnAttente;
    }

    public void setChampionEnAttente(Champion championEnAttente) {
        this.championEnAttente = championEnAttente;
    }

    public List<Monstre> getMonstresChampionJouant() {
        return monstresChampionJouant;
    }

    public void setMonstresChampionJouant(List<Monstre> monstresChampionJouant) {
        this.monstresChampionJouant = monstresChampionJouant;
    }

    public List<Monstre> getMonstresChampionEnAttente() {
        return monstresChampionEnAttente;
    }

    public void setMonstresChampionEnAttente(List<Monstre> monstresChampionEnAttente) {
        this.monstresChampionEnAttente = monstresChampionEnAttente;
    }

    /**
     * Lance le prochain tour de jeu
     * Déroulement :
     *     - les monstres posés par le champion courant jouent
     *     - le champion qui joue pose une carte ou non
     *     - le champion qui joue utilise ou non sa capacité
     *     - on check les niveaux de vie pour enlever les monstre KO et terminer la partie si champion KO
     *     - on change les références du champion qui joue et celui en attente pour le prochain tour
     * Toutes les décision sont faites aléatoirement
     * @return true si un champion est KO, c-a-d que la partie est finie
     */
    public boolean prochainTour(){
        l.info("=====================================");
        l.info("Début du tour de " + this.championJouant.getNom());
        // Etape 1 - les monstres jouent
        if(!this.monstresChampionJouant.isEmpty()) {
            this.monstresChampionJouant.forEach(monstreAllie -> monstreAllie.joueSonTour(this));
        }
        // Etape 2 - le champion pose une carte ou non
        // Génération d'un nombre aléatoire entre 0 et 100
        // si ce nombre ≥ 50, le champion pose une carte (s'il en a)
        int choixAction = new Random().nextInt(100);
        if(choixAction >= 50) {
            Monstre monstreAPoser = this.championJouant.choisiMonstreAPoserRandom();
            if (monstreAPoser != null) {
                l.info("Monstre posé : " + monstreAPoser.getNom());
                this.monstresChampionJouant.add(monstreAPoser);
                this.championJouant.getMonstres().remove(monstreAPoser); // on le retire de sa liste de monstre pour pas qu'il en ait en illimité
            }
        }
        // Etape 3 - Le champion utilise sa capacité ou non
        // pareil, on regénère un chiffre aléatoire comme au dessus pour savoir s'il utilise sa capacité ou non
        choixAction = new Random().nextInt(100);
        if(choixAction >= 50) {
            this.championJouant.getCapaciteSpeciale().declencheCapacite(this);
        }

        // Etape 4 - on gère les champions KO
        if(this.getChampionEnAttente().getPointVie() <= 0){
            l.info("Champion " + this.championEnAttente.getNom() + " KO, le gagnant est : " + this.championJouant.getNom());
            return true;
        }
        //on retire les monstres KO
        this.monstresChampionJouant.removeAll(this.monstresChampionJouant.stream().filter((monstreAllie) -> monstreAllie.getPointVie() <= 0).toList());
        this.monstresChampionEnAttente.removeAll(this.monstresChampionEnAttente.stream().filter((monstreEnnemi) -> monstreEnnemi.getPointVie() <= 0).toList());

        //Etape 5 - on met à jour les références des objets
        updateReferences();
        affichePlateau();

        return false;

    }

    /**
     * met à jour les références des objets pour changer le tour de jeu au champion suivant
     */
    private void updateReferences(){
        l.info("Fin de tour du joueur " + this.championJouant.getNom());
        Champion championTmp = this.championEnAttente;
        this.championEnAttente = this.championJouant;
        this.championJouant = championTmp;

        List<Monstre> monstreListTmp = this.monstresChampionEnAttente;
        this.monstresChampionEnAttente = this.monstresChampionJouant;
        this.monstresChampionJouant = monstreListTmp;
        l.info("=====================================");
    }

    public void affichePlateau(){
        l.info(this.championJouant.getNom() + ", pv : " + this.championJouant.getPointVie());
        l.info("ses monstres posés: " + this.monstresChampionJouant);
        l.info(this.championEnAttente.getNom() + ", pv : " + this.championEnAttente.getPointVie());
        l.info("ses monstres posés: " + this.monstresChampionEnAttente);

    }
}
