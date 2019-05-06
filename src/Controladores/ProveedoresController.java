package Controladores;

import Conexion.Conexion;
import Modelos.PrincipalBo;
import Modelos.ProveedoresBo;
import Modelos.ProveedoresVo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import vistas.Principal;
import vistas.Proveedores;

public class ProveedoresController implements ActionListener {

    ProveedoresBo Modelo;
    Proveedores Vista;

    public ProveedoresController(ProveedoresBo Modelo, Proveedores Vista) {
        this.Modelo = Modelo;
        this.Vista = Vista;
        this.Vista.cambiar.addActionListener(this);
        this.Vista.Volver.addActionListener(this);
        this.Vista.atras.addActionListener(this);
        this.Vista.btnguardar.addActionListener(this);
        this.Vista.btneliminar.addActionListener(this);
        MostrarTabla();
        Vista.tablaproveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaproveedoresMouseClicked(evt);
            }
        });
        Vista.txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
    }

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {

        String Buscar = Vista.txtbuscar.getText();
        Filtrar(Buscar);
    }

    public void MostrarTabla() {
        DefaultTableModel Modo = new DefaultTableModel();
        Modo.addColumn("Proveedor");
        Modo.addColumn("Nit");
        Modo.addColumn("Direccion");
        Modo.addColumn("Telefono");
        Vista.tablaproveedores.setModel(Modo);

        String Datos[] = new String[5];

        try {
            Conexion C = new Conexion();
            String ConsultaListar = "CALL Proveedores (5,0,0,0,0,0); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaListar);

            while (ColAfectadas.next()) {
                Datos[0] = ColAfectadas.getString(2);
                Datos[1] = ColAfectadas.getString(3);
                Datos[2] = ColAfectadas.getString(4);
                Datos[3] = ColAfectadas.getString(5);
                Modo.addRow(Datos);
            }
            Vista.tablaproveedores.setModel(Modo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Mostrar La Tabla " + e);
        }
    }

    public void Filtrar(String Texto) {
        try {
            Conexion C = new Conexion();
            String ConsultaFiltro = "CALL Proveedores (7,0,'" + Texto + "',0,0,0); ";
            DefaultTableModel modelooo = new DefaultTableModel();
            Vista.tablaproveedores.setModel(modelooo);
            modelooo.addColumn("Proveedor");
            modelooo.addColumn("Nit");
            modelooo.addColumn("Direccion");
            modelooo.addColumn("Telefono");
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaFiltro);
            String[] Fila = new String[4];
            while (ColAfectadas.next()) {
                Fila[0] = ColAfectadas.getString("PROVEEDOR");
                Fila[1] = ColAfectadas.getString("NIT");
                Fila[2] = ColAfectadas.getString("DIRECCION");
                Fila[3] = ColAfectadas.getString("TELEFONO");

                modelooo.addRow(Fila);
            }

            ColAfectadas.close();
            Puente.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Filtrar: " + e);
        }
    }

    private void tablaproveedoresMouseClicked(java.awt.event.MouseEvent evt) {

        int FilaSeleccionada = Vista.tablaproveedores.getSelectedRow();
        TableModel Model = Vista.tablaproveedores.getModel();
        String prov = (Model.getValueAt(FilaSeleccionada, 0).toString());
        String nit = (Model.getValueAt(FilaSeleccionada, 2).toString());
        String ciudad = (Model.getValueAt(FilaSeleccionada, 3).toString());
        String telef = (Model.getValueAt(FilaSeleccionada, 3).toString());

        Vista.txtproveedor.setText(prov);
        Vista.txtnit.setText(nit);
        Vista.txtciudad.setText(ciudad);
        Vista.txttelefono.setText(telef);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.cambiar) {
            Vista.multipanel.removeAll();
            Vista.multipanel.add(Vista.pnlregistro);
            Vista.multipanel.repaint();
            Vista.multipanel.revalidate();
            Vista.cambiar.setVisible(false);
        } else if (e.getSource() == Vista.Volver) {
            Vista.multipanel.removeAll();
            Vista.multipanel.add(Vista.pnltabla);
            Vista.multipanel.repaint();
            Vista.multipanel.revalidate();
            Vista.cambiar.setVisible(true);
        } else if (e.getSource() == Vista.atras) {
            Vista.dispose();
            PrincipalBo ModeloPrincipal = new PrincipalBo();
            Principal ventanaprincipal = new Principal();
            ventanaprincipal.setVisible(true);
            new PrincipalController(ventanaprincipal,ModeloPrincipal);
        } else if (e.getSource() == Vista.btnguardar) {
            ProveedoresVo atributos = new ProveedoresVo(Vista.txtproveedor.getText(), Vista.txtciudad.getText(), Vista.txtnit.getText(), Integer.parseInt(Vista.txttelefono.getText()));
            if (atributos.getProveedor().isEmpty() || atributos.getCiudad().isEmpty() || atributos.getNit().isEmpty() || atributos.getTelefono() == 0) {
                JOptionPane.showMessageDialog(null, "Debe Rellenar todos los datos");
            } else {
                Modelo.GuardarProveedores(atributos);
                MostrarTabla();
            }
        } else if (e.getSource() == Vista.btneliminar) {
            int FilaSeleccionada = Vista.tablaproveedores.getSelectedRow();
            TableModel Model = Vista.tablaproveedores.getModel();
            String Nit = Model.getValueAt(FilaSeleccionada, 1).toString();
            if ("".equals(Nit)) {
                JOptionPane.showMessageDialog(null, "no ah seleccionado ningun proveedor");
            } else {

                ProveedoresVo Respuesta = Modelo.EliminarProveedores(Nit);
                JOptionPane.showMessageDialog(null, Nit);
                MostrarTabla();
            }

        }
    }

}
