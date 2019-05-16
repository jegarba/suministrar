package Controladores;

import Conexion.Conexion;
import Conexion.sql;
import Modelos.PdfBo;
import Modelos.PdfVo;
import Modelos.PrincipalBo;
import vistas.Pdf;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;

public final class PdfController implements ActionListener {

    Conexion C = new Conexion();
    PdfBo ModeloBo;
    Pdf Vista;
    //
    PdfVo Listadro, Listapro;
    String ruta_archivo = "";
    int id = -1;

    public PdfController(PdfBo ModeloBo, Pdf Vista) {
        this.ModeloBo = ModeloBo;
        this.Vista = Vista;
        ListaDrogeria();
        ListaProveedor();
        this.Vista.btnnuevo.addActionListener(this);
        this.Vista.btnseleccionar.addActionListener(this);
        this.Vista.btnguardar.addActionListener(this);
        this.Vista.btneliminar.addActionListener(this);
        this.Vista.btncancelar.addActionListener(this);
        this.Vista.btnmodificar.addActionListener(this);
        this.Vista.btnback.addActionListener(this);

        activa_boton(false, false, false);
        bloquearcampos(false, false, false, false, false, false);

        Vista.tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        Mostrartabla();
    }

    private void ListaDrogeria() {
        try {
            String ConsultaListar = "CALL ListBox (4); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaListar);
            DefaultComboBoxModel Combo = new DefaultComboBoxModel();
            Combo.addElement("Seleccione Una Drogeria");
            while (ColAfectadas.next()) {
                PdfVo cate = new PdfVo();
                cate.setIDdro(Integer.valueOf(ColAfectadas.getString("ID")));
                cate.setNombre((String) ColAfectadas.getString("Nombre"));
                Vista.listadrogeria.setModel(Combo);
                Vista.listadrogeria.addItem(cate);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Mostrar La Lista Desplegable " + e);
        }
    }

    private void ListaProveedor() {
        try {
            String ConsultaListar = "CALL ListBox (5); ";
            Statement Puente = C.Conectar().createStatement();
            ResultSet ColAfectadas = Puente.executeQuery(ConsultaListar);
            DefaultComboBoxModel Combo = new DefaultComboBoxModel();
            Combo.addElement("Seleccione Un Proveedor");
            while (ColAfectadas.next()) {
                PdfVo cate = new PdfVo();
                cate.setIDpro(Integer.valueOf(ColAfectadas.getString("ID")));
                cate.setNombre((String) ColAfectadas.getString("PROVEEDOR"));
                Vista.listaproveedor.setModel(Combo);
                Vista.listaproveedor.addItem(cate);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, No Se Pudo Mostrar La Lista Desplegable " + e);
        }
    }

    public void activa_boton(boolean a, boolean b, boolean c) {
        Vista.btnguardar.setEnabled(a);
        Vista.btnguardar.setVisible(a);
        Vista.btnmodificar.setEnabled(b);
        Vista.btnmodificar.setVisible(b);
        Vista.btneliminar.setEnabled(c);
        Vista.btneliminar.setVisible(c);
        Vista.txtname.setText("");
        Vista.txtname.setText("");
        Vista.txtvalor.setText("");
        Vista.txtfechaemi.setCalendar(null);
        Vista.txtfechavenci.setCalendar(null);
        Vista.listadrogeria.setSelectedIndex(0);
        Vista.listaproveedor.setSelectedIndex(0);
        Vista.btnseleccionar.setText("Seleccionar...");
    }

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {
        int column = Vista.tabla.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / Vista.tabla.getRowHeight();
        activa_boton(false, true, true);
        bloquearcampos(true, true, true, true, true, true);
        if (row < Vista.tabla.getRowCount() && row >= 0 && column < Vista.tabla.getColumnCount() && column >= 0) {
            this.id = (int) Vista.tabla.getValueAt(row, 0);
            Object value = Vista.tabla.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    ModeloBo.ejecutar_archivoPDF(this.id);
                    try {
                        Desktop.getDesktop().open(new File("new.pdf"));
                    } catch (IOException ex) {
                    }
                }
            } else {
                String nombre = "" + Vista.tabla.getValueAt(row, 1);
                String valor = "" + Vista.tabla.getValueAt(row, 3);
                String emision = "" + Vista.tabla.getValueAt(row, 4);
                String vencimiento = "" + Vista.tabla.getValueAt(row, 5);
                int drogeria = Integer.parseInt(Vista.tabla.getValueAt(row, 6).toString());
                int provedor = Integer.parseInt(Vista.tabla.getValueAt(row, 7).toString());
                Vista.txtname.setText(nombre);
                Vista.txtvalor.setText(valor);
                Vista.listadrogeria.setSelectedIndex(drogeria);
                Vista.listaproveedor.setSelectedIndex(provedor);
                //llenar los jcalendar con los datos de mysql
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    java.util.Date fechaemimysql = format.parse(emision);
                    java.util.Date fechavencimysql = format.parse(vencimiento);
                    Vista.txtfechaemi.setDate(fechaemimysql);
                    Vista.txtfechavenci.setDate(fechavencimysql);
                } catch (ParseException ex) {
                    Logger.getLogger(PdfController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void Mostrartabla() {
        Vista.tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("nombrepdf");
        dt.addColumn("PDF");
        dt.addColumn("Valor");
        dt.addColumn("F_Emision");
        dt.addColumn("F_Vencimiento");
        dt.addColumn("Drogeria");
        dt.addColumn("Proveedor");

        ImageIcon icono = null;
        if (get_Image("/Resources/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/Resources/32pdf.png"));
        }
        PdfVo vo = new PdfVo();
        ArrayList<PdfVo> list = ModeloBo.Listar_PdfVo();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[8];
                vo = list.get(i);
                fila[0] = vo.getCodigopdf();
                fila[1] = vo.getNombrepdf();
                if (vo.getArchivopdf() != null) {
                    fila[2] = new JButton(icono);
                } else {
                    fila[2] = new JButton("Vacio");
                }
                fila[3] = vo.getValorpdf();
                fila[4] = vo.getFechaemi();
                fila[5] = vo.getFechavenci();
                fila[6] = vo.getDrogeria();
                fila[7] = vo.getProveedor();
                dt.addRow(fila);
            }
            Vista.tabla.setModel(dt);
            Vista.tabla.setRowHeight(32);
            Vista.tabla.getColumnModel().getColumn(0).setPreferredWidth(-2);
            Vista.tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
            Vista.tabla.getColumnModel().getColumn(2).setPreferredWidth(2);
        }
    }

    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }

