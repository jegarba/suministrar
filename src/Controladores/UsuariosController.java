package Controladores;

import Conexion.Conexion;
import Modelos.UsuariosBo;
import Modelos.UsuariosVo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vistas.Usuarios;

public final class UsuariosController implements ActionListener {

    Conexion C = new Conexion();
    Usuarios Vista;
    UsuariosBo ModeloBo;

    public UsuariosController(Usuarios Vista, UsuariosBo ModeloBo) {
        this.Vista = Vista;
        this.ModeloBo = ModeloBo;
        this.Vista.btnAtras.addActionListener(this);
        this.Vista.btnactualizar.addActionListener(this);
        this.Vista.btnbuscar.addActionListener(this);
        this.Vista.btneliminar.addActionListener(this);
        this.Vista.btnguardar.addActionListener(this);
        this.Vista.btnmodificar.addActionListener(this);
        this.Vista.btnnuevo.addActionListener(this);

        bloquear();
        Listarol();
    }

    private void Listarol() {
        try {
            String ConsultaListar = "CALL ListBox (3); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaListar);
            DefaultComboBoxModel Combo = new DefaultComboBoxModel();
            Combo.addElement("Seleccione Un Rol");
            while (ColAfectadas.next()) {
                UsuariosVo cate = new UsuariosVo();
                cate.setRol(Integer.valueOf(ColAfectadas.getString("ID")));
                cate.setNombre((String) ColAfectadas.getString("Tipo"));
                Vista.jComboBox1.setModel(Combo);
                Vista.jComboBox1.addItem(cate);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Mostrar La Lista Desplegable " + e);
        }
    }

    public void desbloquear() {
        //desbloquear botones 
        Vista.btnguardar.setEnabled(true);
        Vista.btnactualizar.setEnabled(true);
        Vista.btneliminar.setEnabled(true);
        //desbloquear campos de texto
        Vista.jComboBox1.setEnabled(true);
        Vista.txtapellido.setEnabled(true);
        Vista.txtcedula.setEnabled(true);
        Vista.txtemail.setEnabled(true);
        Vista.txtnombre.setEnabled(true);
        Vista.txttelefono.setEnabled(true);
    }

    public void bloquear() {
        //bloquear botones 
        Vista.btnguardar.setEnabled(false);
        Vista.btnactualizar.setEnabled(false);
        Vista.btneliminar.setEnabled(false);
        //bloquear campos de texto
        Vista.jComboBox1.setEnabled(false);
        Vista.txtapellido.setEnabled(false);
        Vista.txtcedula.setEnabled(false);
        Vista.txtemail.setEnabled(false);
        Vista.txtnombre.setEnabled(false);
        Vista.txttelefono.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.btnactualizar) {
            System.out.println("Actualizar");
        } else if (e.getSource() == Vista.btnbuscar) {
            String buscar = JOptionPane.showInputDialog(null, " ..::Ingrese el Documento de la persona que desea buscar::..");
            if (buscar == null) {
                System.out.println("busqueda cancelada");
            } else {
                System.out.println("buscar");
            }
        } else if (e.getSource() == Vista.btneliminar) {
            System.out.println("eliminar");
        } else if (e.getSource() == Vista.btnguardar) {
            System.out.println("guardar");
        } else if (e.getSource() == Vista.btnmodificar) {
            if (Vista.txtnombre.getText().isEmpty() || Vista.txtcedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe buscar el Usuario Para Poder Modificar Algun Dato");
            } else {
                desbloquear();
                Vista.btnguardar.setEnabled(false);
                System.out.println("modificar");
            }
        } else if (e.getSource() == Vista.btnnuevo) {
            System.out.println("nuevo");
            desbloquear();
            this.Vista.btnactualizar.setEnabled(false);
            this.Vista.btneliminar.setEnabled(false);
        } else if (e.getSource() == Vista.btnAtras) {
            System.out.println("regresar");
        }
    }

}
