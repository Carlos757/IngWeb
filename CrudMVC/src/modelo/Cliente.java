
package modelo;

public class Cliente {
    private String rfc;
    private String nombre;
    private int edad;
    private int idCiudad;

    public Cliente(String rfc, String nombre, int edad, int idCiudad) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.edad = edad;
        this.idCiudad = idCiudad;
    }

    public Cliente(String rfc) {
        this.rfc = rfc;
    }
    public Cliente() {
       //
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    
}
