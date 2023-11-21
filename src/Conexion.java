import java.sql.*;

/*public class Conexion {

    public Connection get_conConnection(){
        Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/venta","root","");
            if(conection!=null){
                System.out.println("Conexion exitosa ...... ");
            }
        }catch (SQLException e){
            System.out.println("Error: "+e);
        }
        return conection;
    }
}*/

import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class Conexion {
    public Connection get_conConnection() {
        Connection connection = null;
        try {
            // Asegúrate de reemplazar los valores con los correspondientes a tu configuración
            String url = "jdbc:mysql://localhost:3306/venta"; // Apunta a la base de datos 'venta'
            String user = "root";
            String password = "";

            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos 'venta'");
            }
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return connection;
    }



    public static void cerrarRecursos(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                // Manejo de excepciones
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                // Manejo de excepciones
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Manejo de excepciones
            }
        }
    }
}