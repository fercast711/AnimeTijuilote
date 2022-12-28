package anime_tijuilote;

import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class LoginGUI extends javax.swing.JFrame {
    Programa P;
    private static final String PASSWORD_REGEX
            = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,12}$";

    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
    private Connection CON;

    public LoginGUI() {
        //Conexion a la base de datos , En el constructor del login //
        conectar();
        initComponents();
    }

    public void conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection CONN;
            Conexion C = new Conexion();
            CONN = C.getCON();

            /*/Class.forName("com.mysql.jdbc.Driver");
            
            /*
            //Creando la conexion //
            Connection CON = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/I66eN9EkOA","I66eN9EkOA","eryxH5VrAn");
            Statement Comando1 = CON.createStatement();
            ResultSet RS = Comando1.executeQuery("Show DataBases;");     
            
         
            Connection CON;
            String Driver = "com.mysql.jdbc.Driver";
            String User = "I66eN9EkOA";
            String Password = "eryxH5VrAn";
            String URL = "jdbc:mysql://remotemysql.com:3306/I66eN9EkOA";
            Class.forName(Driver);
            this.CON =DriverManager.getConnection(URL, User,Password); */
            // JOptionPane.showMessageDialog(null, "Conexion Exitosa !!");/
            /**/
        } catch (ClassNotFoundException E) {
            JOptionPane.showMessageDialog(null, "ERROR: " + E);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        btnEntrar = new javax.swing.JButton();
        jLbl_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INGRESO AL SISTEMA");
        setResizable(false);

        jLabel1.setText("Usuario");

        jLabel2.setText("Password");

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnEntrar.setText("ENTRAR");
        btnEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEntrarMouseClicked(evt);
            }
        });

        jLbl_Salir.setText("SALIR");
        jLbl_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLbl_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(txtUser)))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnEntrar)
                        .addGap(27, 27, 27)
                        .addComponent(jLbl_Salir)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar)
                    .addComponent(jLbl_Salir)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEntrarMouseClicked
        String User = "", Pass = "";

        try {
            User = this.txtUser.getText();
            Pass = this.txtPass.getText();
            int ExisteUsuario = 0;

            if (User.length() >= 8) {

                //Si cumple con el minimo de 8 caracteres//
                //JOptionPane.showMessageDialog(null, User);
                if (PASSWORD_PATTERN.matcher(User).matches()) {

                    if (Pass.length() >= 4 && Pass.length() <= 100) {

                        if (PASSWORD_PATTERN.matcher(Pass).matches()) {
                            Conexion C1 = new Conexion();
                            C1.AbrirConeccion();
                            Connection CONN1 = C1.getCON();
                            String US, PS;
                            //Aqui se va a verificar el usuario y el password //
                            Statement s1 = CONN1.createStatement();
                            ResultSet RS1 = s1.executeQuery("SELECT * FROM USUARIO U WHERE U.n_usuario = '" + User + "' AND U.pass = '" + Pass + "';");
                            
                            //Comparando los Datos Ingresados Con los Datos optenidos //
                            //JOptionPane.showMessageDialog(null, RS1.getString(1));
                            while (RS1.next()) {
                            
                                     US = RS1.getString("n_usuario");
                                     PS = RS1.getString("pass");
                             
                                    if (US.equals (User) && PS.equals(Pass)) {
                                    EleccionGUI Principal = new EleccionGUI();
                                    Principal.setDefaultCloseOperation(2);
                                    Principal.setVisible(true);
                                    this.setVisible(false);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta.");
                                }

                            }

                            /* if (RS1 == 1) {
                                GUI Principal = new GUI();
                                Principal.setLocationRelativeTo(null);
                                Principal.setVisible(true);
                                this.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta.");
                            }*/
                        } else {
                            JOptionPane.showMessageDialog(null, "La contraseña debe de Cumplir los parametros.");
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El Usuario Debe de tener almenos 1 mayuscula , Una minuscula y Numeros");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El Usuario Debe de tener almenos 8 caracteres de longitud");
            }

        } catch (Exception E) {
        }


    }//GEN-LAST:event_btnEntrarMouseClicked

    private void jLbl_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLbl_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jLbl_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jLbl_Salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
