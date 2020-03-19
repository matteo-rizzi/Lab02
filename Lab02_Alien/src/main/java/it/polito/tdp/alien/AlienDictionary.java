package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<WordEnhanced> dizionario;

	public AlienDictionary() {
		dizionario = new LinkedList<WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {
		WordEnhanced wTemp = new WordEnhanced(alienWord);
		wTemp.addTranslation(translation);
		for (WordEnhanced w : dizionario) {
			if (w != null && w.equals(wTemp)) {
				w.addTranslation(translation);
				return;
			}
		}
		dizionario.add(wTemp);
	}

	public String translateWord(String alienWord) {
		WordEnhanced wTemp = cercaAlienWord(alienWord);
		if (wTemp != null)
			return wTemp.toString();
		else
			return null;
	}

	public WordEnhanced cercaAlienWord(String a) {
		WordEnhanced trovato = null;
		for (WordEnhanced w : dizionario)
			if (w!= null && w.getAlienWord().compareTo(a) == 0)
				trovato = w;
		return trovato;
	}

}
