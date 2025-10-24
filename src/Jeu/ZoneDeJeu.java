package Jeu;
import java.util.*;
import cartes.*;

public class ZoneDeJeu {
	private List<Limite> pileLimites;
	private List<Bataille> pileBatailles;
	private List<Borne> bornes;
	public ZoneDeJeu(List<Limite> l,List<Bataille> b,List<Borne> r){
		pileLimites = l;
		pileBatailles = b;
		bornes = r;
	}
	public List<Limite> getPileLimites(){return this.pileLimites;}
	public List<Bataille> getPileBatailles(){return this.pileBatailles;}
	public List<Borne> getBornes(){return this.bornes;}
	public int donnerLimitationVitesse() {
		if(pileLimites.isEmpty()) return 200;
		Limite i = pileLimites.get(0);
		if(i instanceof FinLimite) return 200;
		return 50;
	}
	public int donnerKMParcourus() {
		int total = 0;
		for(Borne b:bornes) {
			total = total + b.getKM();
		}
		return total;
	}
	public void deposer(Carte c) {
		if(c instanceof Borne b) {bornes.add(0,b);}
		if(c instanceof Bataille bt) {pileBatailles.add(0,bt);}
		if(c instanceof Limite l) {pileLimites.add(0,l);}
	}
	public boolean peutAvancer() {
		if(pileBatailles.isEmpty()) return false;
		Bataille b = pileBatailles.get(0);
		Parade inter = new Parade(Type.FEU);
		return b.equals(inter);
	}
	private boolean estDepotFeuVertAutorise() {
		if(pileBatailles.isEmpty()) return true;
		Bataille b = pileBatailles.get(0);
		Parade inter1 = new Parade(Type.FEU);
		Attaque inter2 = new Attaque(Type.FEU);
		return b.equals(inter2) || !b.equals(inter1);
	}
	private boolean estDepotBorneAutorise(Borne borne) {
		if(!this.peutAvancer()) return false;
		if(borne.getKM()>this.donnerLimitationVitesse()) return false;
		int limite = this.donnerKMParcourus();
		if(limite>1000) return false;
		int total = limite + borne.getKM();
		return total<=1000;
	}
	private boolean estDepotLimiteAutorise(Limite limite) {
		if(limite instanceof DebutLimite) {
			if(pileLimites.isEmpty()) return true;
			Limite inter = pileLimites.get(0);
			return (inter instanceof FinLimite);
		}
		if(pileLimites.isEmpty()) return false;
		Limite inter = pileLimites.get(0);
		return (inter instanceof DebutLimite);
	}
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if(bataille instanceof Parade p) {
			Parade inter = new Parade(Type.FEU);
			if(p.equals(inter)) {
				return this.estDepotFeuVertAutorise();
			}
			if(pileBatailles.isEmpty()) return false;
			Bataille sommet = pileBatailles.get(0);
			if(sommet instanceof Attaque a) {
				return a.getType().equals(bataille.getType());
			}
			return false;
		}
		return this.peutAvancer();
	}
	public boolean estDepotAutorise(Carte carte) {
		if(carte instanceof Borne b) return this.estDepotBorneAutorise(b);
		if(carte instanceof Limite l) return this.estDepotLimiteAutorise(l);
		if(carte instanceof Bataille bt) return this.estDepotBatailleAutorise(bt);
		return false;
	}

}
