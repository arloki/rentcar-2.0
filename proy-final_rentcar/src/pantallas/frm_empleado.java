/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author user
 */
public class frm_empleado extends javax.swing.JFrame {
    
//    declarar el nombre de la jtable
DefaultTableModel empleado;
//-----------------fin----------------
    /**
     * Creates new form frm_empleado
     */
    public frm_empleado() {
        initComponents(); 
        
        //        para que se vea la tabla 
        this.empleado =( DefaultTableModel) table_em.getModel();
//        ----------------------------fin------------------------------

// llamando a la funcion mostrardatos 
mostrardatos("");
//--------------fin----------------    
    }
    
     //    funcion para mostrar datos
    public final void mostrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
       empleado.addColumn("cod_emp");
       empleado.addColumn("fecha_ingreso_emp");
       empleado.addColumn("fecha_salida_emp");
       empleado.addColumn("estado_emp");
       empleado.addColumn("cod_per");
       empleado.addColumn("cod_puesto");
        
        
        this.table_em.setModel(empleado); 
        String sql;
        if(valor.equals("")){
            sql ="select * from empleado"; 
        } else {
            sql = "select * from empleado where cod_emp= '"+valor+"' "; 
        }
        String [ ] datos = new String[ 6];
        
        try{
             Statement st= cn.createStatement();
       ResultSet rs= st.executeQuery(sql);
            
            while(rs.next() ){
                 datos[ 0 ]=rs.getString(1); 
                datos[ 1 ]=rs.getString(2); 
                datos[ 2]=rs.getString(3); 
                datos[ 3 ]=rs.getString(4); 
                datos[ 4 ]=rs.getString(5); 
                datos[ 5 ]=rs.getString(6); 
                
                empleado.addRow(datos);
            }
            table_em.setModel(empleado);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_empleado.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
    //    funcion para filtrar datos por el codigo del empleado
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
       empleado.addColumn("cod_emp");
       empleado.addColumn("fecha_ingreso_emp");
       empleado.addColumn("fecha_salida_emp");
       empleado.addColumn("estado_emp");
       empleado.addColumn("cod_per");
       empleado.addColumn("cod_puesto");
        
        
        this.table_em.setModel(empleado); 
        String sql;
        if(valor.equals("")){
            sql ="select * from empleado"; 
        } else {
            sql = "select * from empleado where cod_emp like  '%"+valor+"%' "; 
        }
        String [ ] datos = new String[ 6];
        
        try{
             Statement st= cn.createStatement();
       ResultSet rs= st.executeQuery(sql);
            
            while(rs.next() ){
                 datos[ 0 ]=rs.getString(1); 
                datos[ 1 ]=rs.getString(2); 
                datos[ 2]=rs.getString(3); 
                datos[ 3 ]=rs.getString(4); 
                datos[ 4 ]=rs.getString(5); 
                datos[ 5 ]=rs.getString(6); 
                
                empleado.addRow(datos);
            }
            table_em.setModel(empleado);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_empleado.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
           empleado.setColumnCount(0);
            empleado.setRowCount(0);
            table_em.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
    public boolean RevisarEmpleado(String empleado){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `empleado` WHERE `cod_emp` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, empleado);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                checkUser = true;
            }
        }   catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error" + ex);
        }
        return checkUser;
        }
//   -----------------------------fin---------------------------------------
    
    public void limpiar(){
        //limpia el formulario despues de llenarlo
        try{
            txt_cod_empleado.setText("");
           txt_fecha_ingreso.setText("");
         txt_fecha_salida.setText("");
        txt_cod_persona.setText("");
        txt_cod_puesto.setText("");
        Cbox_Estado_empleado.setSelectedIndex(0); 
 
        } catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
       
    } 
