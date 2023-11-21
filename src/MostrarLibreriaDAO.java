import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MostrarLibreriaDAO {

    public static void mostrarLibreriasdao() {
        Conexion dbConnect = new Conexion();
        try (Connection conexion = dbConnect.get_conConnection()) {
            PreparedStatement ps = conexion.prepareStatement("SELECT id, nombre, direccion FROM libreria");
            ResultSet rs = ps.executeQuery();

            System.out.println("--- Librerías almacenadas en la base de datos ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Dirección: " + direccion);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar las librerías: " + e.getMessage());
        }
    }
}
