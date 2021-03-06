package vistas;

import Modelos.ProductosVo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
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

        panelArticulos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TxtGanancia = new rojeru_san.RSMTextFull();
        jLabel3 = new javax.swing.JLabel();
        TxtCosto = new rojeru_san.RSMTextFull();
        jLabel5 = new javax.swing.JLabel();
        TxtCantidadCajas = new rojeru_san.RSMTextFull();
        jLabel6 = new javax.swing.JLabel();
        TxtCantidadUnidades = new rojeru_san.RSMTextFull();
        jLabel9 = new javax.swing.JLabel();
        Listalaboratorio = new javax.swing.JComboBox<>();
        Listacategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtNombreArticulo = new rojeru_san.RSMTextFull();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcod = new rojeru_san.RSMTextFull();
        btneliminar = new rojeru_san.RSButtonRiple();
        btnactualizar = new rojeru_san.RSButtonRiple();
        GuardarArticulo = new rojeru_san.RSButtonRiple();
        atras = new rojeru_san.RSButtonRiple();
        rSPanelImage1 = new rojerusan.RSPanelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelArticulos.setBackground(new java.awt.Color(255, 255, 255));
        panelArticulos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 112, 197), 1, true));
        panelArticulos.setForeground(new java.awt.Color(255, 255, 255));
        panelArticulos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 112, 192));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestion De Productos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelArticulos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 190, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TxtGanancia.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtGanancia.setModoMaterial(true);
        TxtGanancia.setPlaceholder("% De Ganancia...");
        jPanel2.add(TxtGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 260, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Precio.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, -1));

        TxtCosto.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtCosto.setModoMaterial(true);
        TxtCosto.setPlaceholder("Costo Del Articulo...");
        jPanel2.add(TxtCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 260, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Precio.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        TxtCantidadCajas.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtCantidadCajas.setModoMaterial(true);
        TxtCantidadCajas.setPlaceholder("Cantidad En Cajas...");
        jPanel2.add(TxtCantidadCajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 260, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/box.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        TxtCantidadUnidades.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtCantidadUnidades.setModoMaterial(true);
        TxtCantidadUnidades.setPlaceholder("Cantidad En Unidades...");
        jPanel2.add(TxtCantidadUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 260, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/countdown.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        jPanel2.add(Listalaboratorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 240, 33));

        jPanel2.add(Listacategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 240, 33));

        jLabel7.setText("Laboratorio");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel8.setText("Categoria");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        TxtNombreArticulo.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        TxtNombreArticulo.setModoMaterial(true);
        TxtNombreArticulo.setPlaceholder("Ingrese el Nombre Del Articulo...");
        jPanel2.add(TxtNombreArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/delivery-cart.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/qr-code.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        txtcod.setBordeColorNoFocus(new java.awt.Color(153, 153, 153));
        txtcod.setModoMaterial(true);
        txtcod.setPlaceholder("Codigo Del Articulo...");
        jPanel2.add(txtcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        btneliminar.setText("Eliminar Producto");
        btneliminar.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        jPanel2.add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 240, -1));

        btnactualizar.setText("Actualizar Producto");
        btnactualizar.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        jPanel2.add(btnactualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 240, -1));

        GuardarArticulo.setText("Registrar Producto");
        GuardarArticulo.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        jPanel2.add(GuardarArticulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 240, -1));

        panelArticulos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 540));

        atras.setText("Atras");
        panelArticulos.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 74, -1));

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/Resources/Logo SUMINISTRAR Nuevo.png"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        panelArticulos.add(rSPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 200, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public rojeru_san.RSButtonRiple GuardarArticulo;
    public javax.swing.JComboBox<ProductosVo> Listacategoria;
    public javax.swing.JComboBox<ProductosVo> Listalaboratorio;
    public rojeru_san.RSMTextFull TxtCantidadCajas;
    public rojeru_san.RSMTextFull TxtCantidadUnidades;
    public rojeru_san.RSMTextFull TxtCosto;
    public rojeru_san.RSMTextFull TxtGanancia;
    public rojeru_san.RSMTextFull TxtNombreArticulo;
    public rojeru_san.RSButtonRiple atras;
    public rojeru_san.RSButtonRiple btnactualizar;
    public rojeru_san.RSButtonRiple btneliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelArticulos;
    private rojerusan.RSPanelImage rSPanelImage1;
    public rojeru_san.RSMTextFull txtcod;
    // End of variables declaration//GEN-END:variables
}
