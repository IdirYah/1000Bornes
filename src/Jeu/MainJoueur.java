package Jeu;
import cartes.*;
import java.util.*;

public class MainJoueur {
	private List<Carte> listCartes;
	public MainJoueur(List<Carte> l) {
		this.listCartes = l;
	}
	public List<Carte> getListCartes(){return this.listCartes;}
	public void prendre(Carte carte) {listCartes.add(carte);}
	public void jouer(Carte carte) {
		assert listCartes.contains(carte);
		listCartes.remove(carte);
	}
	@Override
	public String toString() {
		String s = "";
		for(Carte carte:listCartes) {
			s=s+carte.toString()+" ; ";
		}
		return s;
	}
}
