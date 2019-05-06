package Controladores;

import Conexion.Conexion;
import Conexion.sql;
import Modelos.PrincipalBo;
import Modelos.UsuariosBo;
import Modelos.UsuariosVo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vistas.Principal;
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

        botones(false, false, false, false, false, false, false, false, false);
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

    public void botones(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f, boolean g, boolean h, boolean i) {
        //desbloquear botones 
        Vista.btnguardar.setEnabled(a);
        Vista.btnactualizar.setEnabled(b);
        Vista.btneliminar.setEnabled(c);
        //desbloquear campos de texto
        Vista.jComboBox1.setEnabled(d);
        Vista.txtapellido.setEnabled(e);
        Vista.txtcedula.setEnabled(f);
        Vista.txtemail.setEnabled(g);
        Vista.txtnombre.setEnabled(h);
        Vista.txttelefono.setEnabled(i);
    }

    public void agregar(int codigo, String Nombre, String Apellido, long Cedula, String Email, long Telefono, int rol) {
        UsuariosVo po = new UsuariosVo();
        po.setCod(codigo);
        po.setNombre(Nombre);
        po.setApellido(Apellido);
        po.setCedula(Cedula);
        po.setEmail(Email);
        po.setTelefono(Telefono);
        po.setRol(rol);
        if (ModeloBo.Guardar(po)) {
            JOptionPane.showMessageDialog(null, "Operacion Exitosa");
        }
    }

    public void limpiar() {
        Vista.txtnombre.setText("");
        Vista.txtapellido.setText("");
        Vista.txtcedula.setText("");
        Vista.txtemail.setText("");
        Vista.txttelefono.setText("");
        Vista.jComboBox1.setSelectedIndex(0);
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
            String nombre = Vista.txtnombre.getText();
            String apellido = Vista.txtapellido.getText();
            long cedula = Long.parseLong(Vista.txtcedula.getText());
            String email = Vista.txtemail.getText();
            long telefono = Long.parseLong(Vista.txttelefono.getText());
            UsuariosVo IdRol = (UsuariosVo) Vista.jComboBox1.getSelectedItem();
            sql s = new sql();
            int codigo = s.auto_increment("SELECT MAX(ID) FROM usuarios;");
            agregar(codigo, nombre, apellido, cedula, email, telefono, IdRol.getRol()); //mando los datos al metodo guardar
            limpiar();
            botones(false, false, false, false, false, false, false, false, false); //bloquear componentes
        } else if (e.getSource() == Vista.btnmodificar) {
            if (Vista.txtnombre.getText().isEmpty() || Vista.txtcedula.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe buscar el Usuario Para Poder Modificar Algun Dato");
            } else {
                botones(false, true, true, true, true, true, true, true, true);
                System.out.println("modificar");
            }
        } else if (e.getSource() == Vista.btnnuevo) {
            limpiar();
            botones(true, false, false, true, true, true, true, true, true);
        } else if (e.getSource() == Vista.btnAtras) {
            Vista.dispose();
            PrincipalBo modeloPrincipal = new PrincipalBo();
            Principal Vistaprinc = new Principal();
            Vistaprinc.setVisible(true);
            new PrincipalController(Vistaprinc, modeloPrincipal);
        }
    }

}