//        -----------------------fin------------------------------
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_cod_empleado = new javax.swing.JLabel();
        txt_cod_empleado = new javax.swing.JTextField();
        label_fecha_ingreso = new javax.swing.JLabel();
        txt_fecha_ingreso = new javax.swing.JTextField();
        label_Fecha_salida = new javax.swing.JLabel();
        txt_fecha_salida = new javax.swing.JTextField();
        label_estado_empleado = new javax.swing.JLabel();
        Cbox_Estado_empleado = new javax.swing.JComboBox<>();
        label_cod_persona = new javax.swing.JLabel();
        txt_cod_persona = new javax.swing.JTextField();
        label_cod_puesto = new javax.swing.JLabel();
        txt_cod_puesto = new javax.swing.JTextField();
        btn_print = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        label_listaderentas = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_rentcar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_em = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        label_imgfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_cod_empleado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_empleado.setText("Cod_empleado:");

        txt_cod_empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_empleadoActionPerformed(evt);
            }
        });

        label_fecha_ingreso.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_fecha_ingreso.setText("Fecha_ingreso:");

        txt_fecha_ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_ingresoActionPerformed(evt);
            }
        });

        label_Fecha_salida.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Fecha_salida.setText("Fecha_salida:");

        txt_fecha_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_salidaActionPerformed(evt);
            }
        });

        label_estado_empleado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_estado_empleado.setText("Estado_empleado:");

        Cbox_Estado_empleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "eligir", "activo", "inactivo" }));

        label_cod_persona.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_persona.setText("Cod_persona:");

        txt_cod_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_personaActionPerformed(evt);
            }
        });

        label_cod_puesto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_puesto.setText("Cod_puesto:");

        txt_cod_puesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_puestoActionPerformed(evt);
            }
        });

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-50.png"))); // NOI18N

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-50.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_salida.png"))); // NOI18N

        label_listaderentas.setFont(new java.awt.Font("Goudy Old Style", 0, 22)); // NOI18N
        label_listaderentas.setForeground(new java.awt.Color(0, 102, 102));
        label_listaderentas.setText("Registro de empleados");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);

        label_rentcar.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar.setText("Rent a Car U&S");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        table_em.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_em.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_emMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_em);

        lbl_buscar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_buscar.setText("buscar:");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_rentcar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(label_listaderentas))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_estado_empleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cbox_Estado_empleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label_cod_puesto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cod_puesto))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label_cod_persona)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cod_persona))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label_Fecha_salida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fecha_salida))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label_fecha_ingreso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fecha_ingreso))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(label_cod_empleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cod_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_rentcar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_listaderentas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_empleado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_fecha_ingreso)
                            .addComponent(txt_fecha_ingreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_Fecha_salida)
                            .addComponent(txt_fecha_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_estado_empleado)
                            .addComponent(Cbox_Estado_empleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_persona))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_puesto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_salida, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_buscar)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 800, 450));

        label_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(label_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_empleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_empleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_empleadoActionPerformed

    private void txt_fecha_ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_ingresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_ingresoActionPerformed

    private void txt_fecha_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_salidaActionPerformed

    private void txt_cod_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_personaActionPerformed

    private void txt_cod_puestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_puestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_puestoActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
            // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_empleado.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("empleado ", "Reporte empleado");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // con este boton cada vez que se llena el formulario  se llena en la base de datos 
      String cod = txt_cod_empleado.getText();
      String fecha = txt_fecha_ingreso.getText();
      String salida = txt_fecha_salida.getText();
      String cod_per = txt_cod_persona.getText();
      String cod_puesto = txt_cod_puesto.getText();
      String estado = String.valueOf(Cbox_Estado_empleado.getSelectedIndex());

                
        if(cod.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un empleado");
        }
        
        else if(cod_per.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el codigo de la persona");
        }  
        else if(cod_puesto.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el codigo del puesto");
        } 
        else if(fecha.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega la fecha de ingreso");
        }      
        else if(RevisarEmpleado(cod))
        {
            JOptionPane.showMessageDialog(null, "Este empleado ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `empleado`(`cod_emp`,`fecha_ingreso_emp`, `fecha_salida_emp`, `estado_emp`, `cod_per`, `cod_puesto`) VALUES (?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, fecha);
            ps.setString(3, salida);
            ps.setString(4, estado);
            ps.setString(5, cod_per);
            ps.setString(6, cod_puesto);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo empleado Agregado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
         // con este boton se elimina un registro de la tabla
        String cod = (String) empleado.getValueAt(table_em.getSelectedRow(),0) ;
    

        PreparedStatement ps;
        String query = "delete from empleado where cod_emp=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
              ps.setString(1, cod);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_empleado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        

//      -------------------------------fin--------------------------------------
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        //  llamando a la funcion filtrar datos
        filtrardatos(txt_buscar.getText());
//        ------------fin----------------------
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void table_emMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_emMouseClicked
         // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_em.rowAtPoint(evt.getPoint()); 
       
          txt_fecha_ingreso.setText(table_em.getValueAt(filaseleccionada,1).toString());
          txt_fecha_salida.setText(table_em.getValueAt(filaseleccionada,2).toString());
           Cbox_Estado_empleado.setSelectedItem(table_em.getValueAt(filaseleccionada,3)); 
           txt_cod_persona.setText(table_em.getValueAt(filaseleccionada,4).toString()); 
            txt_cod_puesto.setText(table_em.getValueAt(filaseleccionada,5).toString());  
             
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_emMouseClicked

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
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbox_Estado_empleado;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Fecha_salida;
    private javax.swing.JLabel label_cod_empleado;
    private javax.swing.JLabel label_cod_persona;
    private javax.swing.JLabel label_cod_puesto;
    private javax.swing.JLabel label_estado_empleado;
    private javax.swing.JLabel label_fecha_ingreso;
    private javax.swing.JLabel label_imgfondo;
    private javax.swing.JLabel label_listaderentas;
    private javax.swing.JLabel label_rentcar;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_em;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod_empleado;
    private javax.swing.JTextField txt_cod_persona;
    private javax.swing.JTextField txt_cod_puesto;
    private javax.swing.JTextField txt_fecha_ingreso;
    private javax.swing.JTextField txt_fecha_salida;
    // End of variables declaration//GEN-END:variables
}
