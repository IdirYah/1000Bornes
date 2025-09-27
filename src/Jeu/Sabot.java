package Jeu;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	private Carte[] tabCartes = new Carte[110];
	private int nbCartes;
	private int modCount = 0;
	public Sabot(Carte...cartes) {
		for(int i=0;i<cartes.length;i++) {
			tabCartes[i] = cartes[i];
		}
		this.nbCartes = cartes.length;
	}
	public boolean estVide() {return this.nbCartes == 0;}
	public void ajouterCarte(Carte carte) {
		if(tabCartes.length>=this.nbCartes) {
			throw new IllegalStateException("Capacité maximale atteinte");
		}
		this.tabCartes[this.nbCartes++] = carte;
		this.modCount++;
	}
	public Carte piocher() {
		if(estVide()) {
			throw new NoSuchElementException();
		}
		Iterator<Carte> it = iterator();
		Carte c = it.next();
		it.remove();
		return c;
		
	}
	public Iterator<Carte> iterator(){
		return new Iterator<Carte>(){
			private int indexIterator = 0;
			private int verifModCount = modCount;
			private boolean canRemove = false;
			public boolean hasNext() {return indexIterator<nbCartes;}
			public Carte next() {
				if(verifModCount != modCount) {
					throw new ConcurrentModificationException();
				}
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				Carte c = tabCartes[indexIterator];
				canRemove = true;
				indexIterator++;
				return c;
			}
			public void remove() {
				if(canRemove == false) {
					throw new IllegalStateException();
				}
				if(verifModCount != modCount) {
					throw new ConcurrentModificationException();
				}
				for(int i=indexIterator-1;i<nbCartes-1;i++) {
					tabCartes[i] = tabCartes[i+1];
				}
				nbCartes--;
				tabCartes[nbCartes] = null;
				indexIterator--;
				canRemove = false;
				modCount++;
				verifModCount++;
			}
			
		};
	}

}
