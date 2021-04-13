package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		
		String sql="SELECT * "
				+ "FROM parola "
				+ "WHERE nome=?";
		try {
			Connection conn= ConnectDB.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, anagramma);
			ResultSet rs=st.executeQuery();
			
			if(rs.next()) {
				rs.close();
				st.close();
				conn.close();
				return true;
			}
			rs.close();
			st.close();
			conn.close();
			return false;
		}catch(SQLException sqle) {
			throw new RuntimeException("Errore DB",sqle);
		}
	}
}
