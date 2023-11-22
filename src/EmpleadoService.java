import java.util.Scanner;

public class EmpleadoService {

    public void agregarEmpleado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAñadir Empleado");
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del empleado: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el cargo del empleado: ");
        String cargo = scanner.nextLine();

        Libreria.Empleado nuevoEmpleado = new Libreria.Empleado(nombre, apellido, cargo);

        AgregarEmpleadoDAO.agregarEmpleadoDB(nuevoEmpleado);

        System.out.println("Empleado agregado con éxito.");
    }
}

