package it.polito.tdp.alien;

public class Word {

	private String alienWord;
	private String translation;

	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}

	@Override
	public boolean equals(Object obj) {
		Word w = (Word) obj;
		boolean b = false;
		if (this.alienWord.compareTo(w.getAlienWord()) == 0) {
			b = true;
		}
		return b;
	}

}
