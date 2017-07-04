/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partie;

import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public class Partie {
    
    private int etat;
    private double tempsPartie;
    private ArrayList<Tour> historique;
    private Joueur j1;
    private Joueur j2;
    
    // Constructeur par defaut
    public Partie() {
        
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
     * Permet d'initialiser les parametres d'une partie
     */
    public void initPartie(){
        
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
    
        
    

