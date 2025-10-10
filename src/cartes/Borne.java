package cartes;

public class Borne extends Carte{
	private int km;
	public Borne(int km) {
		this.km = km;
	}
	public int getKM() {return this.km;}
	public String toString() {return this.km+" KM";}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne carte) {
			return this.km == carte.getKM();
		}
		return false;
	}

}
