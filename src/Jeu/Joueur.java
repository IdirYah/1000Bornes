package Jeu;

import cartes.*;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneJoueur;
	private MainJoueur main;
	public Joueur(String nom,ZoneDeJeu zoneJoueur,MainJoueur main) {
		this.nom = nom;
		this.zoneJoueur = zoneJoueur;
		this.main = main;
	}
	public String getNom() {return this.nom;}
	public ZoneDeJeu getZoneDeJeu() {return this.zoneJoueur;}
	public MainJoueur getMain() {return this.main;}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Joueur joueur) {
			return this.nom.equals(joueur.getNom());
		}
		return false;
	}
	@Override
	public String toString() {return this.nom;}
	public void donner(Carte carte) {main.prendre(carte);}
	public Carte prendreCarte(Sabot sabot) {
		if(sabot.estVide()) return null;
		Carte c = sabot.piocher();
		this.donner(c);
		return c;
	}
	public int donnerKMParcourus() {
		return this.getZoneDeJeu().donnerKMParcourus();
	}
	public void deposer(Carte c) {
		this.getZoneDeJeu().deposer(c);
	}
	public boolean estDepotAutorise(Carte c) {
		return this.getZoneDeJeu().estDepotAutorise(c);
	}
}
