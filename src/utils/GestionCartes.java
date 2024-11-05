package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class GestionCartes {
	private static Random rand = new Random();
	
	public static <T> T extraire(List<T> liste) {
		int length = liste.size();
		int index = rand.nextInt(length);
		
		return liste.remove(index);
	} 
	
	
	public static <T> List<T> melanger(List<T> liste) {
		List<T> listeMelange = new ArrayList<>();
		
		for (int length = liste.size(); length > 0; length --) {
			listeMelange.add(extraire(liste));
		}
		return listeMelange;
	}
	
	
	public static <T> boolean verifierMelange(List<T> liste, List<T> liste2) {
		if (liste.size() != liste2.size()) {
			return false;
		} else {
			
			for(int i = 0; i < liste.size(); i++) {
				T c = liste.get(i);
				if(Collections.frequency(liste, c) != Collections.frequency(liste2, c)) {
					return false;
				}
			}
			return true; 
		}
	}
	
	
	public static <T> List<T> rassembler(List<T> liste){
		List<T> listeRassembler= new ArrayList<>();
		
		for(ListIterator<T> iter = liste.listIterator();iter.hasNext();) {
			T elem = iter.next();
			if (listeRassembler.contains(elem)){
				listeRassembler.add(listeRassembler.lastIndexOf(elem), elem);
			} else {
				listeRassembler.add(elem);
			}
		}
        	
		return listeRassembler;
	}
	
	
	public static <T> boolean verifierRassemblement(List <T> list) {
        ListIterator<T> iterator1 = list.listIterator();
        T curseur = iterator1.next(); 
        while(iterator1.hasNext()) {
            T prochain = iterator1.next(); 
            if(!curseur.equals(prochain)) {
                 ListIterator<T> iterator2 = list.listIterator(iterator1.nextIndex());


               while (iterator2.hasNext()) {
                   if (curseur.equals(iterator2.next())) {
                       return false;
                   }
               }

               curseur = prochain;
           }
       }
	
        return true;
	}
}
