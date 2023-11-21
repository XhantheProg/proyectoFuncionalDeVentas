import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrarDatosLibreriaDAO {
    public static void borrarLibreriaPorID(int idLibreria) {
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.get_conConnection()) {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM libreria WHERE id = ?");
            ps.setInt(1, idLibreria);
            ps.executeUpdate();
            System.out.println("Se ha eliminado la librería con ID: " + idLibreria + " de la base de datos.");
        } catch (SQLException e) {
            System.out.println("Error al intentar borrar la librería por ID: " + e.getMessage());
        }
    }

    public static void borrarTodo() {
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.get_conConnection()) {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM libreria");
            int filasEliminadas = ps.executeUpdate();
            System.out.println("Se han eliminado " + filasEliminadas + " datos creados de la tabla libreria.");
        } catch (SQLException e) {
            System.out.println("Error al intentar borrar los datos creados: " + e.getMessage());
        }
    }

}