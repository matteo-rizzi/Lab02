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
		String s = "";
		List<WordEnhanced> wc = new ArrayList<>();
		if (alienWord.contains("?")) {
			for (WordEnhanced we : dizionario) {
				if (we.wildcard(alienWord)) {
					wc.add(we);
				}
			}
			for (WordEnhanced we : wc) {
				s += "La/e traduzione/i della parola '" + we.getAlienWord() + "' è/sono: " + we.toString() + "\n";
			}
			return s;
		} else if (!alienWord.contains("?")){
			WordEnhanced wTemp = cercaAlienWord(alienWord);
			if (wTemp != null)
				return "La/e traduzione/i della parola '" + wTemp.getAlienWord() + "' è/sono: " + wTemp.toString() + "\n";
			else
				return null;
		}
		else
			return null;
	}

	public WordEnhanced cercaAlienWord(String a) {
		WordEnhanced trovato = null;
		for (WordEnhanced w : dizionario)
			if (w != null && w.getAlienWord().compareTo(a) == 0)
				trovato = w;
		return trovato;
	}

}
