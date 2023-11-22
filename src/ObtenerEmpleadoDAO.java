import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObtenerEmpleadoDAO {


    public Libreria.Empleado obtenerEmpleadoPorNombre(String nombre) {
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Libreria.Empleado empleado = null;

        try {
            Conexion db = new Conexion();
            conexion = db.get_conConnection(); // Obtener la conexión desde la clase Conexion

            String query = "SELECT id, Apellido, Cargo FROM empleados WHERE Nombre = ?";
            ps = conexion.prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {

                String apellido = rs.getString("Apellido");
                String cargo = rs.getString("Cargo");

                empleado = new Libreria.Empleado( nombre, apellido, cargo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de excepciones
        } finally {
            Conexion.cerrarRecursos(rs, ps, conexion);
        }

        return empleado;
    }

    public List<Libreria.Empleado> obtenerTodosLosEmpleados() {
        List<Libreria.Empleado> empleados = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Conexion db = new Conexion();
            conexion = db.get_conConnection();

            String query = "SELECT id, Nombre, Apellido, Cargo FROM empleados";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String cargo = rs.getString("cargo");

                Libreria.Empleado empleado = new Libreria.Empleado( nombre, apellido, cargo);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de excepciones
        } finally {
            Conexion.cerrarRecursos(rs, ps, conexion);
        }

        return empleados;
    }
}
