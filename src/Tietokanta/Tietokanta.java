package Tietokanta;

import java.sql.*;

public class Tietokanta {

    private Connection connect() {
        String osoite = "jdbc:sqlite:src/Tietokanta/Varaukset.db";
        Connection yhteys = null;
        try {
            yhteys = DriverManager.getConnection(osoite);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yhteys;
    }


    public void laitaTietokantaan(String asiakkaanNimi, int paikkojenLkm, int sali, String elokuvanNimi) {
        String sql = "INSERT INTO varaukset(ASIAKKAAN_NIMI,PAIKKOJEN_LKM, SALI, ELOKUVAN_NIMI) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, asiakkaanNimi);
            pstmt.setInt(2, paikkojenLkm);
            pstmt.setInt(3, sali);
            pstmt.setString(4, elokuvanNimi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void haeTietokannasta(String asiakkaanNimi) {
        String sql = "SELECT * FROM varaukset WHERE ASIAKKAAN_NIMI = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1,asiakkaanNimi);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set

            int varaustenLkm = 1;
            while (rs.next()) {
                System.out.println();
                System.out.println("Varaus " + varaustenLkm);
                System.out.println("VARAUSTUNNUS: " + rs.getInt("id") +  "\n" +
                        "VARAAJA: " + rs.getString("ASIAKKAAN_NIMI") + "\n" +
                        "VARAAMASI PAIKKOJEN MÄÄRÄ: " + rs.getInt("PAIKKOJEN_LKM") + "\n" +
                        "SALI NUMERO: " + rs.getInt("SALI") + "\n" +
                        "ELOKUVAN NIMI: " + rs.getString("ELOKUVAN_NIMI"));
                System.out.println();
                varaustenLkm++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int haeSalinumero(int varausTunnus) {
        String sql = "SELECT SALI FROM varaukset WHERE ID = ?";

        return haeArvoja(varausTunnus, sql);
    }

    public int haePaikat(int varausTunnus) {
        String sql = "SELECT PAIKKOJEN_LKM FROM varaukset WHERE ID = ?";

        return haeArvoja(varausTunnus, sql);
    }

    private int haeArvoja(int varausTunnus, String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,varausTunnus);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set

            while (rs.next()) {
                return rs.getInt("SALI");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public void poistaTietokannasta(int varaustunnus, String asiakkaanNimi) {
        String sql = "DELETE FROM varaukset WHERE ID = ? AND ASIAKKAAN_NIMI = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, varaustunnus);
            pstmt.setString(2, asiakkaanNimi);
            // execute the delete statement
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
 