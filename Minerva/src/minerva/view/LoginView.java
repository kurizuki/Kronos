package minerva.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import minerva.controller.ControllerLogin;

public class LoginView extends javax.swing.JFrame {

    //VARIABLES DEL MOUSE
    int xMouse, yMouse;
        
    public LoginView() {
        initComponents();
        //CENTRALIZA LA VENTANA DEL PROGRAMA
        this.setLocationRelativeTo(null);   
        asignarListenerEnter();
    }
    
    private void validarCredenciales(){
        String usuario = usuarioTextField.getText(); // Campo de usuario
        String contrasena = String.valueOf(contrasenaTextField.getPassword()); // Campo de contraseña

        // Verificamos si alguno de los campos está vacío
        if (usuario.isEmpty() || contrasena.isEmpty()) {
            // Si algún campo está vacío, salimos del método sin continuar con la validación
            return;
        }
        
        // USAMOS EL LOGINCONTROLER
        if (ControllerLogin.validarCredenciales(usuario, contrasena)) {
            SystemView puntoVentaView = new SystemView(usuario);
            puntoVentaView.setVisible(true);            
            dispose();           
        } else {
            JOptionPane.showMessageDialog(null, "Correo o contraseña invalidos");
        }
    }
    
    private void asignarListenerEnter() {
        contrasenaTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        nombreEmpresa_1 = new javax.swing.JLabel();
        nombreEmpresa_2 = new javax.swing.JLabel();
        nombreEmpresa_3 = new javax.swing.JLabel();
        banner = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        botonSalir = new javax.swing.JPanel();
        botonSalirLabel = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        separador_1 = new javax.swing.JSeparator();
        usuarioTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        separador_2 = new javax.swing.JSeparator();
        contrasenaTextField = new javax.swing.JPasswordField();
        botonIniciarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreEmpresa_1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        nombreEmpresa_1.setForeground(new java.awt.Color(255, 255, 255));
        nombreEmpresa_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEmpresa_1.setText("DRAKO");
        background.add(nombreEmpresa_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 290, -1));

        nombreEmpresa_2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        nombreEmpresa_2.setForeground(new java.awt.Color(255, 255, 255));
        nombreEmpresa_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEmpresa_2.setText("XD");
        background.add(nombreEmpresa_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 290, -1));

        nombreEmpresa_3.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        nombreEmpresa_3.setForeground(new java.awt.Color(255, 255, 255));
        nombreEmpresa_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreEmpresa_3.setText("ASOCIADOS");
        background.add(nombreEmpresa_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 290, -1));

        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BannerFerreteria.png"))); // NOI18N
        background.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 290, 500));

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonSalirMouseExited(evt);
            }
        });

        botonSalirLabel.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        botonSalirLabel.setForeground(new java.awt.Color(0, 0, 0));
        botonSalirLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonSalirLabel.setText("X");

        javax.swing.GroupLayout botonSalirLayout = new javax.swing.GroupLayout(botonSalir);
        botonSalir.setLayout(botonSalirLayout);
        botonSalirLayout.setHorizontalGroup(
            botonSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonSalirLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );
        botonSalirLayout.setVerticalGroup(
            botonSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botonSalirLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 774, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(botonSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 50));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 0, 0));
        titulo.setText("LOGIN");
        background.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        userLabel.setBackground(new java.awt.Color(255, 255, 255));
        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("USUARIO");
        background.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));
        background.add(separador_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 257, 420, -1));

        usuarioTextField.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        usuarioTextField.setForeground(new java.awt.Color(153, 153, 153));
        usuarioTextField.setBorder(null);
        usuarioTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioTextFieldMousePressed(evt);
            }
        });
        background.add(usuarioTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 420, 30));

        passwordLabel.setBackground(new java.awt.Color(255, 255, 255));
        passwordLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 0, 0));
        passwordLabel.setText("CONTRASEÑA");
        background.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        background.add(separador_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 420, 10));

        contrasenaTextField.setForeground(new java.awt.Color(204, 204, 204));
        contrasenaTextField.setBorder(null);
        contrasenaTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contrasenaTextFieldMousePressed(evt);
            }
        });
        contrasenaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenaTextFieldActionPerformed(evt);
            }
        });
        background.add(contrasenaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 420, 30));

        botonIniciarSesion.setBackground(new java.awt.Color(255, 102, 0));
        botonIniciarSesion.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        botonIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        botonIniciarSesion.setText("INICIAR SESIÓN");
        botonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarSesionActionPerformed(evt);
            }
        });
        background.add(botonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 370, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        //MOVIMIENTO DE LA VENTANA DEL PROGRAMA
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        //MOVIMIENTO DE LA VENTANA DEL PROGRAMA
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_headerMouseDragged

    private void botonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalirMouseEntered
        //HOVER DEL BOTON DE CERRAR
        botonSalir.setBackground(Color.red);
        botonSalirLabel.setForeground(Color.white);
    }//GEN-LAST:event_botonSalirMouseEntered

    private void botonSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalirMouseClicked
        //CERRAR EL PROGRAMA
        System.exit(0);
    }//GEN-LAST:event_botonSalirMouseClicked

    private void botonSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalirMouseExited
        //HOVER DEL BOTON DE CERRAR
        botonSalir.setBackground(Color.white);
        botonSalirLabel.setForeground(Color.black);
    }//GEN-LAST:event_botonSalirMouseExited

    private void usuarioTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioTextFieldMousePressed
        //PLACEHOLDER DEL USUARIO
        
    }//GEN-LAST:event_usuarioTextFieldMousePressed

    private void contrasenaTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contrasenaTextFieldMousePressed
        //PLACEHOLDER DE LA CONTRASEÑA
        
    }//GEN-LAST:event_contrasenaTextFieldMousePressed

    private void botonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarSesionActionPerformed
        //LLAMA AL METODO VALIDAR USUARIO AL PRESIONAR EL BOTON "ENTRAR"
        validarCredenciales();
    }//GEN-LAST:event_botonIniciarSesionActionPerformed

    private void contrasenaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasenaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaTextFieldActionPerformed

    
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
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("ERROR: " + e.toString());
        }
            

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JLabel banner;
    private javax.swing.JButton botonIniciarSesion;
    private javax.swing.JPanel botonSalir;
    private javax.swing.JLabel botonSalirLabel;
    private javax.swing.JPasswordField contrasenaTextField;
    private javax.swing.JPanel header;
    private javax.swing.JLabel nombreEmpresa_1;
    private javax.swing.JLabel nombreEmpresa_2;
    private javax.swing.JLabel nombreEmpresa_3;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JSeparator separador_1;
    private javax.swing.JSeparator separador_2;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField usuarioTextField;
    // End of variables declaration//GEN-END:variables
}
