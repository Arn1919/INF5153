/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntelligenceArtificielle;

import GUI.Grille;
import Partie.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author arnaud
 */
public class AI implements AIFactory {
    
    /**
     * Definit le type d'AI selon le parametre niveau
     * 
     * @param niveau
     * @return instance AIAleatoire ou AIMiniMax
     */
    @Override
    public AI getAI(int niveau) {
        switch (niveau) {
            case 0 : 
                return new AIAleatoire();
            case 1 : 
                return new AIMiniMax();
            default :
                throw new IllegalArgumentException("Difficulte inconnue");
        }
    }
    
        /**
     * Place les bateaux de l'intelligence artificielle de facon aleatoire
     * 
     * @param grille
     * @param numCases
     * @return Map<Point, Integer>
     */
    @Override
    public Map<Point, Integer> placerBateau(Grille grille, int numCases){
        Point point = new Point(-1,-1);
        Point nouvPoint;
        Map<Point, Integer> pointsBateau = new HashMap<>() ;
        
        // Determine dans quel sens seront les cases suivants la case aleatoire initiale
        int directionBateau = -1; // 0: haut, 1:droite, 2:bas, 3: gauche
        
        for(int i = 0; i < numCases; i++){
            if(i == 0 ){ // Premiere case est une case aleatoire
                int x = ThreadLocalRandom.current().nextInt(0, grille.getRangees());
                int y = ThreadLocalRandom.current().nextInt(0, grille.getColonnes());
                point = new Point(x, y);
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
    
}
