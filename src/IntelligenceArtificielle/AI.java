/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntelligenceArtificielle;

import GUI.Grille;
import GUI.Case;
import Partie.Joueur;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author arnaud
 */
public class AI extends Joueur {
    
    // NIVEAU FACILE : 0
    // NIVEAU DIFFICILE : 1
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
        int rangeeAleatoire;
        int colonneAleatoire;
        // Cherche aleatoirement une case non choisie dans la grille
        do{
            colonneAleatoire = ThreadLocalRandom.current().nextInt(0, grille.getColonnes());
            rangeeAleatoire = ThreadLocalRandom.current().nextInt(0, grille.getRangees());
        }while(grille.getGrille()[rangeeAleatoire][colonneAleatoire].getStatut() != 0);
        // Retourne la case non choisie
        return grille.getGrille()[rangeeAleatoire][colonneAleatoire];
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
        
        if(this.niveauDifficulte == 0){ // Si Niveau difficulte facile
            return makeRandomMove(grille);       
        }else{                          // Si Niveau difficulte eleve
            return makeMiniMaxMove(grille);
        }
    }
    
    
    public ArrayList<Case> placerBateau(Grille grille, int numCases){
       
        ArrayList<Case> casesBateau = new ArrayList<Case>();

        // Determine dans quel sens seront les cases suivants la case aleatoire initiale
         int directionBateau = -1; // 0: haut, 1:droite, 2:bas, 3: gauche
        
        for(int i = 0; i < numCases; i++){
            if(i == 0 ){ // Premiere case est une case aleatoire
                casesBateau.add(this.makeRandomMove(grille));
                directionBateau = ThreadLocalRandom.current().nextInt(0, 4);
            }else{ // Les cases suivantes du bateau
                if( directionBateau == 0){
                    if( casesBateau.get(i-1).getRangee() == 0){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else if( grille.getGrille()[casesBateau.get(i-1).getRangee()-1][casesBateau.get(i-1).getColonne()].getStatut() == 1){
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else {
                        casesBateau.add(grille.getGrille()[casesBateau.get(i-1).getRangee()-1][casesBateau.get(i-1).getColonne()]);
                    }
                }
                if( directionBateau == 1){
                    if( casesBateau.get(i-1).getColonne() == grille.getColonnes()-1){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else if( grille.getGrille()[casesBateau.get(i-1).getRangee()][casesBateau.get(i-1).getColonne()+1].getStatut() == 1){
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else {
                        casesBateau.add(grille.getGrille()[casesBateau.get(i-1).getRangee()][casesBateau.get(i-1).getColonne()+1]);
                    }
                }
                if( directionBateau == 2 ) {
                    if( casesBateau.get(i-1).getRangee() == grille.getRangees()-1){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else if( grille.getGrille()[casesBateau.get(i-1).getRangee()+1][casesBateau.get(i-1).getColonne()].getStatut() == 1){
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else {
                        casesBateau.add(grille.getGrille()[casesBateau.get(i-1).getRangee()+1][casesBateau.get(i-1).getColonne()]);
                    }
                }
                if( directionBateau == 3 ) {
                    if( casesBateau.get(i-1).getColonne() == 0){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else if( grille.getGrille()[casesBateau.get(i-1).getRangee()][casesBateau.get(i-1).getColonne()-1].getStatut() == 1){
                        i = -1;
                        casesBateau = new ArrayList<Case>();
                    } else {
                        casesBateau.add(grille.getGrille()[casesBateau.get(i-1).getRangee()][casesBateau.get(i-1).getColonne()-1]);
                    }
                }    
            }
           
        }
        
        return casesBateau;
    }
    
    // Getters
    public int getNiveauDifficulte() { return niveauDifficulte; }
    
    // Setters
    public void setNiveauDifficulte(int niveauDifficulte) { this.niveauDifficulte = niveauDifficulte; }
    
}
