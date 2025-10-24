package Jeu;
import java.util.*;
import utils.*;

import cartes.*;

public class Jeu {
	private Sabot sabot;
	public Jeu() {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] tabCartes = jeu.donnerCartes();
		List<Carte> listCartes = new ArrayList<>();
		Collections.addAll(listCartes,tabCartes);
		listCartes = GestionCartes.melanger(listCartes);
		Carte[] cartes = (Carte[])listCartes.toArray();
		sabot = new Sabot(cartes);
	}
	public Sabot getSabot() {return this.sabot;}
}
