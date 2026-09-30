package Cartes;

public abstract class Cartes  {
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Cartes carte) {
			return toString().equals(carte.toString());
		}
		else {
			return false;
		}
	}
	
}
