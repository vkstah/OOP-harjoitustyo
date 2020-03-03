package Tietokanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tietokanta {
	
    private Connection connect() {
        String url = "jdbc:sqlite:VarauksetDB.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public void varaa(int id, String etunimi, String sukunimi, int elokuvaId, int saliId) {
		String sql = "INSERT INTO VARAUKSET(Id, Etunimi, Sukunimi, ElokuvaId, SaliId) VALUES (?,?)";
		try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, etunimi);
            pstmt.setString(3, sukunimi);
            pstmt.setInt(4, elokuvaId);
            pstmt.setInt(5, saliId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void poistaVaraus() {
		
	}
	
	public static void main(String args[]) {
		
		Tietokanta t = new Tietokanta();
		t.varaa(20, "vili", "stahlberg", 30, 5);
	}
}
