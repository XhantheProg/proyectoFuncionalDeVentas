import java.util.Scanner;
import java.util.ArrayList;


public class LibroService {
    private Scanner scanner;
    private MostrarLibroDAO mostrarLibroDAO;

    public LibroService() {



        this.scanner = new Scanner(System.in);
        this.mostrarLibroDAO = new MostrarLibroDAO();
    }

    public void crearLibro() {
        System.out.println("\n--- Crear Libro ---");
        System.out.print("Ingrese el nombre del libro: ");
        String nombreLibro = scanner.nextLine();

        System.out.print("Ingrese la categoría del libro: ");
        String categoriaLibro = scanner.nextLine();

        System.out.print("Ingrese el autor del libro: ");
        String autorLibro = scanner.nextLine();

        Libreria.Libro libro = new Libreria.Libro(1, "Nombre del libro", "Categoria", "Autor");

        libro.setNombreLibro(nombreLibro);
        libro.setCategoria(categoriaLibro);
        libro.setAutor(autorLibro);


       CrearLibroDAO.crearLibroDB(libro);

        System.out.println("Libro creado exitosamente.");
    }

    public void editarLibro() {

        System.out.print("Ingrese el ID del libro a editar: ");
        int idLibro = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Lógica para obtener y editar el libro en base al ID
        Libreria.Libro libro = obtenerLibroPorId(idLibro);

        if (libro != null) {
            System.out.print("Ingrese el nuevo nombre del libro (presione Enter para no cambiar): ");
            String nuevoNombre = scanner.nextLine();
            if (!nuevoNombre.isEmpty()) {
                libro.setNombreLibro(nuevoNombre);
            }

            System.out.print("Ingrese la nueva categoría del libro (presione Enter para no cambiar): ");
            String nuevaCategoria = scanner.nextLine();
            if (!nuevaCategoria.isEmpty()) {
                libro.setCategoria(nuevaCategoria);
            }

            System.out.print("Ingrese el nuevo autor del libro (presione Enter para no cambiar): ");
            String nuevoAutor = scanner.nextLine();
            if (!nuevoAutor.isEmpty()) {
                libro.setAutor(nuevoAutor);
            }

            // Aquí deberías llamar al método en el DAO para actualizar los datos del libro en la base de datos
            actualizarLibroEnBaseDeDatos(libro);

            System.out.println("Libro editado correctamente.");
        } else {
            System.out.println("No se encontró ningún libro con el ID proporcionado.");
        }
    }

    // Métodos de búsqueda y actualización en la base de datos (simulados)
    private Libreria.Libro obtenerLibroPorId(int id) {
        return MostrarLibroDAO.obtenerLibroPorId(id);
    }

    private void actualizarLibroEnBaseDeDatos(Libreria.Libro libroActualizado) {
        EditarLibroDAO.editarLibroEnBaseDeDatos(libroActualizado);
    }
}
