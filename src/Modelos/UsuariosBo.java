package Modelos;

import Conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class UsuariosBo {

    Conexion C = new Conexion();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = format.format(new Date());

    public boolean Guardar(UsuariosVo atributos) { //metodo vacio, no se puede estblecer la clausula boolean en el constructor
        try {
            String sql = "CALL usuarios (1,'" + atributos.getCod()+ "','" + atributos.getNombre()+ "','" + atributos.getApellido()+ "','" + atributos.getCedula()+ "','" + atributos.getEmail()+ "','" + atributos.getTelefono()+ "','" + atributos.getRol()+ "','" + this.dateString + "');";
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
