import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MostrarLibroDAO {




    private static Connection obtenerConexion() throws SQLException {
        // Usa la clase Conexion para obtener la conexión a la base de datos
        Conexion conexion = new Conexion();
        return conexion.get_conConnection();
    }

    public List<Libreria.Libro> obtenerTodosLosLibros() {
        List<Libreria.Libro> listaLibros = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = obtenerConexion();
            String query = "SELECT * FROM libro";
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String categoria = rs.getString("categoria");
                String autor = rs.getString("autor");

                Libreria.Libro libro = new Libreria.Libro(id, nombre, categoria, autor);


                listaLibros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo básico de errores, puedes cambiarlo según tu caso
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement y Connection)
            cerrarRecursos(rs, ps, connection);
        }

        return listaLibros;
    }

    // Método para cerrar recursos
    private void cerrarRecursos(ResultSet rs, PreparedStatement ps, Connection connection) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Libreria.Libro obtenerLibroPorId(int id) {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Libreria.Libro libro = null;

        try {
            conexion = obtenerConexion();
            String query = "SELECT id, NombreDelLibro, Categoria, Autor FROM libro WHERE id = ?";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int libroId = resultSet.getInt("id");
                String nombre = resultSet.getString("NombreDelLibro");
                String categoria = resultSet.getString("Categoria");
                String autor = resultSet.getString("Autor");

                // Crear un objeto Libro con los datos obtenidos de la base de datos
                libro = new Libreria.Libro(libroId, nombre, categoria, autor);
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        } finally {
            // Cerrar los recursos en el orden inverso de su apertura para evitar fugas de recursos
            Conexion.cerrarRecursos(resultSet, statement, conexion); // Reemplaza este método con tu lógica de cierre
        }

        return libro;
    }
}
