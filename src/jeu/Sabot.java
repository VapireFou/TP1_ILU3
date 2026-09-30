package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import Cartes.Cartes;

public class Sabot implements Iterable<Cartes> {

    private Cartes[] cartes;
    private int nbCartes;
    private int nbModifications;

    public Sabot(Cartes[] cartes) {
        this.cartes = cartes;
        this.nbCartes = cartes.length;
        this.nbModifications = 0;
    }

    public boolean estVide() {
        return nbCartes == 0;
    }

    public void ajouterCarte(Cartes carte) {
        if (nbCartes == cartes.length) {
            throw new IllegalStateException();
        }
        cartes[nbCartes] = carte;
        nbCartes++;
        nbModifications++;
    }

    @Override
    public Iterator<Cartes> iterator() {

        return new Iterator<Cartes>() {
            private int position = 0;
            private int modifications = nbModifications;
            private boolean peutSupprimer = false;

            @Override
            public boolean hasNext() {
                return position < nbCartes;
            }

            @Override
            public Cartes next() {

                if (modifications != nbModifications) {
                    throw new ConcurrentModificationException();
                }

                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Cartes carte = cartes[position];
                position++;
                peutSupprimer = true;
                return carte;
            }

            @Override
            public void remove() {

                if (modifications != nbModifications) {
                    throw new ConcurrentModificationException();
                }
                if (!peutSupprimer) {
                    throw new IllegalStateException();
                }
                for (int i = position - 1; i < nbCartes - 1; i++) {
                    cartes[i] = cartes[i + 1];
                }
                nbCartes--;
                cartes[nbCartes] = null;
                position--;
                nbModifications++;
                modifications++;
                peutSupprimer = false;
            }
        };
    }

    public Cartes piocher() {
        Iterator<Cartes> it = iterator();
        if (!it.hasNext()) {
        	System.out.println("La Pioche n'est pas valide");
        	throw new IllegalStateException();
        }
        Cartes carte = it.next();
        it.remove();
        return carte;
    }
}