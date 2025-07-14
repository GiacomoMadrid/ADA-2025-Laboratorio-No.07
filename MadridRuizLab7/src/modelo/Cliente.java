
package modelo;

/**
 *
 * @author Giacomo
 */
public class Cliente {
    private String codigo;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String direccion;
    private String codigoPostal;

    public Cliente(String codigo, String nombres, String apellidos, String telefono, 
                  String correo, String direccion, String codigoPostal) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public String getTelefono() { return telefono; }
    public String getCorreo() { return correo; }
    public String getDireccion() { return direccion; }
    public String getCodigoPostal() { return codigoPostal; }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
               "Nombre: " + nombres + " " + apellidos + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Correo: " + correo + "\n" +
               "Dirección: " + direccion + "\n" +
               "Código Postal: " + codigoPostal;
    }
}
