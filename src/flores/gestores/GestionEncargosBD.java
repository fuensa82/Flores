/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.gestores;

import flores.Beans.ComposicionBean;
import flores.Beans.EncargoBean;
import flores.Beans.FlorBean;
import flores.utils.ConectorBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author vPalomo
 */
public class GestionEncargosBD {

    public static int setEncargoNuevo(String nombre, String fechaEntrega) {
        return setEncargoNuevo(nombre, fechaEntrega, "0");
    }
    public static int setEncargoNuevo(String nombre, String fechaEntrega, String idCliente) {
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            // INSERT INTO `hospitalidad`.`autobuses` (`Descripcion`, `PlazasNoEnfermos`, `PlazasEnfermos`, `Observaciones`, `idViaje`) VALUES ('Nº 2', '10', '9', 'Ninguna', '1');

            PreparedStatement insert1 = conexion.prepareStatement("INSERT INTO `flores`.`encargos` (`NombreComposicion`, `FechaEntrega`, `Estado`, idCliente) VALUES (?, ?, 'Pendiente', ?);");
            insert1.setString(1, nombre);
            insert1.setString(2, fechaEntrega);
            insert1.setString(3, idCliente);
            System.out.println(insert1);
            int fila = insert1.executeUpdate();
            if (fila == 1) {
                PreparedStatement consultaId = conexion.prepareStatement("SELECT LAST_INSERT_ID()");
                ResultSet resultado = consultaId.executeQuery();
                if (resultado.next()) {
                    int id = resultado.getInt(1);
                    System.out.println("Ultimo id insertado: " + id);
                    return id; //Todo correcto
                }
            }
            return 0; //Error

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestionComposicionesBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0; //Error
    }
    
    public static int setEncargoNuevoFlores(int idEncargo, int idFlor, int cantidad) {
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement insert1 = conexion.prepareStatement("INSERT INTO `flores`.`floresencargo` (`idEncargo`, `idFlor`, `Cantidad`) VALUES (?, ?, ?);");
            insert1.setInt(1, idEncargo);
            insert1.setInt(2, idFlor);
            insert1.setInt(3, cantidad);
            System.out.println(insert1);
            int fila = insert1.executeUpdate();
            return fila; //Error

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestionComposicionesBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0; //Error
    }
    
    public static int cambiarEstado(String estadoNuevo, String idEncargo) {
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement insert1 = conexion.prepareStatement("UPDATE `flores`.`encargos` SET `Estado`=? WHERE  `idEncargo`=?");
            insert1.setString(2, idEncargo);
            insert1.setString(1, estadoNuevo);
            System.out.println(insert1);
            int fila = insert1.executeUpdate();
            return fila; //Error

        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(GestionComposicionesBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0; //Error
    }
    
    public static DefaultComboBoxModel getModeloComboEstados() {
        ArrayList<String> lista = getListaEstados();
        String[] modelo = new String[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            modelo[i] = lista.get(i);
        }
        return new javax.swing.DefaultComboBoxModel<>(modelo);

    }

    public static ArrayList<String> getListaEstados() {
        ArrayList<String> listaEstados=new ArrayList<>();
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement("select nombre FROM estadosencargos order by orden");

            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                listaEstados.add(resultado.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException ex) {

        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
            }
        }
        return listaEstados;
    }
    
    public static ArrayList<EncargoBean> getListaEncargos(String estado){
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT idEncargo,encargos.idCliente,NombreComposicion,FechaAlta,FechaEntrega,Estado,Nombre " +
                    "FROM clientes, encargos " +
                    "WHERE clientes.IdCliente=encargos.idCliente AND estado=? " +
                    "UNION " +
                    "SELECT idEncargo,encargos.idCliente,NombreComposicion,FechaAlta,FechaEntrega,Estado, 'Sin cliente' AS Nombre " +
                    "FROM encargos " +
                    "WHERE encargos.idCliente=0 AND estado=? ");
            consulta.setString(1, estado);
            consulta.setString(2, estado);
            System.out.println(consulta);
            ResultSet resultado = consulta.executeQuery();
            ArrayList<EncargoBean> lista = new ArrayList();
            EncargoBean encargo;
            while (resultado.next()) {
                encargo=new EncargoBean();
                encargo.setIdEncargo(resultado.getString(1));
                encargo.setIdCliente(resultado.getString(2));
                encargo.setNombreComposicion(resultado.getString(3));
                encargo.setFechaAlta(resultado.getString(4));
                encargo.setFechaEntrega(resultado.getString(5));
                encargo.setEstado(resultado.getString(6));
                encargo.setNombreCliente(resultado.getString(7));
                lista.add(encargo);
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
    
    
    
    /**
     * Devuelve la lista de flores que lleva un encargo en cuestion
     * @param idEncargo
     * @return 
     */
    public static ArrayList<FlorBean> getListaFloresEncargo(String idEncargo){
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT flores.idFlor, familias.Nombre AS nombreFam, flores.Nombre, Color, floresencargo.Cantidad " +
                    "FROM flores, floresencargo, familias " +
                    "WHERE flores.idFamilia=familias.idFamilia AND " +
                    "	flores.idFlor=floresencargo.idFlor AND floresencargo.idEncargo=?");
            consulta.setString(1, idEncargo);
            System.out.println(consulta);
            ResultSet resultado = consulta.executeQuery();
            ArrayList<FlorBean> lista = new ArrayList();
            FlorBean flor;
            while (resultado.next()) {
                flor=new FlorBean();
                flor.setIdFlor(resultado.getString(1));
                flor.setIdFamilia(resultado.getString(2));
                flor.setNombre(resultado.getString(3));
                flor.setColor(resultado.getString(4));
                flor.setCantidad(resultado.getInt(5));
                lista.add(flor);
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
