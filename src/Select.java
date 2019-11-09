import java.sql.*;
import java.lang.*;
import java.sql.Connection;
import java.lang.String;


public class Select {

    String query = "SELECT id_prod, nazwa_prod, material, typ, cena FROM produkt";

    Statement stmt = null;
    Connection conn = ConnectionProperties.getConnection();
    public void setSelect(){
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_prod = rs.getInt("id_prod");
                String nazwa_prod = rs.getString("nazwa_prod");
                String material = rs.getString("material");
                String typ = rs.getString("typ");
                float cena = rs.getFloat("cena");

                System.out.format("\n[%-11s] [%-14s] [%-8s] [%-3s] [%-4s]", id_prod, nazwa_prod, material, typ, cena);
            }
            conn.close();
        } catch (SQLException e) {
            // komunikaty o bledach
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    public void formatSelect(){

        System.out.format("[%-11s] [%-14s] [%-8s] [%-3s] [%-4s]", "id_produktu", "nazwa produktu", "material", "typ", "cena");
    }
    public void selectLog4j(){
        Log4j.logger.trace("Wykonales zapytanie: SELECT * FROM produkt");
    }


}
