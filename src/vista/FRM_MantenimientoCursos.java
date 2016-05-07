/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_MantenimientoCursos;
import controlador.Controlador_FRM_VentanaPrincipal;
import javax.swing.JOptionPane;
import modelo.MetodosCursos;

/**
 *
 * @author administrador
 */
public class FRM_MantenimientoCursos extends javax.swing.JFrame {

    /**
     * Creates new form FRM_MantenimientoCursos
     */
    public Controlador_FRM_MantenimientoCursos controlador;
    MetodosCursos metodosCursos;
    public Controlador_FRM_VentanaPrincipal controlador_FRM_VentanaPrincipal;
    public FRM_MantenimientoCursos(MetodosCursos metodosCursos) 
    {
        initComponents();
        this.setLocation(350, 100);
        controlador = new Controlador_FRM_MantenimientoCursos(this, metodosCursos);
        this.metodosCursos=metodosCursos;
        agregarEventos();
    }

    public void agregarEventos()
    {
        this.panel_Botones1.agregarEventosCursos(controlador);
        this.panel_Cursos1.agregarEventos(controlador);
    }
    
    public String devolverSigla()
    {
        return this.panel_Cursos1.devolverSigla();
    }
    
    public void habilitarEdicion()
    {
        this.panel_Botones1.habilitarEdicion();
        this.panel_Cursos1.habilitarEdicion();
    }
    
     public void mostrarInformacion(String arreglo[])
    {
        this.panel_Cursos1.mostrarInformacion(arreglo);
    }
     
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    
    public int mostrarMensajeVerificacion(String mensaje)
    {
       return JOptionPane.showConfirmDialog(this,mensaje);
    }
    
    public void habilitarAgregar()
    {
        this.panel_Botones1.habilitarAgregar();
        this.panel_Cursos1.habilitarCampos();
    }
    
     public String[] devolverInformacion()
    {
        return this.panel_Cursos1.devolverInformacion();
    }
     
    public void resetearGUI()
    {
        this.panel_Botones1.deshabilitarBotones();
        this.panel_Cursos1.deshabilitarCampos();
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Botones1 = new vista.Panel_Botones();
        panel_Cursos1 = new vista.Panel_Cursos();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_Cursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel_Cursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        if(controlador_FRM_VentanaPrincipal.getTipoAlmacenamiento().equalsIgnoreCase("Archivo Plano"))
            this.metodosCursos.escribirSobreArchivo();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private vista.Panel_Botones panel_Botones1;
    private vista.Panel_Cursos panel_Cursos1;
    // End of variables declaration//GEN-END:variables
}
