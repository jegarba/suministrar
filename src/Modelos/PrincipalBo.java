package Modelos;

import Conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class PrincipalBo {

    Conexion C = new Conexion();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    String dateString = format.format(new Date());

    public boolean Actulizar(PrincipalVo atributos) {
        try {
            String sql = "CALL Login (3,'" + atributos.getCedula() + "',0,'" + this.dateString + "'); ";
            Statement Puente = C.Conectar().createStatement();
            Puente.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error: " + e);
        }
        return false;
    }
}
