package minerva.view.panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import minerva.controller.ControllerPanelProducto;
import minerva.model.dto.DTOProducto;
import minerva.server.CodigoBarrasServer;

/**
 *
 * @author L
 */
public class PanelProducto extends javax.swing.JPanel {

    // CONTROLLER
    ControllerPanelProducto controllerPanelProducto = null;
    
    // TABLAS
    DefaultTableModel modeloTblRegistro = new DefaultTableModel();
    DefaultTableModel modeloTblConsulta = new DefaultTableModel();
    
    public PanelProducto() {
        initComponents();
        controllerPanelProducto = new ControllerPanelProducto(this);
        asignarListenerEnter();
    }    
    
    public void setcodigoBarrasTextFieldTblRegistro(long codigoBarras) {
        String codigoBarrasString = "";
        try {
            codigoBarrasString = String.valueOf(codigoBarras);
        } catch (Exception e) {
            System.out.println("HUBO ERROR EN SET DE PANEL PRODUCTO DE LA VARIABLE CODGIOBARRAS LONG");
        }
        this.codigoBarrasTextFieldTblRegistro.setText(codigoBarrasString);
    }
    
    private ArrayList<DTOProducto> consultarPorNombre(String nombre) {
        nombre.replaceAll("\\s+", "");
        ArrayList<DTOProducto> dtoProductList = controllerPanelProducto.listAllProductoDB();
        if (dtoProductList == null) {
            return null;
        }
        ArrayList<DTOProducto> dtoProductListReturn = new ArrayList<>();
        for (DTOProducto dtoProducto : dtoProductList) {
            if (dtoProducto.getNombre().replaceAll("\\s+", "").equals(nombre)) {
                dtoProductListReturn.add(dtoProducto);
            }
        }
        return dtoProductList;
    }
    
    private boolean shouldContinueLoop = false;       

