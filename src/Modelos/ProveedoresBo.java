/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PC ACER OFICINA
 */
public class ProveedoresBo {

    public boolean GuardarProveedores(ProveedoresVo ProveedoresVo) {

        try {
            Conexion C = new Conexion();
            String CosultaInsertar = "CALL Proveedores (1,0,'" + ProveedoresVo.getProveedor() + "','" + ProveedoresVo.getNit() + "','" + ProveedoresVo.getCiudad() + "','" + ProveedoresVo.getTelefono() + "'); ";
            Statement Puente = C.Conectar().createStatement();
            int ColAfectadas = Puente.executeUpdate(CosultaInsertar);

            if (ColAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado Correctamente...!!!");
            } else {
                JOptionPane.showMessageDialog(null, "El Registro No Se Pudo Guardar...!!!");
            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error: " + e);
        }
        return false;

    }

//    public ProveedoresVo ActulizarProveedores(ProveedoresVo ProveedoresVo) {
//
//        try {
//            Conexion C = new Conexion();
//            String CosultaInsertar = "CALL Proveedores (2,'" + Id + "','" + Categoria + "','" + Articulo + "','" + Precio + "'); ";
//            Statement Puente = C.Conectar().createStatement();
//            int ColAfectadas = Puente.executeUpdate(CosultaInsertar);
//
//            if (ColAfectadas > 0) {
//                JOptionPane.showMessageDialog(null, "Registro Guardado Correctamente...!!!");
//
//            } else {
//                JOptionPane.showMessageDialog(null, "El Registro No Se Pudo Guardar...!!!");
//
//            }
//
//        } catch (SQLException | HeadlessException e) {
//            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error: " + e);
//
//        }
//        return null;
//
//    }
//
    public ProveedoresVo EliminarProveedores(String Nit) {

        try {
            Conexion C = new Conexion();
            String ConsultaEliminar = "CALL Proveedores (3,0,0,'" + Nit + "',0,0); ";
            Statement Puente = C.Conectar().createStatement();
            int ColAfectadas = Puente.executeUpdate(ConsultaEliminar);

            if (ColAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente....!!!");

            } else {
                JOptionPane.showMessageDialog(null, "Error En La Eliminacion...!!!");

            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, " Se Produjo El Siguiente Error: " + e);

        }
        return null;

    }
}
