package testFonctionnels;
import cartes.*;

public class TestMethodeEquals {

	public TestMethodeEquals() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] arg) {
		Borne b1 = new Borne(25);
		Borne b2 = new Borne(25);
		Attaque f1 = new Attaque(Type.FEU);
		Attaque f2 = new Attaque(Type.FEU);
		Attaque e1 = new Attaque(Type.FEU);
		Parade e2 = new Parade(Type.FEU);
		System.out.println(b1.equals(b2));
		System.out.println(f1.equals(f2));
		System.out.println(e1.equals(e2));
	}

}
