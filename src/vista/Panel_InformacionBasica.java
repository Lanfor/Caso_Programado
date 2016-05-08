/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_MantenimientoEstudiantes;
import controlador.Controlador_FRM_VentanaPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author tecnologiamultimedia
 */
public class Panel_InformacionBasica extends javax.swing.JPanel {

    /**
     * Creates new form Panel_InformacionBasica
     */
    Controlador_FRM_MantenimientoEstudiantes controlador;
    Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    public Panel_InformacionBasica() 
    {
        initComponents();
        deshabilitarCampos();
    }
    public void agregarEventos(Controlador_FRM_MantenimientoEstudiantes controlador)
    {
        this.controlador=controlador;
        this.btn_ConsultaRapida.addActionListener(controlador);
        this.jt_Cedula.addActionListener(controlador);
    }
    public String[] devolverInformacion()
    {
        String informacion[]=new String[3];
        
        informacion[0]=this.jt_Cedula.getText();
        informacion[1]=this.jt_NombreCompleto.getText();
        informacion[2]=this.jt_Direccion.getText();
        
        return informacion;
    }
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_NombreCompleto.setText(arreglo[0]);
        this.jt_Direccion.setText(arreglo[1]);
    }
    public void habilitarCampos()
    {
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_Direccion.setEnabled(true);
    }
    public void deshabilitarCampos()
    {
        this.jt_Cedula.setEnabled(true);
        this.jt_Cedula.setText("");
        this.jt_NombreCompleto.setText("");
        this.jt_Direccion.setText("");
        this.jt_NombreCompleto.setEnabled(false);
        this.jt_Direccion.setEnabled(false);
    }
    public void habilitarEdicion()
    {
        this.jt_Cedula.setEnabled(false);
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_Direccion.setEnabled(true);
    }
    public void recibirControlPrincipal(Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal)
    {
        this.controlador_FRM_VentanaPrincipal=controlador_FRM_VentanaPrincipal;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jl_NombreCompleto = new javax.swing.JLabel();
        jl_Direccion = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_NombreCompleto = new javax.swing.JTextField();
        jt_Direccion = new javax.swing.JTextField();
        btn_ConsultaRapida = new javax.swing.JButton();

        jl_Cedula.setText("Cédula");

        jl_NombreCompleto.setText("Nombre Completo");

        jl_Direccion.setText("Dirección");

        jt_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_CedulaKeyPressed(evt);
            }
        });

        btn_ConsultaRapida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaRapida.setActionCommand("Consulta_Rapida");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jl_Cedula, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Direccion, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_ConsultaRapida)
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addComponent(jt_NombreCompleto)
                    .addComponent(jt_Direccion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jl_Cedula)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_ConsultaRapida)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Direccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jt_CedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_CedulaKeyPressed
        
      if(evt.getKeyCode()==10)
        {
            switch(controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento())
            {
                case "Archivo Plano":
                    controlador.buscarArchivosPlanos();
                break;

                case "Archivo XML":
                    //Falta XML
                break;
                case "Base de Datos":
                      controlador.buscarEnBD();
                break;
                default:
                    JOptionPane.showMessageDialog(null,"Error 407 ha fallado el sistema");
            }
            this.controlador.buscarArchivosPlanos();
        }  
    }//GEN-LAST:event_jt_CedulaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaRapida;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_Direccion;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_Direccion;
    private javax.swing.JTextField jt_NombreCompleto;
    // End of variables declaration//GEN-END:variables
}
