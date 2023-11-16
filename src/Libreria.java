public class Libreria {

        private int id;
        private String nombreLibreria;
        private String direccion;

        public Libreria() {

        }

    public Libreria(String nombreLibreria, String direccion) {
        this.nombreLibreria = nombreLibreria;
        this.direccion = direccion;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLibreria() {
        return nombreLibreria;
    }

    public void setNombreLibreria(String nombreLibreria) {
        this.nombreLibreria = nombreLibreria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
