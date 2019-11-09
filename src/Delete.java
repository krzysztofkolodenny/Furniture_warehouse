import java.sql.*;
import java.sql.Connection;


public class Delete {
    Connection conn = ConnectionProperties.getConnection();
        Statement stmt = null;
        int delete_id;
    public void setDelete_id(int delete_id) {
        this.delete_id = delete_id;
    }

        public void setDelete()
        {
            try {

            String sql="delete FROM produkt where id_prod='" + delete_id +"'";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
            } catch (SQLException e) {
                // komunikaty o bledach
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            }
        }
    public void deleteLog4j(){
        Log4j.logger.trace("Wykonales zapytanie: delete FROM produkt where id_prod=" + delete_id + "\n");
    }
}
