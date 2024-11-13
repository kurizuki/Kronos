package minerva.view.panel;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import minerva.controller.ControllerPanelProducto;
import minerva.controller.ControllerSystem;
import minerva.model.ExceptionHandler;

/**
 *
 * @author L
 */
public class PanelProducto extends javax.swing.JPanel {

    // CONTROLLER
    ControllerPanelProducto productoController = null;
    
    public PanelProducto(ControllerSystem controllerSystem) {
        initComponents();
        productoController = new ControllerPanelProducto(controllerSystem);
        asignarListenerEnter();
    }
    
    private void asignarListenerEnter() {
        codigoBarrasTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonRegistrarProductoActionPerformed(evt);
            }
        });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        REGISTRO = new javax.swing.JTabbedPane();
        panel_4 = new javax.swing.JPanel();
        codigo_panel_4 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        descripcion_panel_4 = new javax.swing.JLabel();
        precioTextField = new javax.swing.JTextField();
        cantidad_panel_4 = new javax.swing.JLabel();
        stockTextField = new javax.swing.JTextField();
        precio_panel_4 = new javax.swing.JLabel();
        codigoBarrasTextField = new javax.swing.JTextField();
        proveedor_4 = new javax.swing.JLabel();
        tabla_productos = new javax.swing.JScrollPane();
        TablaRegistro = new javax.swing.JTable();
        botonRegistrarProducto = new javax.swing.JButton();
        descripcionTextField = new javax.swing.JTextField();
        CONSULTA = new javax.swing.JPanel();
        tabla_productos1 = new javax.swing.JScrollPane();
        tablaConsulta = new javax.swing.JTable();
        botonNuevo_5 = new javax.swing.JButton();
        precioTXT_5 = new javax.swing.JTextField();
        precio_panel_5 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        REGISTRO.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                REGISTROComponentAdded(evt);
            }
        });

        panel_4.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                panel_4ComponentAdded(evt);
            }
        });

        codigo_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        codigo_panel_4.setText("NOMBRE");

        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        descripcion_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        descripcion_panel_4.setText("PRECIO");

        precioTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });

        cantidad_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cantidad_panel_4.setText("STOCK");

        stockTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTextFieldActionPerformed(evt);
            }
        });
        stockTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockKeyTyped(evt);
            }
        });

        precio_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        precio_panel_4.setText("CODIGO BARRAS");

        codigoBarrasTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoBarrasTextFieldActionPerformed(evt);
            }
        });
        codigoBarrasTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoBarrasKeyTyped(evt);
            }
        });

        proveedor_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        proveedor_4.setText("DESCRIPCION");

        TablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "PRECIO", "DESCRIPCION", "STOCK"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_productos.setViewportView(TablaRegistro);

        botonRegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        botonRegistrarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_4Layout = new javax.swing.GroupLayout(panel_4);
        panel_4.setLayout(panel_4Layout);
        panel_4Layout.setHorizontalGroup(
            panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_4Layout.createSequentialGroup()
                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_4Layout.createSequentialGroup()
                        .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_4Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precioTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_4Layout.createSequentialGroup()
                                            .addComponent(proveedor_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(descripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panel_4Layout.createSequentialGroup()
                                            .addComponent(precio_panel_4)
                                            .addGap(18, 18, 18)
                                            .addComponent(codigoBarrasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(panel_4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_4Layout.createSequentialGroup()
                                        .addComponent(cantidad_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(stockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel_4Layout.createSequentialGroup()
                                        .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(descripcion_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(panel_4Layout.createSequentialGroup()
                                                .addComponent(codigo_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18))
                    .addGroup(panel_4Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(botonRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)))
                .addComponent(tabla_productos, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel_4Layout.setVerticalGroup(
            panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_panel_4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcion_panel_4))
                .addGap(42, 42, 42)
                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad_panel_4))
                .addGap(44, 44, 44)
                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proveedor_4)
                    .addComponent(descripcionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panel_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoBarrasTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio_panel_4))
                .addGap(42, 42, 42)
                .addComponent(botonRegistrarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabla_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        REGISTRO.addTab("REGISTRO", panel_4);

        tablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "PRECIO", "DESCRIPCION", "STOCK", "CODIGOBARRAS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_productos1.setViewportView(tablaConsulta);

        botonNuevo_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        botonNuevo_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        precioTXT_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTXT_5ActionPerformed(evt);
            }
        });

        precio_panel_5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        precio_panel_5.setText("CODIGO BARRAS");

        botonActualizar.setText("ACTUALIZAR PRODUCTO");
        botonActualizar.setToolTipText("");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("MODO");

        javax.swing.GroupLayout CONSULTALayout = new javax.swing.GroupLayout(CONSULTA);
        CONSULTA.setLayout(CONSULTALayout);
        CONSULTALayout.setHorizontalGroup(
            CONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONSULTALayout.createSequentialGroup()
                .addGroup(CONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CONSULTALayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(precio_panel_5))
                    .addGroup(CONSULTALayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(botonNuevo_5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CONSULTALayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(CONSULTALayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(precioTXT_5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CONSULTALayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(botonActualizar)))
                .addGap(12, 12, 12)
                .addComponent(tabla_productos1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        CONSULTALayout.setVerticalGroup(
            CONSULTALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CONSULTALayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(precio_panel_5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(precioTXT_5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(botonNuevo_5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CONSULTALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabla_productos1)
                .addContainerGap())
        );

        REGISTRO.addTab("CONSULTA", CONSULTA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        REGISTRO.addTab("tab3", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(REGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(REGISTRO, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void REGISTROComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_REGISTROComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_REGISTROComponentAdded

    private void panel_4ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_panel_4ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_panel_4ComponentAdded

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    private void precioTXT_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTXT_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioTXT_5ActionPerformed

    private void stockTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTextFieldActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarProductoActionPerformed
        // VALIDEMOS QUE LOS CAMPOS NECESARIOS PARA EL REGISTRO NO ESTEN VACIOS
        // USAMOS EL TRY POR LOS POSIBLES DATOS INCOPATIBLES QUE PUEDA INGRESAR EL USUARIO
        String mensaje = "";
        try {
            if (nombreTextField.getText().isEmpty()) {
                mensaje = "FALTA NOMBRE";
            } else if (precioTextField.getText().isEmpty() || Integer.parseInt(precioTextField.getText()) <  1){
                mensaje = "FALTA PRECIO";
            } else if (descripcionTextField.getText().isEmpty()) {
                mensaje = "FALTA DESCRIPCION";
            } else if (stockTextField.getText().isEmpty() || Integer.parseInt(stockTextField.getText()) <  1) {
                mensaje = "FALTA STOCK";
            } else if (codigoBarrasTextField.getText().isEmpty() || Integer.parseInt(codigoBarrasTextField.getText()) <  1) {
                mensaje = "FALTA CODIGO BARRAS";
            }
        } catch (HeadlessException | NumberFormatException e) {
            ExceptionHandler exceptionHandler = new ExceptionHandler("CAYO LA ULTIMA BARRERA DE DEFENSA CONTRA LOS ERRORES XDDD", e.toString());
            return;
        }
        
        if (!(mensaje.isEmpty())) {
            JOptionPane.showMessageDialog(null, mensaje);
            return;
        }
                
        System.out.println("LLEGAMOS AL FINAL");
    }//GEN-LAST:event_botonRegistrarProductoActionPerformed

    private void codigoBarrasTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoBarrasTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoBarrasTextFieldActionPerformed

    private void codigoBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBarrasKeyTyped
        // CODIGO PARA QUE SOLAMENTE SE PUEDAN INGRESAR NUMEROS
        char c = evt.getKeyChar();
        
        if (c<'0' || c> '9') {
            evt.consume();            
        }
    }//GEN-LAST:event_codigoBarrasKeyTyped

    private void stockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockKeyTyped
        // CODIGO PARA QUE SOLAMENTE SE PUEDAN INGRESAR NUMEROS
        char c = evt.getKeyChar();
        
        if (c<'0' || c> '9') {
            evt.consume();            
        }
    }//GEN-LAST:event_stockKeyTyped

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        // CODIGO PARA QUE SOLAMENTE SE PUEDAN INGRESAR NUMEROS
        char c = evt.getKeyChar();
        
        if (c<'0' || c> '9') {
            evt.consume();            
        }
    }//GEN-LAST:event_precioKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CONSULTA;
    private javax.swing.JTabbedPane REGISTRO;
    private javax.swing.JTable TablaRegistro;
    private javax.swing.JCheckBox botonActualizar;
    private javax.swing.JButton botonNuevo_5;
    private javax.swing.JButton botonRegistrarProducto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel cantidad_panel_4;
    private javax.swing.JTextField codigoBarrasTextField;
    private javax.swing.JLabel codigo_panel_4;
    private javax.swing.JTextField descripcionTextField;
    private javax.swing.JLabel descripcion_panel_4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JPanel panel_4;
    private javax.swing.JTextField precioTXT_5;
    private javax.swing.JTextField precioTextField;
    private javax.swing.JLabel precio_panel_4;
    private javax.swing.JLabel precio_panel_5;
    private javax.swing.JLabel proveedor_4;
    private javax.swing.JTextField stockTextField;
    private javax.swing.JTable tablaConsulta;
    private javax.swing.JScrollPane tabla_productos;
    private javax.swing.JScrollPane tabla_productos1;
    // End of variables declaration//GEN-END:variables
}
