/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.Grille.NUM_COLONNES;
import static GUI.Grille.NUM_RANGEES;
import Modeles.Navire;
import Partie.Point;

import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public class GrilleBuildDirector  {
    
    private final IGrilleBuilder builder;
    
    public GrilleBuildDirector(final IGrilleBuilder builder){
        this.builder = builder;
    }
    
    public Grille constructGrilleJoueur(){
        // Initialisation de la grille
        Case[][] grilleJoueur = new Case[NUM_RANGEES][NUM_COLONNES];
        for(int i = 0; i < NUM_RANGEES; i++){
            for(int j = 0; j < NUM_COLONNES; j++){
                grilleJoueur[i][j] = new Case(new Point(i, j));
            }
        }
        // Initialisation des navires
        ArrayList<Navire> listeNavires = new ArrayList<>();
        listeNavires.add(new Navire(0, 2));
        listeNavires.add(new Navire(0, 3));
        listeNavires.add(new Navire(0, 3));
        listeNavires.add(new Navire(0, 4));
        listeNavires.add(new Navire(0, 5));
        
        builder.setRangees(NUM_RANGEES);
        builder.setColonnes(NUM_COLONNES);
        builder.setGrille(grilleJoueur);
        builder.setNavires(listeNavires);
        return (Grille) builder;
    }
    
    public Grille constructGrilleEssai(){
        // Initialisation de la grille
        Case[][] grilleEssai = new Case[NUM_RANGEES][NUM_COLONNES];
        for(int i = 0; i < NUM_RANGEES; i++){
            for(int j = 0; j < NUM_COLONNES; j++){
                grilleEssai[i][j] = new Case(new Point(i, j));
            }
        }
        builder.setRangees(NUM_RANGEES);
        builder.setColonnes(NUM_COLONNES);
        builder.setGrille(grilleEssai);
        builder.setNavires(null);
        return (Grille) builder;
    }
    
}
