import java.sql.*;
import java.lang.*;
import java.sql.Connection;

public class Insert {
    Connection conn = ConnectionProperties.getConnection();
    Statement stmt = null;
    String insert_produkt, insert_material, insert_typ;
    float insert_cena;

    public void setInsert_produkt(String insert_produkt){
        this.insert_produkt = insert_produkt;
    }

    public void setInsert_material(String insert_material) {
        this.insert_material = insert_material;
    }

    public void setInsert_typ(String insert_typ) {
        this.insert_typ = insert_typ;
    }

    public void setInsert_cena(float insert_cena) {
        this.insert_cena = insert_cena;
    }

    public void setInsert() {

        try {

            String query = "insert into produkt(nazwa_prod,material,typ,cena) " +
                    "values('" + insert_produkt + "','" + insert_material + "','" + insert_typ + "','" + insert_cena + "')";
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        } catch (SQLException e) {
            // komunikaty o bledach
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }
    public void insertLog4j(){
        Log4j.logger.trace("Wykonales zapytanie: insert into produkt(nazwa_prod,material,typ,cena)" +
                " nazwa_prod=" + insert_produkt +
                ", material=" + insert_material +
                ", typ=" + insert_typ +
                ", cena=" + insert_cena + "\n");
    }
}
