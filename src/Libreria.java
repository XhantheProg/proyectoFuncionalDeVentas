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

    public static class Libro {
        private int id;
        private String nombreLibro;
        private String categoria;
        private String autor;

        public Libro(int id, String nombreLibro, String categoria, String autor) {
            this.id = id;
            this.nombreLibro = nombreLibro;
            this.categoria = categoria;
            this.autor = autor;
        }



        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombreLibro() {
            return nombreLibro;
        }

        public void setNombreLibro(String nombreLibro) {
            this.nombreLibro = nombreLibro;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }
    }
}
