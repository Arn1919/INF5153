/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partie;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author arnaud
 */
public class Partie {
    
    private int etat; // O: En cours 1: Termine
    private long tempsPartie;
    private ArrayList<Tour> historique;
    private Joueur j1; // Human
    private Joueur j2; // AI
    
    // Constructeur par defaut
    public Partie() {
        this.etat = 0;
        this.tempsPartie = 0;
        this.historique = new ArrayList<>();
        this.j1 = new Joueur("LORDPET");
        this.j2 = new Joueur(0);
    }
    
    // Constructeur par attributs
    public Partie(String nom, int niveau) {
        this.etat = 0;
        this.tempsPartie = 0;
        this.historique = new ArrayList<>();
        this.j1 = new Joueur(nom);
        this.j2 = new Joueur(niveau);
    }
    
    public Partie(int etat, long tempsPartie, ArrayList<Tour> historique, Joueur j1, Joueur j2){
        this.etat = etat;
        this.tempsPartie = tempsPartie;
        this.historique = historique;
        this.j1 = j1;
        this.j2 = j2;
    }
    
    // Methodes de classe
    
    /**
     * Places les bateaux du joueur humain et du joueur artificiel
     */
    public void preparationPartie(){
        // J1 - Place ses bateaux
        
        // J2 - Place ses bateaux
        j2.placerBateau(0, j2.getAI().placerBateau(j2.getGrilleJoueur(), 2));
        j2.placerBateau(1, j2.getAI().placerBateau(j2.getGrilleJoueur(), 3));
        j2.placerBateau(2, j2.getAI().placerBateau(j2.getGrilleJoueur(), 3));
        j2.placerBateau(3, j2.getAI().placerBateau(j2.getGrilleJoueur(), 4));
        j2.placerBateau(4, j2.getAI().placerBateau(j2.getGrilleJoueur(), 5));
    }
    
    /**
     * La partie commence:
     *  -Le premier joueur a jouer est choisi au hasard
     */
    public void jouerPartie(){   
        tempsPartie = System.currentTimeMillis();
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
        
        // *** FIN DE PARTIE *** 
        // CALCUL DU TEMPS
        long tempsPartieFin = System.currentTimeMillis();
        long secondes = (tempsPartieFin - tempsPartie)/1000; // Le Temps de la partie en secondes
        long minutes = 0;
        long heures = 0;
        // Duree de Plus d'une minute
        if(secondes%60 > 0){
            minutes = secondes/60;      // Nombre de minutes
            secondes %= 60;             // Secondes restantes
            
        }
        // Duree de Plus d'une heure
        if(minutes%60 > 0){
            heures = minutes/60;
            minutes %= 60;
        }
    }  
    
    /**
     * Evalue si la partie est terminee
     * 
     * @return boolean
     */
    public boolean partieEstTerminee(){
        if(j1.estGagnant(j2.getGrilleJoueur())){
           etat = 1;
        }
        if(j2.estGagnant(j1.getGrilleJoueur())){
           etat = 1;
        }
        return etat == 1;
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
    public long getTempsPartie() { return tempsPartie; }
    public ArrayList<Tour> getHistorique() { return historique; }
    public Joueur getJ1() { return j1; }
    public Joueur getJ2() { return j2; }
    
    // Setters
    public void setEtat(int etat) { this.etat = etat; }
    public void setTempsPartie(long tempsPartie) { this.tempsPartie = tempsPartie; }
    public void setHistorique(ArrayList<Tour> historique) { this.historique = historique; }
    public void setJ1(Joueur j1) { this.j1 = j1; }
    public void setJ2(Joueur j2) { this.j2 = j2; }
    
}
    
        
    

