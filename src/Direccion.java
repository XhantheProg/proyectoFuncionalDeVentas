public class Direccion {
int id;
String NombreDeDireccion;

public Direccion(){

}
    public Direccion(String nombreDeDireccion) {
        this.NombreDeDireccion = nombreDeDireccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDeDireccion() {
        return NombreDeDireccion;
    }

    public void setNombreDeDireccion(String nombreDeDireccion) {
        NombreDeDireccion = nombreDeDireccion;
    }
}
