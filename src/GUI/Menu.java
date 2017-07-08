package GUI;

import Partie.Temps;
import Partie.Partie;
import Partie.Joueur;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
        
        try {
                
            File file = new File("src/Local_Storage/sauvegardes.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Partie.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(partie, file);
            jaxbMarshaller.marshal(partie, System.out);

	} catch (JAXBException e) {
            e.printStackTrace();
	}
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