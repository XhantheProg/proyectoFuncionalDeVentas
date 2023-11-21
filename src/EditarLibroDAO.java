import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditarLibroDAO {
    public static void editarLibroEnBaseDeDatos(Libreria.Libro libro) {
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE libro SET NombreDelLibro = ?, Categoria = ?, Autor = ? WHERE id = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, libro.getNombreLibro());
                ps.setString(2, libro.getCategoria());
                ps.setString(3, libro.getAutor());
                ps.setInt(4, libro.getId()); // Asumiendo que el ID se establece en la clase Libro

                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
