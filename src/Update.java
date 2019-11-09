import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    Connection conn = ConnectionProperties.getConnection();
    int update_id;
    String update_produkt,update_material,update_typ;
    float update_cena;
    Statement stmt = null;

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }

    public void setUpdate_produkt(String update_produkt) {
        this.update_produkt = update_produkt;
    }

    public void setUpdate_material(String update_material) {
       this.update_material=update_material;
    }

    public void setUpdate_typ(String update_typ) {
        this.update_typ = update_typ;
    }

    public void setUpdate_cena(float update_cena) {
        this.update_cena = update_cena;
    }


    public void setUpdate(){
        try {

            String query="update produkt SET nazwa_prod='" + update_produkt + "'"
                    +", material='" + update_material +"'"
                    +", typ='" + update_typ +"'"
                    +", cena='" + update_cena +"'"
                    +"where id_prod='" + update_id +"'";

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
    public void updateLog4j(){
        Log4j.logger.trace("Wykonales zapytanie: update produkt SET" +
                " nazwa_prod=" + update_produkt +
                ", material=" + update_material +
                ", typ=" + update_typ +
                ", cena=" + update_cena + "\n");
    }

    }

