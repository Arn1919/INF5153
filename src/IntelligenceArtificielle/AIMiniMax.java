/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntelligenceArtificielle;

import GUI.Grille;
import Partie.Point;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author arnaud
 */
public class AIMiniMax extends AI {
    
    
    // Constructeur par defaut
    public AIMiniMax(){
        
    }
    
    
        /**
     * Choisit une case non-choisit de la grille en attribut selon l'algorithme mini-max
     * 
     * @param grille
     * @return Case
     */
    public Point makeMiniMaxMove(Grille grille) {
        ArrayList<Point> pointsTouches;
        ArrayList<Point> coupsPossibles;
        // 1. Reconnaissance
        pointsTouches = reconnaissanceGrille(grille);
        // 2. Coups possibles 
        coupsPossibles = determinerCoupsPossibles(pointsTouches, grille);
        // 3. Effectue un choix aleatoire
        if(coupsPossibles.size() > 0){
            return coupsPossibles.get(ThreadLocalRandom.current().nextInt(0, coupsPossibles.size()));
        }else{
            return new Point( ThreadLocalRandom.current().nextInt(0, grille.getRangees()), ThreadLocalRandom.current().nextInt(0, grille.getColonnes()));
        }
    }
    
        // Methodes de classes
    
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
    
}
