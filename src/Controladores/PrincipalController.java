package Controladores;

import Conexion.Conexion;
import Modelos.FacturacionBo;
import Modelos.PdfBo;
import Modelos.PrincipalBo;
import Modelos.PrincipalVo;
import Modelos.ProductosBo;
import Modelos.ProveedoresBo;
import Modelos.UsuariosBo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.Facturacion;
import vistas.Principal;
import vistas.Proveedores;
import vistas.EntradaProductos;
import vistas.Pdf;
import vistas.Productos;
import vistas.Usuarios;

public final class PrincipalController implements ActionListener {

    Principal Vista;
    PrincipalBo ModeloBo;
    Conexion C = new Conexion();

    public void botones(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f) {
        Vista.MenuProveedores.setEnabled(a);
        Vista.btnfacturaselectronicas.setEnabled(b);
        Vista.BtnGestionUsuarios.setEnabled(c);
        Vista.btnentradaproductos.setEnabled(d);
        Vista.btngestionproductos.setEnabled(e);
        Vista.MenuFacturacion.setEnabled(f);
    }

    public void properties(String Parametro) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("conf/Datos.properties"));
            prop.setProperty("Usuario", Parametro);
            prop.store(new FileWriter("conf/Datos.properties"), "Usuario Logueado");
            Filtrar(prop.getProperty("Usuario"));
        } catch (IOException e) {
            System.out.println("No Se Pudo Cargar El Archivo De Configuracion...!!!" + e);
        }

    }

    public void properties() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("conf/Datos.properties"));
            String Usuario3 = prop.getProperty("Usuario");
            prop.store(new FileWriter("conf/Datos.properties"), "Usuario Rertonado");
            Filtrar(Usuario3);
        } catch (IOException e) {
            System.out.println("No Se Pudo Cargar El Archivo De Configuracion...!!!" + e);
        }

    }

    public void Filtrar(String Prope) {
        try {
            String ConsultaFiltro = "CALL Login (2,'" + Prope + "',0,0);";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaFiltro);
            PrincipalVo po = new PrincipalVo();
            while (ColAfectadas.next()) {
                po.setNombre(ColAfectadas.getString("Nombre"));
                po.setCedula(ColAfectadas.getString("Cedula"));
                po.setRol(ColAfectadas.getString("ID_Privilegios"));
            }
            ColAfectadas.close();
            Vista.lbluser.setText(po.getNombre());
            Vista.lblcedula.setText(po.getCedula());
            Vista.lblrol.setText(po.getRol());
            switch (po.getRol()) {
                case "1":
                    botones(false, false, false, false, false, false);
                    break;
                case "2":
                    botones(false, false, false, true, true, true);
                    break;
                case "3":
                    botones(true, true, true, true, true, true);
                    break;
                default:
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Filtrar: " + e);
        }
    }

    public PrincipalController(Principal Vista, PrincipalBo ModeloBo, String Valor) {
        this.Vista = Vista;
        this.ModeloBo = ModeloBo;
        this.Vista.MenuFacturacion.addActionListener(this);
        this.Vista.MenuProveedores.addActionListener(this);
        this.Vista.btnentradaproductos.addActionListener(this);
        this.Vista.logout.addActionListener(this);
        this.Vista.btngestionproductos.addActionListener(this);
        this.Vista.BtnHome.addActionListener(this);
        this.Vista.BtnGestionUsuarios.addActionListener(this);
        this.Vista.btnfacturaselectronicas.addActionListener(this);
        properties(Valor);
    }

    public PrincipalController(Principal Vista, PrincipalBo ModeloBo) {
        this.Vista = Vista;
        this.ModeloBo = ModeloBo;
        this.Vista.MenuFacturacion.addActionListener(this);
        this.Vista.MenuProveedores.addActionListener(this);
        this.Vista.btnentradaproductos.addActionListener(this);
        this.Vista.logout.addActionListener(this);
        this.Vista.btngestionproductos.addActionListener(this);
        this.Vista.BtnHome.addActionListener(this);
        this.Vista.BtnGestionUsuarios.addActionListener(this);
        this.Vista.btnfacturaselectronicas.addActionListener(this);
        properties();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.btnentradaproductos) {
            Vista.dispose();
            EntradaProductos VistaEntrada = new EntradaProductos();
            VistaEntrada.setVisible(true);
            new EntradaProductosController(VistaEntrada);
        } else if (e.getSource() == Vista.btngestionproductos) {
            Vista.dispose();
            ProductosBo ModeloProveedor = new ProductosBo();
            Productos VistaProveedor = new Productos();
            VistaProveedor.setVisible(true);
            new ProductosController(ModeloProveedor, VistaProveedor);
        } else if (e.getSource() == Vista.logout) {
            PrincipalVo atributos = new PrincipalVo(Vista.lbluser.getText(), Vista.lblcedula.getText(), Vista.lblrol.getText());
            if (ModeloBo.Actulizar(atributos)) {
                JOptionPane.showMessageDialog(null, "DesLogeado Corectamente");
                Properties properties = new Properties();
                try {
                    properties.load(new FileInputStream("conf/Datos.properties"));
                    properties.setProperty("Usuario", "Default");
                    properties.store(new FileWriter("conf/Datos.properties"), "Usuario DesLogueado");
                } catch (IOException ex) {
                    Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(Vista, "se ah producido un error");
            }
        } else if (e.getSource() == Vista.BtnGestionUsuarios) {
            Vista.dispose();
            UsuariosBo ModeloUsuarios = new UsuariosBo();
            Usuarios VistaUsuarios = new Usuarios();
            VistaUsuarios.setVisible(true);
            new UsuariosController(VistaUsuarios, ModeloUsuarios);
        } else if (e.getSource() == Vista.btnfacturaselectronicas) {
            Vista.dispose();
            PdfBo Modelopdf = new PdfBo();
            Pdf Vistapdf = new Pdf();
            Vistapdf.setVisible(true);
            new PdfController(Modelopdf, Vistapdf);
        } else if (e.getSource() == Vista.MenuFacturacion) {
            Vista.dispose();
            FacturacionBo Modelo = new FacturacionBo();
            Facturacion VistaArticulo = new Facturacion();
            VistaArticulo.setVisible(true);
            new Facturacioncontroller(VistaArticulo,Modelo);
        } else if (e.getSource() == Vista.MenuProveedores) {
            Vista.dispose();
            ProveedoresBo Modelo = new ProveedoresBo();
            Proveedores VistaProveedor = new Proveedores();
            VistaProveedor.setVisible(true);
            new ProveedoresController(Modelo, VistaProveedor);
        }
    }
}
