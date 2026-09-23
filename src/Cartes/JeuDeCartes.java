package Cartes;

public class JeuDeCartes {
	private Configuration[] typesDeCartes = new Configuration[19];
	

	public JeuDeCartes() {
		typesDeCartes[0] = new Configuration(new Borne(25), 10);
		typesDeCartes[1] = new Configuration(new Borne(50), 10);
		typesDeCartes[2] = new Configuration(new Borne(75), 10);
		typesDeCartes[3] = new Configuration(new Borne(100), 12);
		typesDeCartes[4] = new Configuration(new Borne(200), 4);
		typesDeCartes[5] = new Configuration(new Parade(Type.FEU), 14);
		typesDeCartes[6] = new Configuration(new FinLimite(), 6);
		typesDeCartes[7] = new Configuration(new Parade(Type.ESSENCE), 6);
		typesDeCartes[8] = new Configuration(new Parade(Type.CREVAISON), 6);
		typesDeCartes[9] = new Configuration(new Parade(Type.ACCIDENT), 6);
		typesDeCartes[10] = new Configuration(new Attaque(Type.FEU), 5);
		typesDeCartes[11] = new Configuration(new DebutLimite(),4);
		typesDeCartes[12] = new Configuration(new Attaque(Type.ESSENCE), 3);
		typesDeCartes[13] = new Configuration(new Attaque(Type.CREVAISON), 3);
		typesDeCartes[14] = new Configuration(new Attaque(Type.ACCIDENT), 3);
		typesDeCartes[15] = new Configuration(new Botte(Type.FEU), 1);
		typesDeCartes[16] = new Configuration(new Botte(Type.ACCIDENT), 1);
		typesDeCartes[17] = new Configuration(new Botte(Type.CREVAISON), 1);
		typesDeCartes[18] = new Configuration(new Botte(Type.ESSENCE), 1);
		
	}

	private class Configuration extends Cartes {
		private int nbExemplaires;
		private Cartes carte;
		
		private Configuration(Cartes carte,int nbExemplaires) {
			super();
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Cartes getCarte() {
			return carte;
		}
	
	}
	
	public String affichageJeuDeCartes() {
		System.out.println("JEU :");
		
		StringBuilder texte = new StringBuilder();
		
		for (int i = 0; i < typesDeCartes.length;i++) {
			texte.append(typesDeCartes[i].getCarte().toString());
		}
		
		return texte.toString();
	}
	
	public Cartes[] donnerCartes() {
		int total = 0;
		for(int i = 0; i < typesDeCartes.length;i++) {
			total += typesDeCartes[i].getNbExemplaires();
		}
		Cartes[] tab = new Cartes[total];
		int compt = 0;
		for(int i = 0; i < typesDeCartes.length;i++) {
			for (int j = 0; j < typesDeCartes[i].getNbExemplaires(); j++) {
				tab[compt] = typesDeCartes[i].getCarte();
				compt++;
			}
		}
		return tab;
	}
	
}
