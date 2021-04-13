package it.polito.tdp.anagrammi.DAO;

public class TestAnagrammaDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnagrammaDAO anaDao=new AnagrammaDAO();
		boolean risultato= anaDao.isCorrect("hola");
		System.out.print(risultato);
	}

}
