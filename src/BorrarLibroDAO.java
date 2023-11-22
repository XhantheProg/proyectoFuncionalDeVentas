import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BorrarLibroDAO {
    public static void borrarLibroPorID(int idLibro) {
        Conexion conexion = new Conexion();
        try (Connection connection = conexion.get_conConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM libro WHERE id = ?")) {
            statement.setInt(1, idLibro);
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Libro eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún libro con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el libro por ID: " + e.getMessage());
        }
    }

    public static void borrarTodosLosLibros() {
        Conexion conexion = new Conexion();
        try (Connection connection = conexion.get_conConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM libro")) {
            int filasAfectadas = statement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Todos los libros han sido eliminados.");
            } else {
                System.out.println("No hay libros para eliminar en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar todos los libros: " + e.getMessage());
        }
    }
}
