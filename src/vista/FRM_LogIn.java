/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_LogIn;
import javax.swing.JOptionPane;
import modelo.MetodosUsuarios;

/**
 *
 * @author Lanfor
 */
public class FRM_LogIn extends javax.swing.JFrame {

    Controlador_FRM_LogIn controlador;
    FRM_RegistroUsuarios frm_RegistroUsuarios;
    public FRM_VentanaPrincipal frm_VentanaPrincipal;
    public FRM_LogIn(FRM_VentanaPrincipal frm_VentanaPrincipal, FRM_RegistroUsuarios frm_RegistroUsuarios, MetodosUsuarios metodosUsuarios) {
        initComponents();
        setLocation(300, 200);
        this.frm_RegistroUsuarios=frm_RegistroUsuarios;
        controlador=new Controlador_FRM_LogIn(frm_VentanaPrincipal, this, metodosUsuarios, this.frm_RegistroUsuarios);
        this.frm_VentanaPrincipal=frm_VentanaPrincipal;
        agregarEventos();
    }
    
    public void agregarEventos()
    {
        btn_Aceptar.addActionListener(controlador);
        btn_Salir.addActionListener(controlador);
        btn_Registrar.addActionListener(controlador);
    }
    public String devolverContraseña()
    {
        return jt_Contrasena.getText();
    }
    
    public String devolverUsuario()
    {
        return jt_Usuario.getText();
    }
    
    public int mostrarMensajeOpcional(String msj)
    {
        return JOptionPane.showConfirmDialog(this, msj);
    }
    public void mostrarMensaje(String msj)
    {
         JOptionPane.showMessageDialog(this, msj,"Mensaje",JOptionPane.PLAIN_MESSAGE);
    }
    public void habitarRegistro()
    {
        btn_Registrar.setEnabled(true);
    }
    public void desabitarRegistro()
    {
        btn_Registrar.setEnabled(false);
    }
    public void soyAdministrador()
    {
        this.frm_VentanaPrincipal.soyAdimistrador();
    }
    public void soyDesarrollador()
    {
        this.frm_VentanaPrincipal.soyDesarrollador();
    }
    public void soyUsuario()
    {
        this.frm_VentanaPrincipal.soyUsuario();
    }
    public void inicioSecion()
    {
        btn_Aceptar.setEnabled(false);
    }
    public void cerrarSecion()
    {
        btn_Aceptar.setEnabled(true);
        btn_Registrar.setEnabled(false);
    }
    public void limpiar()
    {
        this.jt_Usuario.setText("");
        this.jt_Contrasena.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jt_Usuario = new javax.swing.JTextField();
        jt_Contrasena = new javax.swing.JPasswordField();
        btn_Aceptar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();

        jLabel1.setText("Nomb.Usuario:");

        jLabel2.setText("Password:");

        btn_Aceptar.setBackground(new java.awt.Color(0, 153, 255));
        btn_Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check_sign_icon_blue.png"))); // NOI18N
        btn_Aceptar.setText("Aceptar");

        btn_Salir.setBackground(new java.awt.Color(204, 0, 51));
        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btn_Salir.setText("Salir");

        btn_Registrar.setBackground(new java.awt.Color(51, 204, 0));
        btn_Registrar.setText("Registrar Usuario");
        btn_Registrar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jt_Contrasena)
                        .addComponent(jt_Usuario)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_Contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Salir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Registrar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jt_Contrasena;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}
