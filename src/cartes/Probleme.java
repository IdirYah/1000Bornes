package cartes;

public abstract class Probleme extends Carte{
	private Type type;
	public Probleme(Type type) {
		this.type = type;
	}
	public Type getType() {return this.type;}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Probleme probleme) {
			return probleme.getClass() == this.getClass() && type.equals(probleme.getType());
		}
		return false;
	}

}
