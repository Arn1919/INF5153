/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntelligenceArtificielle;

import GUI.Grille;
import Partie.Point;

import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author arnaud
 */
public class AIAleatoire extends AI {
    
    
    // Constructeur par defaut
    public AIAleatoire() {
        
    }
    
    // Methodes de classes
    
    /**
     * Choisit une case aleatoire non-choisit de la grille en attribut
     * 
     * @param grille
     * @return Case 
     */
    public Point makeRandomMove(Grille grille){
        int rangeeAleatoire;
        int colonneAleatoire;
        // Cherche aleatoirement une case non choisie dans la grille
        do{
            colonneAleatoire = ThreadLocalRandom.current().nextInt(0, grille.getColonnes());
            rangeeAleatoire = ThreadLocalRandom.current().nextInt(0, grille.getRangees());
        }while(grille.getGrille()[rangeeAleatoire][colonneAleatoire].getStatut() != 0);
        // Retourne la case non choisie
        return grille.getGrille()[rangeeAleatoire][colonneAleatoire].getPoint();
    }

    
}
