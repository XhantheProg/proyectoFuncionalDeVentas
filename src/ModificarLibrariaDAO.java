import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificarLibrariaDAO {

    public static void actualizarDireccion(Libreria lib) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE libreria SET direccion = ? WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, lib.getDireccion());
                ps.setInt(2, lib.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarDireccionN(Libreria lib) {
        Conexion db_connect = new Conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE libreria SET nombre = ? WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, lib.getNombreLibreria()); // Corregir aquí
                ps.setInt(2, lib.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
