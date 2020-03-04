package Tietokanta;

import Luokat.Sali;

import java.sql.*;
import java.util.ArrayList;

public class Tietokanta {
    private String virhe;

    public Tietokanta() {
        virhe = "Virhe yhdistettäessä tietokantaan!";
    }

    private Connection connect() {
        String osoite = "jdbc:sqlite:src/Tietokanta/Varaukset.db";
        Connection yhteys = null;
        try {
            yhteys = DriverManager.getConnection(osoite);
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
        return yhteys;
    }

    //SALIT
    public void lisaaSali(int saliNumero, int paikkojenLkm, String elokuva) {
        String sql = "INSERT INTO salit(SALI_NUMERO, PAIKAT, ELOKUVA) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, saliNumero);
            pstmt.setInt(2, paikkojenLkm);
            pstmt.setString(3, elokuva);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }

    }

    public String annaElokuva(int saliNumero) {
        String sql = "SELECT ELOKUVA FROM salit WHERE SALI_NUMERO = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, saliNumero);

            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                return rs.getString("ELOKUVA");
            }

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }

        return null;
    }

    public int annaVapaatPaikat(int saliNumero) {
        String sql = "SELECT PAIKAT FROM salit WHERE SALI_NUMERO = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, saliNumero);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                return rs.getInt("PAIKAT");
            }

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }
        return 0;
    }

    public ArrayList<Integer> annaSalitJoissaElokuva(String elokuva) {
        String sql = "SELECT SALI_NUMERO FROM salit WHERE ELOKUVA = ?";
        ArrayList<Integer> palautus = new ArrayList<>();

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, elokuva);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                palautus.add(rs.getInt("SALI_NUMERO"));
            }

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }
        return palautus;
    }

    public ArrayList<String> annaKaikkiElokuvat() {
        ArrayList<String> palautus = new ArrayList<>();
        String sql = "SELECT DISTINCT ELOKUVA FROM salit";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                palautus.add(rs.getString("ELOKUVA"));
            }

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }

        return palautus;
    }

    public void asetaElokuva(int saliNumero, String elokuva){
        String sql = "UPDATE salit SET ELOKUVA = ? WHERE SALI_NUMERO = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, elokuva);
            pstmt.setInt(2, saliNumero);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }
    }

    public void lisaaPaikkoja(int saliNumero, int lisattaviaPaikkoja) {
        String sql = "UPDATE salit SET PAIKAT = PAIKAT + ? WHERE SALI_NUMERO = ?";

        yhdista(saliNumero, lisattaviaPaikkoja, sql);
    }

    public int annaSali(int saliNumero) {
        String sql = "SELECT SALI_NUMERO FROM salit WHERE SALI_NUMERO = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1, saliNumero);

            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                return rs.getInt("SALI_NUMERO");
            }


        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }

        return 0;
    }

    private void yhdista(int saliNumero, int lisattaviaPaikkoja, String sql) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, lisattaviaPaikkoja);
            pstmt.setInt(2, saliNumero);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }
    }


    //VARAUKSET


    public void teeVaraus(String asiakkaanNimi, int paikkojenLkm, int sali, String elokuvanNimi) {
        String sql = "INSERT INTO varaukset(ASIAKKAAN_NIMI,PAIKKOJEN_LKM, SALI, ELOKUVAN_NIMI) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, asiakkaanNimi);
            pstmt.setInt(2, paikkojenLkm);
            pstmt.setInt(3, sali);
            pstmt.setString(4, elokuvanNimi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }
    }


    public void haeVaraukset(String asiakkaanNimi) {
        String sql = "SELECT * FROM varaukset WHERE ASIAKKAAN_NIMI = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, asiakkaanNimi);

            ResultSet rs = pstmt.executeQuery();


            int varaustenLkm = 1;
            while (rs.next()) {
                System.out.println("Varaus " + varaustenLkm);
                System.out.println("VARAUSTUNNUS: " + rs.getInt("id") + "\n" +
                        "VARAAJA: " + rs.getString("ASIAKKAAN_NIMI") + "\n" +
                        "VARAAMASI PAIKKOJEN MÄÄRÄ: " + rs.getInt("PAIKKOJEN_LKM") + "\n" +
                        "SALI NUMERO: " + rs.getInt("SALI") + "\n" +
                        "ELOKUVAN NIMI: " + rs.getString("ELOKUVAN_NIMI"));
                varaustenLkm++;
                System.out.println();
            }

            if (varaustenLkm == 1) {
                System.out.println("Nimelläsi ei löydy yhtään varausta.");
                System.out.println();
            }

        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }
    }

    public int haeSalinumero(int varausTunnus) {
        String sql = "SELECT SALI FROM varaukset WHERE ID = ?";

        return haeArvoja(varausTunnus, sql, "SALI");
    }

    public int haePaikat(int varausTunnus) {
        String sql = "SELECT PAIKKOJEN_LKM FROM varaukset WHERE ID = ?";

        return haeArvoja(varausTunnus, sql, "PAIKKOJEN_LKM");
    }

    private int haeArvoja(int varausTunnus, String sql, String sarake) {
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1, varausTunnus);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                return rs.getInt(sarake);

            }


        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }

        return 0;
    }

    public boolean onkoVarausta(int varaustunnus, String asiakkaanNimi) {
        String sql = "SELECT 1 FROM varaukset WHERE ID = ? AND ASIAKKAAN_NIMI = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, varaustunnus);
            pstmt.setString(2, asiakkaanNimi);

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                return true;
            }


        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }

        return false;
    }

    public void poistaVaraus(int varaustunnus, String asiakkaanNimi) {
        String sql = "DELETE FROM varaukset WHERE ID = ? AND ASIAKKAAN_NIMI = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, varaustunnus);
            pstmt.setString(2, asiakkaanNimi);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            System.out.println(virhe);
        }
    }

}
 