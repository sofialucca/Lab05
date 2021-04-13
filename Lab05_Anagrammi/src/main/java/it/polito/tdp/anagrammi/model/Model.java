package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private AnagrammaDAO anagrammaDao=new AnagrammaDAO();
	
	public List<Anagramma> anagrammi(String stringa){
		List<Anagramma> risultato=new LinkedList<>();
		String parziale="";
		ricorsiva(risultato, stringa,parziale);
		return risultato;
	}

	private void ricorsiva(List<Anagramma> risultato, String stringa, String parziale) {
		if(stringa.length()==0) {
			boolean corretta=anagrammaDao.isCorrect(parziale);
			Anagramma nuovoAnagramma=new Anagramma(parziale,corretta);
			risultato.add(nuovoAnagramma);
			
		}else {
			for(int i=0;i<stringa.length();i++) {
				String nuovaStringa=stringa.substring(0,i)+stringa.substring(i+1, stringa.length());
				String nuovaParziale=parziale+stringa.charAt(i);
				ricorsiva(risultato,nuovaStringa,nuovaParziale);
			}
		}
		
	}
}
