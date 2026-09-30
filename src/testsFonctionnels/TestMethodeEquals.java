package testsFonctionnels;

import Cartes.Attaque;
import Cartes.Borne;
import Cartes.Parade;
import Cartes.Type;

public class TestMethodeEquals {

	public static void main(String[] args) {
		System.out.println("========== TEST CARTE BORNE ==========");
		Borne borne1 = new Borne(25);
		Borne borne2 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? ");
		System.out.println(borne1.equals(borne2));
		
		System.out.println("========== TEST CARTE FEU ==========");
		Attaque rouge1 = new Attaque(Type.FEU);
		Attaque rouge2 = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? ");
		System.out.println(rouge1.equals(rouge2));
		
		System.out.println("========== TEST CARTE FEU ROUGE ET VERT ==========");
		Parade vert1 = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ?");
		System.out.println(rouge1.equals(vert1));
	}

}
