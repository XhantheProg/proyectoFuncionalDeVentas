import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AgregarEmpleadoDAO {
    public static void agregarEmpleadoDB(Libreria.Empleado empleado) {
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO empleados (Nombre, Apellido, Cargo) VALUES (?, ?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, empleado.getNombre());
                ps.setString(2, empleado.getApellido());
                ps.setString(3, empleado.getCargo());
                ps.executeUpdate();
                // Commit después de la inserción
                conexion.commit();
                System.out.println("Empleado agregado exitosamente a la base de datos.");
            } catch (SQLException ex) {
                System.out.println("Error al insertar el empleado: " + ex.getMessage());
                // Realiza un rollback en caso de error
                conexion.rollback();
            }
        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
    }
}
