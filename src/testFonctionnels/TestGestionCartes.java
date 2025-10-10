package testFonctionnels;
import cartes.*;
import utils.*;
import java.util.*;

public class TestGestionCartes {

	public TestGestionCartes() {
	}
	public static void main(String[] args) {
		GestionCartes g = new GestionCartes();
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeu.donnerCartes()) {
		    listeCarteNonMelangee.add(carte);
		}
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println(listeCartes);
		listeCartes = g.melanger(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste mélangée sans erreur ? "
		+ g.verifierMelanger(listeCartes,listeCarteNonMelangee));
		listeCartes = g.rassembler(listeCartes);
		System.out.println(listeCartes);
		System.out.println("liste rassemblée sans erreur ? "
		+ g.verifierRassembler(listeCartes));
	}

}
