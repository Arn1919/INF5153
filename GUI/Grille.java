package GUI;

import Modeles.Navire;

import java.util.ArrayList;

public class Grille{
    
    private int colonnes;
    private int rangees;
    private Case[][] grille;
    private ArrayList<Navire> navires;
    
    // Constructeur par defaut
    public Grille(){
 
    }
    
    // Constructeur par attributs
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