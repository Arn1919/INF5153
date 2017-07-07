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
        ArrayList<Point> pointsTouches = new ArrayList<>();
        ArrayList<Point> coupsPossibles = new ArrayList<>();
        // 1. Reconnaissance
        pointsTouches = reconnaissanceGrille(grille);
        // 2. Coups possibles 
        coupsPossibles = determinerCoupsPossibles(pointsTouches, grille);
        // 3. Effectue un choix aleatoire
        if(coupsPossibles.size() > 0){
            return coupsPossibles.get(ThreadLocalRandom.current().nextInt(0, coupsPossibles.size()));
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
    
    /**
     * Cherche la grille pour toutes les cases de bateaux touches
     * et retourne la liste
     * 
     * @param grille
     * @return ArrayList<Point>
     */
    public ArrayList<Point> reconnaissanceGrille(Grille grille){
        ArrayList<Point> pointsTouches = new ArrayList<>();
        for(int i = 0; i < grille.getRangees(); i++){
            for(int j = 0; j < grille.getColonnes(); j++){
                if(grille.getGrille()[i][j].getStatut() == 2){
                    pointsTouches.add(new Point(i, j));
                }
            }
        }
        return pointsTouches;
    }
    
    /**
     * Genere une liste de points possibles a partir des points touches
     * 
     * @param pointsTouches
     * @return ArrayList<Point>
     */
    public ArrayList<Point> determinerCoupsPossibles(ArrayList<Point> pointsTouches, Grille grille){
        ArrayList<Point> coupsPossibles = new ArrayList<>();
        for(int i = 0; i < pointsTouches.size(); i++){
            //Verification Case du Haut
            if(pointsTouches.get(i).getRangee() -1 > 0 ){
                if(grille.getGrille()[pointsTouches.get(i).getRangee()-1][pointsTouches.get(i).getColonne()].getStatut() != 2){
                    coupsPossibles.add(new Point(pointsTouches.get(i).getRangee() - 1, pointsTouches.get(i).getColonne()));
                }    
            }
            // Verification Case du Bas
            if( pointsTouches.get(i).getRangee() +1 < grille.getRangees()){
                if(grille.getGrille()[pointsTouches.get(i).getRangee()+1][pointsTouches.get(i).getColonne()].getStatut() != 2){
                    coupsPossibles.add(new Point(pointsTouches.get(i).getRangee() + 1, pointsTouches.get(i).getColonne()));
                }
            }
            //Verification Case de Gauche
            if(pointsTouches.get(i).getColonne() -1 > 0){
                if(grille.getGrille()[pointsTouches.get(i).getRangee()][pointsTouches.get(i).getColonne()-1].getStatut() != 2){
                    coupsPossibles.add(new Point(pointsTouches.get(i).getRangee(), pointsTouches.get(i).getColonne() - 1));
                }
            }
            // Verification Case du Droite
            if( pointsTouches.get(i).getColonne() +1 < grille.getColonnes()){
                if(grille.getGrille()[pointsTouches.get(i).getRangee()][pointsTouches.get(i).getColonne()+1].getStatut() != 2){
                    coupsPossibles.add(new Point(pointsTouches.get(i).getRangee(), pointsTouches.get(i).getColonne() + 1));
                }
            }
        }
        
        
        return coupsPossibles;
    }
    
    
    
    
    /**
     * Place les bateaux de l'intelligence artificielle de facon aleatoire
     * 
     * @param grille
     * @param numCases
     * @return Map<Point, Integer>
     */
    public Map<Point, Integer> placerBateau(Grille grille, int numCases){
        Point point = new Point(-1,-1);
        Point nouvPoint;
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
