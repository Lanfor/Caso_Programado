/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Controlador_FRM_Matricula;
import javax.swing.table.DefaultTableModel;

/**
    @author Lanfor
 */
public class Panel_InformacionMatricula extends javax.swing.JPanel {

    /**
     * Creates new form Panel_InformacionMatricula
     */
    DefaultTableModel modelo;
    Controlador_FRM_Matricula controlador;
    
    public Panel_InformacionMatricula() {
        initComponents();
        modelo=new DefaultTableModel();
        colocarTitulosTabla();
    }
    
    public void colocarTitulosTabla()
    {
        tbl_Tabla.setModel(modelo);
        String[] titulos={"Codigo","Cedula","Nombre","Sigla"};
        modelo.setColumnIdentifiers(titulos);;
        
    }
    public void agregarEventosMatricula(Controlador_FRM_Matricula controlador)
    {
        this.controlador=controlador;
        this.btn_ConsultaEstudiante.addActionListener(controlador);
        this.btn_ConsultaCurso.addActionListener(controlador);
    }
    public  String devolverCedula()
    {
        return jt_Cedula.getText();
    }
    public  String devolverCodigo()
    {
        return jt_CodigoMatricula.getText();
    }
    public String devolverDato(int fila,int columna)
    {
        return ""+modelo.getValueAt(fila, columna);
    }
    public  String devolverSigla()
    {
        return jt_Sigla.getText();
    }
    public  String devolverSiglaSeleccionada()
    {
        return ""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 3);
    }
    public void mostrarInformacionEstudiante(String nombre)
    {
        jt_NombEstudiante.setText(nombre);
    }
     public void mostrarInformacionCurso(String nombre)
    {
        jt_NombCurso.setText(nombre);
    }
     
     public void colocarCodigo(String codigo)
    {
        this.jt_CodigoMatricula.setText(codigo);
    }
     
    public void agregarMatricula()
    {
        String[] matricula={jt_CodigoMatricula.getText(),jt_Cedula.getText(),jt_NombEstudiante.getText(),jt_Sigla.getText()};
        modelo.addRow(matricula);
    }
    
    public void agregarMatricula(String[] arreglo)
    {
        modelo.addRow(arreglo);
        this.jt_NombEstudiante.setText(arreglo[2]);
        this.jt_Cedula.setText(arreglo[1]);
    }
    public boolean verificarEspacios()
    {
        boolean espacios=true;
        if(devolverCedula().equals("")||devolverSigla().equals("")||jt_NombEstudiante.getText().equals("")||jt_NombCurso.getText().equals(""))
        espacios=false;
        return espacios;
    }
     public void limpiarCurso()
     {
         jt_NombCurso.setText("");
         jt_Sigla.setText("");
         
     }
     public void limpiadoInicial()
    {
        jt_NombCurso.setText("");
        jt_Sigla.setText("");
        jt_NombEstudiante.setText("");
         jt_Cedula.setText("");
    }
    public String[] devolverInformacion()
    {
        String informacion[]=new String[3];
        informacion[0]=this.jt_CodigoMatricula.getText();
        informacion[1]=this.jt_Cedula.getText();
        informacion[2]=this.jt_Sigla.getText();
        
        return informacion;
    }
    public int getCantidadFilas()
    {
        return modelo.getRowCount();
    }
    public void resetearVentana()
    {
        for (int i = 0; i < modelo.getRowCount(); i=0) 
        {
            modelo.removeRow(i);
        }
    }
    
    public void borrarFila()
    {
        modelo.removeRow(tbl_Tabla.getSelectedRow());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Cedula = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        btn_ConsultaEstudiante = new javax.swing.JButton();
        jl_NombEstudiante = new javax.swing.JLabel();
        jl_Sigla = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jt_NombEstudiante = new javax.swing.JTextField();
        jl_NombCurso = new javax.swing.JLabel();
        jt_NombCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Tabla = new javax.swing.JTable();
        btn_ConsultaCurso = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jl_CodigoMatricula = new javax.swing.JLabel();
        jt_CodigoMatricula = new javax.swing.JTextField();

        jl_Cedula.setText("Cedula");

        jt_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_CedulaKeyPressed(evt);
            }
        });

        btn_ConsultaEstudiante.setBackground(new java.awt.Color(0, 153, 204));
        btn_ConsultaEstudiante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaEstudiante.setText("Consultar");
        btn_ConsultaEstudiante.setActionCommand("ConsultarEstudiante");

        jl_NombEstudiante.setText("Nombre Estudiante");

        jl_Sigla.setText("Sigla");

        jt_Sigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_SiglaKeyPressed(evt);
            }
        });

        jt_NombEstudiante.setEnabled(false);

        jl_NombCurso.setText("NombreCurso");

        jt_NombCurso.setEnabled(false);

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Tabla);

        btn_ConsultaCurso.setBackground(new java.awt.Color(0, 153, 255));
        btn_ConsultaCurso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btn_ConsultaCurso.setText("Consultar");
        btn_ConsultaCurso.setActionCommand("ConsultarCurso");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logoUCR-300x231.png"))); // NOI18N

        jl_CodigoMatricula.setText("Codigo de Matricula:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_Sigla)
                            .addComponent(jl_NombCurso))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_ConsultaCurso))
                            .addComponent(jt_NombCurso)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_Cedula)
                                    .addComponent(jl_CodigoMatricula)))
                            .addComponent(jl_NombEstudiante))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_ConsultaEstudiante))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jt_NombEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_CodigoMatricula)
                    .addComponent(jt_CodigoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_Cedula)
                        .addComponent(jt_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_ConsultaEstudiante, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombEstudiante)
                    .addComponent(jt_NombEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ConsultaCurso)
                    .addComponent(jt_Sigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Sigla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombCurso)
                    .addComponent(jt_NombCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jt_CedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_CedulaKeyPressed
        if(evt.getKeyCode()==10)
        {
            this.controlador.buscarEstudiante();
        } 
    }//GEN-LAST:event_jt_CedulaKeyPressed

    private void jt_SiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_SiglaKeyPressed
        if(evt.getKeyCode()==10)
        {
            this.controlador.buscarCurso();
        }
    }//GEN-LAST:event_jt_SiglaKeyPressed

    private void tbl_TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TablaMouseClicked
        jt_CodigoMatricula.setText(""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 0));
        jt_Cedula.setText(""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 1));
        jt_NombEstudiante.setText(""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 2));
        jt_Sigla.setText(""+modelo.getValueAt(tbl_Tabla.getSelectedRow(), 3));
        controlador.buscarCurso();
        controlador.frm_Matricula.hablitarEdicion();
    }//GEN-LAST:event_tbl_TablaMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ConsultaCurso;
    private javax.swing.JButton btn_ConsultaEstudiante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_Cedula;
    private javax.swing.JLabel jl_CodigoMatricula;
    private javax.swing.JLabel jl_NombCurso;
    private javax.swing.JLabel jl_NombEstudiante;
    private javax.swing.JLabel jl_Sigla;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombCurso;
    private javax.swing.JTextField jt_NombEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private javax.swing.JTable tbl_Tabla;
    // End of variables declaration//GEN-END:variables
}
