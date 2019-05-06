package Controladores;

import Conexion.Conexion;
import Modelos.PrincipalBo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import vistas.EntradaProductos;
import vistas.Principal;

public final class EntradaProductosController implements ActionListener {

    EntradaProductos Vista;
    Conexion C = new Conexion();

    public EntradaProductosController(EntradaProductos Vista) {
        this.Vista = Vista;
        this.Vista.btnregistrar.addActionListener(this);
        this.Vista.btnSeleccion.addActionListener(this);
        this.Vista.btncambiarcosto.addActionListener(this);
        this.Vista.atras.addActionListener(this);
        Vista.txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });
        mostrartabla();
    }
    private String code, Nom, Cos, cantidad;
    private int fila, cantidaddb;

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.code = Vista.txtbuscar.getText();
            Filtrar(this.code);
            validar(this.code);
        }
    }

    public void mostrartabla() {
        DefaultTableModel modelooo = new DefaultTableModel();
        Vista.jTable1.setModel(modelooo);
        modelooo.addColumn("Cod");
        modelooo.addColumn("Articulo");
        modelooo.addColumn("Costo Actual");
        modelooo.addColumn("Cantidad");
    }

    public void agregardatos() {
        String cantida = JOptionPane.showInputDialog(null, "cuantos desea ingresar");
        DefaultTableModel dtm = (DefaultTableModel) Vista.jTable1.getModel();
        Object datos[] = new Object[4];
        datos[0] = this.code;
        datos[1] = this.Nom;
        datos[2] = this.Cos;
        datos[3] = cantida;
        dtm.addRow(datos);
        Vista.txtbuscar.grabFocus();
        Vista.txtbuscar.setText("");
    }

    public void validar(String Texto) {
        if (Vista.jTable1.getRowCount() > 0) {
            int a = 0;
            for (int i = 0; i < Vista.jTable1.getRowCount(); i++) {
                if (Vista.jTable1.getValueAt(i, 0).toString().equals(Texto)) {
                    this.cantidad = Vista.jTable1.getValueAt(i, 3).toString();
                    this.fila = i;
                    a += 1;
                }
            }
            if (a > 0) {
                System.out.println("El número si existe");
                String ingrcant = JOptionPane.showInputDialog(null, "cuantos desea ingresar");
                int suma = Integer.parseInt(ingrcant) + Integer.parseInt(this.cantidad);
                Vista.jTable1.setValueAt(suma, this.fila, 3);
                Vista.txtbuscar.grabFocus();
                Vista.txtbuscar.setText("");
            } else {
                agregardatos();
            }
        } else {
            agregardatos();
        }
    }

    public void Filtrar(String Texto) {
        try {
            String ConsultaFiltro = "CALL Filtro (1,'" + Texto + "'); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaFiltro);

            while (ColAfectadas.next()) {
                this.Nom = ColAfectadas.getString("Nombre");
                this.Cos = ColAfectadas.getString("Costo");
                this.cantidaddb = ColAfectadas.getInt("Unidades");
            }
            ColAfectadas.close();
            Puente.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Filtrar: " + e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.btnregistrar) {
            if (Vista.jTable1.getRowCount() > 0) {
                for (int i = 0; i < Vista.jTable1.getRowCount(); i++) {
                    try {
                        int suma = Integer.parseInt(Vista.jTable1.getValueAt(i, 3).toString()) + this.cantidaddb;
                        String sql = "CALL Productos (4,'" + Vista.jTable1.getValueAt(i, 0) + "',0,0,0,'" + suma + "',0,0,0); ";
                        Statement Puente = C.Conectar().createStatement();
                        Puente.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Pedido Ingresado al sistema");
                    } catch (SQLException ex) {
                        Logger.getLogger(EntradaProductosController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                DefaultTableModel tabla = (DefaultTableModel) Vista.jTable1.getModel();
                int fil = 0;
                while (tabla.getRowCount() > 0) {
                    tabla.removeRow(fil);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay Nada Que Guardar!");
            }
        } else if (e.getSource() == Vista.btnSeleccion) {
            DefaultTableModel modelo = (DefaultTableModel) Vista.jTable1.getModel();
            int filas = Vista.jTable1.getSelectedRow(); ////cambiar de fila a filas
            if (filas >= 0) {
                modelo.removeRow(filas);
            } else {
                JOptionPane.showMessageDialog(Vista, "Debe seleccionar una fila");
            }
        } else if (e.getSource() == Vista.btncambiarcosto) {
            if (Vista.jTable1.getSelectedRowCount() > 0) {
                JOptionPane.showMessageDialog(null, "Tenga en Cuenta que El Valor Sera Promediado Si es Mayor Al Que Esta Registrado.");
                String newvalor = JOptionPane.showInputDialog(null, "De Cuanto Es El Nuevo Costo");
                int FilaSeleccionada = Vista.jTable1.getSelectedRow();
                TableModel Model = Vista.jTable1.getModel();
                int preciodb = Integer.parseInt(Model.getValueAt(FilaSeleccionada, 2).toString());
                int promedio = (Integer.parseInt(newvalor) + preciodb) / 2;
                Vista.jTable1.setValueAt(promedio, FilaSeleccionada, 2);
            } else {
                JOptionPane.showMessageDialog(null, "Debe Selecionar el Producto Al Que Quiere Agregar Un Nuevo Costo.");
            }
        } else if (e.getSource() == Vista.atras) {
            Vista.dispose();
            PrincipalBo ModeloPrincipal = new PrincipalBo();
            Principal ventanaprincipal = new Principal();
            ventanaprincipal.setVisible(true);
            new PrincipalController(ventanaprincipal,ModeloPrincipal);
        }
    }
}
