import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearLibroDAO {
    public static void crearLibroDB(Libreria.Libro libro) {
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO libro (NombreDelLibro, Categoria, Autor) VALUES (?, ?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, libro.getNombreLibro());
                ps.setString(2, libro.getCategoria());
                ps.setString(3, libro.getAutor());
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error al insertar el libro: " + ex.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
}
