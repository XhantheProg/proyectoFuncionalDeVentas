import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibreriaService {

    public static void crearLibreria() {
        Scanner sc= new Scanner(System.in);
        System.out.println("\n--- Crear Librería ---");
        System.out.print("Ingrese el nombre de la librería: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la dirección de la librería: ");
        String direccion = sc.nextLine();

        Libreria libreria = new Libreria();
        libreria.setNombreLibreria(nombre);
        libreria.setDireccion(direccion);

        LibreriaDAO.crearLibreriaDB(libreria);

        System.out.println("Librería creada exitosamente.");

        LibroService libroService = new LibroService();

        int opcionLibros = 0;
        while (opcionLibros != 5) {
            System.out.println("\n--- Menú de Libros ---");
            System.out.println("1. Crear Libro");
            System.out.println("2. Editar Libro");
            System.out.println("3. Mostrar Libros");
            System.out.println("4. Borrar Libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcionLibros = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del scanner

            switch (opcionLibros) {
                case 1:
                    libroService.crearLibro();
                    break;
                case 2:
                    libroService.editarLibro();
                    break;
                case 3:
                    libroService.mostrarLibros();
                    break;
                /*case 4:
                    libroService.borrarLibro();
                    break;
                case 5:
                    System.out.println("Saliendo del Menú de Libros...");
                    salir = true; // Salir del menú de libros para volver al menú anterior
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;*/
            }
        }
    }









    public static void editarLibreria() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Editar Librería ---");
        System.out.print("Ingrese el ID de la librería a editar: ");

        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.print("Ingrese el nuevo nombre de la librería (presione Enter para no cambiar): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese la nueva dirección de la librería (presione Enter para no cambiar): ");
        String nuevaDireccion = scanner.nextLine();

        Libreria libreria = new Libreria();
        libreria.setId(id);

        if (!nuevoNombre.isEmpty()) {
            libreria.setNombreLibreria(nuevoNombre);
            ModificarLibrariaDAO.actualizarDireccionN(libreria); // Actualizar el nombre
        }

        if (!nuevaDireccion.isEmpty()) {
            libreria.setDireccion(nuevaDireccion);
            ModificarLibrariaDAO.actualizarDireccion(libreria); // Actualizar la dirección
        }

        System.out.println("Librería editada correctamente.");
    }


    public static void mostrarLibrerias() {
        MostrarLibreriaDAO.mostrarLibreriasdao();
    }

    public static void borrarLibrerias() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción para borrar:");
        System.out.println("1. Borrar una librería específica por ID");
        System.out.println("2. Borrar todos los datos");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el ID de la librería a borrar: ");
                int idLibreria = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                BorrarDatosLibreriaDAO.borrarLibreriaPorID(idLibreria);
                break;
            case 2:
                System.out.println("¿Está seguro de borrar toda la base de datos? (S/N)");
                String confirmacion = scanner.nextLine().toUpperCase();
                if (confirmacion.equals("S")) {
                    BorrarDatosLibreriaDAO.borrarTodo();
                } else {
                    System.out.println("Operación de borrado cancelada.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }




    }









