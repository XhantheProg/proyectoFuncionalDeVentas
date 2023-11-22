import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarEmpleadoDAO {

    public static void borrarEmpleadoPorNombre(String nombreEmpleado) {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            Conexion db = new Conexion();
            conexion = db.get_conConnection(); // Obtener la conexión desde la clase Conexion

            String query = "DELETE FROM empleados WHERE nombre = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombreEmpleado);
            ps.executeUpdate();

            System.out.println("Empleado '" + nombreEmpleado + "' ha sido eliminado.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de excepciones
        } finally {
            Conexion.cerrarRecursos(null, ps, conexion);
        }
    }

    public static void borrarTodosLosEmpleados() {
        Connection conexion = null;
        PreparedStatement ps = null;

        try {
            Conexion db = new Conexion();
            conexion = db.get_conConnection(); // Obtener la conexión desde la clase Conexion

            String query = "DELETE FROM empleados";
            ps = conexion.prepareStatement(query);
            ps.executeUpdate();

            System.out.println("Todos los empleados han sido eliminados.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de excepciones
        } finally {
            Conexion.cerrarRecursos(null, ps, conexion);
        }
    }
}
