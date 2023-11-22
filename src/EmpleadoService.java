import java.util.List;
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

        // Crear el nuevo empleado sin especificar el ID
        Libreria.Empleado nuevoEmpleado = new Libreria.Empleado(nombre, apellido, cargo);

        // Llamar al método para agregar el nuevo empleado
        AgregarEmpleadoDAO.agregarEmpleadoDB(nuevoEmpleado);

        System.out.println("Empleado agregado con éxito.");
    }


    public void mostrarEmpleados() {
        ObtenerEmpleadoDAO obtenerEmpleadoDAO = new ObtenerEmpleadoDAO();
        List<Libreria.Empleado> listaEmpleados = obtenerEmpleadoDAO.obtenerTodosLosEmpleados();

        if (!listaEmpleados.isEmpty()) {
            System.out.println("\nListado de Empleados:");
            for (Libreria.Empleado empleado : listaEmpleados) {
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getApellido());
                System.out.println("Cargo: " + empleado.getCargo());
                System.out.println("--------------------");
            }
        } else {
            System.out.println("No se encontraron empleados.");
        }
    }



    public void editarEmpleado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEditar Empleado");
        System.out.print("Ingrese el nombre del empleado a editar: ");
        String nombreEmpleado = scanner.nextLine();

        ObtenerEmpleadoDAO obtenerEmpleadoDAO = new ObtenerEmpleadoDAO();
        Libreria.Empleado empleado = obtenerEmpleadoDAO.obtenerEmpleadoPorNombre(nombreEmpleado);

        if (empleado != null) {
            System.out.println("Empleado encontrado:");
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Apellido: " + empleado.getApellido());
            System.out.println("Cargo: " + empleado.getCargo());

            // Aquí puedes solicitar los nuevos datos para el empleado
            System.out.print("Ingrese el nuevo nombre del empleado: ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Ingrese el nuevo apellido del empleado: ");
            String nuevoApellido = scanner.nextLine();

            System.out.print("Ingrese el nuevo cargo del empleado: ");
            String nuevoCargo = scanner.nextLine();

            // Actualizar los datos del empleado con los nuevos valores
            empleado.setNombre(nuevoNombre);
            empleado.setApellido(nuevoApellido);
            empleado.setCargo(nuevoCargo);

            // Llamar al método en el DAO para editar el empleado con los nuevos datos
            EditarEmpleadoDAO.editarEmpleadoDB(empleado);

            System.out.println("Empleado editado con éxito.");
        } else {
            System.out.println("No se encontró el empleado con el nombre ingresado.");
        }
    }


    public void borrarEmpleado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nOpciones para borrar empleados:");
        System.out.println("1. Borrar un empleado específico por nombre.");
        System.out.println("2. Borrar todos los empleados.");

        System.out.print("Seleccione una opción (1 o 2): ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                borrarEmpleadoPorNombre();
                break;
            case 2:
                borrarTodosLosEmpleados();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void borrarEmpleadoPorNombre() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del empleado a borrar: ");
        String nombreEmpleado = scanner.nextLine();

        // Llamar al método en el DAO para borrar el empleado por nombre
        EliminarEmpleadoDAO.borrarEmpleadoPorNombre(nombreEmpleado);

        System.out.println("Empleado '" + nombreEmpleado + "' borrado con éxito.");
    }

    private void borrarTodosLosEmpleados() {
        // Llamar al método en el DAO para borrar todos los empleados
        EliminarEmpleadoDAO.borrarTodosLosEmpleados();

        System.out.println("Todos los empleados han sido borrados.");
    }



}