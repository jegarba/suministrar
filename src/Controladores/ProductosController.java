package Controladores;

import Conexion.Conexion;
import Modelos.PrincipalBo;
import Modelos.ProductosBo;
import Modelos.ProductosVo;
import vistas.Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import vistas.Principal;

public class ProductosController implements ActionListener {

    Conexion C = new Conexion();
    ProductosBo ModeloBo;
    Productos Vista;
    ProductosVo Listacate, Listalab;

    public ProductosController(ProductosBo ModeloBo, Productos Vista) {
        this.ModeloBo = ModeloBo;
        this.Vista = Vista;
        this.Vista.GuardarArticulo.setVisible(false);
        this.Vista.btneliminar.setVisible(false);
        this.Vista.btnactualizar.setVisible(false);

        ListaCategoria();
        ListaLaboratorio();
        this.Vista.GuardarArticulo.addActionListener(this);
        this.Vista.btnactualizar.addActionListener(this);
        this.Vista.btneliminar.addActionListener(this);
        this.Vista.atras.addActionListener(this);

        this.Vista.txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

    }

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            limpiarfiltro();
            String Buscar = Vista.txtcod.getText();
            Vista.txtcod.selectAll();
            Vista.txtcod.requestFocus();
            Filtrar(Buscar);
            if (Vista.TxtNombreArticulo.getText().isEmpty()) {
                this.Vista.btneliminar.setVisible(false);
                this.Vista.btnactualizar.setVisible(false);
                JOptionPane.showMessageDialog(null, "Este Producto No Existe, A continuncion Vera El Boton De Guardado O Sigua Escaneando Si No Desea Guardarlo");
                Vista.GuardarArticulo.setVisible(true);
            } else if (!"".equals(Vista.TxtNombreArticulo.getText())) {
                Vista.GuardarArticulo.setVisible(false);
                this.Vista.btneliminar.setVisible(true);
                this.Vista.btnactualizar.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Error, Contacte con el programador");
            }
        }
    }

    public void Filtrar(String Texto) {
        try {
            String ConsultaFiltro = "CALL Filtro (1,'" + Texto + "');";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaFiltro);

            while (ColAfectadas.next()) {
                String nombre = ColAfectadas.getString("Nombre");
                int cat = Integer.parseInt(ColAfectadas.getString("Categoria"));
                int lab = Integer.parseInt(ColAfectadas.getString("Laboratorio"));
                String uni = ColAfectadas.getString("Unidades");
                String cajas = ColAfectadas.getString("Cajas");
                String cost = ColAfectadas.getString("Costo");
                String gan = ColAfectadas.getString("Ganancia");

                Vista.TxtNombreArticulo.setText(nombre);
                Vista.Listacategoria.setSelectedIndex(cat);
                Vista.Listalaboratorio.setSelectedIndex(lab);
                Vista.TxtCantidadUnidades.setText(uni);
                Vista.TxtCantidadCajas.setText(cajas);
                Vista.TxtCosto.setText(cost);
                Vista.TxtGanancia.setText(gan);
            }
            ColAfectadas.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Filtrar: " + e);
        }
    }

    private void ListaCategoria() {
        try {
            String ConsultaListar = "CALL ListBox (1); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaListar);
            DefaultComboBoxModel Combo = new DefaultComboBoxModel();
            Combo.addElement("Seleccione Una Categoria");
            while (ColAfectadas.next()) {
                ProductosVo cate = new ProductosVo();
                cate.setIDcate(Integer.valueOf(ColAfectadas.getString("ID")));
                cate.setNombre((String) ColAfectadas.getString("Nombre"));
                Vista.Listacategoria.setModel(Combo);
                Vista.Listacategoria.addItem(cate);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Mostrar La Lista Desplegable " + e);
        }
    }

    private void ListaLaboratorio() {
        try {
            String ConsultaListar = "CALL ListBox (2); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaListar);
            DefaultComboBoxModel Combo = new DefaultComboBoxModel();
            Combo.addElement("Seleccione Un Laboratorio");
            while (ColAfectadas.next()) {
                ProductosVo lab = new ProductosVo();
                lab.setIDlab(Integer.valueOf(ColAfectadas.getString("ID")));
                lab.setNombre((String) ColAfectadas.getString("Nombre"));

                Vista.Listalaboratorio.setModel(Combo);
                Vista.Listalaboratorio.addItem(lab);
            }
            Puente.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Mostrar La Lista Desplegable " + e);
        }

    }

    public void validarCampos() {
        if (Vista.txtcod.getText().isEmpty() || Vista.TxtNombreArticulo.getText().isEmpty() || Vista.TxtCantidadUnidades.getText().isEmpty() || Vista.TxtCantidadCajas.getText().isEmpty() || Vista.TxtCosto.getText().isEmpty() || Vista.TxtGanancia.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(null, "Debe Rellenar Todos Los Campos");
        } else {

        }
    }

    public void limpiarfiltro() {
        String t = "";
        Vista.TxtNombreArticulo.setText(t);
        Vista.Listacategoria.setSelectedIndex(0);
        Vista.Listalaboratorio.setSelectedIndex(0);
        Vista.TxtCantidadUnidades.setText(t);
        Vista.TxtCantidadCajas.setText(t);
        Vista.TxtCosto.setText(t);
        Vista.TxtGanancia.setText(t);
    }

    public void limpiar() {
        String t = "";
        Vista.txtcod.setText(t);
        Vista.TxtNombreArticulo.setText(t);
        Vista.Listacategoria.setSelectedIndex(0);
        Vista.Listalaboratorio.setSelectedIndex(0);
        Vista.TxtCantidadUnidades.setText(t);
        Vista.TxtCantidadCajas.setText(t);
        Vista.TxtCosto.setText(t);
        Vista.TxtGanancia.setText(t);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.GuardarArticulo) {
            String cod = Vista.txtcod.getText();
            String name = Vista.TxtNombreArticulo.getText();
            this.Listacate = (ProductosVo) Vista.Listacategoria.getSelectedItem();
            this.Listalab = (ProductosVo) Vista.Listalaboratorio.getSelectedItem();
            int unidades = Integer.parseInt(Vista.TxtCantidadUnidades.getText());
            int cajas = Integer.parseInt(Vista.TxtCantidadCajas.getText());
            int costo = Integer.parseInt(Vista.TxtCosto.getText());
            int ganancia = Integer.parseInt(Vista.TxtGanancia.getText());
            ProductosVo atributos = new ProductosVo(cod, name, Listacate.getIDcate(), Listalab.getIDlab(), unidades, cajas, costo, ganancia);
            if (ModeloBo.Guardar(atributos)) {
                limpiar();
                Vista.GuardarArticulo.setVisible(false);
                JOptionPane.showMessageDialog(null, "Guardado Corectamente");
            } else {
                JOptionPane.showMessageDialog(Vista, "se ah producido un error");
            }
        } else if (e.getSource() == Vista.btnactualizar) {
            String cod = Vista.txtcod.getText();
            String name = Vista.TxtNombreArticulo.getText();
            this.Listacate = (ProductosVo) Vista.Listacategoria.getSelectedItem();
            this.Listalab = (ProductosVo) Vista.Listalaboratorio.getSelectedItem();
            int unidades = Integer.parseInt(Vista.TxtCantidadUnidades.getText());
            int cajas = Integer.parseInt(Vista.TxtCantidadCajas.getText());
            int costo = Integer.parseInt(Vista.TxtCosto.getText());
            int ganancia = Integer.parseInt(Vista.TxtGanancia.getText());
            ProductosVo atributos = new ProductosVo(cod, name, Listacate.getIDcate(), Listalab.getIDlab(), unidades, cajas, costo, ganancia);
            if (ModeloBo.Actulizar(atributos)) {
                limpiar();
                this.Vista.btneliminar.setVisible(false);
                this.Vista.btnactualizar.setVisible(false);
                JOptionPane.showMessageDialog(null, "Actualizado Corectamente");
            } else {
                JOptionPane.showMessageDialog(Vista, "se ah producido un error");
            }
        } else if (e.getSource() == Vista.btneliminar) {
            String cod = Vista.txtcod.getText();
            ProductosVo atributos = new ProductosVo(cod,"",0,0,0,0,0,0);
            if (ModeloBo.Eliminar(atributos)) {
                limpiar();
                this.Vista.btneliminar.setVisible(false);
                this.Vista.btnactualizar.setVisible(false);
                JOptionPane.showMessageDialog(null, "El articulo Ah Sido Eliminado De la Base de Datos");
            } else {
                JOptionPane.showMessageDialog(Vista, "se ah producido un error");
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
