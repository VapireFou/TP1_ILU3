package Cartes;

public class Borne extends Cartes {
	private int km;
	
	public Borne(int km) {
		super();
		this.km = km;
	}
	
	@Override
	public String toString() {
		return km + "KM";
	}
}
