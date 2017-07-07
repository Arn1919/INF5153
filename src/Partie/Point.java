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
public class Point {
    
    private int rangee; 
    private int colonne;
    
    // Constructeur par défaut
    public Point (){
        
    }
    
    // Constructeur par attributs complets
    public Point (int rangee, int colonne){
        this.rangee = rangee;
        this.colonne = colonne;
    }
    
    // Constructeur par copie
    public Point (Point unPoint){
        this.rangee = unPoint.getRangee();
        this.colonne = unPoint.getColonne();
    }
    
    // Surdefinitition
    @Override
    public boolean equals(Object objet){
        if ( objet == null) return false;
        if ( objet == this) return true;
        if ( !(objet instanceof Point)) return false;
        Point objetPoint = (Point)objet;
        return this.rangee == objetPoint.rangee && this.colonne == objetPoint.colonne;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.rangee;
        hash = 31 * hash + this.colonne;
        return hash;
    }
    
    // Getters
    public int getRangee(){ return rangee; }
    public int getColonne() { return colonne; }
    // Setters 
    public void setRangee(int rangee) { this.rangee = rangee; }
    public void setColonne(int colonne) { this.colonne = colonne; }
    
}
