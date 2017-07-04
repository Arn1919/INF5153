
package GUI;

public class Case {

  private int statut; // 0:Vide 1:Occupe par bateau 2:Touche 3:Ratee
  private int rangee;
  private int colonne;

  // Constructeur par défaut
  public Case(){
      this.statut = 0;
  }
  
  // Constructeur par attributs incomplets
  public Case(int rangee, int colonne){
      this.statut = 0;
      this.rangee = rangee;
      this.colonne = colonne;
  }
  // Constructeur par attributs complets
  public Case(int statut, int rangee, int colonne){
    this.statut = statut;
    this.rangee = rangee;
    this.colonne = colonne;
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
      if(this.rangee == c2.getRangee() ){
          if( this.colonne == c2.getColonne()-1 || this.colonne == c2.getColonne()+1){
              verite = true;
          }
      // Si c1 et c2 ne sont pas sur la meme rangee
      }else if(this.rangee == c2.getRangee()-1 || this.rangee == c2.getRangee()+1){
          if( this.colonne == c2.getColonne()){
              verite = true;
          }
      }      
      return verite;
  }
  
  public boolean estIdentiquementSituee(Case autreCase){
      if(this.rangee == autreCase.getRangee() && this.colonne == autreCase.getColonne()){
          return true;
      }else{
          return false;
      }
  }
  
  // Getters
  public int getStatut() { return statut; }
  public int getRangee() { return rangee; }
  public int getColonne() { return colonne; }
  // Setters
  public void setStatut(int statut) { this.statut = statut; }
  public void setRangee(int rangee) { this.rangee = rangee; }
  public void setColonne(int colonne) { this.colonne = colonne; }

}
