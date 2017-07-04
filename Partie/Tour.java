/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partie;

import GUI.Case;
import GUI.Grille;

/**
 *
 * @author arnaud
 */
public class Tour {
    
    private int resultat;
    private int joueur;
    private Case action;
    
    // Constructeur par defaut
    public Tour(){
        
    }
    
    // Constructeur par attributs
    public Tour(int resultat, int joueur, Case action){
        this.resultat = resultat;
        this.joueur = joueur;
        this.action = action;
    }
    
    // Methodes de classe
    
    /**
     * Affiche les informations et le résultat du tour

     */
    public void afficherResultat() {
       
    }
    
    /**
     * Applique l'action a la grille entre ne attribut
     * 
     * @param grille 
     */
    public void appliquerTour(Grille grille) {
        
    }
    
    /**
     * Evalue si le joueur venant d'effectuer son tour est gagnant
     * 
     * @param grilleAutreJoueur
     * @return boolean 
     */
    public boolean estGagnant(Grille grilleAutreJoueur){
        return false;
    }
    
    
    // Getters
    public int getResultat() { return resultat; }
    public int getJoueur() { return joueur; }
    public Case getAction() { return action; }
    
    // Setters
    public void setResultat(int resultat) { this.resultat = resultat; }
    public void setJoueur(int joueur) { this.joueur = joueur; }
    public void setAction(Case action) { this.action = action; }
 
}
