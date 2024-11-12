package minerva.view;

import minerva.view.panel.PanelVenta;
import minerva.view.panel.PanelCliente;
import minerva.view.panel.PanelProveedor;
import minerva.view.panel.PanelNuevaVenta;
import minerva.view.panel.PanelProducto;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import minerva.controller.ControllerSystem;


public class SystemView extends javax.swing.JFrame {

    //VARIABLES DEL MOUSE
    int xMouse, yMouse;
    
    // CONTROLLER
    ControllerSystem systemController = null;
    
    // PANELES
    PanelNuevaVenta nuevaVentaPanel = null;
    PanelCliente   clientesPanel  = null;
    PanelProveedor  proveedorPanel = null;
    PanelProducto  productosPanel = null;
    PanelVenta     ventasPanel    = null;

    public SystemView() {       
    }

    public SystemView(String usuario) {
        initComponents();
        //CENTRALIZA LA VENTANA DEL PROGRAMA
        this.setLocationRelativeTo(null);
       
        // CONTROLLER INICIALIZAR
        systemController = new ControllerSystem(usuario);
        
        // PANEL INICIALIZAR
        nuevaVentaPanel= new PanelNuevaVenta(systemController);
        clientesPanel  = new PanelCliente(systemController);
        proveedorPanel = new PanelProveedor(systemController);
        productosPanel = new PanelProducto(systemController);
        ventasPanel    = new PanelVenta(systemController);
        
        // ESTE ES EL PANEL INICIAL QUE SE MOSTRARÁ
        dibujarPanel(nuevaVentaPanel);
    }
  
    public ControllerSystem getController() {
        return systemController;
    }
    
    private void dibujarPanel(JPanel jPanel) {
        jPanel.setSize(1080, 610);
        jPanel.setLocation(0, 0);
        
        content.removeAll();
        content.add(jPanel, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navBar = new javax.swing.JPanel();
        logoEmpresa = new javax.swing.JLabel();
        botonNuevaVenta = new javax.swing.JButton();
        botonClientes = new javax.swing.JButton();
        botonProveedor = new javax.swing.JButton();
        botonProductos = new javax.swing.JButton();
        botonVentas = new javax.swing.JButton();
        botonConfig = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        botonExit = new javax.swing.JPanel();
        botonExitLabel = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navBar.setBackground(new java.awt.Color(255, 102, 0));
        navBar.setPreferredSize(new java.awt.Dimension(200, 720));

        logoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoFerreteria.png"))); // NOI18N

        botonNuevaVenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Nventa.png"))); // NOI18N
        botonNuevaVenta.setText("Nueva Venta");
        botonNuevaVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaVentaActionPerformed(evt);
            }
        });

        botonClientes.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes.png"))); // NOI18N
        botonClientes.setText("Clientes");
        botonClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClientesActionPerformed(evt);
            }
        });

        botonProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/proveedor.png"))); // NOI18N
        botonProveedor.setText("Porveedor");
        botonProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProveedorActionPerformed(evt);
            }
        });

        botonProductos.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/compras.png"))); // NOI18N
        botonProductos.setText("Ventas");
        botonProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVentasActionPerformed(evt);
            }
        });

        botonVentas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/config.png"))); // NOI18N
        botonVentas.setText("Config");
        botonVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfigActionPerformed(evt);
            }
        });

        botonConfig.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        botonConfig.setText("Productos");
        botonConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonProductosConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addComponent(logoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(navBarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonNuevaVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(logoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(botonNuevaVenta)
                .addGap(30, 30, 30)
                .addComponent(botonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(botonVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        getContentPane().add(navBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 720));

        header.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1020, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 110, Short.MAX_VALUE)
        );

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1020, 110));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        getContentPane().add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 110, 1080, 610));

        botonExit.setBackground(new java.awt.Color(255, 102, 0));
        botonExit.setToolTipText("");
        botonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonExitMouseExited(evt);
            }
        });

        botonExitLabel.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        botonExitLabel.setForeground(new java.awt.Color(0, 0, 0));
        botonExitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonExitLabel.setText("X");

        javax.swing.GroupLayout botonExitLayout = new javax.swing.GroupLayout(botonExit);
        botonExit.setLayout(botonExitLayout);
        botonExitLayout.setHorizontalGroup(
            botonExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botonExitLayout.createSequentialGroup()
                .addComponent(botonExitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        botonExitLayout.setVerticalGroup(
            botonExitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botonExitLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botonExitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(botonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 60, 50));

        panel.setBackground(new java.awt.Color(255, 102, 0));
        panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMouseDragged(evt);
            }
        });
        panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 50, 60, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMousePressed
        //MOVIMIENTO DE LA VENTANA DEL PROGRAMA
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_panelMousePressed

    private void panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseDragged
        //MOVIMIENTO DE LA VENTANA DEL PROGRAMA
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_panelMouseDragged

    private void botonExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseEntered
        //HOVER DEL BOTON DE CERRAR
        botonExit.setBackground(Color.red);
        botonExitLabel.setForeground(Color.white);
    }//GEN-LAST:event_botonExitMouseEntered

    private void botonExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseExited
        //HOVER DEL BOTON DE CERRAR
        botonExit.setBackground(new Color(255, 102, 0));
        botonExitLabel.setForeground(Color.black);
    }//GEN-LAST:event_botonExitMouseExited

    private void botonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonExitMouseClicked
        //CERRAR EL PROGRAMA
        System.exit(0);
    }//GEN-LAST:event_botonExitMouseClicked

    private void botonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClientesActionPerformed
        dibujarPanel(clientesPanel);
    }//GEN-LAST:event_botonClientesActionPerformed

    private void botonNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaVentaActionPerformed
        dibujarPanel(nuevaVentaPanel);   
    }//GEN-LAST:event_botonNuevaVentaActionPerformed

    private void botonProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProveedorActionPerformed
        dibujarPanel(proveedorPanel);
    }//GEN-LAST:event_botonProveedorActionPerformed

    private void botonProductosConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonProductosConfigActionPerformed
        dibujarPanel(productosPanel);
    }//GEN-LAST:event_botonProductosConfigActionPerformed

    private void botonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVentasActionPerformed
        dibujarPanel(ventasPanel);
    }//GEN-LAST:event_botonVentasActionPerformed

    private void botonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonConfigActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonClientes;
    private javax.swing.JButton botonConfig;
    private javax.swing.JPanel botonExit;
    private javax.swing.JLabel botonExitLabel;
    private javax.swing.JButton botonNuevaVenta;
    private javax.swing.JButton botonProductos;
    private javax.swing.JButton botonProveedor;
    private javax.swing.JButton botonVentas;
    private javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel logoEmpresa;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

}
