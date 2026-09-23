package Cartes;

public class Botte extends Probleme {

	protected Botte(Type type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return getType().getBotte();
	}
}
