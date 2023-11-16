import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DireccionDAO {
    public static void AñadirDireccion(Libreria lib) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `libreria`.`direccion` (`Nombre_de_Direccion`) VALUES (?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, lib.getDireccion());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
