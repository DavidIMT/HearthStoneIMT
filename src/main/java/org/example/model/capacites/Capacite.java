package org.example.model.capacites;

import org.example.model.Plateau;

import java.util.logging.Logger;

public interface Capacite {

    Logger logger = Logger.getLogger("org.example.Main");
    /**
     * Méthode pour déclencher la capacité spéciale du champion
     * On met le plateau entier en entrée car ici j'autorise potentiellement
     * le champion a attaquer plusieurs acteurs alliés ou ennemis
     * (grâce aux champions et aux listes de monstre en attribut du plateau)
     * @param p le plateau sur lequel la capacité aura des effets
     */
    void declencheCapacite(Plateau p);

    /**
     * affiche le nom de l'attaque spéciale
     */
    String afficheNom();
}
