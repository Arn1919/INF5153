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
  // Constructeur avec attributs
  public Navire(int etatNavire, ArrayList<Case> cases, int typeNavire){
    this.etatNavire = etatNavire;
    this.cases = cases;
    this.typeNavire = typeNavire;
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

