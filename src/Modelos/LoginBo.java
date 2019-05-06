package Modelos;

import Conexion.Conexion;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LoginBo {

    public boolean ConsultaLogin(LoginVo atributos) {
        Conexion C = new Conexion();
        try {
            String sql = "CALL Login (1,'" + atributos.getUsername() + "','" + atributos.getPassword() + "',0); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(sql);
            return ColAfectadas.first();
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Se Produjo El Siguiente Error al iniciar sesion: " + e);
        }
        return false;
    }

}
