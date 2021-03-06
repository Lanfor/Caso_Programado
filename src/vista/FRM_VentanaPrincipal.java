/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_VentanaPrincipal;
 
public class FRM_VentanaPrincipal extends javax.swing.JFrame {

    
    
    public Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    
    public FRM_VentanaPrincipal() {
        initComponents();
        this.setLocation(200, 100);
        controlador_FRM_VentanaPrincipal=new Controlador_FRM_VentanaPrincipal(this);
        agregarEventos();
        desabilitarItems();
    }
    
    public void agregarEventos()
    {
        this.jm_Mantenimientos.setMnemonic('M');
        this.jm_Archivo.setMnemonic('A');
        this.jm_Salir.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Estudiantes.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Cursos.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_Matricula.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_LogIn.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_LogOut.addActionListener(controlador_FRM_VentanaPrincipal);
        this.jm_TipoAlmacenamiento.addActionListener(controlador_FRM_VentanaPrincipal);
    }
    public void desabilitarItems()
    {
        this.jm_Estudiantes.setEnabled(false);
        this.jm_Cursos.setEnabled(false);
        this.jm_Matricula.setEnabled(false);
    }
    
    public void soyDesarrollador()
    {
        this.jm_Salir.setEnabled(true);
        this.jm_Estudiantes.setEnabled(true);
        this.jm_Cursos.setEnabled(true);
        this.jm_Matricula.setEnabled(true);
        this.jm_LogIn.setEnabled(true);
    }
    public void soyAdimistrador()
    {
        this.jm_Estudiantes.setEnabled(false);
        this.jm_Cursos.setEnabled(false);
        this.jm_Matricula.setEnabled(false);
    }
    public void soyUsuario()
    {
        this.jm_Estudiantes.setEnabled(true);
        this.jm_Cursos.setEnabled(true);
        this.jm_Matricula.setEnabled(true);
    }
    public void cerrarSecion()
    {
        this.jm_Estudiantes.setEnabled(false);
        this.jm_Cursos.setEnabled(false);
        this.jm_Matricula.setEnabled(false);
        this.jm_LogIn.setEnabled(true);
        this.jm_LogOut.setEnabled(false);
    }
    public void iniciarSecion()
    {
        this.jm_LogOut.setEnabled(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Fondo = new javax.swing.JLabel();
        jm_BarraMenu = new javax.swing.JMenuBar();
        jm_Archivo = new javax.swing.JMenu();
        jm_Salir = new javax.swing.JMenuItem();
        jm_LogIn = new javax.swing.JMenuItem();
        jm_LogOut = new javax.swing.JMenuItem();
        jm_Mantenimientos = new javax.swing.JMenu();
        jm_Estudiantes = new javax.swing.JMenuItem();
        jm_Cursos = new javax.swing.JMenuItem();
        jm_Matricula = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jm_TipoAlmacenamiento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jl_Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N

        jm_Archivo.setText("Archivo");

        jm_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jm_Salir.setText("Salir");
        jm_Archivo.add(jm_Salir);

        jm_LogIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jm_LogIn.setText("LogIn");
        jm_Archivo.add(jm_LogIn);

        jm_LogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jm_LogOut.setText("LogOut");
        jm_Archivo.add(jm_LogOut);

        jm_BarraMenu.add(jm_Archivo);

        jm_Mantenimientos.setText("Mantenimientos");

        jm_Estudiantes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jm_Estudiantes.setText("Estudiantes");
        jm_Mantenimientos.add(jm_Estudiantes);

        jm_Cursos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jm_Cursos.setText("Cursos");
        jm_Mantenimientos.add(jm_Cursos);

        jm_Matricula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        jm_Matricula.setText("Matricula");
        jm_Mantenimientos.add(jm_Matricula);

        jm_BarraMenu.add(jm_Mantenimientos);

        jMenu1.setText("Configuración");

        jm_TipoAlmacenamiento.setText("Tipo de Almacenamiento");
        jMenu1.add(jm_TipoAlmacenamiento);

        jm_BarraMenu.add(jMenu1);

        setJMenuBar(jm_BarraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jl_Fondo, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
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
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRM_VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRM_VentanaPrincipal().setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel jl_Fondo;
    private javax.swing.JMenu jm_Archivo;
    private javax.swing.JMenuBar jm_BarraMenu;
    private javax.swing.JMenuItem jm_Cursos;
    private javax.swing.JMenuItem jm_Estudiantes;
    private javax.swing.JMenuItem jm_LogIn;
    private javax.swing.JMenuItem jm_LogOut;
    private javax.swing.JMenu jm_Mantenimientos;
    private javax.swing.JMenuItem jm_Matricula;
    private javax.swing.JMenuItem jm_Salir;
    private javax.swing.JMenuItem jm_TipoAlmacenamiento;
    // End of variables declaration//GEN-END:variables
}
