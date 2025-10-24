package testFonctionnels;
import java.util.*;

import cartes.*;
import Jeu.*;

public class TestZoneDeJeu {

	public static void main(String[] args){
		boolean depotOK = false;
		List<Bataille> b = new ArrayList<>();
		List<Limite> l = new ArrayList<>();
		List<Borne> br = new ArrayList<>();
		ZoneDeJeu zoneDeJeu = new ZoneDeJeu(l,b,br);
		// Feu rouge
		System.out.println("Deposer carte Feu rouge");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_ROUGE);
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_ROUGE);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// accident
		System.out.println("Deposer carte attaque - accident");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ACCIDENT));
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ACCIDENT));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// panne d'essence
		System.out.println("Deposer carte attaque - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Attaque(Type.ESSENCE));
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Attaque(Type.ESSENCE));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// roue de secours
		System.out.println("Deposer carte parade - roue de secours");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.CREVAISON));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.CREVAISON));
		}
		System.out.println("depot ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// bidon d'essence
		System.out.println("Deposer carte parade - essence");
		depotOK = zoneDeJeu.estDepotAutorise(new Parade(Type.ESSENCE));
		if (depotOK) {
			zoneDeJeu.deposer(new Parade(Type.ESSENCE));
		}
		System.out.println("depot ok ? " + depotOK);
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Feu vert
		System.out.println("Deposer carte Feu vert");
		depotOK = zoneDeJeu.estDepotAutorise(Cartes.FEU_VERT);
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(Cartes.FEU_VERT);
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot limitation de vitesse 50 bornes
		System.out.println("Deposer carte limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new DebutLimite());
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new DebutLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// Depot 25 bornes
		System.out.println("Deposer carte borne - 25");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(25));
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(25));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot fin limitation
		System.out.println("Deposer carte fin limite - 50");
		depotOK = zoneDeJeu.estDepotAutorise(new FinLimite());
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new FinLimite());
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
		// D�pot 100 bornes
		System.out.println("Deposer carte borne - 100");
		depotOK = zoneDeJeu.estDepotAutorise(new Borne(100));
		System.out.println("depot ok ? " + depotOK);
		if (depotOK) {
			zoneDeJeu.deposer(new Borne(100));
		}
		System.out.println("peut avancer ? " + zoneDeJeu.peutAvancer());
	}

}
