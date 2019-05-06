package Modelos;

import Conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ProductosBo {

    Conexion C = new Conexion();

    public boolean Guardar(ProductosVo atributos) {
        try {
            String sql = "CALL Productos (1,'" + atributos.getCod() + "','" + atributos.getNombre() + "','" + atributos.getCategoria() + "','" + atributos.getLaboratorio() + "','" + atributos.getUnidades() + "','" + atributos.getCajas() + "','" + atributos.getCosto() + "','" + atributos.getPorcentaje() + "'); ";
            Statement Puente = C.Conectar().createStatement();
            Puente.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error: " + e);
        }
        return false;
    }

    public boolean Actulizar(ProductosVo atributos) {
        try {
            String sql = "CALL Productos (2,'" + atributos.getCod() + "','" + atributos.getNombre() + "','" + atributos.getCategoria() + "','" + atributos.getLaboratorio() + "','" + atributos.getUnidades() + "','" + atributos.getCajas() + "','" + atributos.getCosto() + "','" + atributos.getPorcentaje() + "'); ";
            Statement Puente = C.Conectar().createStatement();
            Puente.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error: " + e);
        }
        return false;
    }

    public boolean Eliminar(ProductosVo atributos) {
        try {
            String sql = "CALL Productos (3,'" + atributos.getCod() + "',0,0,0,0,0,0,0); ";
            Statement Puente = C.Conectar().createStatement();
            Puente.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Se Produjo El Siguiente Error: " + e);
        }
        return false;
    }
}
