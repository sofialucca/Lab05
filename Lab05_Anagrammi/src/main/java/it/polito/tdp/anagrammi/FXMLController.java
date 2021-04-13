package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model=new Model();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button bttnAnagramma;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button bttnReset;
    
    @FXML
    private Label labelErroreInput;

    @FXML
    void doAnagramma(ActionEvent event) {
    	this.bttnReset.setDisable(false);
    	String input=this.txtInput.getText();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	if(!isCorretta(input)) {
    		this.labelErroreInput.setText("ERRORE: input non valido");
    		return;
    	}
    	input=input.toLowerCase();
    	List<Anagramma>anagrammi= model.anagrammi(input);
    	for(Anagramma a:anagrammi) {
    		if(a.isCorretta()) {
    			txtCorretti.appendText(a.toString()+"\n");
    		}else {
    			txtErrati.appendText(a.toString()+"\n");
    		}
    	}
    	this.labelErroreInput.setText(null);
    }

    private boolean isCorretta(String input) {
		if(input.isBlank()) {
			return false;
		}else if(input.matches(".[a-zA-Z]*")) {
			return true;
		}
		return false;
	}

	@FXML
    void doReset(ActionEvent event) {
		this.txtCorretti.clear();
		this.txtErrati.clear();
		this.txtInput.clear();
		this.labelErroreInput.setText(null);
		this.bttnReset.setDisable(true);
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bttnAnagramma != null : "fx:id=\"bttnAnagramma\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErratti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bttnReset != null : "fx:id=\"bttnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert labelErroreInput != null : "fx:id=\"labelErroreInput\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
