
package GUI;

import Partie.Point;

public class Case {

  private int statut; // 0:Vide 1:Occupe par bateau 2:Touche 3:Ratee
  private Point point;

  // Constructeur par défaut
  public Case(){
      this.statut = 0;
  }
  
  // Constructeur par attributs incomplets
  public Case(Point point){
      this.statut = 0;
      this.point = point;
  }
  // Constructeur par attributs complets
  public Case(int statut, Point point){
    this.statut = statut;
    this.point = point;
  }
  //Methodes de classes
  /**
   * Valide si la case c1 est adjacente à c2
   * 
   * @param c1
   * @param c2
   * @return boolean  
   */
  public boolean sontAdjacentes(Case c2){
      boolean verite = false;
      // Si c1 et c2 sont sur la meme rangee
      if(this.point.getRangee() == c2.getPoint().getRangee() ){
          if( this.point.getColonne() == c2.getPoint().getColonne()-1 
                  || this.getPoint().getColonne() == c2.getPoint().getColonne()+1){
              verite = true;
          }
      // Si c1 et c2 ne sont pas sur la meme rangee
      }else if(this.getPoint().getRangee() == c2.getPoint().getRangee()-1
                  || this.getPoint().getRangee() == c2.getPoint().getRangee()+1){
          if( this.getPoint().getColonne() == c2.getPoint().getColonne()){
              verite = true;
          }
      }      
      return verite;
  }
  
  public boolean estIdentiquementSituee(Case autreCase){
      if(this.getPoint().getRangee() == autreCase.getPoint().getRangee() 
              && this.getPoint().getColonne() == autreCase.getPoint().getColonne()){
          return true;
      }else{
          return false;
      }
  }
  
  // Getters
  public int getStatut() { return statut; }
  public Point getPoint() { return point; }
  // Setters
  public void setStatut(int statut) { this.statut = statut; }
  public void setPoint(Point point) { this.point = point; }

}
