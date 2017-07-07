/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntelligenceArtificielle;

import GUI.Grille;
import GUI.Case;
import Partie.Point;
import Partie.Joueur;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
    
    /**
     * Choisit une case non-choisit de la grille en attribut selon l'algorithme mini-max
     * 
     * @param grille
     * @return Case
     */
    public Point makeMiniMaxMove(Grille grille) {
        Map<Point, Integer> pointsTouches = new HashMap<>();
        ArrayList 
        if( > 0){
            int choixCasesPotentielles = ThreadLocalRandom.current().nextInt(0,casesPotentielles.size());
            int rangee = casesPotentielles.get(choixCasesPotentielles).getPoint().getRangee();
            int colonne = casesPotentielles.get(choixCasesPotentielles).getPoint().getColonne();
            int directionProchaineCase;
            boolean neSatisfaitPasCondition;
            do{               
                neSatisfaitPasCondition = false;
                directionProchaineCase = ThreadLocalRandom.current().nextInt(0, casesPotentielles.size());
                switch (directionProchaineCase) {
                    case 0:
                        // haut
                        if(rangee > 0){
                            rangee -= 1;
                        } else {
                            neSatisfaitPasCondition = true;
                        }   break;
                    case 1:
                        // droite
                        if(colonne > 0){
                            colonne += 1;
                        } else {
                            neSatisfaitPasCondition = true;
                        }   break;
                    case 2:
                        // bas
                        if(rangee > 0){
                            rangee += 1;
                        } else {
                            neSatisfaitPasCondition = true;
                        }   break;
                    case 3:
                        // gauche
                        if(colonne > 0){
                            colonne -= 1;
                        } else {
                            neSatisfaitPasCondition = true;
                        }   break;
                    default:
                        break;
                }
            }while(neSatisfaitPasCondition);
            
            return new Point(rangee, colonne);
            
        }else{
            return makeRandomMove(grille);
        }
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
    public Point makeMove(Grille grille){
        
        if(this.niveauDifficulte == 0){ // Si Niveau difficulte facile
            return makeRandomMove(grille);       
        }else{                          // Si Niveau difficulte eleve
            return makeMiniMaxMove(grille);
        }
    }
    
    
    public Map<Point, Integer> placerBateau(Grille grille, int numCases){
        Point point = new Point(-1,-1);
        Point nouvPoint = new Point(-1, -1);
        Map<Point, Integer> pointsBateau = new HashMap<>() ;
        
        // Determine dans quel sens seront les cases suivants la case aleatoire initiale
        int directionBateau = -1; // 0: haut, 1:droite, 2:bas, 3: gauche
        
        for(int i = 0; i < numCases; i++){
            if(i == 0 ){ // Premiere case est une case aleatoire
                point = this.makeRandomMove(grille);
                pointsBateau.put(point, 1);
                directionBateau = ThreadLocalRandom.current().nextInt(0, 4);
            }else{ // Les cases suivantes du bateau
                if( directionBateau == 0){
                    if( point.getRangee() == 0){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else if( grille.getGrille()[point.getRangee()-1][point.getColonne()].getStatut() == 1){
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else {
                        pointsBateau.put(grille.getGrille()[point.getRangee()-1][point.getColonne()].getPoint(), 1);
                        nouvPoint = new Point(point.getRangee()-1, point.getColonne());
                        point = new Point(nouvPoint);
                    }
                }
                if( directionBateau == 1){
                    if( point.getColonne() == grille.getColonnes()-1){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else if( grille.getGrille()[point.getRangee()][point.getColonne()+1].getStatut() == 1){
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else {
                        pointsBateau.put(grille.getGrille()[point.getRangee()][point.getColonne()+1].getPoint(), 1);
                        nouvPoint = new Point(point.getRangee(), point.getColonne()+1);
                        point = new Point(nouvPoint);
                    }
                }
                if( directionBateau == 2 ) {
                    if( point.getRangee() == grille.getRangees()-1){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else if( grille.getGrille()[point.getRangee()+1][point.getColonne()].getStatut() == 1){
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else {
                        pointsBateau.put(grille.getGrille()[point.getRangee()+1][point.getColonne()].getPoint(), 1);
                        nouvPoint = new Point(point.getRangee()+1, point.getColonne());
                        point = new Point(nouvPoint);
                    }
                }
                if( directionBateau == 3 ) {
                    if( point.getColonne() == 0){ // Atteint une extremite, on recommence le positionnement
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else if( grille.getGrille()[point.getRangee()][point.getColonne()-1].getStatut() == 1){
                        i = -1;
                        pointsBateau = new HashMap<>();
                    } else {
                        pointsBateau.put(grille.getGrille()[point.getRangee()][point.getColonne()-1].getPoint(), 1);
                        nouvPoint = new Point(point.getRangee(), point.getColonne()-1);
                        point = new Point(nouvPoint);
                    }
                }    
            }
           
        }
        
        return pointsBateau;
    }
    
    // Getters
    public int getNiveauDifficulte() { return niveauDifficulte; }
    
    // Setters
    public void setNiveauDifficulte(int niveauDifficulte) { this.niveauDifficulte = niveauDifficulte; }
    
}
