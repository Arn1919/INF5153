
package GUI;

public class Case {

  private int statut;
  private int rangee;
  private int colonne;

  // Constructeur par défaut
  public Case(){
  }
  // Constructeur par attributs
  public Case(int statut, int rangee, int colonne){
    this.statut = statut;
    this.rangee = rangee;
    this.colonne = colonne;
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
