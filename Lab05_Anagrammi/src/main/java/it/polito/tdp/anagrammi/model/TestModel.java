package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m=new Model();
		List<Anagramma> anagrammi=new LinkedList<>();
		anagrammi=m.anagrammi("hola");
		System.out.println(anagrammi);
	}

}