    private void asignarListenerEnter() {
        codigoBarrasTextFieldTblRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonRegistrarProductoTblRegistroActionPerformed(evt);
            }
        });
        
        codigoBarrasTextFieldTblRegistro.addFocusListener(new FocusListener() {
            
            @Override
            public void focusGained(FocusEvent e) {
                 // Ejecutar el bucle en un hilo separado para no bloquear la interfaz
                new Thread(() -> {
                    if (jCheckBoxTblRegistro.isSelected()) {
                        shouldContinueLoop = true;
                        while (shouldContinueLoop) {
                            try {
                                if (CodigoBarrasServer.getCodigoBarras() != 0) {                                
                                    codigoBarrasTextFieldTblRegistro.setText(String.valueOf(CodigoBarrasServer.getCodigoBarras()) );
                                }
                                Thread.sleep(1000);  // Pausa de 1 segundo entre cada iteración
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }                  
                }).start();
            }       

            @Override
            public void focusLost(FocusEvent e) {
                shouldContinueLoop = false;
            }
        });
        
        codigoBarrasTextFieldTblConsulta.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                new Thread(() -> {
                    if (jCheckBoxTblConsulta.isSelected()) {
                        shouldContinueLoop = true;
                        while (shouldContinueLoop) {
                            try {
                                if (CodigoBarrasServer.getCodigoBarras() != 0) {                                
                                    codigoBarrasTextFieldTblConsulta.setText(String.valueOf(CodigoBarrasServer.getCodigoBarras()) );
                                }
                                Thread.sleep(1000);  // Pausa de 1 segundo entre cada iteración
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }                  
                }).start();
            }

            @Override
            public void focusLost(FocusEvent e) {
                shouldContinueLoop = false;
            }             
        }); 
        
        codigoBarrasTextFieldActualizar.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                new Thread(() -> {
                    if (jCheckBoxActualizar.isSelected()) {
                        shouldContinueLoop = true;
                        while (shouldContinueLoop) {
                            try {
                                if (CodigoBarrasServer.getCodigoBarras() != 0) {                                
                                    codigoBarrasTextFieldActualizar.setText(String.valueOf(CodigoBarrasServer.getCodigoBarras()) );
                                }
                                Thread.sleep(1000);  // Pausa de 1 segundo entre cada iteración
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }                  
                }).start();
            }

            @Override
            public void focusLost(FocusEvent e) {
                shouldContinueLoop = false;
            }        
        });
    }
    
    private void agregarFilaTblConsulta(String nombre, double precio, String descripcion, long stock, long codigoBarras) {
        Object[] objects= new Object[5];
        objects[0] = nombre;
        objects[1] = precio;
        objects[2] = descripcion;
        objects[3] = stock;
        objects[4] = codigoBarras;
        
        modeloTblConsulta = (DefaultTableModel) tblConsulta.getModel();
        
        modeloTblConsulta.addRow(objects);      
    }
    
    private void agregarFilaTblRegistro(String nombre, double precio, String descripcion, long stock) {
        Object[] objects= new Object[4];
        objects[0] = nombre;
        objects[1] = precio;
        objects[2] = descripcion;
        objects[3] = stock;
        
        modeloTblRegistro = (DefaultTableModel) tblRegistro.getModel();
        
        modeloTblRegistro.addRow(objects);
        // TablaRegistro.setModel(modeloTblRegistro);
    }
    
    private void limpiarTblRegistro() {
        modeloTblRegistro = (DefaultTableModel) tblRegistro.getModel();
        for (int i = modeloTblRegistro.getRowCount() -1; i >= 0 ; i--) {
            modeloTblRegistro.removeRow(i);
        }
    }
    
    private void limpiarTblConsulta() {
        modeloTblConsulta = (DefaultTableModel) tblConsulta.getModel();
        
        for (int i = modeloTblConsulta.getRowCount() -1; i >= 0 ; i--) {
            modeloTblConsulta.removeRow(i);
        }
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
        panelProducto = new javax.swing.JTabbedPane();
        subPanelRegistro = new javax.swing.JPanel();
        codigo_panel_4 = new javax.swing.JLabel();
        nombreTextFieldTblRegistro = new javax.swing.JTextField();
        descripcion_panel_4 = new javax.swing.JLabel();
        precioTextFieldTblRegistro = new javax.swing.JTextField();
        cantidad_panel_4 = new javax.swing.JLabel();
        stockTextFieldTblRegistro = new javax.swing.JTextField();
        precio_panel_4 = new javax.swing.JLabel();
        codigoBarrasTextFieldTblRegistro = new javax.swing.JTextField();
        proveedor_4 = new javax.swing.JLabel();
        tabla_productos = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        botonRegistrarProductoTblRegistro = new javax.swing.JButton();
        descripcionTextFieldTblRegistro = new javax.swing.JTextField();
        botonLimpiarTblRegistro = new javax.swing.JButton();
        jCheckBoxTblRegistro = new javax.swing.JCheckBox();
        subPanelConsulta = new javax.swing.JPanel();
        tabla_productos1 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        consultarProductoPorCodigo = new javax.swing.JButton();
        codigoBarrasTextFieldTblConsulta = new javax.swing.JTextField();
        CODIGO_BARRAS_LABEL = new javax.swing.JLabel();
        botonListarProductoTblConsulta = new javax.swing.JButton();
        botonLimpiarTblConsulta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreTextFieldTblConsulta = new javax.swing.JTextField();
        botonConsultarProductoPorNombre = new javax.swing.JButton();
        jCheckBoxTblConsulta = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        descripcion_panel_5 = new javax.swing.JLabel();
        precioTextFieldActualizar = new javax.swing.JTextField();
        stockTextFieldActualizar = new javax.swing.JTextField();
        cantidad_panel_5 = new javax.swing.JLabel();
        proveedor_5 = new javax.swing.JLabel();
        descripcionTextFieldActualizar = new javax.swing.JTextField();
        botonActualizarProducto = new javax.swing.JButton();
        precio_panel_6 = new javax.swing.JLabel();
        codigoBarrasTextFieldActualizar = new javax.swing.JTextField();
        nombreTextFieldaActualizar = new javax.swing.JTextField();
        codigo_panel_6 = new javax.swing.JLabel();
        botonConsultarPorCodigo = new javax.swing.JButton();
        jCheckBoxActualizar = new javax.swing.JCheckBox();

        panelProducto.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                panelProductoComponentAdded(evt);
            }
        });

        subPanelRegistro.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                subPanelRegistroComponentAdded(evt);
            }
        });

        codigo_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        codigo_panel_4.setText("NOMBRE");

        nombreTextFieldTblRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldTblRegistroActionPerformed(evt);
            }
        });

        descripcion_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        descripcion_panel_4.setText("PRECIO");

        precioTextFieldTblRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });

        cantidad_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cantidad_panel_4.setText("STOCK");

        stockTextFieldTblRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTextFieldTblRegistroActionPerformed(evt);
            }
        });
        stockTextFieldTblRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockKeyTyped(evt);
            }
        });

        precio_panel_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        precio_panel_4.setText("CODIGO BARRAS");

        codigoBarrasTextFieldTblRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoBarrasTextFieldTblRegistroActionPerformed(evt);
            }
        });
        codigoBarrasTextFieldTblRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoBarrasKeyTyped(evt);
            }
        });

        proveedor_4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        proveedor_4.setText("DESCRIPCION");

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_productos.setViewportView(tblRegistro);

        botonRegistrarProductoTblRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarTodo.png"))); // NOI18N
        botonRegistrarProductoTblRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonRegistrarProductoTblRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarProductoTblRegistroActionPerformed(evt);
            }
        });

        botonLimpiarTblRegistro.setText("X");
        botonLimpiarTblRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cambiaColor(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cambiarColorAlSalir(evt);
            }
        });
        botonLimpiarTblRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarTblRegistroActionPerformed(evt);
            }
        });

        jCheckBoxTblRegistro.setText("ServidorAtlas");
        jCheckBoxTblRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxTblRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subPanelRegistroLayout = new javax.swing.GroupLayout(subPanelRegistro);
        subPanelRegistro.setLayout(subPanelRegistroLayout);
        subPanelRegistroLayout.setHorizontalGroup(
            subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelRegistroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precioTextFieldTblRegistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelRegistroLayout.createSequentialGroup()
                                .addComponent(proveedor_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(descripcionTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subPanelRegistroLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subPanelRegistroLayout.createSequentialGroup()
                                .addComponent(cantidad_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stockTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(descripcion_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subPanelRegistroLayout.createSequentialGroup()
                        .addComponent(precio_panel_4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(codigoBarrasTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, subPanelRegistroLayout.createSequentialGroup()
                        .addComponent(codigo_panel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(nombreTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(subPanelRegistroLayout.createSequentialGroup()
                        .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonLimpiarTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxTblRegistro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonRegistrarProductoTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(tabla_productos, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addContainerGap())
        );
        subPanelRegistroLayout.setVerticalGroup(
            subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelRegistroLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_panel_4))
                .addGap(48, 48, 48)
                .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcion_panel_4))
                .addGap(42, 42, 42)
                .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidad_panel_4))
                .addGap(44, 44, 44)
                .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proveedor_4)
                    .addComponent(descripcionTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoBarrasTextFieldTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(precio_panel_4))
                .addGroup(subPanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(subPanelRegistroLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(botonRegistrarProductoTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subPanelRegistroLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBoxTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonLimpiarTblRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabla_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );

        panelProducto.addTab("REGISTRO", subPanelRegistro);

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_productos1.setViewportView(tblConsulta);

        consultarProductoPorCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/nuevo.png"))); // NOI18N
        consultarProductoPorCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        consultarProductoPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarProductoPorCodigoActionPerformed(evt);
            }
        });

        codigoBarrasTextFieldTblConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoBarrasTextFieldTblConsultaActionPerformed(evt);
            }
        });
        codigoBarrasTextFieldTblConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoBarrasTblConsultaKeyTyped(evt);
            }
        });

        CODIGO_BARRAS_LABEL.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        CODIGO_BARRAS_LABEL.setText("CODIGO BARRAS");

        botonListarProductoTblConsulta.setText("listar");
        botonListarProductoTblConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonListarProductoTblConsultaActionPerformed(evt);
            }
        });

        botonLimpiarTblConsulta.setText("X");
        botonLimpiarTblConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarTblConsultaActionPerformed(evt);
            }
        });

        jLabel1.setText("NOMBRE");

        botonConsultarProductoPorNombre.setText("CONSULTAR");
        botonConsultarProductoPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarProductoPorNombreActionPerformed(evt);
            }
        });

        jCheckBoxTblConsulta.setText("ServidorAtlas");

        javax.swing.GroupLayout subPanelConsultaLayout = new javax.swing.GroupLayout(subPanelConsulta);
        subPanelConsulta.setLayout(subPanelConsultaLayout);
        subPanelConsultaLayout.setHorizontalGroup(
            subPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                .addGroup(subPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subPanelConsultaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(subPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                                .addComponent(botonLimpiarTblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(botonListarProductoTblConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(codigoBarrasTextFieldTblConsulta, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(subPanelConsultaLayout.createSequentialGroup()
                        .addGroup(subPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel1))
                            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(CODIGO_BARRAS_LABEL))
                            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(botonConsultarProductoPorNombre))
                            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nombreTextFieldTblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jCheckBoxTblConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(consultarProductoPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabla_productos1, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        subPanelConsultaLayout.setVerticalGroup(
            subPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subPanelConsultaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTextFieldTblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonConsultarProductoPorNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(subPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonListarProductoTblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonLimpiarTblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(subPanelConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(subPanelConsultaLayout.createSequentialGroup()
                        .addComponent(CODIGO_BARRAS_LABEL)
                        .addGap(12, 12, 12)
                        .addComponent(codigoBarrasTextFieldTblConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(consultarProductoPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBoxTblConsulta))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subPanelConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabla_productos1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelProducto.addTab("CONSULTA", subPanelConsulta);

        descripcion_panel_5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        descripcion_panel_5.setText("PRECIO");

        precioTextFieldActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioTextFieldActualizarprecioKeyTyped(evt);
            }
        });

        stockTextFieldActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTextFieldActualizarActionPerformed(evt);
            }
        });
        stockTextFieldActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockTextFieldActualizarstockKeyTyped(evt);
            }
        });

        cantidad_panel_5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cantidad_panel_5.setText("STOCK");

        proveedor_5.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        proveedor_5.setText("DESCRIPCION");

        botonActualizarProducto.setText("actualizar");
        botonActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarProductoActionPerformed(evt);
            }
        });

        precio_panel_6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        precio_panel_6.setText("CODIGO BARRAS");

        codigoBarrasTextFieldActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoBarrasTextFieldActualizarActionPerformed(evt);
            }
        });
        codigoBarrasTextFieldActualizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoBarrasTextFieldActualizarcodigoBarrasKeyTyped(evt);
            }
        });

        nombreTextFieldaActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldaActualizarActionPerformed(evt);
            }
        });

        codigo_panel_6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        codigo_panel_6.setText("NOMBRE");

        botonConsultarPorCodigo.setText("CONSULTAR CODIGO");
        botonConsultarPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarPorCodigoActionPerformed(evt);
            }
        });

        jCheckBoxActualizar.setText("ServidorAtlas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonConsultarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBoxActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(precio_panel_6)
                        .addGap(18, 18, 18)
                        .addComponent(codigoBarrasTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(codigo_panel_6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombreTextFieldaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(proveedor_5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(descripcionTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(descripcion_panel_5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(precioTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(cantidad_panel_5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stockTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(189, 189, 189)
                .addComponent(botonActualizarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextFieldaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_panel_6))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descripcion_panel_5)
                    .addComponent(precioTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonConsultarPorCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(stockTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cantidad_panel_5))
                    .addComponent(botonActualizarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(descripcionTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proveedor_5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jCheckBoxActualizar)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoBarrasTextFieldActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precio_panel_6))))
                .addGap(300, 300, 300))
        );

        panelProducto.addTab("ACTUALIZAR", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void panelProductoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_panelProductoComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_panelProductoComponentAdded

    private void subPanelRegistroComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_subPanelRegistroComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_subPanelRegistroComponentAdded

    private void nombreTextFieldTblRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldTblRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldTblRegistroActionPerformed

    private void codigoBarrasTextFieldTblConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoBarrasTextFieldTblConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoBarrasTextFieldTblConsultaActionPerformed

    private void stockTextFieldTblRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTextFieldTblRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTextFieldTblRegistroActionPerformed

    private void botonRegistrarProductoTblRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarProductoTblRegistroActionPerformed
        String nombre = nombreTextFieldTblRegistro.getText().trim();
        String descripcion = descripcionTextFieldTblRegistro.getText().trim();
        String ubicacionAlmacen = ""; 
        double precio;
        long stock;
        long codigoBarras;
      
        // VALIDACION NOMBRE
        if (nombre.isEmpty()) {
            mostrarMensaje("FALTA NOMBRE");
            return;
        }
        
        // VALIDACION PRECIO
        try {
            precio = Double.parseDouble(precioTextFieldTblRegistro.getText().trim());
            if (precio <= 0) {
                mostrarMensaje("FALTA PRECIO");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("FALTA PRECIO");
            return;
        }
        
        // VALIDACION STOCK
        try {
            stock = Long.parseLong(stockTextFieldTblRegistro.getText().trim());
            if (stock <= 0) {
                mostrarMensaje("FALTA STOCK");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("FALTA STOCK");
            return;
        }
        
        // VALIDACION DESCRIPCION
        if (descripcion.isEmpty()) {
            mostrarMensaje("FALTA DESCRIPCION");
            return;
        } 
        
        // VALIDACION CODIGO BARRAS
        try {
            codigoBarras = Long.parseLong(codigoBarrasTextFieldTblRegistro.getText().trim());
            if (codigoBarras <= 0) {
                mostrarMensaje("FALTA CODIGO BARRAS");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("FALTA CODIGO BARRAS");
            return;
        }
        
        DTOProducto dtoProducto = new DTOProducto(nombre, precio, descripcion, stock, codigoBarras, ubicacionAlmacen);
                
        boolean operacionRegistro = controllerPanelProducto.createProductoDB(dtoProducto);
        
        if (operacionRegistro) {
            agregarFilaTblRegistro(nombre, precio, descripcion,stock);
        }        
    }//GEN-LAST:event_botonRegistrarProductoTblRegistroActionPerformed
    
    private void mostrarMensaje(String mensajeError) {
        JOptionPane.showMessageDialog(null, mensajeError);
    }
    private void codigoBarrasTextFieldTblRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoBarrasTextFieldTblRegistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoBarrasTextFieldTblRegistroActionPerformed

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
        char c = evt.getKeyChar();
        String texto = ((javax.swing.JTextField) evt.getSource()).getText();

        // Permite la entrada de números y el punto ('.')
        if ((c < '0' || c > '9') && c != '.') {
            evt.consume(); // Consume el evento si no es un número ni un punto
            return;
        }

        // Limita la longitud total del texto a 20 caracteres (incluyendo el punto)
        if (texto.length() >= 20 && c != '\b') { // \b es el código para la tecla Backspace
            evt.consume(); // Si el texto tiene 20 caracteres, no permite más entradas
            return;
        }

        // Permite solo un punto decimal
        if (c == '.' && texto.contains(".")) {
            evt.consume(); // Consume el evento si ya existe un punto en el texto
            return;
        }

        // Permite máximo 3 decimales después del punto
        if (texto.contains(".")) {
            int cantidadDecimales = texto.substring(texto.indexOf('.') + 1).length();
            if (cantidadDecimales >= 3 && c != '\b') { // Si ya hay 3 decimales, no permite más
                evt.consume(); // Consume el evento si ya hay 3 decimales
            }
        }
    }//GEN-LAST:event_precioKeyTyped

    private void botonLimpiarTblRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarTblRegistroActionPerformed
        limpiarTblRegistro();
    }//GEN-LAST:event_botonLimpiarTblRegistroActionPerformed

    private void consultarProductoPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarProductoPorCodigoActionPerformed
        long codigoBarras = 0;
        try {
            codigoBarras = Long.parseLong(codigoBarrasTextFieldTblConsulta.getText().trim());
            if (codigoBarras <= 0) {
                mostrarMensaje("FALTA CODIGO BARRAS");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("FALTA CODIGO BARRAS");
            return;
        }
        
        DTOProducto dtoProducto = controllerPanelProducto.readProductoDB(codigoBarras);
        
        if (dtoProducto != null) {
            agregarFilaTblConsulta(dtoProducto.getNombre(), dtoProducto.getPrecio(), dtoProducto.getDescripcion(), dtoProducto.getStock(), dtoProducto.getCodigoBarras());
        }        
    }//GEN-LAST:event_consultarProductoPorCodigoActionPerformed

    private void codigoBarrasTblConsultaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBarrasTblConsultaKeyTyped
        // CODIGO PARA QUE SOLAMENTE SE PUEDAN INGRESAR NUMEROS
        char c = evt.getKeyChar();
        
        if (c<'0' || c> '9') {
            evt.consume();            
        }
    }//GEN-LAST:event_codigoBarrasTblConsultaKeyTyped

    private void botonLimpiarTblConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarTblConsultaActionPerformed
        limpiarTblConsulta();
    }//GEN-LAST:event_botonLimpiarTblConsultaActionPerformed

    private void botonListarProductoTblConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonListarProductoTblConsultaActionPerformed
        ArrayList<DTOProducto> dtoProductoList= controllerPanelProducto.listAllProductoDB();
        
        if (dtoProductoList != null) {
            limpiarTblConsulta();
            for (DTOProducto dtoProducto : dtoProductoList) {
                agregarFilaTblConsulta(dtoProducto.getNombre(), dtoProducto.getPrecio(), dtoProducto.getDescripcion(), dtoProducto.getStock(), dtoProducto.getCodigoBarras());
            }
        }        
    }//GEN-LAST:event_botonListarProductoTblConsultaActionPerformed

    private void precioTextFieldActualizarprecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioTextFieldActualizarprecioKeyTyped
        char c = evt.getKeyChar();
        String texto = ((javax.swing.JTextField) evt.getSource()).getText();

        // Permite la entrada de números y el punto ('.')
        if ((c < '0' || c > '9') && c != '.') {
            evt.consume(); // Consume el evento si no es un número ni un punto
            return;
        }

        // Limita la longitud total del texto a 20 caracteres (incluyendo el punto)
        if (texto.length() >= 20 && c != '\b') { // \b es el código para la tecla Backspace
            evt.consume(); // Si el texto tiene 20 caracteres, no permite más entradas
            return;
        }

        // Permite solo un punto decimal
        if (c == '.' && texto.contains(".")) {
            evt.consume(); // Consume el evento si ya existe un punto en el texto
            return;
        }

        // Permite máximo 3 decimales después del punto
        if (texto.contains(".")) {
            int cantidadDecimales = texto.substring(texto.indexOf('.') + 1).length();
            if (cantidadDecimales >= 3 && c != '\b') { // Si ya hay 3 decimales, no permite más
                evt.consume(); // Consume el evento si ya hay 3 decimales
            }
        }
    }//GEN-LAST:event_precioTextFieldActualizarprecioKeyTyped

    private void stockTextFieldActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTextFieldActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTextFieldActualizarActionPerformed

    private void stockTextFieldActualizarstockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockTextFieldActualizarstockKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTextFieldActualizarstockKeyTyped

    private void botonConsultarProductoPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarProductoPorNombreActionPerformed
        String nombreProducto = nombreTextFieldTblConsulta.getText();
        
        if (nombreProducto.isEmpty()) {
            return;
        }
        
        ArrayList<DTOProducto> dtoProductoList = consultarPorNombre(nombreProducto);
        
        if (dtoProductoList != null) {
            for (DTOProducto dtoProducto : dtoProductoList) {
                agregarFilaTblConsulta(dtoProducto.getNombre(), dtoProducto.getPrecio(), dtoProducto.getDescripcion(), dtoProducto.getStock(), dtoProducto.getCodigoBarras());            
            }
        }       
    }//GEN-LAST:event_botonConsultarProductoPorNombreActionPerformed

    private void codigoBarrasTextFieldActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoBarrasTextFieldActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoBarrasTextFieldActualizarActionPerformed

    private void codigoBarrasTextFieldActualizarcodigoBarrasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBarrasTextFieldActualizarcodigoBarrasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoBarrasTextFieldActualizarcodigoBarrasKeyTyped

    private void nombreTextFieldaActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldaActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldaActualizarActionPerformed

    private void botonConsultarPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarPorCodigoActionPerformed
        long codigoBarras = 0;
        try {
            codigoBarras = Long.parseLong(codigoBarrasTextFieldActualizar.getText().trim());
            if (codigoBarras <= 0) {
                mostrarMensaje("FALTA CODIGO BARRAS");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("FALTA CODIGO BARRAS");
            return;
        }
        
        DTOProducto dtoProducto = controllerPanelProducto.readProductoDB(codigoBarras);
        
        nombreTextFieldaActualizar.setText(dtoProducto.getNombre());
        precioTextFieldActualizar.setText(String.valueOf(dtoProducto.getPrecio()));
        stockTextFieldActualizar.setText(String.valueOf(dtoProducto.getStock()));
        descripcionTextFieldActualizar.setText(dtoProducto.getDescripcion());
    }//GEN-LAST:event_botonConsultarPorCodigoActionPerformed

    private void botonActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarProductoActionPerformed
        // Obtener los valores de los campos de texto
        String nombre = nombreTextFieldaActualizar.getText().trim();
        String precioStr = precioTextFieldActualizar.getText().trim();
        String stockStr = stockTextFieldActualizar.getText().trim();
        String descripcion = descripcionTextFieldActualizar.getText().trim();
        String codigoBarrasStr = codigoBarrasTextFieldActualizar.getText().trim();

        // VALIDACION NOMBRE
        if (nombre.isEmpty()) {
            mostrarMensaje("FALTA NOMBRE");
            return;
        }

        // VALIDACION PRECIO
        double precio;
        try {
            precio = Double.parseDouble(precioStr);
            if (precio <= 0) {
                mostrarMensaje("FALTA PRECIO");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("PRECIO INVÁLIDO");
            return;
        }

        // VALIDACION STOCK
        long stock;
        try {
            stock = Long.parseLong(stockStr);
            if (stock <= 0) {
                mostrarMensaje("FALTA STOCK");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("STOCK INVÁLIDO");
            return;
        }

        // VALIDACION DESCRIPCION
        if (descripcion.isEmpty()) {
            mostrarMensaje("FALTA DESCRIPCION");
            return;
        }

        // VALIDACION CODIGO BARRAS
        long codigoBarras;
        try {
            codigoBarras = Long.parseLong(codigoBarrasStr);
            if (codigoBarras <= 0) {
                mostrarMensaje("FALTA CÓDIGO DE BARRAS");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarMensaje("CÓDIGO DE BARRAS INVÁLIDO");
            return;
        }
        
        long productoID = controllerPanelProducto.readProductoDB(codigoBarras).getProductoID();
        
        DTOProducto dtoProducto = new DTOProducto( productoID, nombre, precio, descripcion, stock, codigoBarras, "");
        boolean operacionActualizar = controllerPanelProducto.updateProductoDB(dtoProducto);

        if (operacionActualizar) {
            mostrarMensaje("ACTUALIZACION REALIZADA CON EXITO");
        }
    }//GEN-LAST:event_botonActualizarProductoActionPerformed

    private void cambiaColor(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiaColor
        //HOVER DEL BOTON DE CERRAR
        botonLimpiarTblRegistro.setBackground(Color.red);
        
    }//GEN-LAST:event_cambiaColor

    private void cambiarColorAlSalir(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cambiarColorAlSalir
        botonLimpiarTblRegistro.setBackground(new Color(255, 102, 0));

    }//GEN-LAST:event_cambiarColorAlSalir

    private void jCheckBoxTblRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxTblRegistroActionPerformed
        if (!jCheckBoxTblRegistro.isSelected()) {
            shouldContinueLoop = false;
        }
    }//GEN-LAST:event_jCheckBoxTblRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CODIGO_BARRAS_LABEL;
    private javax.swing.JButton botonActualizarProducto;
    private javax.swing.JButton botonConsultarPorCodigo;
    private javax.swing.JButton botonConsultarProductoPorNombre;
    private javax.swing.JButton botonLimpiarTblConsulta;
    private javax.swing.JButton botonLimpiarTblRegistro;
    private javax.swing.JButton botonListarProductoTblConsulta;
    private javax.swing.JButton botonRegistrarProductoTblRegistro;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel cantidad_panel_4;
    private javax.swing.JLabel cantidad_panel_5;
    private javax.swing.JTextField codigoBarrasTextFieldActualizar;
    private javax.swing.JTextField codigoBarrasTextFieldTblConsulta;
    private javax.swing.JTextField codigoBarrasTextFieldTblRegistro;
    private javax.swing.JLabel codigo_panel_4;
    private javax.swing.JLabel codigo_panel_6;
    private javax.swing.JButton consultarProductoPorCodigo;
    private javax.swing.JTextField descripcionTextFieldActualizar;
    private javax.swing.JTextField descripcionTextFieldTblRegistro;
    private javax.swing.JLabel descripcion_panel_4;
    private javax.swing.JLabel descripcion_panel_5;
    private javax.swing.JCheckBox jCheckBoxActualizar;
    private javax.swing.JCheckBox jCheckBoxTblConsulta;
    private javax.swing.JCheckBox jCheckBoxTblRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreTextFieldTblConsulta;
    private javax.swing.JTextField nombreTextFieldTblRegistro;
    private javax.swing.JTextField nombreTextFieldaActualizar;
    private javax.swing.JTabbedPane panelProducto;
    private javax.swing.JTextField precioTextFieldActualizar;
    private javax.swing.JTextField precioTextFieldTblRegistro;
    private javax.swing.JLabel precio_panel_4;
    private javax.swing.JLabel precio_panel_6;
    private javax.swing.JLabel proveedor_4;
    private javax.swing.JLabel proveedor_5;
    private javax.swing.JTextField stockTextFieldActualizar;
    private javax.swing.JTextField stockTextFieldTblRegistro;
    private javax.swing.JPanel subPanelConsulta;
    private javax.swing.JPanel subPanelRegistro;
    private javax.swing.JScrollPane tabla_productos;
    private javax.swing.JScrollPane tabla_productos1;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTable tblRegistro;
    // End of variables declaration//GEN-END:variables
}
