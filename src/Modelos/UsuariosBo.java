package Modelos;

import Conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class UsuariosBo {

    Conexion C = new Conexion();

    public boolean Guardar(UsuariosVo atributos) {
        try {
            String sql = "CALL Productos (1,'" + atributos.getNombre()+ "'); ";
            Statement Puente = C.Conectar().createStatement();
            Puente.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error: " + e);
        }
        return false;
    }

    public boolean Actulizar(UsuariosVo atributos) {
        try {
            String sql = "CALL Productos (2,'" + atributos.getNombre() + "'); ";
            Statement Puente = C.Conectar().createStatement();
            Puente.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error: " + e);
        }
        return false;
    }

    public boolean Eliminar(UsuariosVo atributos) {
        try {
            String sql = "CALL Productos (3,'" + atributos.getCedula()+ "',0,0,0,0,0,0,0); ";
            Statement Puente = C.Conectar().createStatement();
            Puente.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Se Produjo El Siguiente Error: " + e);
        }
        return false;
    }
}
