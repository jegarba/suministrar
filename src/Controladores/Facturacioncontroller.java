package Controladores;

import Conexion.Conexion;
import Modelos.FacturacionVo;
import Modelos.FacturacionBo;
import Modelos.PrincipalBo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vistas.Facturacion;
import vistas.Principal;

public final class Facturacioncontroller implements ActionListener {

    Facturacion Vista;
    private InputStream formato;
    private String nombre, precio;

    public void iniciar() {
        Object[] formatos = {"DistibuidoraNacional", "DistriMedic", "InversionesSabana"};
        Object opcion = JOptionPane.showInputDialog(null, "Selecciona un formato para la factura", "Elegir", JOptionPane.QUESTION_MESSAGE, null, formatos, formatos[0]);

        ClassLoader cl = this.getClass().getClassLoader();

        if (opcion == null) {
            JOptionPane.showMessageDialog(null, "debe selecionar un formato de factura para poder continuar");
            Vista.dispose();
            PrincipalBo ModeloPrincipal = new PrincipalBo();
            Principal ventanaprincipal = new Principal();
            ventanaprincipal.setVisible(true);
            new PrincipalController(ventanaprincipal,ModeloPrincipal);
        } else if ("DistibuidoraNacional".equals(opcion.toString())) {
            this.formato = (cl.getResourceAsStream("reportes/distribuidoranacional.jasper"));
            //JOptionPane.showMessageDialog(null, formato);
        } else if ("DistriMedic".equals(opcion.toString())) {
            this.formato = (cl.getResourceAsStream("reportes/distrimedic.jasper"));
        } else {
            this.formato = (cl.getResourceAsStream("reportes/inversionessabana.jasper"));
        }
    }

    public void MostrarTabla() {

        DefaultTableModel Modo = new DefaultTableModel();
        Modo.addColumn("Id");
        Modo.addColumn("Cod");
        Modo.addColumn("Categoria");
        Modo.addColumn("Articulo");
        Modo.addColumn("Precio");
        Vista.TablaArticulos.setModel(Modo);

        DefaultTableModel Modo1 = new DefaultTableModel();
        Modo1.addColumn("CANTIDAD");
        Modo1.addColumn("ARTICULO");
        Modo1.addColumn("VR.UNITARIO");
        Modo1.addColumn("VALOR TOTAL");
        Vista.tablaventa.setModel(Modo1);

        String Datos[] = new String[5];

        try {
            Conexion C = new Conexion();
            String ConsultaListar = "CALL Articulos (5,0,0,0,0,0,0); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaListar);

            while (ColAfectadas.next()) {
                Datos[0] = ColAfectadas.getString(1);
                Datos[1] = ColAfectadas.getString(2);
                Datos[2] = ColAfectadas.getString(3);
                Datos[3] = ColAfectadas.getString(4);
                Datos[4] = ColAfectadas.getString(5);
                Modo.addRow(Datos);
            }
            Vista.TablaArticulos.setModel(Modo);
            Vista.TablaArticulos.getColumnModel().getColumn(0).setPreferredWidth(-1);
            Vista.TablaArticulos.getColumnModel().getColumn(2).setPreferredWidth(-1);
            Vista.TablaArticulos.getColumnModel().getColumn(3).setPreferredWidth(320);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Mostrar La Tabla " + e);
        }

    }

