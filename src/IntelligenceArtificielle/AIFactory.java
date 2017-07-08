/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntelligenceArtificielle;

import java.util.Map;
import GUI.Grille;
import Partie.Point;

/**
 *
 * @author arnaud
 */
public interface AIFactory {
    
    public AI getAI(int niveau);   
    public Map<Point, Integer> placerBateau(Grille grille, int numCases);
    
}
