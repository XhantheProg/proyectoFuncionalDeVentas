import java.util.List;
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




        public void mostrarLibros() {
            MostrarLibroDAO mostrarLibroDAO = new MostrarLibroDAO();
            List<Libreria.Libro> libros = mostrarLibroDAO.obtenerTodosLosLibros();

            if (libros.isEmpty()) {
                System.out.println("No hay libros disponibles.");
            } else {
                System.out.println("--- Listado de Libros ---");
                for (Libreria.Libro libro : libros) {
                    System.out.println("ID: " + libro.getId());
                    System.out.println("Nombre: " + libro.getNombreLibro());
                    System.out.println("Categoría: " + libro.getCategoria());
                    System.out.println("Autor: " + libro.getAutor());
                    System.out.println("------------------------");
                }
            }
        }


    public void borrarLibro() {
        Scanner scanner = new Scanner(System.in);
        MostrarLibroDAO mostrarLibroDAO = new MostrarLibroDAO();

        System.out.println("--- Menú de Borrado de Libros ---");
        System.out.println("1. Borrar un libro por ID");
        System.out.println("2. Borrar todos los libros");
        System.out.print("Elija una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el ID del libro a borrar: ");
                int idLibro = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                if (mostrarLibroDAO.existeLibro(idLibro)) {
                    BorrarLibroDAO.borrarLibroPorID(idLibro);
                    System.out.println("El libro con ID " + idLibro + " ha sido eliminado.");
                } else {
                    System.out.println("No se encontró ningún libro con el ID proporcionado.");
                }
                break;
            case 2:
                BorrarLibroDAO.borrarTodosLosLibros();
                System.out.println("Todos los libros han sido eliminados.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    }
