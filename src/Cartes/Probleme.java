package Cartes;

public abstract class Probleme extends Cartes {
	private Type type;
	
	protected Probleme(Type type) {
		super();
		this.type = type;
	}

	public Type getType() {
		return type;
	}

}
