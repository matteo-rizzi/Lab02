package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private AlienDictionary ad;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtInserisci;

	@FXML
	private Button btnTraduzione;

	@FXML
	private TextArea txtRisultato;

	@FXML
	private Button btnCancella;

	@FXML
	void doReset(ActionEvent event) {
		txtRisultato.clear();
	}

	@FXML
	void doTranslate(ActionEvent event) {
		
		txtInserisci.clear();
		
		String inserita = txtInserisci.getText().toLowerCase();
		if (inserita.equals("")) {
			txtRisultato.appendText("Non hai inserito alcuna parola!\n");
			return;
		}
		
		if (inserita.contains(" ")) {
			String alienWord = inserita.substring(0, inserita.indexOf(" "));
			String translation = inserita.substring(inserita.indexOf(" ") + 1);
			if(!parolaConsentita(alienWord) || !parolaConsentita(translation)) {
				txtRisultato.appendText("Le parole inserite possono contenere solo lettere!\n");
				return;
			}
			this.ad.addWord(alienWord, translation);
		}
		else if (!inserita.contains(" ")){
			String traduzione = this.ad.translateWord(inserita);
			if (traduzione == null) {
				txtRisultato.appendText("La parola inserita non è presente nel dizionario!\n");
				return;
			}
			txtRisultato.appendText("La traduzione della parola '" + inserita + "' è: " + traduzione + "\n");
		}

	}
	
	private boolean parolaConsentita(String p) {
		boolean b = true;
		if (p.equals(""))
			b = false;
		for (char c : p.toCharArray()) {
			if (!Character.isLetter(c)) {
				b = false;
			}
		}
		return b;
	}

	@FXML
	void initialize() {
		assert txtInserisci != null : "fx:id=\"txtInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnTraduzione != null : "fx:id=\"btnTraduzione\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";

	}

	public void setAlienDictionary(AlienDictionary ad) {
		this.ad = ad;
	}
}
