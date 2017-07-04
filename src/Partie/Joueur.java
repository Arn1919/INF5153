/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partie;

import GUI.Grille;
import GUI.Case;
import Modeles.Navire;
import IntelligenceArtificielle.AI;

import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public class Joueur {
    
    private String nom;
    private Grille grilleJoueur;
    private Grille grilleEnnemi;
    private AI ai;
    
    // Constructeur par defaut
    public Joueur(){
        
    }   
    // Constructeur par attributs incomplets
    //  -- Pour un joueur humain
    public Joueur(String nom){
        this.nom = nom;
        this.ai = null;
        this.grilleJoueur = new Grille();
        this.grilleEnnemi = new Grille();
    }
    // -- Pour un joueur artificielle
    public Joueur(int niveauIntelligenceArtificielle){
        if(niveauIntelligenceArtificielle == 0){
            this.nom = "Cortana";
        }else{
            this.nom = "Skynet";
        }
        this.ai = new AI(niveauIntelligenceArtificielle);
        this.grilleJoueur = new Grille();
        this.grilleEnnemi = new Grille();
    }
    
    // Constructeur par attributs complets
    public Joueur(String nom, Grille grilleJoueur, Grille grilleEnnemi, AI ai){
        this.nom = nom;
        this.grilleJoueur = grilleJoueur;
        this.grilleEnnemi = grilleEnnemi;
        this.ai = ai;
    }
    
    // Methodes de classe
    /**
     * Retourne la case choisie par l'humain
     * 
     * @return Case
     */
    public Case makeMove(){
        return new Case();
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
    /**
     * Place le bateau dans la grille selon les cases specifiees
     * 
     * @param grilleJoueur
     * @param numBateau
     * @param cases
     */
    public void placerBateau(Grille grilleJoueur, int numBateau, ArrayList<Case> cases){       
        grilleJoueur.getNavires().get(numBateau).setCases(cases);
        for(int i = 0; i < cases.size(); i++){
            grilleJoueur.getGrille()[cases.get(i).getRangee()][cases.get(i).getColonne()].setStatut(1);
        }
    }
    
    // Getters
    public String getNom() { return nom; }
    public Grille getGrilleJoueur() { return grilleJoueur; }
    public Grille getGrilleEnnemi() { return grilleEnnemi; }
    public AI getAI() { return ai; }
    
    // Setters 
    public void setNom() { this.nom = nom; }
    public void setGrilleJoueur() { this.grilleJoueur = grilleJoueur; }
    public void setGrilleEnnemi() { this.grilleEnnemi = grilleEnnemi; }
    public void setAI() { this.ai = ai; }
    
}
