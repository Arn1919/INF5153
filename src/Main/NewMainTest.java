/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.*;
import IntelligenceArtificielle.*;
import Modeles.*;
import Partie.*;

import java.util.ArrayList;
/**
 *
 * @author arnaud
 */
public class NewMainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        testGrille();
        testCase();
        testAI();
        testPartie();
        testNavire();
        testTour();
    }
    
    /**
     *
     */
    public static void testGrille(){
        
        System.out.println("\n------------TEST GRILLE---------------\n");
        Grille test = new Grille();
        // Test TypeNavire
        if(test.getNavires().get(0).getTypeNavire() == 2){
            System.out.println("Test TypeNavire : REUSSI");
        }else{
            System.out.println("Test TypeNavire : ECHEC");
        }
        
        // Test Case de la Grille
        if(test.getColonnes() == 10) {
            System.out.println("Test Colonnes Grille: REUSSI");
        }else{
            System.out.println("Test Colonnes Grille: ECHEC");
        }
        
        // Test Rangees
        if(test.getRangees() == 10) {
            System.out.println("Test Rangees Grille: REUSSI");
        }else{
            System.out.println("Test Rangees Grille: ECHEC");
        }
        
        // Test Grille Complete
        System.out.println("Test Grille Complete:");
        for(int i = 0; i < test.getRangees(); i++){
            for(int j = 0; j < test.getColonnes(); j++){
                System.out.println("Case: R" + i + " C" + j);
            }
        }
    }
    
   public static void testAI(){
       
       System.out.println("\n------------TEST AI---------------\n");
       // FACILE
       AI testFacile = new AI(0);
       // Test Case 1
       Grille grilleCase1 = new Grille();
       if(testFacile.makeMove(grilleCase1).getStatut() == 0){
            System.out.println("Test Case 1 : REUSSI");
       }else{
            System.out.println("Test Case 1 : ECHEC");
       }
       // Test Case 2
       Grille grilleCase2 = new Grille(2,2);
       grilleCase2.getGrille()[0][0].setStatut(1);
       grilleCase2.getGrille()[1][0].setStatut(0);
       grilleCase2.getGrille()[0][1].setStatut(1);
       grilleCase2.getGrille()[1][1].setStatut(1);
       
       Case caseRandomAI = testFacile.makeMove(grilleCase2);
       
       if(caseRandomAI.getStatut() == 0){
           if(caseRandomAI.getRangee() == 1 
                   && caseRandomAI.getColonne() == 0){
               System.out.println("Test Case 2 : REUSSI");
           }else{
               System.out.println("Test Case 2 : ECHEC");
           }
       }else{
           System.out.println("Test Case 2 : ECHEC");
       } 
       
       // Test Placer Bateau AI - Preparation de grille test
       Grille grilleBateauTest = new Grille(5,5);
       System.out.println("Affichage grilleBateauTest: ");
       for (int i = 0; i < 5; i++){
           for( int j = 0; j < 5; j++){
               if( i == 1 && j == 2){
                   grilleBateauTest.getGrille()[i][j].setStatut(1);
               }
               if( (i == 2 && j == 0) || (i == 2 && j == 1) || (i == 2 && j == 2) ){
                   grilleBateauTest.getGrille()[i][j].setStatut(1);
               }
               if(i == 4 ){
                   grilleBateauTest.getGrille()[i][j].setStatut(1);
               }   
            System.out.print(grilleBateauTest.getGrille()[i][j].getStatut());
            if( j != 4 ){
                System.out.print(" ");
            }else{
                System.out.println("");
            }
           }
       }
       // Test Placer Bateau AI - Test 2 Cases
       ArrayList<Case> test2Cases = testFacile.placerBateau(grilleBateauTest, 2);
       System.out.println("Test Navire de deux Cases");
       for(int k = 0; k < test2Cases.size(); k++){
           System.out.println("Case: R" + test2Cases.get(k).getRangee() + " C" + test2Cases.get(k).getColonne() );
       }
       // Test Placer Bateau AI - Test 3 Cases
       ArrayList<Case> test3Cases = testFacile.placerBateau(grilleBateauTest, 3);
       System.out.println("Test Navire de trois Cases");
       for(int l = 0; l < test3Cases.size(); l++){
           System.out.println("Case: R" + test3Cases.get(l).getRangee() + " C" + test3Cases.get(l).getColonne() );
       }
       // Test Placer Bateau AI - Test 4 Cases
       ArrayList<Case> test4Cases = testFacile.placerBateau(grilleBateauTest, 4);
       System.out.println("Test Navire de quatre Cases");
       for(int m = 0; m < test4Cases.size(); m++){
           System.out.println("Case: R" + test4Cases.get(m).getRangee() + " C" + test4Cases.get(m).getColonne() );
       }
       // Test Placer Bateau AI - Test 5 Cases
       ArrayList<Case> test5Cases = testFacile.placerBateau(grilleBateauTest, 5);
       System.out.println("Test Navire de cinq Cases");
       for(int n = 0; n < test5Cases.size(); n++){
           System.out.println("Case: R" + test5Cases.get(n).getRangee() + " C" + test5Cases.get(n).getColonne() );
       }
       
   }
   
   public static void testCase(){
       
       System.out.println("\n------------TEST CASE---------------\n");
       // Test Adjacence 1
       Grille grilleTest = new Grille(4,4);
       if(grilleTest.getGrille()[0][0].sontAdjacentes(grilleTest.getGrille()[0][1]) == true){
           System.out.println("Test Adjacence 1 : REUSSI");
       }else{
           System.out.println("Test Adjacence 1 : ECHEC");
       }
       // Test Adjacence 2
       if(grilleTest.getGrille()[0][0].sontAdjacentes(grilleTest.getGrille()[1][1]) == false){
           System.out.println("Test Adjacence 2 : REUSSI");
       }else{
           System.out.println("Test Adjacence 2 : ECHEC");
       }
       // Test Adjacence 3
       if(grilleTest.getGrille()[0][0].sontAdjacentes(grilleTest.getGrille()[1][0]) == true){
           System.out.println("Test Adjacence 3 : REUSSI");
       }else{
           System.out.println("Test Adjacence 3 : ECHEC");
       }
       // Test Adjacence 4
       if(grilleTest.getGrille()[0][0].sontAdjacentes(grilleTest.getGrille()[0][0]) == false){
           System.out.println("Test Adjacence 4 : REUSSI");
       }else{
           System.out.println("Test Adjacence 4 : ECHEC");
       }
       // Test Adjacence 5
       if(grilleTest.getGrille()[0][0].sontAdjacentes(grilleTest.getGrille()[0][3]) == false){
           System.out.println("Test Adjacence 5 : REUSSI");
       }else{
           System.out.println("Test Adjacence 5 : ECHEC");
       }
   }
   
   public static void testPartie(){
       
      System.out.println("\n------------TEST PARTIE---------------\n"); 
      Partie test = new Partie();
      // Test Preparation Partie
      test.preparationPartie();
      System.out.println("Premier Navire");
      for(int i = 0; i < test.getJ2().getGrilleJoueur().getNavires().get(0).getCases().size(); i++){
          System.out.println("Case: R"
                  + test.getJ2().getGrilleJoueur().getNavires().get(0).getCases().get(i).getRangee()
                  + " C"
                  + test.getJ2().getGrilleJoueur().getNavires().get(0).getCases().get(i).getColonne()
          );
      }
      System.out.println("Deuxieme Navire");
      for(int i = 0; i < test.getJ2().getGrilleJoueur().getNavires().get(1).getCases().size(); i++){
          System.out.println("Case: R"
                  + test.getJ2().getGrilleJoueur().getNavires().get(1).getCases().get(i).getRangee()
                  + " C"
                  + test.getJ2().getGrilleJoueur().getNavires().get(1).getCases().get(i).getColonne()
          );
      }
      System.out.println("Troisieme Navire");
      for(int i = 0; i < test.getJ2().getGrilleJoueur().getNavires().get(2).getCases().size(); i++){
          System.out.println("Case: R"
                  + test.getJ2().getGrilleJoueur().getNavires().get(2).getCases().get(i).getRangee()
                  + " C"
                  + test.getJ2().getGrilleJoueur().getNavires().get(2).getCases().get(i).getColonne()
          );
      }
      System.out.println("Quatrieme Navire");
      for(int i = 0; i < test.getJ2().getGrilleJoueur().getNavires().get(3).getCases().size(); i++){
          System.out.println("Case: R"
                  + test.getJ2().getGrilleJoueur().getNavires().get(3).getCases().get(i).getRangee()
                  + " C"
                  + test.getJ2().getGrilleJoueur().getNavires().get(3).getCases().get(i).getColonne()
          );
      }
      System.out.println("Cinquieme Navire");
      for(int i = 0; i < test.getJ2().getGrilleJoueur().getNavires().get(4).getCases().size(); i++){
          System.out.println("Case: R"
                  + test.getJ2().getGrilleJoueur().getNavires().get(4).getCases().get(i).getRangee()
                  + " C"
                  + test.getJ2().getGrilleJoueur().getNavires().get(4).getCases().get(i).getColonne()
          );
        }
    }
   
    public static void testNavire(){
       
       System.out.println("\n------------TEST NAVIRE---------------\n"); 
       // Test Fonction estToucheCoule() - Preparation
       Grille grille = new Grille();
       grille.getNavires().add(new Navire(0, 2));
       grille.getNavires().add(new Navire(0, 3));
       grille.getNavires().add(new Navire(0, 3));
       grille.getNavires().add(new Navire(0, 4));
       grille.getNavires().add(new Navire(0, 5));     
       ArrayList<Case> cases1 = new ArrayList<Case>();
       ArrayList<Case> cases2 = new ArrayList<Case>();
       ArrayList<Case> cases3 = new ArrayList<Case>();
       ArrayList<Case> cases4 = new ArrayList<Case>();
       ArrayList<Case> cases5 = new ArrayList<Case>();
       cases1.add(new Case(2, 0, 0));
       cases1.add(new Case(2, 0, 1));
       cases2.add(new Case(2, 1, 0));
       cases2.add(new Case(2, 1, 1));
       cases2.add(new Case(2, 1, 2));
       cases3.add(new Case(2, 2, 0));
       cases3.add(new Case(2, 2, 1));
       cases3.add(new Case(2, 2, 2));
       cases4.add(new Case(2, 3, 0));
       cases4.add(new Case(2, 3, 1));
       cases4.add(new Case(2, 3, 2));
       cases4.add(new Case(2, 3, 3));
       cases5.add(new Case(2, 4, 0));
       cases5.add(new Case(2, 4, 1));
       cases5.add(new Case(2, 4, 2));
       cases5.add(new Case(2, 4, 3));
       cases5.add(new Case(2, 4, 4));
       grille.getNavires().get(0).setCases(cases1);
       grille.getNavires().get(1).setCases(cases2);
       grille.getNavires().get(2).setCases(cases3);
       grille.getNavires().get(3).setCases(cases4);
       grille.getNavires().get(4).setCases(cases5);
       // Test estToucheCoule() 1
       if(grille.getNavires().get(0).estToucheCoule()){
            System.out.println("Test estToucheCoule() 1 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 1  : ECHEC");
       }
       // Test estToucheCoule() 2
       if(grille.getNavires().get(1).estToucheCoule()){
            System.out.println("Test estToucheCoule() 2 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 2  : ECHEC");
       }
       // Test estToucheCoule() 3
       if(grille.getNavires().get(2).estToucheCoule()){
            System.out.println("Test estToucheCoule() 3 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 3  : ECHEC");
       }
       // Test estToucheCoule() 4
       if(grille.getNavires().get(3).estToucheCoule()){
            System.out.println("Test estToucheCoule() 4 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 4  : ECHEC");
       }
       // Test estToucheCoule() 5
       if(grille.getNavires().get(4).estToucheCoule()){
            System.out.println("Test estToucheCoule() 5 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 5  : ECHEC");
       }
       
    }    
       
   
   public static void testTour(){
       
       System.out.println("\n------------TEST TOUR---------------\n"); 
       // Test appliquerTour() - Preparation
       Grille grille = new Grille();    
       ArrayList<Case> cases1 = new ArrayList<>();
       ArrayList<Case> cases2 = new ArrayList<>();
       ArrayList<Case> cases3 = new ArrayList<>();
       ArrayList<Case> cases4 = new ArrayList<>();
       ArrayList<Case> cases5 = new ArrayList<>();
       cases1.add(new Case(1, 0, 0));
       cases1.add(new Case(1, 0, 1));
       cases2.add(new Case(1, 1, 0));
       cases2.add(new Case(1, 1, 1));
       cases2.add(new Case(1, 1, 2));
       cases3.add(new Case(2, 2, 0));
       cases3.add(new Case(1, 2, 1));
       cases3.add(new Case(2, 2, 2));
       cases4.add(new Case(1, 3, 0));
       cases4.add(new Case(1, 3, 1));
       cases4.add(new Case(1, 3, 2));
       cases4.add(new Case(1, 3, 3));
       cases5.add(new Case(1, 4, 0));
       cases5.add(new Case(1, 4, 1));
       cases5.add(new Case(1, 4, 2));
       cases5.add(new Case(1, 4, 3));
       cases5.add(new Case(1, 4, 4));
       grille.getGrille()[0][0].setStatut(1);
       grille.getGrille()[0][1].setStatut(1);
       grille.getGrille()[1][0].setStatut(1);
       grille.getGrille()[1][1].setStatut(1);
       grille.getGrille()[1][2].setStatut(1);
       grille.getGrille()[2][0].setStatut(2);
       grille.getGrille()[2][1].setStatut(1);
       grille.getGrille()[2][2].setStatut(2);
       grille.getGrille()[3][0].setStatut(1);
       grille.getGrille()[3][1].setStatut(1);
       grille.getGrille()[3][2].setStatut(1);
       grille.getGrille()[3][3].setStatut(1);
       grille.getGrille()[4][0].setStatut(1);
       grille.getGrille()[4][1].setStatut(1);
       grille.getGrille()[4][2].setStatut(1);
       grille.getGrille()[4][3].setStatut(1);
       grille.getGrille()[4][4].setStatut(1);
       grille.getNavires().get(0).setCases(cases1);
       grille.getNavires().get(1).setCases(cases2);
       grille.getNavires().get(2).setCases(cases3);
       grille.getNavires().get(3).setCases(cases4);
       grille.getNavires().get(4).setCases(cases5);
       Tour test1 = new Tour(1, new Case(7,7)); // Manque
       Tour test2 = new Tour(1, new Case(0,0)); // Touche
       Tour test3 = new Tour(1, new Case(3,3)); // Touche
       Tour test4 = new Tour(1, new Case(0,1)); // Touche-Coule
       Tour test5 = new Tour(1, new Case(2,1)); // Touche-Coule
       test1.appliquerTour(grille); 
       test2.appliquerTour(grille);
       test3.appliquerTour(grille);
       test4.appliquerTour(grille);
       test5.appliquerTour(grille);
       // Test appliquerTour() #1 Case: 0 -> 3
       if(grille.getGrille()[7][7].getStatut() == 3){
            System.out.println("Test appliquerTour() 1 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 1 : ECHEC");
            System.out.println(" Case getStatut(): " + grille.getGrille()[7][7].getStatut());
       }
       // Test appliquerTour() #2 Case: 1 -> 2
       if(grille.getGrille()[0][0].getStatut() == 2){
            System.out.println("Test appliquerTour() 2 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 2 : ECHEC");
            System.out.println(" Case getStatut(): " + grille.getGrille()[0][0].getStatut());
       }
       // Test appliquerTour() #3 Case: 1 -> 2
       if(grille.getGrille()[3][3].getStatut() == 2){
            System.out.println("Test appliquerTour() 3 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 3 : ECHEC");
            System.out.println(" Case getStatut(): " + grille.getGrille()[3][3].getStatut());
       }
       // Test appliquerTour() #4 Case: 1 -> 2
       if(grille.getGrille()[0][1].getStatut() == 2){
            System.out.println("Test appliquerTour() 4 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 4 : ECHEC");
            System.out.println(" Case getStatut(): " + grille.getGrille()[0][1].getStatut());
       }
       // Test appliquerTour() #5 Case: 1 -> 2
       if(grille.getGrille()[2][1].getStatut() == 2){
            System.out.println("Test appliquerTour() 5 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 5 : ECHEC");
            System.out.println(" Case getStatut(): " + grille.getGrille()[2][1].getStatut());
       }
       
       // Test resultat du tour 1
       if(test1.getResultat() == 0){
            System.out.println("Test Resultat 1 : REUSSI");
       }else{
            System.out.print("Test Resultat 1 : ECHEC");
            System.out.println(" Case getResultat(): " + test1.getResultat());
       }
       // Test resultat du tour 2
       if(test2.getResultat() == 1){
            System.out.println("Test Resultat 2 : REUSSI");
       }else{
            System.out.print("Test Resultat 2 : ECHEC");
            System.out.println(" Case getResultat(): " + test2.getResultat());
       }
       // Test resultat du tour 3
       if(test3.getResultat() == 1){
            System.out.println("Test Resultat 3 : REUSSI");
       }else{
            System.out.print("Test Resultat 3 : ECHEC");
            System.out.println(" Case getResultat(): " + test3.getResultat());
       }
       // Test resultat du tour 4
       if(test4.getResultat() == 2){
            System.out.println("Test Resultat 4 : REUSSI");
       }else{
            System.out.print("Test Resultat 4 : ECHEC");
            System.out.println(" Case getResultat(): " + test4.getResultat());
       }
       // Test resultat du tour 5
       if(test5.getResultat() == 2){
            System.out.println("Test Resultat 5 : REUSSI");
       }else{
            System.out.print("Test Resultat 5 : ECHEC");
            System.out.println(" Case getResultat(): " + test5.getResultat());
       }
       
   }
}

