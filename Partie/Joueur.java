/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partie;

import GUI.Grille;
import GUI.Case;
import Modeles.Navire;

import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public class Joueur {
    
    private String nom;
    private Grille grilleJoueur;
    
    // Constructeur par defaut
    public Joueur(){
        
    }
    
    // Constructeur par attributs
    public Joueur(String nom, Grille grilleJoueur){
        this.nom = nom;
        this.grilleJoueur = grilleJoueur;
    }
    
    // Methodes de classe

    /**
     * Le joueur humain effectue son tour et retourne la case choisie
     * 
     * @param grilleAutreJoueur
     * @return Case
     */
    public Case makeMoveHuman(Grille grilleAutreJoueur){
        return new Case();
    }
    
    /**
     * L'intelligence artificielle effectue son tour et retourne la case choisie
     * 
     * @param grilleAutreJoueur
     * @return Case 
     */
    public Case makeMoveAI(Grille grilleAutreJoueur){
        return new Case();
    }
    
    /**
     * Place le bateau dans la grille selon les cases specifiees
     * 
     * @param grilleJoueur
     * @param navire 
     * @param cases
     */
    public void placerBateau(Grille grilleJoueur, Navire navire, ArrayList<Case> cases){
        
    }
    
    // Getters
    public String getNom() { return nom; }
    public Grille getGrilleJoueur() { return grilleJoueur; }
    
    // Setters 
    public void setNom() { this.nom = nom; }
    public void setGrilleJoueur() { this.grilleJoueur = grilleJoueur; }
    
}
