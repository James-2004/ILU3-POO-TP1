package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot<E extends Carte> implements Iterable<E> {
	private static final int MAX_CARTES = 106;
	
	private final E[] sabot;
	private int nbCartes;
	private int operationCount = 0;
	
	public Sabot(E[] cartes) {
		this.sabot = cartes;
		this.nbCartes = cartes.length;
	}
	
	public boolean estVide() {
		return this.nbCartes == 0;
	}
	
	public void ajouterCarte(E carte) {
		if (nbCartes < MAX_CARTES) {
			sabot[nbCartes++] = carte;
			operationCount++; // invalidate existing iterators
		} else {
			throw new IndexOutOfBoundsException("Le Sabot est déjà plein");
		}
	}
	
	public E piocher() {
		Iterator<E> iterator = this.iterator();
		
		if (iterator.hasNext()) {
			E drawnCard = iterator.next();
			iterator.remove();
			nbCartes--;
			operationCount++;
			
			return drawnCard;
		} else {
			throw new NoSuchElementException("Le sabot est vide");
		}
	}
	
	@Override
	public Iterator<E> iterator() {
		return new Iterateur();
	}
	
	//////////////////////////////////////////////////////////////////////////////
	/////////////////////////////CLASSE INTERNE///////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	
	private class Iterateur implements Iterator<E> {
		private int currentIndex = 0;
		private final int initialOperationCount = operationCount;
		private boolean canRemove = false;

		@Override
		public boolean hasNext() {
			return currentIndex < nbCartes;
		}

		@Override
		public E next() {
			checkForModification();
			
			if (hasNext()) {
				E element = sabot[currentIndex++];
				canRemove = true;
				
				return element;
			} else {
				throw new NoSuchElementException("Sortie du sabot");
			}
		}
		
		@Override
		public void remove() {
			checkForModification();
			
			if (canRemove) {
				System.arraycopy(sabot, currentIndex, sabot, currentIndex - 1, nbCartes - currentIndex);
				nbCartes--;
				operationCount++;
				canRemove = false;
			} else {
				throw new IllegalStateException();
			}
		}
		
		private void checkForModification() {
			 if (operationCount != initialOperationCount) {
				 throw new ConcurrentModificationException();
			 }
		}
	}		
}
