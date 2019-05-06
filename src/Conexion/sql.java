package Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class sql {

    Conexion C = new Conexion();

    public int auto_increment(String sql) {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = C.Conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("idmaximo" + ex.getMessage());
            id = 1;
        } finally {
            try {
                ps.close();
                rs.close();
                C.desconectar();
            } catch (Exception ex) {
            }
        }
        return id;
    }

    public static void main(String[] args) {
    }

}
