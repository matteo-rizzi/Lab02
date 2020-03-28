package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {

	private String alienWord;
	private List<String> translations;

	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
		this.translations = new LinkedList<String>();
	}

	public WordEnhanced(String alienWord, List<String> translations) {
		this.alienWord = alienWord;
		this.translations = translations;
	}

	public void addTranslation(String translation) {
		boolean presente = false;
		for (String t : translations) {
			if (t != null && t.compareTo(translation) == 0) // La traduzione è già presente. Non bisogna aggiungerla
															// nuovamente
				presente = true;
		}
		if (presente == false)
			this.translations.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public boolean wildcard(String s) {
		int puntiInterrogativi = 0;
		if (this.alienWord.length() != s.length()) {
			return false;
		} else {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '?')
					puntiInterrogativi++;
				else if (s.charAt(i) != this.alienWord.charAt(i)) {
					return false;
				}
			}
		}
		if (puntiInterrogativi == 1) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean equals(Object obj) {
		WordEnhanced w = (WordEnhanced) obj;
		boolean b = false;
		if (this.alienWord.compareTo(w.getAlienWord()) == 0) {
			b = true;
		}
		return b;
	}

	@Override
	public String toString() {
		String traduzione = "";
		for (String t : translations) {
			if (traduzione.compareTo("") == 0)
				traduzione += t;
			else
				traduzione += ", " + t;
		}
		return traduzione;
	}
}
