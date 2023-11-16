import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcion;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n--- Menú de Biblioteca ---");
            System.out.println("1. Crear Librería");
            System.out.println("2. Editar Librería");
            System.out.println("3. Mostrar Librerías");
            System.out.println("4. Borrar Librerías");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    LibreriaService.crearLibreria();
                    break;
                        case 2:
                            LibreriaService.editarLibreria();
                            break;
                        /*case 3:
                            mostrarLibrerias();
                            break;
                        case 4:
                            borrarLibrerias();
                            break;
                        case 5:
                            System.out.println("Saliendo del programa...");
                            break;*/
                default:
                    System.out.println("Opción inválida. Por favor, elija una opción del 1 al 5.");
            }
        } while (opcion != 5);
    }




            /*private void editarLibreria() {
                System.out.println("\n--- Editar Librería ---");
                System.out.print("Ingrese el ID de la librería a editar: ");
                int id = obtenerEntero();

                for (Libreria libreria : librerias) {
                    if (libreria.getId() == id) {
                        System.out.print("Ingrese el nuevo nombre de la librería (presione Enter para no cambiar): ");
                        String nuevoNombre = scanner.nextLine();
                        if (!nuevoNombre.isEmpty()) {
                            libreria.setNombre(nuevoNombre);
                        }

                        System.out.print("Ingrese la nueva dirección de la librería (presione Enter para no cambiar): ");
                        String nuevaDireccion = scanner.nextLine();
                        if (!nuevaDireccion.isEmpty()) {
                            libreria.setDireccion(nuevaDireccion);
                        }

                        System.out.println("Librería editada correctamente.");
                        return;
                    }
                }

                System.out.println("No se encontró ninguna librería con el ID proporcionado.");
            }

            private void mostrarLibrerias() {
                System.out.println("\n--- Mostrar Librerías ---");
                System.out.println("Total de librerías creadas: " + librerias.size());
            }

            private void borrarLibrerias() {
                System.out.println("\n--- Borrar Librerías ---");
                System.out.println("1. Borrar una librería específica");
                System.out.println("2. Borrar todas las librerías");
                System.out.print("Elija una opción: ");

                int opcion = obtenerEntero();
                switch (opcion) {
                    case 1:
                        borrarLibreriaEspecifica();
                        break;
                    case 2:
                        librerias.clear();
                        System.out.println("Todas las librerías han sido borradas.");
                        break;
                    default:
                        System.out.println("Opción inválida.");
                }
            }

            private void borrarLibreriaEspecifica() {
                System.out.println("\n--- Borrar una Librería Específica ---");
                System.out.print("Ingrese el ID de la librería a borrar: ");
                int id = obtenerEntero();

                for (int i = 0; i < librerias.size(); i++) {
                    if (librerias.get(i).getId() == id) {
                        librerias.remove(i);
                        System.out.println("Librería eliminada correctamente.");
                        return;
                    }
                }

                System.out.println("No se encontró ninguna librería con el ID proporcionado.");
            }

            private int obtenerEntero() {
                int num;
                while (true) {
                    try {
                        num = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer del scanner
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número válido.");
                        scanner.nextLine(); // Limpiar el buffer del scanner
                    }
                }
                return num;
            }
        }

        /*public class MenuBiblioteca {
            public static void main(String[] args) {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.mostrarMenu();
            }
        }*/
    }
