/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.Beans;

/**
 *
 * @author vPalomo
 */
public class ClienteBean {
    private String id;
    private String nombre;
    private String apellidos;
    private String telefono1;
    private String telefono2;
    private String email;
    private String dirEntregaDefecto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDirEntregaDefecto() {
        return dirEntregaDefecto;
    }

    public void setDirEntregaDefecto(String dirEntregaDefecto) {
        this.dirEntregaDefecto = dirEntregaDefecto;
    }
}
