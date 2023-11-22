import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditarEmpleadoDAO {

    public static void editarEmpleadoDB(Libreria.Empleado empleado) {
        Conexion dbConnect = new Conexion();

        try (Connection conexion = dbConnect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE empleados SET Nombre = ?, Apellido = ?, Cargo = ? WHERE Nombre = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, empleado.getNombre());
                ps.setString(2, empleado.getApellido());
                ps.setString(3, empleado.getCargo());


                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
                // Manejo de excepciones durante la actualización
            } finally {
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
            // Manejo de excepciones de conexión
        }
    }
}
