package vistas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Facturacion extends javax.swing.JFrame {

    public Facturacion() {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaArticulos = new javax.swing.JTable();
        AtrasUsu = new rojeru_san.RSButtonRiple();
        TextIdUsu = new rojeru_san.RSMTextFull();
        jLabel1 = new javax.swing.JLabel();
        agregarAR = new rojeru_san.RSButtonRiple();
        PanelReporte = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaventa = new javax.swing.JTable();
        quitar = new javax.swing.JButton();
        btnmodipre = new javax.swing.JButton();
        valortotal = new rojeru_san.RSMTextFull();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtFacturaDireccion = new rojeru_san.RSMTextFull();
        TxtFacturaNit = new rojeru_san.RSMTextFull();
        TxtFacturaNombre = new rojeru_san.RSMTextFull();
        jLabel6 = new javax.swing.JLabel();
        TxtFacturaTelefono = new rojeru_san.RSMTextFull();
        lblvalor = new javax.swing.JLabel();
        FacturarArticulo = new rojeru_san.RSButtonRiple();
        rSPanelImage1 = new rojerusan.RSPanelImage();
        panelArticulos = new javax.swing.JPanel();
        TxtNombreArticulo = new rojeru_san.RSMTextFull();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TxtPrecioPrecio = new rojeru_san.RSMTextFull();
        GuardarArticulo = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 112, 192));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("facturacion");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, -1, -1));

        TablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaArticulos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(TablaArticulos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 610, 180));

        AtrasUsu.setText("Atras");
        jPanel2.add(AtrasUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 77, -1));

        TextIdUsu.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TextIdUsu.setModoMaterial(true);
        TextIdUsu.setPlaceholder("Buscar Articulos Por Nombre...");
        jPanel2.add(TextIdUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/buscar.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, -1, 32));

        agregarAR.setText("Facturar");
        jPanel2.add(agregarAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 170, 40));

        PanelReporte.setBackground(new java.awt.Color(255, 255, 255));
        PanelReporte.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 112, 197), 1, true));
        PanelReporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 112, 197));
        jLabel4.setText("Generador De Factura");
        PanelReporte.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));

        tablaventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tablaventa);

        PanelReporte.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, 280));

        quitar.setText("Retirar");
        PanelReporte.add(quitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 80, -1));

        btnmodipre.setText("Modificar Precio");
        PanelReporte.add(btnmodipre, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 140, -1));

        valortotal.setPlaceholder("Valor Total");
        PanelReporte.add(valortotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, 40));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/phone-call.png"))); // NOI18N
        PanelReporte.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 200, 30, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/id-card.png"))); // NOI18N
        PanelReporte.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 30, 40));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/address.png"))); // NOI18N
        PanelReporte.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 30, 30));

        TxtFacturaDireccion.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtFacturaDireccion.setModoMaterial(true);
        TxtFacturaDireccion.setPlaceholder("Direccion...");
        PanelReporte.add(TxtFacturaDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 140, 240, -1));

        TxtFacturaNit.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtFacturaNit.setModoMaterial(true);
        TxtFacturaNit.setPlaceholder("C.C. ó NIT.");
        PanelReporte.add(TxtFacturaNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 240, -1));

        TxtFacturaNombre.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtFacturaNombre.setModoMaterial(true);
        TxtFacturaNombre.setPlaceholder("Nombres...");
        PanelReporte.add(TxtFacturaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 240, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/lbl-user1.png"))); // NOI18N
        PanelReporte.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 30, 30));

        TxtFacturaTelefono.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtFacturaTelefono.setModoMaterial(true);
        TxtFacturaTelefono.setPlaceholder("Ingrese Telefono...");
        PanelReporte.add(TxtFacturaTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 190, 240, -1));

        lblvalor.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblvalor.setForeground(new java.awt.Color(255, 51, 51));
        PanelReporte.add(lblvalor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 510, 30));

        FacturarArticulo.setText("Imprimir");
        PanelReporte.add(FacturarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, -1, -1));

        jPanel2.add(PanelReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 970, 370));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logo SUMINISTRAR Nuevo.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 264, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );

        jPanel2.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        panelArticulos.setBackground(new java.awt.Color(255, 255, 255));
        panelArticulos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 112, 197), 1, true));
        panelArticulos.setForeground(new java.awt.Color(255, 255, 255));

        TxtNombreArticulo.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtNombreArticulo.setModoMaterial(true);
        TxtNombreArticulo.setPlaceholder("Ingrese el Nombre Del Articulo...");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delivery-cart.png"))); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Precio.png"))); // NOI18N

        TxtPrecioPrecio.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtPrecioPrecio.setModoMaterial(true);
        TxtPrecioPrecio.setPlaceholder("Precio Del Articulo...");

        GuardarArticulo.setText("Agregar");
        GuardarArticulo.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelArticulosLayout = new javax.swing.GroupLayout(panelArticulos);
        panelArticulos.setLayout(panelArticulosLayout);
        panelArticulosLayout.setHorizontalGroup(
            panelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArticulosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GuardarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelArticulosLayout.createSequentialGroup()
                        .addGroup(panelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPrecioPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelArticulosLayout.setVerticalGroup(
            panelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelArticulosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TxtNombreArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(panelArticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(TxtPrecioPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(GuardarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(panelArticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 320, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Facturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rojeru_san.RSButtonRiple AtrasUsu;
    public rojeru_san.RSButtonRiple FacturarArticulo;
    public rojeru_san.RSButtonRiple GuardarArticulo;
    private javax.swing.JPanel PanelReporte;
    public javax.swing.JTable TablaArticulos;
    public rojeru_san.RSMTextFull TextIdUsu;
    public rojeru_san.RSMTextFull TxtFacturaDireccion;
    public rojeru_san.RSMTextFull TxtFacturaNit;
    public rojeru_san.RSMTextFull TxtFacturaNombre;
    public rojeru_san.RSMTextFull TxtFacturaTelefono;
    public rojeru_san.RSMTextFull TxtNombreArticulo;
    public rojeru_san.RSMTextFull TxtPrecioPrecio;
    public rojeru_san.RSButtonRiple agregarAR;
    public javax.swing.JButton btnmodipre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel lblvalor;
    private javax.swing.JPanel panelArticulos;
    public javax.swing.JButton quitar;
    private rojerusan.RSPanelImage rSPanelImage1;
    public javax.swing.JTable tablaventa;
    public rojeru_san.RSMTextFull valortotal;
    // End of variables declaration//GEN-END:variables
}
