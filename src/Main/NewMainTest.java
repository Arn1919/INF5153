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
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
/**
 *
 * @author arnaud
 */
public class NewMainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO
        //testGrille();
        //testCase();
        testAI();
        //testPartie();
        //testNavire();
        //testTour();
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
       Iterator<Map.Entry<Point, Integer>> it ;
       // Test RandomMove 1
       Grille grilleCase1 = new Grille();
       Point pointRandom = testFacile.makeMove(grilleCase1);
       if(grilleCase1.getGrille()[pointRandom.getRangee()][pointRandom.getColonne()].getStatut() == 0){
            System.out.println("Test RandomMove 1 : REUSSI");
       }else{
            System.out.println("Test RandomMove 1 : ECHEC");
       }
       // Test RandomMove 2
       Grille grilleCase2 = new Grille(2,2);
       grilleCase2.getGrille()[0][0].setStatut(1);
       grilleCase2.getGrille()[1][0].setStatut(0);
       grilleCase2.getGrille()[0][1].setStatut(1);
       grilleCase2.getGrille()[1][1].setStatut(1);
       
       Point pointRandomAI = testFacile.makeMove(grilleCase2);
       
       if(grilleCase2.getGrille()[pointRandomAI.getRangee()][pointRandomAI.getColonne()].getStatut() == 0){
           if(pointRandomAI.getRangee() == 1 
                   && pointRandomAI.getColonne() == 0){
               System.out.println("Test RandomMove 2 : REUSSI");
           }else{
               System.out.println("Test RandomMove 2 : ECHEC");
           }
       }else{
           System.out.println("Test RandomMove 2 : ECHEC");
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
       // Test Placer Bateau AI - Test 2 Points
       System.out.println("Test Navire de deux Points");
        Map<Point, Integer> test2Points = testFacile.placerBateau(grilleBateauTest, 2);
        it = test2Points.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Point, Integer> entree = it.next();
            System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
        }

        // Test Placer Bateau AI - Test 3 Points
       System.out.println("Test Navire de trois Points");
        Map<Point, Integer> test3Points = testFacile.placerBateau(grilleBateauTest, 3);
        it = test3Points.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Point, Integer> entree = it.next();
            System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
        }
        // Test Placer Bateau AI - Test 4 Points
       System.out.println("Test Navire de quatre Points");
        Map<Point, Integer> test4Points = testFacile.placerBateau(grilleBateauTest, 4);
        it = test4Points.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Point, Integer> entree = it.next();
            System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
        }
        // Test Placer Bateau AI - Test 5 Points
        System.out.println("Test Navire de cinq Points");
        Map<Point, Integer> test5Points = testFacile.placerBateau(grilleBateauTest, 5);
        it = test5Points.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Point, Integer> entree = it.next();
            System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
        }
        
        // Test makeMiniMaxMove
        AI testDifficile = new AI(1);
        Grille grille = new Grille(5, 5);
        for(int i = 0; i < grille.getRangees(); i++){
            for( int j = 0; j < grille.getColonnes(); j++){
                if( (i == 0 && j == 0) || (i==2 && j==3) || (i==3&&j==3) || (i==3&&j==0) ){
                    grille.getGrille()[i][j].setStatut(2);
                    
                }
            }
        }
        Point pointChoisi = testDifficile.makeMove(grille);
        System.out.print("Test makeMiniMaxMove() 1 --");
        System.out.println("Point : (" + pointChoisi.getRangee() + ", " + pointChoisi.getColonne() + ")");
        
   
      
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
      Iterator<Map.Entry<Point, Integer>> it ;
      Partie test = new Partie();
      // Test Preparation Partie
      test.preparationPartie();
      System.out.println("Premier Navire");
      it = test.getJ2().getGrilleJoueur().getNavires().get(0).getPointsGrille().entrySet().iterator();
      while(it.hasNext()){
          Map.Entry<Point, Integer> entree = it.next();
          System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
      }
      System.out.println("Deuxieme Navire");
      it = test.getJ2().getGrilleJoueur().getNavires().get(1).getPointsGrille().entrySet().iterator();
      while(it.hasNext()){
          Map.Entry<Point, Integer> entree = it.next();
          System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
      }
      System.out.println("Troisieme Navire");
      it = test.getJ2().getGrilleJoueur().getNavires().get(2).getPointsGrille().entrySet().iterator();
      while(it.hasNext()){
          Map.Entry<Point, Integer> entree = it.next();
          System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
      }
      System.out.println("Quatrieme Navire");
      it = test.getJ2().getGrilleJoueur().getNavires().get(3).getPointsGrille().entrySet().iterator();
      while(it.hasNext()){
          Map.Entry<Point, Integer> entree = it.next();
          System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
                );
          
      }
      System.out.println("Cinquieme Navire");
      it = test.getJ2().getGrilleJoueur().getNavires().get(4).getPointsGrille().entrySet().iterator();
      while(it.hasNext()){
          Map.Entry<Point, Integer> entree = it.next();
          System.out.println("Case: R"
                  + entree.getKey().getRangee()
                  + " C"
                  + entree.getKey().getColonne()
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
       Map<Point, Integer> points1 = new HashMap<>();
       Map<Point, Integer> points2 = new HashMap<>();
       Map<Point, Integer> points3 = new HashMap<>();
       Map<Point, Integer> points4 = new HashMap<>();
       Map<Point, Integer> points5 = new HashMap<>();
       points1.put(new Point(0, 0), 2);
       points1.put(new Point(0, 1), 2); // estToucheCoule() == true
       points2.put(new Point(1, 0), 2);
       points2.put(new Point(1, 1), 1);
       points2.put(new Point(1, 2), 2); // estToucheCoule() == false
       points3.put(new Point(2, 0), 2);
       points3.put(new Point(2, 1), 2);
       points3.put(new Point(2, 2), 2); // estToucheCoule() == true
       points4.put(new Point(3, 0), 1);
       points4.put(new Point(3, 1), 2);
       points4.put(new Point(3, 2), 1);
       points4.put(new Point(3, 3), 1); // estToucheCoule() == false
       points5.put(new Point(4, 0), 2);
       points5.put(new Point(4, 1), 2);
       points5.put(new Point(4, 2), 2);
       points5.put(new Point(4, 3), 2);
       points5.put(new Point(4, 4), 1); // estToucheCoule() == true
       grille.getNavires().get(0).setPointsGrille(points1);
       grille.getNavires().get(1).setPointsGrille(points2);
       grille.getNavires().get(2).setPointsGrille(points3);
       grille.getNavires().get(3).setPointsGrille(points4);
       grille.getNavires().get(4).setPointsGrille(points5);
       // Test estToucheCoule() 1
       if(grille.getNavires().get(0).estToucheCoule()){
            System.out.println("Test estToucheCoule() 1 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 1  : ECHEC");
            System.out.println("estToucheCoule() : " + grille.getNavires().get(0).estToucheCoule());
       }
       // Test estToucheCoule() 2
       if(!grille.getNavires().get(1).estToucheCoule()){
            System.out.println("Test estToucheCoule() 2 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 2  : ECHEC");
            System.out.println("estToucheCoule() : " + grille.getNavires().get(1).estToucheCoule());
       }
       // Test estToucheCoule() 3
       if(grille.getNavires().get(2).estToucheCoule()){
            System.out.println("Test estToucheCoule() 3 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 3  : ECHEC");
            System.out.println("estToucheCoule() : " + grille.getNavires().get(2).estToucheCoule());
       }
       // Test estToucheCoule() 4
       if(!grille.getNavires().get(3).estToucheCoule()){
            System.out.println("Test estToucheCoule() 4 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 4  : ECHEC");
            System.out.println("estToucheCoule() : " + grille.getNavires().get(3).estToucheCoule());
       }
       // Test estToucheCoule() 5
       if(!grille.getNavires().get(4).estToucheCoule()){
            System.out.println("Test estToucheCoule() 5 : REUSSI");
       }else{
            System.out.println("Test estToucheCoule() 5  : ECHEC");
            System.out.println("estToucheCoule() : " + grille.getNavires().get(4).estToucheCoule());
       }
       
    }    
       
   
   public static void testTour(){
       
       System.out.println("\n------------TEST TOUR---------------\n"); 
       // Test appliquerTour() - Preparation
       Grille grille1 = new Grille(); // Grille Adversaire
       Grille grille2 = new Grille(); // Grille Essai du Joueur
       Map<Point, Integer> points1 = new HashMap<>();
       Map<Point, Integer> points2 = new HashMap<>();
       Map<Point, Integer> points3 = new HashMap<>();
       Map<Point, Integer> points4 = new HashMap<>();
       Map<Point, Integer> points5 = new HashMap<>();
       points1.put(new Point(0, 0), 1);
       points1.put(new Point(0, 1), 1);
       points2.put(new Point(1, 0), 1);
       points2.put(new Point(1, 1), 1);
       points2.put(new Point(1, 2), 1);
       points3.put(new Point(2, 0), 2);
       points3.put(new Point(2, 1), 1);
       points3.put(new Point(2, 2), 2);
       points4.put(new Point(3, 0), 1);
       points4.put(new Point(3, 1), 1);
       points4.put(new Point(3, 2), 1);
       points4.put(new Point(3, 3), 1);
       points5.put(new Point(4, 0), 1);
       points5.put(new Point(4, 1), 1);
       points5.put(new Point(4, 2), 1);
       points5.put(new Point(4, 3), 1);
       points5.put(new Point(4, 4), 1);
       grille1.getGrille()[0][0].setStatut(1);
       grille1.getGrille()[0][1].setStatut(1);
       grille1.getGrille()[1][0].setStatut(1);
       grille1.getGrille()[1][1].setStatut(1);
       grille1.getGrille()[1][2].setStatut(1);
       grille1.getGrille()[2][0].setStatut(2);
       grille1.getGrille()[2][1].setStatut(1);
       grille1.getGrille()[2][2].setStatut(2);
       grille1.getGrille()[3][0].setStatut(1);
       grille1.getGrille()[3][1].setStatut(1);
       grille1.getGrille()[3][2].setStatut(1);
       grille1.getGrille()[3][3].setStatut(1);
       grille1.getGrille()[4][0].setStatut(1);
       grille1.getGrille()[4][1].setStatut(1);
       grille1.getGrille()[4][2].setStatut(1);
       grille1.getGrille()[4][3].setStatut(1);
       grille1.getGrille()[4][4].setStatut(1);
       grille1.getNavires().get(0).setPointsGrille(points1);
       grille1.getNavires().get(1).setPointsGrille(points2);
       grille1.getNavires().get(2).setPointsGrille(points3);
       grille1.getNavires().get(3).setPointsGrille(points4);
       grille1.getNavires().get(4).setPointsGrille(points5);
       Tour test1 = new Tour(1, new Point(7, 7)); // Manque
       Tour test2 = new Tour(1, new Point(0, 0)); // Touche
       Tour test3 = new Tour(1, new Point(3, 3)); // Touche
       Tour test4 = new Tour(1, new Point(0, 1)); // Touche-Coule
       Tour test5 = new Tour(1, new Point(2, 1)); // Touche-Coule
       test1.appliquerTour(grille1, grille2); 
       test2.appliquerTour(grille1, grille2);
       test3.appliquerTour(grille1, grille2);
       test4.appliquerTour(grille1, grille2);
       test5.appliquerTour(grille1, grille2);
       // Test appliquerTour() #1 Case: 0 -> 3
       if(grille1.getGrille()[7][7].getStatut() == 3){
            System.out.println("Test appliquerTour() 1 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 1 : ECHEC");
            System.out.println(" Case getStatut(): " + grille1.getGrille()[7][7].getStatut());
       }
       // Test appliquerTour() #2 Case: 1 -> 2
       if(grille1.getGrille()[0][0].getStatut() == 2){
            System.out.println("Test appliquerTour() 2 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 2 : ECHEC");
            System.out.println(" Case getStatut(): " + grille1.getGrille()[0][0].getStatut());
       }
       // Test appliquerTour() #3 Case: 1 -> 2
       if(grille1.getGrille()[3][3].getStatut() == 2){
            System.out.println("Test appliquerTour() 3 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 3 : ECHEC");
            System.out.println(" Case getStatut(): " + grille1.getGrille()[3][3].getStatut());
       }
       // Test appliquerTour() #4 Case: 1 -> 2
       if(grille1.getGrille()[0][1].getStatut() == 2){
            System.out.println("Test appliquerTour() 4 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 4 : ECHEC");
            System.out.println(" Case getStatut(): " + grille1.getGrille()[0][1].getStatut());
       }
       // Test appliquerTour() #5 Case: 1 -> 2
       if(grille1.getGrille()[2][1].getStatut() == 2){
            System.out.println("Test appliquerTour() 5 : REUSSI");
       }else{
            System.out.print("Test appliquerTour() 5 : ECHEC");
            System.out.println(" Case getStatut(): " + grille1.getGrille()[2][1].getStatut());
       }
       
       // Test resultat du tour 1
       if(test1.getResultat() == 0){
            System.out.println("Test Resultat 1 : REUSSI");
       }else{
            System.out.print("Test Resultat 1 : ECHEC");
            System.out.print(" Case getResultat(): " + test1.getResultat());
            System.out.print(" R" + test1.getAction().getRangee() + "C" + test1.getAction().getColonne());
            System.out.println(" Statut: " + grille1.getGrille()[test1.getAction().getRangee()][test1.getAction().getColonne()].getStatut());
       }
       // Test resultat du tour 2
       if(test2.getResultat() == 1){
            System.out.println("Test Resultat 2 : REUSSI");
       }else{
            System.out.print("Test Resultat 2 : ECHEC");
            System.out.print(" Case getResultat(): " + test2.getResultat());
            System.out.print(" R" + test2.getAction().getRangee() + "C" + test2.getAction().getColonne());
            System.out.println(" Statut: " + grille1.getGrille()[test2.getAction().getRangee()][test2.getAction().getColonne()].getStatut());
       }
       // Test resultat du tour 3
       if(test3.getResultat() == 1){
            System.out.println("Test Resultat 3 : REUSSI");
       }else{
            System.out.print("Test Resultat 3 : ECHEC");
            System.out.print(" Case getResultat(): " + test3.getResultat());
            System.out.print(" R" + test3.getAction().getRangee() + "C" + test3.getAction().getColonne());
            System.out.println(" Statut: " + grille1.getGrille()[test3.getAction().getRangee()][test3.getAction().getColonne()].getStatut());
       }
       // Test resultat du tour 4
       if(test4.getResultat() == 2){
            System.out.println("Test Resultat 4 : REUSSI");
       }else{
            System.out.print("Test Resultat 4 : ECHEC");
            System.out.print(" Case getResultat(): " + test4.getResultat());
            System.out.print(" R" + test4.getAction().getRangee() + "C" + test4.getAction().getColonne());
            System.out.println(" Statut: " + grille1.getGrille()[test4.getAction().getRangee()][test4.getAction().getColonne()].getStatut());
       }
       // Test resultat du tour 5
       if(test5.getResultat() == 2){
            System.out.println("Test Resultat 5 : REUSSI");
       }else{
            System.out.print("Test Resultat 5 : ECHEC");
            System.out.print(" Case getResultat(): " + test5.getResultat());
            System.out.print(" R" + test5.getAction().getRangee() + "C" + test5.getAction().getColonne());
            System.out.println(" Statut: " + grille1.getGrille()[test5.getAction().getRangee()][test5.getAction().getColonne()].getStatut());
       }
       
       
   }
}
