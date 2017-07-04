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
    
    private int resultat; // 0:Le coup a rater 1:Le coup a touche 2:Le coup a touche-coule
    private int joueur;
    private Case action;
    
    // Constructeur par defaut
    public Tour(){
        
    }
    
    // Constructeur par attributs incomplets
    public Tour(int joueur, Case action){
        this.joueur = joueur;
        this.action = action;
    }
    
    // Constructeur par attributs complets
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
     * Applique l'action a la grille entre en attribut
     * 
     * @param grille 
     */
    public void appliquerTour(Grille grille) {
       
       int statutCase = grille.getGrille()[action.getRangee()][action.getColonne()].getStatut();
       
       if( statutCase == 1 ){ // La case est occupee par un bateau, non touchee
            grille.getGrille()[action.getRangee()][action.getColonne()].setStatut(2); // MAJ Statut Case de Grille
            for(int i = 0; i < grille.getNavires().size(); i++){
                for(int j = 0; j < grille.getNavires().get(i).getCases().size(); j++){
                    if(action.estIdentiquementSituee(grille.getNavires().get(i).getCases().get(j))){
                        grille.getNavires().get(i).getCases().get(j).setStatut(2); // MAJ Statut Case du Navire
                        if(grille.getNavires().get(i).estToucheCoule()){
                            resultat = 2;
                        }else{
                            resultat = 1;
                        }
                    }
                }
            }                        
       }else if ( statutCase == 0 ){ // La case est vide
            grille.getGrille()[action.getRangee()][action.getColonne()].setStatut(3); // MAJ Statut Case de Grille 
            resultat = 0;
       }
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
