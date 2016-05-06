package vista;

import controlador.Controlador_FRM_Matricula;
import javax.swing.JOptionPane;
import modelo.MetodosCursos;
import modelo.MetodosEstudiantes;
import modelo.MetodosMatriculas;

/**
 *
 * @author administrador
 */
public class FRM_Matricula extends javax.swing.JFrame {

    /**
     * Creates new form FRM_Matricula
     */
    
    Controlador_FRM_Matricula controlador;
    MetodosMatriculas metodosMatricula;
    public FRM_Matricula(MetodosEstudiantes metodosEstudiantes, MetodosCursos metodosCursos) 
    {
        initComponents();
        this.setLocation(350, 50);
        controlador=new Controlador_FRM_Matricula(this, metodosEstudiantes, metodosCursos);
        this.metodosMatricula = controlador.metodosMatriculas;
        colocarCodigo();
        agregarEventos();
    }
    public  void agregarEventos()
    {
        panel_InformacionMatricula1.agregarEventosMatricula(controlador);
        panel_Botones1.agregarEventosMatricula(controlador);
        btn_Finalizar.addActionListener(controlador);
    }
    
    public  String devolverCedula()
    {
        return panel_InformacionMatricula1.devolverCedula();
    }
    public  String devolverCodigo()
    {
        return panel_InformacionMatricula1.devolverCodigo();
    }
    public String devolverDato(int fila,int columna)
    {
        return panel_InformacionMatricula1.devolverDato(fila, columna);
    }
    public  String devolverSigla()
    {
        return panel_InformacionMatricula1.devolverSigla();
    }
    public void hablitarEdicion()
    {
        panel_Botones1.habilitarEdicion();
    }
    public void desabilitarBotones()
    {
        panel_Botones1.deshabilitarBotones();
    }
    public  String devolverSiglaSeleccionada()
    {
        return panel_InformacionMatricula1.devolverSiglaSeleccionada();
    }
    public void mostrarInformacionEstudiante(String nombre)
    {
        panel_InformacionMatricula1.mostrarInformacionEstudiante(nombre);
    }
    public void mostrarInformacionCurso(String nombre)
    {
        panel_InformacionMatricula1.mostrarInformacionCurso(nombre);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(this,mensaje);
    }
    public int mostrarMensajeVerificacion(String mensaje)
    {
        System.out.println("Me devuelve: "+mostrarMensajeVerificacion(mensaje));
       return JOptionPane.showConfirmDialog(this,mensaje);
        
    }
    public void desabililitarFinalizar()
    {
        btn_Finalizar.setEnabled(false);
    }
    public void habililitarFinalizar()
    {
        btn_Finalizar.setEnabled(true);
    }
    public void habilitarAgregar()
    {
        this.panel_Botones1.habilitarAgregar();
    }
    public void resetearGUI()
    {
        this.panel_Botones1.deshabilitarBotones();
        this.panel_InformacionMatricula1.limpiarCurso();
    }
    public void limpiadoInicial()
    {
        panel_InformacionMatricula1.limpiadoInicial();
        panel_InformacionMatricula1.resetearVentana();
        panel_Botones1.deshabilitarBotones();
    }
    public boolean verificarEspacios()
    {
        return panel_InformacionMatricula1.verificarEspacios();
    }
    public void agregarMatricula()
    {
        panel_InformacionMatricula1.agregarMatricula();
        resetearGUI();
    }
    public void agregarMatricula(String[] arreglo)
    {
        panel_InformacionMatricula1.agregarMatricula(arreglo);
    }
    public void resetearVentana()
    {
        panel_InformacionMatricula1.resetearVentana();
    }
    public void colocarCodigo()
    {
        this.panel_InformacionMatricula1.colocarCodigo(metodosMatricula.devolverCodigo());
    }
    public String[] devolverInformacion()
    {
        return panel_InformacionMatricula1.devolverInformacion();
    }
    public int getCantidadFilas()
    {
        return panel_InformacionMatricula1.getCantidadFilas();
    }
    
    public void borrarFila()
    {
        this.panel_InformacionMatricula1.borrarFila();;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_Botones1 = new vista.Panel_Botones();
        panel_InformacionMatricula1 = new vista.Panel_InformacionMatricula();
        btn_Finalizar = new javax.swing.JButton();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_Finalizar.setText("Finalizar Matricula");
        btn_Finalizar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_InformacionMatricula1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Finalizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_InformacionMatricula1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_Finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        resetearGUI();
        limpiadoInicial();
    }//GEN-LAST:event_formWindowClosing

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
       this.metodosMatricula.escribirSobreArchivo();
    }//GEN-LAST:event_formComponentHidden

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Finalizar;
    private vista.Panel_Botones panel_Botones1;
    private vista.Panel_InformacionMatricula panel_InformacionMatricula1;
    // End of variables declaration//GEN-END:variables
}
