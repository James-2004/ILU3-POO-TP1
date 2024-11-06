package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot<E extends Carte> implements Iterable<E>{
	private static int NB_CARTES = 106;
	
	private E[] sabot;
	private int nbCartes;
	private int nombreOperations = 0;
	
	
	public Sabot(E[] cartes) {
		this.sabot = cartes;
		this.nbCartes = sabot.length;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(E carte) {
		if(nbCartes < NB_CARTES) {
			sabot[nbCartes] = carte;
			nombreOperations++; // les itĆ©rateurs existants perdent leur droit dā€™accĆØs
		} else {
			throw new IndexOutOfBoundsException("Le Sabot est dĆ©jĆ  plein");
		}
	}
	
	public E piocher() {
		Iterator<E> it = iterator();
		
		if(it.hasNext()) {
			E cartePioche = it.next();
			it.remove();
			nombreOperations ++;
			nbCartes --;
			
			return cartePioche;
		} else {
			throw new NoSuchElementException("le sabot est vide");
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iterateur();
	}
	
	//////////////////////////////////////////////////////////////////////////////
	/////////////////////////////CLASSE INTERNE///////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	private class Iterateur implements Iterator<E>{
		private int indiceIterateur = 0;
		private int nombreOperationsReference = nombreOperations;
		private boolean nextEffectue = false;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public E next() {
			verificationConcurrence();
			
			if (hasNext()) {
				E element = sabot[indiceIterateur];
				indiceIterateur ++;
				nombreOperationsReference ++; nombreOperations ++;
				nextEffectue = true;
				
				return element;
			} else {
				throw new NoSuchElementException("Sortie du sabot");
			}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			
			if (nextEffectue) {
				for(int i = indiceIterateur - 1; i < nbCartes - 1; i++) {
					sabot[i] = sabot[i + 1];
				}
				
				nextEffectue = false;
				nombreOperations ++; nombreOperationsReference ++;
			} else {
				throw new IllegalStateException();
			}
		}
		
		private void verificationConcurrence(){
			 if (nombreOperations != nombreOperationsReference)
				 throw new ConcurrentModificationException();
		}
	}		
}