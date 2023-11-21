import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;





public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibreriaService libreriaService = new LibreriaService();
        LibroService libroService = new LibroService();

        int opcion;
        do {
            System.out.println("\n--- Menú de Biblioteca ---");
            System.out.println("1. Crear Librería");
            System.out.println("2. Editar Librería");
            System.out.println("3. Mostrar Librerías");
            System.out.println("4. Borrar Librerías");
            System.out.println("5. Libros");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    libreriaService.crearLibreria();
                    break;
                case 2:
                    libreriaService.editarLibreria();
                    break;
                case 3:
                    libreriaService.mostrarLibrerias();
                    break;
                /*case 4:
                    libreriaService.borrarLibreria();
                    break;*/
                case 5:
                    menuLibros(libroService, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void menuLibros(LibroService libroService, Scanner scanner) {
        int opcionLibros;
        do {
            System.out.println("\n--- Menú de Libros ---");
            System.out.println("1. Crear Libro");
            System.out.println("2. Editar Libro");
            System.out.println("3. Mostrar Libros");
            System.out.println("4. Borrar Libro");
            System.out.println("5. Volver");
            System.out.print("Elija una opción: ");

            opcionLibros = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcionLibros) {
                case 1:
                    libroService.crearLibro();
                    break;
                case 2:
                    libroService.editarLibro();
                    break;
                /*case 3:
                    libroService.mostrarLibros();
                    break;
                case 4:
                    libroService.borrarLibro();
                    break;*/
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcionLibros != 5);
    }
}