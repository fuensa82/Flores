/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.Beans;

/**
 *
 * @author vPalomo
 */
public class EncargoBean {
    private String idEncargo;
    private String idCliente;
    private String nombreCliente;
    private String nombreComposicion;
    private String fechaAlta;
    private String fechaEntrega;
    private String estado;

    public String getIdEncargo() {
        return idEncargo;
    }

    public void setIdEncargo(String idEncargo) {
        this.idEncargo = idEncargo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreComposicion() {
        return nombreComposicion;
    }

    public void setNombreComposicion(String nombreComposicion) {
        this.nombreComposicion = nombreComposicion;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
