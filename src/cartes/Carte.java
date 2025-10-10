package cartes;

abstract public class Carte {

	public Carte() {
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Carte carte) {
			return this.getClass() == carte.getClass();
		}
		return false;
	}
	

}
