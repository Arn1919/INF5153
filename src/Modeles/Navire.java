/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modeles;

import GUI.Case;

import java.util.ArrayList;
/**
 *
 * @author arnaud
 */
public class Navire {

  private int etatNavire;
  private ArrayList<Case> cases;
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
  public Navire(int etatNavire, ArrayList<Case> cases, int typeNavire){
    this.etatNavire = etatNavire;
    this.cases = cases;
    this.typeNavire = typeNavire;
  }
  // Methodes de classe
  /**
   * Valide que les cases du Navire sont tous libres et adjacentes
   * 
   * @return boolean
   */
  public boolean casesSontLibresEtAdjacentes(){
      boolean casesSontValides = true;
      for(int i = 0; i < cases.size(); i++){
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
  
  /**
   * Valide si un navire est touche-coule
   * 
   * @return boolean 
   */
  public boolean estToucheCoule(){
      boolean estToucheCoule = true;
        for(int i = 0; i < cases.size(); i++){
            if(cases.get(i).getStatut() != 2){
                estToucheCoule = false;
            }
        }
        return estToucheCoule;
  }
  
  
  
  // Getters
  public int getEtatNavire() { return etatNavire; }
  public ArrayList<Case> getCases() { return cases; }
  public int getTypeNavire() { return typeNavire; }
  // Setters
  public void setEtatNavire(int etatNavire) { this.etatNavire = etatNavire; }
  public void setCases(ArrayList<Case> cases) { this.cases = cases; }
  public void setTypeNavire(int typeNavire) { this.typeNavire = typeNavire; }
}

