/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partie;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import GUI.Case;

/**
 *
 * @author arnaud
 */
public class Partie {
    
    private int etat; // O: En cours 1: Termine
    private double tempsPartie;
    private ArrayList<Tour> historique;
    private Joueur j1; // Human
    private Joueur j2; // AI
    
    // Constructeur par defaut
    public Partie() {
        this.etat = 0;
        this.tempsPartie = 0.0;
        this.historique = new ArrayList<Tour>();
        this.j1 = new Joueur("LORDPET");
        this.j2 = new Joueur(0);
    }
    
    // Constructeur par attributs
    public Partie(int etat, double tempsPartie, ArrayList<Tour> historique, Joueur j1, Joueur j2){
        this.etat = etat;
        this.tempsPartie = tempsPartie;
        this.historique = historique;
        this.j1 = j1;
        this.j2 = j2;
    }
    
    // Methodes de classe
    
    /**
     * Permet de lancer les deux phases de la partie
     *  -Phase 1: Placer les bateaux
     *  -Phase 2: Debuter la partie
     */
    public void initPartie(){
        preparationPartie();
        jouerPartie();
    }
    
    /**
     * Places les bateaux du joueur humain et du joueur artificiel
     */
    public void preparationPartie(){
        // J1 - Place ses bateaux
        
        // J2 - Place ses bateaux
        ArrayList<Case> casesNavire0 = j2.getAI().placerBateau(j2.getGrilleJoueur(), 2);
        j2.placerBateau(j2.getGrilleJoueur(), 0, casesNavire0);
        ArrayList<Case> casesNavire1 = j2.getAI().placerBateau(j2.getGrilleJoueur(), 3);
        j2.placerBateau(j2.getGrilleJoueur(), 1, casesNavire1);
        ArrayList<Case> casesNavire2 = j2.getAI().placerBateau(j2.getGrilleJoueur(), 3);
        j2.placerBateau(j2.getGrilleJoueur(), 2, casesNavire2);
        ArrayList<Case> casesNavire3 = j2.getAI().placerBateau(j2.getGrilleJoueur(), 4);
        j2.placerBateau(j2.getGrilleJoueur(), 3, casesNavire3);
        ArrayList<Case> casesNavire4 = j2.getAI().placerBateau(j2.getGrilleJoueur(), 5);
        j2.placerBateau(j2.getGrilleJoueur(), 4, casesNavire4);
    }
    
    /**
     * La partie commence:
     *  -Le premier joueur a jouer est choisi au hasard
     */
    public void jouerPartie(){        
        Tour tour;
        int joueurAJouer = ThreadLocalRandom.current().nextInt(0, 2);  // choisit joueur a commencer de facon aleatoire
        
        while(partieEstTerminee()){ // Tant que partie n'est pas terminer
           // Le joueur a jouer effectue son tour
            if(joueurAJouer == 0){
               tour = new Tour(joueurAJouer, j1.makeMove());
           }else{
               tour = new Tour(joueurAJouer, j2.getAI().makeMove());
           } 
           // Historique 
           historique.add(tour);
           // Alterne le joueur a jouer
           joueurAJouer++;
           joueurAJouer%=2;
        }
    }  
    
    /**
     * Evalue si la partie est terminee
     */
    public boolean partieEstTerminee(){
        if(j1.estGagnant(j2.getGrilleJoueur())){
           etat = 1;
        }
        if(j2.estGagnant(j1.getGrilleJoueur())){
           etat = 1;
        }
        if(etat == 1){
            return true;
        } else {
            return false;
        }
    }
    
    
    /**
     * Calcule puis retourne le temps de la partie en secondes
     * 
     * @return double 
     */
    public double calculerTempsPartie(){
        return 0.0;
    }
    
    /**
     * Permet de visualiser la partie tour par tour selon l'historique
     */
    public void visualiserPartie(){
        
    }
    
    
    // Getters
    public int getEtat() { return etat; }
    public double getTempsPartie() { return tempsPartie; }
    public ArrayList<Tour> getHistorique() { return historique; }
    public Joueur getJ1() { return j1; }
    public Joueur getJ2() { return j2; }
    
    // Setters
    public void setEtat(int etat) { this.etat = etat; }
    public void setTempsPartie(double tempsPartie) { this.tempsPartie = tempsPartie; }
    public void setHistorique(ArrayList<Tour> historique) { this.historique = historique; }
    public void setJ1(Joueur j1) { this.j1 = j1; }
    public void setJ2(Joueur j2) { this.j2 = j2; }
    
}
    
        
    

