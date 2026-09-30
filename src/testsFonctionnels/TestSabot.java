package testsFonctionnels;

import java.util.Iterator;

import Cartes.Cartes;
import Cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {

    public static void main(String[] args) {
        JeuDeCartes jeu = new JeuDeCartes();
        System.out.println("========== TEST PIOCHER ==========");
        Cartes[] cartes = jeu.donnerCartes();
        Sabot sabot = new Sabot(cartes);

        while (!sabot.estVide()) {
            System.out.println("Je pioche " + sabot.piocher());
        }

        System.out.println();
        System.out.println("========== TEST ITERATOR + REMOVE ==========");

        cartes = jeu.donnerCartes();
        sabot = new Sabot(cartes);

        Iterator<Cartes> iterateur = sabot.iterator();

        while (iterateur.hasNext()) {
            Cartes carte = iterateur.next();
            System.out.println("Je pioche " + carte);
            iterateur.remove();
        }
        System.out.println();
        System.out.println("========== TEST CONCURRENT MODIFICATION ==========");

        cartes = jeu.donnerCartes();
        sabot = new Sabot(cartes);

        iterateur = sabot.iterator();

        try {
            while (iterateur.hasNext()) {

                Cartes carte = iterateur.next();
                System.out.println("je pioche " + carte);

                sabot.piocher();
            }
        } catch (Exception e) {
            System.out.println("Confirmation de l'exception : " + e.getClass().getSimpleName());
        }
    }
}
