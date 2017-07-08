/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modeles.Navire;
import java.util.ArrayList;

/**
 *
 * @author arnaud
 */
public interface IGrilleBuilder {
    
    Grille build();
    
    IGrilleBuilder setColonnes(final int colonnes);
    IGrilleBuilder setRangees(final int rangees);
    IGrilleBuilder setGrille(final Case[][] grille);
    IGrilleBuilder setNavires(final ArrayList<Navire> navires);
    
    
}
