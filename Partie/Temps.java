/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Partie;

/**
 *
 * @author arnaud
 */
public class Temps {
    
    private int niveauDifficulte;
    private double temps; 
    private String nomJoueur;
    
    // Constructeur par defaut
    public Temps() {
        
    }
    
    // Constructeur par attributs
    public Temps(int niveauDifficulte, double temps, String nomJoueur){
        this.niveauDifficulte = niveauDifficulte;
        this.temps = temps;
        this.nomJoueur = nomJoueur;
    }
    
    // Getters
    public int getNiveauDifficulte() { return niveauDifficulte;}
    public double getTemps() { return temps; }
    public String getNomJoueur() { return nomJoueur; }
    
    // Setters
    public void setNiveauDifficulte(int niveauDifficulte) { this.niveauDifficulte = niveauDifficulte; }
    public void setTemps(double temps) { this.temps = temps; }
    public void setNomJoueur(String nomJoueur) { this.nomJoueur = nomJoueur; }
    
}
