package Cartes;

public class Attaque extends Bataille {

	protected Attaque(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return getType().getAttaque();
	}
}
