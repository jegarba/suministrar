package Conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class Conexion {

    // ATRIBUTOS -------------------------------------------------------------------
    private String Servidor, NombreBase, Usuario, Password;
    private static Connection Con;

    //metodo verifica properties
    public void properties() {

    }

    // METODO -------------------------------------------------------------------
    public Connection Conectar() {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("Conexion/Conexion.properties"));
            this.Servidor = properties.getProperty("Servidor");
            this.NombreBase = properties.getProperty("NombreBase");
            this.Usuario = properties.getProperty("Usuario");
            this.Password = properties.getProperty("Password");
        } catch (IOException e) {
            System.out.println("No Se Pudo Cargar El Archivo De Configuracion...!!!" + e);
            Con = null;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Con = DriverManager.getConnection("jdbc:mysql://" + this.Servidor + "/" + this.NombreBase + "", this.Usuario, this.Password);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha Ocurrido El Siguiente Error: " + e.getMessage());
        }

        if (Con != null) {
            System.out.println("Conexión " + this.NombreBase + " OK\n");
        }
        return Con;
    }

    public void desconectar() {
        try {
            Con.close();
        } catch (SQLException ex) {
        }
    }
}
