/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package flores.utils;

import javax.swing.JTable;

/**
 *
 * @author vPalomo
 */
public class Utils {
    /**
     * Oculta la columna que se le pase en el indice. Los datos seguirán estando accesibles y la columna seguirá existiendo con su numero.
     * Su uso se aconseja para ocultar la columna id. También es bueno que esa columna sea la última
     * @param jTableFamilias
     * @param indice 
     */
    public static void ocultaFilaN(JTable jTable, int indice) {
        jTable.getColumnModel().getColumn(indice).setMinWidth(0);
        jTable.getColumnModel().getColumn(indice).setMaxWidth(0);
        jTable.getColumnModel().getColumn(indice).setWidth(0);
    }
}
