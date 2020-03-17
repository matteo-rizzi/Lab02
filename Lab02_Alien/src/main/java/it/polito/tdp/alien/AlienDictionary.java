package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<Word> dizionario;

	public AlienDictionary() {
		dizionario = new LinkedList<Word>();
	}

	public void addWord(String alienWord, String translation) {
		Word wTemp = new Word(alienWord, translation);
		for (Word w : dizionario) {
			if (w.equals(wTemp)) {
				dizionario.remove(w);
				dizionario.add(wTemp);
				return;
			}
		}
		dizionario.add(wTemp);
	}

	public String translateWord(String alienWord) {
		String traduzione = null;
		for (Word w : dizionario) {
			if (w.getAlienWord().compareTo(alienWord) == 0) {
				traduzione = w.getTranslation();
			}
		}
		return traduzione;
	}

}
