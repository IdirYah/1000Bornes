package cartes;

public enum Type {
	FEU("Feu rouge","Feu vert","Véhicule prioritaire"),
	ESSENCE("Panne d'essence","Essence","Citerne d'essence"),
	CREVAISON("Crevaison","Roue de secours","Increvable"),
	ACCIDENT("Accident","Réparations","As du volant");
	private String attaque;
	private String parade;
	private String botte;
	private Type(String attaque,String parade,String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	}
	public String getAttaque() {return this.attaque;}
	public String getParade() {return this.parade;}
	public String getBotte() {return this.botte;}

}
