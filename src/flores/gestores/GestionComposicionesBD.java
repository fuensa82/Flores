/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.gestores;

import flores.Beans.ComposicionBean;
import flores.Beans.FlorBean;
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
public class GestionComposicionesBD {
    
    public static ArrayList<ComposicionBean> getListaComposiciones(){
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT idComposicion,Nombre,FechaAlta,Observaciones FROM composiciones");
            System.out.println(consulta);
            ResultSet resultado = consulta.executeQuery();
            ArrayList<ComposicionBean> lista = new ArrayList();
            ComposicionBean compo;
            while (resultado.next()) {
                compo=new ComposicionBean();
                compo.setIdComposicion(resultado.getString(1));
                compo.setNombre(resultado.getString(2));
                compo.setFechaAlta(resultado.getString(3));
                compo.setObservaciones(resultado.getString(4));
                lista.add(compo);
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
    
    public static ArrayList<FlorBean> getListaFloresCompo(String idCompo){
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT flores.idFlor, familias.Nombre AS nombreFam, flores.Nombre, Color, florescomposicion.Cantidad " +
                    "FROM flores, florescomposicion, familias " +
                    "WHERE flores.idFamilia=familias.idFamilia AND " +
                    "	flores.idFlor=florescomposicion.idFlor AND florescomposicion.idComposicion=?");
            consulta.setString(1, idCompo);
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
