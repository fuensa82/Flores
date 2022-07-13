/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.Beans;

/**
 *
 * @author vPalomo
 */
public class FlorBean {

    private String idFlor;
    private String idFamilia;
    private String nombreFamilia;
    private String nombre;
    private int duracion;
    private String color;
    private int cantidad; // Se utilizará para saber la cantidad en una composicion o encargo
    private int cantMinima;
    private int cantidadAlmacen;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public String getIdFlor() {
        return idFlor;
    }

    public void setIdFlor(String idFlor) {
        this.idFlor = idFlor;
    }

    public String getIdFamilia() {
        return idFamilia;
    }

    public void setIdFamilia(String idFamilia) {
        this.idFamilia = idFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantMinima() {
        return cantMinima;
    }

    public void setCantMinima(int cantMinima) {
        this.cantMinima = cantMinima;
    }

    public int getCantidadAlmacen() {
        return cantidadAlmacen;
    }

    public void setCantidadAlmacen(int cantidadAlmacen) {
        this.cantidadAlmacen = cantidadAlmacen;
    }
}
