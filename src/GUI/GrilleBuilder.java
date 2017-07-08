/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;

import Modeles.Navire;

/**
 *
 * @author arnaud
 */
abstract class GrilleBuilder implements IGrilleBuilder{
    
    private Grille grille;
    
    public GrilleBuilder() {
        grille = new Grille();
    }
    
    @Override
    public Grille build() {
        return grille;
    }
    
    @Override
    public IGrilleBuilder setColonnes(final int colonnes){
        grille.setColonnes(colonnes);
        return this;
    }
    
    @Override
    public IGrilleBuilder setRangees(final int rangees){
        grille.setRangees(rangees);
        return this;
    }
    
    @Override
    public IGrilleBuilder setGrille(final Case[][] uneGrille){
        grille.setGrille(uneGrille);
        return this;
    }
    
    @Override
    public IGrilleBuilder setNavires(final ArrayList<Navire> navires){
        grille.setNavires(navires);
        return this;
    }
}