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
    private Point action;
    
    // Constructeur par defaut
    public Tour(){
        
    }
    
    // Constructeur par attributs incomplets
    public Tour(int joueur, Point action){
        this.joueur = joueur;
        this.action = action;
        this.resultat = -1;
    }
    
    // Constructeur par attributs complets
    public Tour(int resultat, int joueur, Point action){
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
     * @param grilleAdversaire
     * @param grilleEssai 
     */
    public void appliquerTour(Grille grilleAdversaire, Grille grilleEssai) {
        
       // MAJ GrilleEssai
       
       int statutCase = grilleAdversaire.getGrille()[action.getRangee()][action.getColonne()].getStatut();
       //System.out.println("TEST: ADAVDVAD");
       if( statutCase == 1 ){ // La case est occupee par un bateau, non touchee
            // MAJ Statut de la Case de la Grille
            grilleAdversaire.getGrille()[action.getRangee()][action.getColonne()].setStatut(2); // Grille Adversaire
            grilleEssai.getGrille()[action.getRangee()][action.getColonne()].setStatut(2); // Grille Essaie du joueur
            for(int i = 0; i < grilleAdversaire.getNavires().size(); i++){   
                    //System.out.println("TEST: " + grilleAdversaire.getNavires().get(i).getPointsGrille().containsKey(action));
                    if(grilleAdversaire.getNavires().get(i).getPointsGrille().containsKey(action)){
                        // MAJ Statut de la Case du Navire
                        grilleAdversaire.getNavires().get(i).getPointsGrille().replace(action, 2); 
                        if(grilleAdversaire.getNavires().get(i).estToucheCoule()){
                            grilleAdversaire.getNavires().get(i).setEtatNavire(1); // Le navire est coule
                            resultat = 2; // C'est un touche-coule
                        }else{
                            resultat = 1;
                        }
                    }
                
            }                        
       }else if ( statutCase == 0 ){ // La case est vide
            // MAJ Statut de la Case
            grilleAdversaire.getGrille()[action.getRangee()][action.getColonne()].setStatut(3); // Grille de l'adversaire
            grilleEssai.getGrille()[action.getRangee()][action.getColonne()].setStatut(3);     // Grille d'essai du joueur
            resultat = 0;
       }
    }    
    
    // Getters
    public int getResultat() { return resultat; }
    public int getJoueur() { return joueur; }
    public Point getAction() { return action; }
    
    // Setters
    public void setResultat(int resultat) { this.resultat = resultat; }
    public void setJoueur(int joueur) { this.joueur = joueur; }
    public void setAction(Point action) { this.action = action; }
 
}
