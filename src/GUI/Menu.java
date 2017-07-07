package GUI;

import Partie.Temps;
import Partie.Partie;
import Partie.Joueur;

import java.util.ArrayList;

public class Menu {
    
    private ArrayList<Temps> meilleursTemps;
    
    // Constructeur par defaut
    public Menu(){
        
    }
    
    // Constructeur par attributs
    public Menu(ArrayList<Temps> meilleursTemps) {
        this.meilleursTemps = meilleursTemps;
    }
    
    // Methodes de classes
    
    /**
     * Sauvegarde la partie en attribut dans le fichier sauvegardes.xml
     * 
     * @param partie 
     */
    public void sauvegarderPartie(Partie partie) {
        
    }
    
    /**
     * Charge la partie demandee en attribut et resume la partie 
     * 
     * @return Partie
     */
    public Partie chargerPartie(int partieDemandee){
        return new Partie();
    }
    
    /**
     * Debute une partie contre un adversaire selon le type de partie demande
     * 
     *  typePartie(1) : Joueur contre intelligence artificielle de bas niveau 
     *  typePartie(2) : Joueur contre intelligence artificielle de haut niveau
     * 
     * @param typePartie 
     */
    public void debuterPartie(int typePartie){
        
    }
    
    /**
     * Le joueur en attribut declare forfait
     * 
     * @param joueur
     * @param partie 
     */
    public void abandonnerPartie(Joueur joueur, Partie partie){
        
    }
    
    /**
     * Evalue si le temps de la partie fait partie des meilleurs temps
     * selon le temps et la difficulte de l'intelligence artificielle
     * 
     * @param partie 
     */
    public void evaluationMeilleurTemps(Partie partie) {
        
    }
    
    /**
     * Affiche les meilleurs temps enregistrees selon le type de difficulte de l'AI
     */
    public void visualiserMeilleursTemps(){
        
    }
    
    /**
     * Enregistre les infos de la partie dans meilleurs_temps.xml
     * 
     * @param partie 
     */
    public void enregistrementMeilleurTemps(Partie partie) {
        
    }
    
    // Getters
    public ArrayList<Temps> getMeilleursTemps() { return meilleursTemps; }
    
    // Setters
    public void setMeilleursTemps(ArrayList<Temps> meilleursTemps) { this.meilleursTemps = meilleursTemps; }
    
    
}