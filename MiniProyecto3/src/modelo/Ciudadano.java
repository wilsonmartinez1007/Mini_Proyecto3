package modelo;

public class Ciudadano {
    private String nombre;
    private String cedula;

    private Ciudades ciudades;
    
    public Ciudadano(String nombre, String cedula, Ciudades ciudades) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.ciudades = ciudades;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
        
    }
    public String getCedula() {
        return this.cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Ciudades getCiudades() {
        return this.ciudades;
    }
    public void setCiudades(Ciudades ciudades) {
        this.ciudades = ciudades;
    }
    
}