    public void guardar_pdf(int codigo, String nombre, File ruta, int valor, Date Emis, Date venc, int drog, int prov) {
        PdfVo po = new PdfVo();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        po.setValorpdf(valor);
        po.setFechaemi(Emis);
        po.setFechavenci(venc);
        po.setDrogeria(drog);
        po.setProveedor(prov);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        ModeloBo.Agregar_PdfVO(po);
    }

    public void eliminar_pdf(int codigo) {
        PdfVo po = new PdfVo();
        po.setCodigopdf(codigo);
        ModeloBo.Eliminar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, String nombre, File ruta, int valor, Date Emis, Date venc, int drog, int prov) {
        PdfVo po = new PdfVo();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        po.setValorpdf(valor);
        po.setFechaemi(Emis);
        po.setFechavenci(venc);
        po.setDrogeria(drog);
        po.setProveedor(prov);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        ModeloBo.Modificar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, String nombre, int valor, Date Emis, Date venc, int drog, int prov) {
        PdfVo po = new PdfVo();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        po.setValorpdf(valor);
        po.setFechaemi(Emis);
        po.setFechavenci(venc);
        po.setDrogeria(drog);
        po.setProveedor(prov);
        ModeloBo.Modificar_PdfVO2(po);
    }

    public void bloquearcampos(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f) {
        Vista.txtname.setEnabled(a);
        Vista.txtvalor.setEnabled(b);
        Vista.txtfechaemi.setEnabled(c);
        Vista.txtfechavenci.setEnabled(d);
        Vista.listadrogeria.setEnabled(e);
        Vista.listaproveedor.setEnabled(f);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Vista.btnnuevo) {
            activa_boton(true, false, false);
            bloquearcampos(true, true, true, true, true, true);
            ruta_archivo = "";
        } else if (e.getSource() == Vista.btnseleccionar) {
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
            j.setFileFilter(fi);
            int se = j.showOpenDialog(Vista);
            if (se == 0) {
                Vista.btnseleccionar.setText("" + j.getSelectedFile().getName());
                Vista.txtname.setText("" + j.getSelectedFile().getName());
                ruta_archivo = j.getSelectedFile().getAbsolutePath();
            } else {
            }
        } else if (e.getSource() == Vista.btnguardar) {
            String nombre = Vista.txtname.getText();
            int valor = Integer.parseInt(Vista.txtvalor.getText());
            //obtenerfecha de jcalendar en formato sql
            java.util.Date emisi = Vista.txtfechaemi.getDate();
            Long Em = emisi.getTime();
            java.sql.Date emi = new java.sql.Date(Em);
            java.util.Date venc = Vista.txtfechavenci.getDate();
            Long Ve = venc.getTime();
            java.sql.Date ven = new java.sql.Date(Ve);
            //
            //obtener el id del combobox
            this.Listadro = (PdfVo) Vista.listadrogeria.getSelectedItem();
            this.Listapro = (PdfVo) Vista.listaproveedor.getSelectedItem();
            //
            sql s = new sql();
            int codigo = s.auto_increment("SELECT MAX(codigopdf) FROM pdf;");
            File ruta = new File(ruta_archivo);
            if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
                guardar_pdf(codigo, nombre, ruta, valor, emi, ven, Listadro.getIDdro(), Listapro.getIDpro());
                Mostrartabla();
                ruta_archivo = "";
                activa_boton(false, false, false);
                bloquearcampos(false, false, false, false, false, false);
            } else {
                JOptionPane.showMessageDialog(null, "Rellenar todo los campos");
            }
        } else if (e.getSource() == Vista.btneliminar) {
            eliminar_pdf(id);
            Mostrartabla();
            activa_boton(false, false, false);
            bloquearcampos(false, false, false, false, false, false);
            ruta_archivo = "";
        } else if (e.getSource() == Vista.btncancelar) {
            activa_boton(false, false, false);
            ruta_archivo = "";
            bloquearcampos(false, false, false, false, false, false);
        } else if (e.getSource() == Vista.btnmodificar) {
            String nombre = Vista.txtname.getText();
            int valor = Integer.parseInt(Vista.txtvalor.getText());
            //obtenerfecha de jcalendar en formato sql
            java.util.Date emisi = Vista.txtfechaemi.getDate();
            Long Em = emisi.getTime();
            java.sql.Date emi = new java.sql.Date(Em);
            java.util.Date venc = Vista.txtfechavenci.getDate();
            Long Ve = venc.getTime();
            java.sql.Date ven = new java.sql.Date(Ve);
            //
            //obtener el id del combobox
            this.Listadro = (PdfVo) Vista.listadrogeria.getSelectedItem();
            this.Listapro = (PdfVo) Vista.listaproveedor.getSelectedItem();
            //
            File ruta = new File(ruta_archivo);
            if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
                modificar_pdf(id, nombre, ruta, valor, emi, ven, Listadro.getIDdro(), Listapro.getIDpro());
                Mostrartabla();
            } else if (ruta_archivo.trim().length() == 0) {
                modificar_pdf(id, nombre, valor, emi, ven, Listadro.getIDdro(), Listapro.getIDpro());
                Mostrartabla();
            }
            ruta_archivo = "";
            activa_boton(false, false, false);
            bloquearcampos(false, false, false, false, false, false);
        } else if (e.getSource() == Vista.btnback) {
            Vista.dispose();
            PrincipalBo ModeloPrincipal = new PrincipalBo();
            Principal ventanaprincipal = new Principal();
            ventanaprincipal.setVisible(true);
            new PrincipalController(ventanaprincipal, ModeloPrincipal);
        }
    }

}
