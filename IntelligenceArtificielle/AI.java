/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntelligenceArtificielle;

import GUI.Grille;
import GUI.Case;
import Partie.Joueur;

/**
 *
 * @author arnaud
 */
public class AI extends Joueur {
    
    private int niveauDifficulte;
    
    // Constructeur par defaut
    public AI() {
        
    }
    
    // Constructeur par attributs
    public AI(int niveauDifficulte){
        this.niveauDifficulte = niveauDifficulte;
    }
    
    // Methodes de classes
    
    /**
     * Choisit une case aleatoire non-choisit de la grille en attribut
     * 
     * @param grille
     * @return Case 
     */
    public Case makeRandomMove(Grille grille){
        return new Case();
    }
    
    /**
     * Choisit une case non-choisit de la grille en attribut selon l'algorithme mini-max
     * 
     * @param grille
     * @return 
     */
    public Case makeMiniMaxMove(Grille grille) {
        return new Case();
    }
    
    
    /**
     * Decide du type de coup de l'intelligence artificielle selon son niveau de 
     * difficulte
     * 
     * Retourne la case choisie ensuite.
     * 
     * @param grille
     * @return Case
     */
    public Case makeMove(Grille grille){
        
        if(this.niveauDifficulte == 1){ // Si Niveau difficulte facile
            return makeRandomMove(grille);       
        }else{                          // Si Niveau difficulte eleve
            return makeMiniMaxMove(grille);
        }
    }
    
    // Getters
    public int getNiveauDifficulte() { return niveauDifficulte; }
    
    // Setters
    public void setNiveauDifficulte(int niveauDifficulte) { this.niveauDifficulte = niveauDifficulte; }
    
}
