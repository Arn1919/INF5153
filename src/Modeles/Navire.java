/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import Partie.Point;
import GUI.Case;

import java.util.Map;
/**
 *
 * @author arnaud
 */
public class Navire {

  private int etatNavire; // 0: En etat 1:Coule
  private Map<Point, Integer> pointsGrille;
  private int typeNavire;

  // Constructeur par défaut
  public Navire(){
  }
  
  // Constructeur avec attributs incomplets
  public Navire(int etatNavire, int typeNavire){
      this.etatNavire = etatNavire;
      this.typeNavire = typeNavire;
  }
  
  // Constructeur avec attributs complets
  public Navire(int etatNavire, Map<Point, Integer> pointsGrille, int typeNavire){
    this.etatNavire = etatNavire;
    this.pointsGrille = pointsGrille;
    this.typeNavire = typeNavire;
  }
  
  // Methodes de classe
  /**
   * Valide que les cases du Navire sont tous libres et adjacentes
   * 
   * @return boolean
   */
  /**
  public boolean casesSontLibresEtAdjacentes(){
      boolean casesSontValides = true;
      for(int i = 0; i < .size(); i++){
        // Est-ce que la case est libre?
        if(cases.get(i).getStatut() != 0){
            casesSontValides = false;
        }
        // Est-ce que la case actuelle et la case suivante sont adjacentes?
        if(i+1 != cases.size()){
            if(!(cases.get(i).sontAdjacentes(cases.get(i+1)))){
               casesSontValides = false;     
            }
        }                       
      }
      return casesSontValides;
  }
  */
  
  /**
   * Valide si un navire est touche-coule
   * 
   * @return boolean 
   */
  public boolean estToucheCoule(){      
      return !(pointsGrille.containsValue(1));
  }
  
  public boolean estUneCaseDuNavire(Case uneCase){
      Point pointCase = new Point(uneCase.getPoint());
      return pointsGrille.containsKey(pointCase);
  }
  
  
  
  // Getters
  public int getEtatNavire() { return etatNavire; }
  public Map<Point, Integer> getPointsGrille() { return pointsGrille; }
  public int getTypeNavire() { return typeNavire; }
  // Setters
  public void setEtatNavire(int etatNavire) { this.etatNavire = etatNavire; }
  public void setPointsGrille(Map<Point, Integer> pointsGrille) { this.pointsGrille = pointsGrille; }
  public void setTypeNavire(int typeNavire) { this.typeNavire = typeNavire; }
}

