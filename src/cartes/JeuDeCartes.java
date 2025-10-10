package cartes;

public class JeuDeCartes {
	private class Configuration{
		private Carte carte;
		private int nbExemplaires;
		public Configuration(int nbExemplaires,Carte carte) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}
		public int getNbExemplaires() {return this.nbExemplaires;}
		public Carte getCarte() {return this.carte;}
	}
	private Configuration[] typesDeCartes;
	public JeuDeCartes() {
		typesDeCartes = new Configuration[19];
		typesDeCartes[0] = new Configuration(1,new Botte(Type.FEU));
		typesDeCartes[1] = new Configuration(1,new Botte(Type.ESSENCE));
		typesDeCartes[2] = new Configuration(1,new Botte(Type.CREVAISON));
		typesDeCartes[3] = new Configuration(1,new Botte(Type.ACCIDENT));
		typesDeCartes[4] = new Configuration(5, new Attaque(Type.FEU));
		typesDeCartes[5] = new Configuration(4,new DebutLimite());
		typesDeCartes[6] = new Configuration(3,new Attaque(Type.ESSENCE));
		typesDeCartes[7] = new Configuration(3,new Attaque(Type.CREVAISON));
		typesDeCartes[8] = new Configuration(3,new Attaque(Type.ACCIDENT));
		typesDeCartes[9] = new Configuration(14,new Parade(Type.FEU));
		typesDeCartes[10] = new Configuration(6,new FinLimite());
		typesDeCartes[11] = new Configuration(6,new Parade(Type.ESSENCE));
		typesDeCartes[12] = new Configuration(6,new Parade(Type.CREVAISON));
		typesDeCartes[13] = new Configuration(6,new Parade(Type.ACCIDENT));
		typesDeCartes[14] = new Configuration(10,new Borne(25));
		typesDeCartes[15] = new Configuration(10,new Borne(50));
		typesDeCartes[16] = new Configuration(10,new Borne(75));
		typesDeCartes[17] = new Configuration(12,new Borne(100));
		typesDeCartes[18] = new Configuration(4,new Borne(200));
	}
	public Carte[] donnerCartes() {
	    int total = 0;
	    for (Configuration config : typesDeCartes) {
	        total += config.getNbExemplaires();
	    }
	    Carte[] cartes = new Carte[total];
	    int index = 0;
	    for (Configuration config : typesDeCartes) {
	        for (int i = 0; i < config.getNbExemplaires(); i++) {
	            cartes[index++] = config.getCarte();
	        }
	    }

	    return cartes;
	}
	public void affichageJeuDeCartes() {
		for(Configuration config:typesDeCartes) {
			System.out.println(config.getNbExemplaires()+" "+config.getCarte().toString());
		}
	}
	public boolean checkCount(Carte[] cartes) {
		for(Carte c:cartes) {
			int count = 0;
			for(Carte e:cartes) {
				if(c.equals(e)) count++;
			}
			int i = 0;
			for(Configuration inter:this.typesDeCartes) {
				if(inter.carte.equals(c)) i=i+inter.getNbExemplaires();
			}
			if(i != count) return false;
		}
		return true;
	}

}
