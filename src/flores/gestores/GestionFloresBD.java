/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.gestores;

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
public class GestionFloresBD {
    public static ArrayList<FlorBean> getListaFloresAlmacen(){
        Connection conexion = null;
        try {
            conexion = ConectorBD.getConnection();
            PreparedStatement consulta = conexion.prepareStatement(
                    "SELECT flores.idFlor, familias.Nombre AS nombreFam, flores.Nombre, Color, flores.CantidadAlmacen " +
                    "FROM flores, familias " +
                    "WHERE flores.idFamilia=familias.idFamilia");
            System.out.println(consulta);
            ResultSet resultado = consulta.executeQuery();
            ArrayList<FlorBean> lista = new ArrayList();
            FlorBean flor;
            while (resultado.next()) {
                flor=new FlorBean();
                flor.setIdFlor(resultado.getString(1));
                flor.setNombreFamilia(resultado.getString(2));
                flor.setNombre(resultado.getString(3));
                flor.setColor(resultado.getString(4));
                flor.setCantidadAlmacen(resultado.getInt(5));
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
