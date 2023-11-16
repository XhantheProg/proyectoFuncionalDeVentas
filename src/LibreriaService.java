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
        }

        if (!nuevaDireccion.isEmpty()) {
            libreria.setDireccion(nuevaDireccion);
        }
        ModificarLibrariaDAO.actualizarDireccionN(libreria); // Llamar al método para actualizar el nombre

        System.out.println("Librería editada correctamente.");
    }


    }