    public void Filtrar(String Texto) {
        try {
            Conexion C = new Conexion();
            String ConsultaFiltro = "CALL Articulos (7,0,0,0,'" + Texto + "',0,0); ";
            DefaultTableModel modelooo = new DefaultTableModel();
            Vista.TablaArticulos.setModel(modelooo);
            modelooo.addColumn("Id");
            modelooo.addColumn("Cod");
            modelooo.addColumn("Categoria");
            modelooo.addColumn("Articulo");
            modelooo.addColumn("Precio");
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaFiltro);
            String[] Fila = new String[5];
            while (ColAfectadas.next()) {
                Fila[0] = ColAfectadas.getString("ID");
                Fila[1] = ColAfectadas.getString("Codigo");
                Fila[2] = ColAfectadas.getString("Categoria");
                Fila[3] = ColAfectadas.getString("Articulo");
                Fila[4] = ColAfectadas.getString("Precio");
                modelooo.addRow(Fila);
            }
            Vista.TablaArticulos.getColumnModel().getColumn(3).setPreferredWidth(500);

            ColAfectadas.close();
            Puente.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Filtrar: " + e);
        }
    }

    private void nuevo() {
        Vista.TextIdUsu.setText(null);
        this.nombre = null;
        this.precio = null;
        Vista.TxtFacturaNombre.setText(null);
        Vista.TxtFacturaNit.setText(null);
        Vista.TxtFacturaDireccion.setText(null);
        Vista.TxtFacturaTelefono.setText(null);
        Vista.valortotal.setText(null);
        Vista.lblvalor.setText(null);
        DefaultTableModel tabla = (DefaultTableModel) Vista.tablaventa.getModel();
        int fila = 0;
        while (tabla.getRowCount() > 0) {
            tabla.removeRow(fila);
        }
    }

    private void nuevoProducto() {
        Vista.TextIdUsu.setText(null);
        this.nombre = null;
        this.precio = null;
        Vista.TextIdUsu.grabFocus();
    }

    private void Totalizar() {
        int t = 0;
        int p = 0;
        if (Vista.tablaventa.getRowCount() > 0) {
            for (int i = 0; i < Vista.tablaventa.getRowCount(); i++) {
                p = Integer.parseInt(Vista.tablaventa.getValueAt(i, 3).toString());
                t += p;
            }
            Vista.valortotal.setText(Integer.toString(t));
            String n = Vista.valortotal.getText();
            Vista.lblvalor.setText(FacturacionBo.cantidadConLetra(n));
        } else {
//Sin Acciones
        }
    }

    public Facturacioncontroller(Facturacion Vista) {
        this.Vista = Vista;
        iniciar();

        this.Vista.AtrasUsu.addActionListener(this);
        this.Vista.agregarAR.addActionListener(this);
        this.Vista.quitar.addActionListener(this);
        this.Vista.FacturarArticulo.addActionListener(this);
        this.Vista.btnmodipre.addActionListener(this);

        MostrarTabla();

        Vista.TablaArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaUsuMouseClicked(evt);
            }
        });
        Vista.TextIdUsu.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextIdUsuKeyReleased(evt);
            }
        });

    }

    public void reporte() {
        List lista = new ArrayList();
        for (int i = 0; i < Vista.tablaventa.getRowCount(); i++) {
            FacturacionVo t = new FacturacionVo(Vista.tablaventa.getValueAt(i, 0).toString(), Vista.tablaventa.getValueAt(i, 1).toString(), Vista.tablaventa.getValueAt(i, 2).toString(), Integer.parseInt(Vista.tablaventa.getValueAt(i, 3).toString()));
            lista.add(t);
        }
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(this.formato);
            Map parametro = new HashMap();
            //parametro.put("total", Vista.valortotal.getText());
            parametro.put("txtName", Vista.TxtFacturaNombre.getText());
            parametro.put("txtdirec", Vista.TxtFacturaDireccion.getText());
            parametro.put("txtnit", Vista.TxtFacturaNit.getText());
            parametro.put("txttele", Vista.TxtFacturaTelefono.getText());
            parametro.put("valorletras", Vista.lblvalor.getText());
            JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));
            JasperViewer.viewReport(imprimir, false);
        } catch (JRException ex) {
            Logger.getLogger(Facturacioncontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.AtrasUsu) {
            Vista.dispose();
            PrincipalBo ModeloPrincipal = new PrincipalBo();
            Principal ventanaprincipal = new Principal();
            ventanaprincipal.setVisible(true);
            new PrincipalController(ventanaprincipal,ModeloPrincipal);
        } else if (e.getSource() == Vista.agregarAR) {
            String cantidad = JOptionPane.showInputDialog(null, "Ingresa la cantidad a facturar", "Cantidad de articulos", JOptionPane.QUESTION_MESSAGE);
            if ("".equals(cantidad)) {
                JOptionPane.showMessageDialog(null, "debe ingresar por lo menos una cantidad");
            } else {
                DefaultTableModel dtm = (DefaultTableModel) Vista.tablaventa.getModel();
                Object datos[] = new Object[4];
                datos[0] = cantidad;
                datos[1] = this.nombre;
                datos[2] = Integer.parseInt(this.precio);

                int valor, cantidad1, subtotal;
                valor = Integer.parseInt(datos[2].toString());
                cantidad1 = Integer.parseInt(datos[0].toString());
                subtotal = (valor * cantidad1);
                datos[3] = subtotal;
                dtm.addRow(datos);
                nuevoProducto();
                Totalizar();
            }
        } else if (e.getSource() == Vista.quitar) {
            DefaultTableModel modelo = (DefaultTableModel) Vista.tablaventa.getModel();
            int fila = Vista.tablaventa.getSelectedRow();
            if (fila >= 0) {
                modelo.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(Vista, "Debe seleccionar una fila");
            }
            Totalizar();
        } else if (e.getSource() == Vista.FacturarArticulo) {
            if (Vista.TxtFacturaNombre.getText().isEmpty() || Vista.TxtFacturaDireccion.getText().isEmpty() || Vista.TxtFacturaNit.getText().isEmpty() || Vista.TxtFacturaTelefono.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede dejar los datos de faturacion vacios");
            } else {
                reporte();
                nuevo();
            }
        } else if (e.getSource() == Vista.btnmodipre) {
            if (Vista.tablaventa.getSelectedRowCount() > 0) {
                String newvalor = JOptionPane.showInputDialog(null, "De Cuanto Es El Nuevo Costo");
                int FilaSeleccionada = Vista.tablaventa.getSelectedRow();
                TableModel Model = Vista.tablaventa.getModel();
                int cantid = Integer.parseInt(Model.getValueAt(FilaSeleccionada, 0).toString());
                int nuevosub = (Integer.parseInt(newvalor) * cantid);
                Vista.tablaventa.setValueAt(newvalor, FilaSeleccionada, 2);
                Vista.tablaventa.setValueAt(nuevosub, FilaSeleccionada, 3);
                Totalizar();
            } else {
                JOptionPane.showMessageDialog(null, "Debe Selecionar el Producto Al Que Quiere Agregar Un Nuevo Costo.");
            }
        }
    }

    private void TablaUsuMouseClicked(java.awt.event.MouseEvent evt) {
        int FilaSeleccionada = Vista.TablaArticulos.getSelectedRow();
        TableModel Model = Vista.TablaArticulos.getModel();
        this.nombre = (Model.getValueAt(FilaSeleccionada, 3).toString());
        this.precio = (Model.getValueAt(FilaSeleccionada, 4).toString());
    }

    private void TextIdUsuKeyReleased(java.awt.event.KeyEvent evt) {

        String Buscar = Vista.TextIdUsu.getText();
        Filtrar(Buscar);

    }
}
