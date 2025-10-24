package testFonctionnels;
import Jeu.*;
import cartes.*;
import java.util.*;

public class TestJoueur {

	public TestJoueur() {
	}
	public static void main(String[] args) {
		List<Limite> l = new ArrayList<>();
		List<Bataille> b = new ArrayList<>();
		List<Borne> br = new ArrayList<>();
		List<Carte> cartes = new ArrayList<>();
		ZoneDeJeu zone = new ZoneDeJeu(l,b,br);
		MainJoueur main = new MainJoueur(cartes);
		Joueur j = new Joueur("Idir",zone,main);
		Borne b1 = new Borne(25);
		Borne b2 = new Borne(50);
		Borne b3 = new Borne(75);
		Limite l1 = new DebutLimite();
		Limite l2 = new FinLimite();
		j.deposer(b1);
		j.deposer(b2);
		j.deposer(b3);
		System.out.println("Total des bornes : "+j.donnerKMParcourus());
		System.out.println("Limite : "+j.getZoneDeJeu().donnerLimitationVitesse());
		j.deposer(l1);
		System.out.println("Limite : "+j.getZoneDeJeu().donnerLimitationVitesse());
		j.deposer(l2);
		System.out.println("Limite : "+j.getZoneDeJeu().donnerLimitationVitesse());
	}

}
