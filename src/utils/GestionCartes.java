package utils;
import java.util.*;

import cartes.*;

public class GestionCartes{
	private static Random random = new Random();

	public static Carte extraireV1(List<Carte> l) {
		int index = random.nextInt(l.size());
		Carte c = l.remove(index);
		return c;
	}
	public static Carte extraireV2(List<Carte> l) {
		int index = random.nextInt(l.size());
		ListIterator<Carte> it = l.listIterator();
		int i=0;
		Carte c = null;
		while(i<=index && it.hasNext()) {
			c = it.next();
			i++;
		}
		it.remove();
		return c;
	}
	public static List<Carte> melanger(List<Carte> l){
		List<Carte> res = new ArrayList<>();
		Random r = new Random();
		while(!l.isEmpty()) {
			int index = r.nextInt(l.size());
			Carte c = l.get(index);
			res.add(c);
			l.remove(index);
		}
		return res;
	}
	public static boolean verifierMelanger(List<Carte> l1,List<Carte> l2) {
		if(l1.size() != l2.size()) return false;
		for(Carte e:l1) {
			if(Collections.frequency(l1,e) != Collections.frequency(l2,e)) return false;
		}
		return true;
	}
	public static List<Carte> rassembler(List<Carte> l){
		List<Carte> res = new ArrayList<>();
		Carte c = l.get(0);
		res.add(c);
		for(int i=1;i<l.size();i++) {
			c = l.get(i);
			int j = res.lastIndexOf(c);
			if(j==-1) {
				res.add(c);
			}else {
				res.add(j+1,c);
			}
		}
		return res;
	}
	public static boolean verifierRassembler(List<Carte> l) {
		if(l.isEmpty()) return true;
		ListIterator<Carte> it1 = l.listIterator();
		Carte current = it1.next();
		while(it1.hasNext()) {
			Carte next = it1.next();
			if(!current.equals(next)) {
				ListIterator<Carte> it2 = l.listIterator(it1.nextIndex());
				while(it2.hasNext()) {
					Carte c = it2.next();
					if(c.equals(current)) return false;
				}
				current = next;
			}
		}
		return true;
	}

}
