package GUI;

import Modeles.Navire;
import Partie.Point;

import java.util.ArrayList;

public class Grille{
    
    public static final int NUM_COLONNES = 10;
    public static final int NUM_RANGEES = 10;
    
    private int colonnes;
    private int rangees;
    private Case[][] grille;
    private ArrayList<Navire> navires;
    
    // Constructeur par defaut
    public Grille(){    
 
    }
    
    // Constructeur par attributs incomplets
    public Grille( int colonnes, int rangees){
        this.colonnes = colonnes;
        this.rangees = rangees;
        this.grille = new Case[rangees][colonnes];
        for(int i = 0; i < rangees; i++){
            for(int j = 0; j < colonnes; j++){
                this.grille[i][j] = new Case(new Point(i, j));
            }
        }
    }
          
    
    // Constructeur par attributs complets
    public Grille( int colonnes, int rangees, Case[][] grille, ArrayList<Navire> navires){
        this.colonnes = colonnes;
        this.rangees = rangees;
        this.grille = grille;
        this.navires = navires;
    }
    
    // Getters
    public int getColonnes() { return colonnes; }
    public int getRangees() { return rangees; }
    public Case[][] getGrille() { return grille; }
    public ArrayList<Navire> getNavires() { return navires; }
    // Setters
    public void setColonnes(int colonnes) { this.colonnes = colonnes; }
    public void setRangees(int rangees) { this.rangees = rangees; }
    public void setGrille(Case[][] grille) { this.grille = grille; }
    public void setNavires(ArrayList<Navire> navires) { this.navires = navires; }
    
}