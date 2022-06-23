/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.gestores;

import flores.Beans.ClienteBean;
import flores.utils.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author vPalomo
 */
public class GestionClientesBD {
    public static ArrayList<ClienteBean> getListaClientes(){
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT Id,Nombre,Apellidos,Telefono,email,`Telefono 2`,`Direccion entrega` FROM clientes");
            System.out.println(consulta);
            ResultSet resultado = consulta.executeQuery();
            ArrayList<ClienteBean> lista = new ArrayList();
            ClienteBean cliente;
            while (resultado.next()) {
                cliente=new ClienteBean();
                cliente.setId(resultado.getString(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setApellidos(resultado.getString(3));
                cliente.setTelefono1(resultado.getString(4));
                cliente.setEmail(resultado.getString(5));
                cliente.setTelefono2(resultado.getString(6));
                cliente.setDirEntregaDefecto(resultado.getString(7));
                lista.add(cliente);
            }
            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException ex) {

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
            }
        }
        return null;
    }

    public static ArrayList<ClienteBean> getListaClientesConFiltro(String filtro) {
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT Id,Nombre,Apellidos,Telefono,email,`Telefono 2`,`Direccion entrega` FROM clientes "
                    + "where Apellidos LIKE ? OR Nombre LIKE ?");

            consulta.setString(1, "%" + filtro + "%");
            consulta.setString(2, "%" + filtro + "%");
            System.out.println(consulta);
            ResultSet resultado = consulta.executeQuery();
            ArrayList<ClienteBean> lista = new ArrayList();
            ClienteBean cliente;
            while (resultado.next()) {
                cliente=new ClienteBean();
                cliente.setId(resultado.getString(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setApellidos(resultado.getString(3));
                cliente.setTelefono1(resultado.getString(4));
                cliente.setEmail(resultado.getString(5));
                cliente.setTelefono2(resultado.getString(6));
                cliente.setDirEntregaDefecto(resultado.getString(7));
                lista.add(cliente);
            }
            return lista;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException ex) {

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
            }
        }
        return null;
    }
}
