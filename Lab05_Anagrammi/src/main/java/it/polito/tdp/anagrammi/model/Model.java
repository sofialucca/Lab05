package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Model {

	public List<String> anagrammi(String stringa){
		List<String> risultato=new LinkedList<>();
		String parziale="";
		ricorsiva(risultato, stringa,parziale);
		return risultato;
	}

	private void ricorsiva(List<String> risultato, String stringa, String parziale) {
		if(stringa.length()==0) {
			risultato.add(parziale);
		}else {
			for(int i=0;i<stringa.length();i++) {
				String nuovaStringa=stringa.substring(0,i)+stringa.substring(i+1, stringa.length());
				String nuovaParziale=parziale+stringa.charAt(i);
				ricorsiva(risultato,nuovaStringa,nuovaParziale);
			}
		}
		
	}
}
