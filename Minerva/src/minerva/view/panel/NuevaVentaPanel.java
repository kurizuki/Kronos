package minerva.view.panel;

import minerva.controller.NuevaVentaController;
import minerva.controller.SystemController;

/**
 *
 * @author L
 */
public class NuevaVentaPanel extends javax.swing.JPanel {
    // CONTROLLER
    NuevaVentaController nuevaVentaController = null;
    
    public NuevaVentaPanel(SystemController systemController) {
        initComponents();
        nuevaVentaController= new NuevaVentaController(systemController);
        actualizarDatos();
    }
      
    private void actualizarDatos() {
        vendedorUsuarioLabel.setText(nuevaVentaController.getVendedorUsuario());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JTabbedPane();
        panel_1 = new javax.swing.JPanel();
        codigo = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        descripcionTXT = new javax.swing.JTextField();
        stock = new javax.swing.JLabel();
        eliminar = new javax.swing.JButton();
        tabla_nuevaVenta = new javax.swing.JScrollPane();
        tabla_1 = new javax.swing.JTable();
        botonRegistrarEImprimir = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        total_precio = new javax.swing.JLabel();
        botonImprimir = new javax.swing.JButton();
        botonRegistrarVenta = new javax.swing.JButton();
        codigo1 = new javax.swing.JLabel();
        javax.swing.JTextField codigoTXT1 = new javax.swing.JTextField();
        javax.swing.JTextField codigoTXT2 = new javax.swing.JTextField();
        codigo2 = new javax.swing.JLabel();
        vendedorUsuarioLabel = new javax.swing.JLabel();
        stockLabel = new javax.swing.JLabel();

        body.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                bodyAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        codigo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        codigo.setText("Vendedor");

        descripcion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        descripcion.setText("Cliente");

        descripcionTXT.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        stock.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        stock.setText("Stock ");

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        tabla_1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tabla_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "COD", "PRODUCTO", "DESCRIPCION", "CANTIDAD", "PRECIO U.", "MONTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_nuevaVenta.setViewportView(tabla_1);
        if (tabla_1.getColumnModel().getColumnCount() > 0) {
            tabla_1.getColumnModel().getColumn(0).setPreferredWidth(5);
            tabla_1.getColumnModel().getColumn(1).setPreferredWidth(50);
            tabla_1.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabla_1.getColumnModel().getColumn(5).setPreferredWidth(15);
        }

        botonRegistrarEImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        botonRegistrarEImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarEImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarEImprimirProductoActionPerformed(evt);
            }
        });

        total.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        total.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/money.png"))); // NOI18N
        total.setText("TOTAL A PAGAR");

        total_precio.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        total_precio.setText("-----");

        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        botonImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });

        botonRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/print.png"))); // NOI18N
        botonRegistrarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarVentaregistrarProductoActionPerformed(evt);
            }
        });

        codigo1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        codigo1.setText("Codigo");

        codigoTXT1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        codigoTXT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTXT1ActionPerformed(evt);
            }
        });

        codigoTXT2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        codigoTXT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTXT2ActionPerformed(evt);
            }
        });

        codigo2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        codigo2.setText("Cantidad");

        vendedorUsuarioLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        stockLabel.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        javax.swing.GroupLayout panel_1Layout = new javax.swing.GroupLayout(panel_1);
        panel_1.setLayout(panel_1Layout);
        panel_1Layout.setHorizontalGroup(
            panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo)
                    .addComponent(vendedorUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcion)
                    .addComponent(descripcionTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(eliminar)
                .addGap(19, 19, 19))
            .addGroup(panel_1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo1)
                    .addComponent(codigoTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigo2)
                    .addComponent(codigoTXT2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonRegistrarEImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(total)
                .addGap(42, 42, 42)
                .addComponent(total_precio)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabla_nuevaVenta)
                .addContainerGap())
        );
        panel_1Layout.setVerticalGroup(
            panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_1Layout.createSequentialGroup()
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigo)
                            .addComponent(stock)
                            .addComponent(descripcion))
                        .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(descripcionTXT)
                                    .addComponent(vendedorUsuarioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stockLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addGroup(panel_1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(eliminar)))
                .addGap(21, 21, 21)
                .addComponent(tabla_nuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRegistrarEImprimir)
                    .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total)
                        .addComponent(total_precio))
                    .addComponent(botonRegistrarVenta)
                    .addComponent(botonImprimir)
                    .addGroup(panel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panel_1Layout.createSequentialGroup()
                            .addComponent(codigo2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(codigoTXT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panel_1Layout.createSequentialGroup()
                            .addComponent(codigo1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(codigoTXT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        body.addTab("NuevaVenta", panel_1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bodyAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bodyAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_bodyAncestorMoved

    private void codigoTXT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTXT1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTXT1ActionPerformed

    private void botonRegistrarVentaregistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarVentaregistrarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegistrarVentaregistrarProductoActionPerformed

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonImprimirActionPerformed

    private void botonRegistrarEImprimirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarEImprimirProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegistrarEImprimirProductoActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed

    private void codigoTXT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoTXT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoTXT2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane body;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JButton botonRegistrarEImprimir;
    private javax.swing.JButton botonRegistrarVenta;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel codigo1;
    private javax.swing.JLabel codigo2;
    private javax.swing.JLabel descripcion;
    private javax.swing.JTextField descripcionTXT;
    private javax.swing.JButton eliminar;
    private javax.swing.JPanel panel_1;
    private javax.swing.JLabel stock;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JTable tabla_1;
    private javax.swing.JScrollPane tabla_nuevaVenta;
    private javax.swing.JLabel total;
    private javax.swing.JLabel total_precio;
    private javax.swing.JLabel vendedorUsuarioLabel;
    // End of variables declaration//GEN-END:variables
}
