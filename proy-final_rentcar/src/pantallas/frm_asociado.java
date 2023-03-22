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
/**
 *
 * @author user
 */
public class frm_asociado extends javax.swing.JFrame {
    
//declarar la jtable con el nombre de la tabla 
    DefaultTableModel asociado;
//    --------------------fin-----------------------
    
  
    public frm_asociado() {
        initComponents();
        
        //        para que se vea la tabla 
        this.asociado =( DefaultTableModel) table_asociado.getModel();
//        ----------------------------fin------------------------------

// llamando a la funcion mostrardatos 
              mostrardatos("");
//--------------fin----------------
    }  
    
        //    funcion para filtrar datos por el rnc 
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
       asociado.addColumn("Cod_asociado");
        asociado.addColumn("rnc_asoc");
        asociado.addColumn("moneda_asoc");
        asociado.addColumn("estado_asoc");
        asociado.addColumn("cod_per");
        this.table_asociado.setModel(asociado); 
        String sql;
        if(valor.equals("")){
            sql ="select * from asociado"; 
        } else {
            sql = "select * from asociado where rnc_asoc like  '%"+valor+"%' "; 
        }
        String [ ] datos = new String[ 5];
        
        try{
             Statement st= cn.createStatement();
       ResultSet rs= st.executeQuery(sql);
            
            while(rs.next() ){
                 datos[ 0 ]=rs.getString(1); 
                datos[ 1 ]=rs.getString(2); 
                datos[ 2]=rs.getString(3); 
                datos[ 3 ]=rs.getString(4); 
                datos[ 4 ]=rs.getString(5); 
              
                
                asociado.addRow(datos);
            }
            table_asociado.setModel(asociado);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_asociado.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
    
    //    funcion para mostrar datos
    public final void mostrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
       asociado.addColumn("Cod_asociado");
        asociado.addColumn("rnc_asoc");
        asociado.addColumn("moneda_asoc");
        asociado.addColumn("estado_asoc");
        asociado.addColumn("cod_per");
        this.table_asociado.setModel(asociado); 
        String sql;
        if(valor.equals("")){
            sql ="select * from asociado"; 
        } else {
            sql = "select * from asociado where cod_asoc= '"+valor+"' "; 
        }
        String [ ] datos = new String[ 5];
        
        try{
             Statement st= cn.createStatement();
       ResultSet rs= st.executeQuery(sql);
            
            while(rs.next() ){
                 datos[ 0 ]=rs.getString(1); 
                datos[ 1 ]=rs.getString(2); 
                datos[ 2]=rs.getString(3); 
                datos[ 3 ]=rs.getString(4); 
                datos[ 4 ]=rs.getString(5); 
              
                
                asociado.addRow(datos);
            }
            table_asociado.setModel(asociado);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_asociado.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            asociado.setColumnCount(0);
            asociado.setRowCount(0);
            table_asociado.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
    
    
 public boolean RevisarAsociado(String asociado){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `asociado` WHERE `cod_asoc` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, asociado);
            
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
            txt_cod_asociado.setText("");
           txt_rnc_asociado.setText("");
          txt_moneda_asociado.setText("");
        txt_cod_persona.setText("");
        Cbox_estado_asociado.setSelectedIndex(0); 
 
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

        label_rentcar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_listadepersona = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label_cod_asociado = new javax.swing.JLabel();
        txt_cod_asociado = new javax.swing.JTextField();
        label_rnc_asociado = new javax.swing.JLabel();
        txt_rnc_asociado = new javax.swing.JTextField();
        label_moneda_asociado = new javax.swing.JLabel();
        txt_moneda_asociado = new javax.swing.JTextField();
        label_estado_asociado = new javax.swing.JLabel();
        label_cod_persona = new javax.swing.JLabel();
        txt_cod_persona = new javax.swing.JTextField();
        Cbox_estado_asociado = new javax.swing.JComboBox<>();
        btn_print = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        label_rentcar1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        label_listadeasociados = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_asociado = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        label_imgfondo = new javax.swing.JLabel();

        label_rentcar.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar.setText("Rent a Car U&S");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);

        label_listadepersona.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listadepersona.setText("Lista de personas");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_cod_asociado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_asociado.setText("Cod_asociado:");

        txt_cod_asociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_asociadoActionPerformed(evt);
            }
        });

        label_rnc_asociado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_rnc_asociado.setText("rnc_asociado:");

        txt_rnc_asociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rnc_asociadoActionPerformed(evt);
            }
        });

        label_moneda_asociado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_moneda_asociado.setText("Moneda_asociado:");

        txt_moneda_asociado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_moneda_asociadoActionPerformed(evt);
            }
        });

        label_estado_asociado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_estado_asociado.setText("Estado_asociado:");

        label_cod_persona.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_persona.setText("Cod_persona:");

        txt_cod_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_personaActionPerformed(evt);
            }
        });

        Cbox_estado_asociado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "eligir", "activo", "inactivo" }));

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-50.png"))); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-50.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_salida.png"))); // NOI18N

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        label_rentcar1.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar1.setText("Rent a Car U&S");

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setAlignmentX(1.0F);
        jSeparator2.setAlignmentY(1.0F);

        label_listadeasociados.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listadeasociados.setForeground(new java.awt.Color(0, 102, 102));
        label_listadeasociados.setText("Registro de asociados");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        table_asociado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_asociado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_asociadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_asociado);

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_cod_persona)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_cod_persona))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_estado_asociado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Cbox_estado_asociado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_moneda_asociado)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_moneda_asociado))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_rnc_asociado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_rnc_asociado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_cod_asociado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_cod_asociado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_listadeasociados)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label_rentcar1)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(label_rentcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_listadeasociados)))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cod_asociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_cod_asociado))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_rnc_asociado)
                    .addComponent(txt_rnc_asociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_moneda_asociado)
                    .addComponent(txt_moneda_asociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_estado_asociado)
                    .addComponent(Cbox_estado_asociado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cod_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_cod_persona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_print, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_edit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 870, 410));

        label_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(label_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 929, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_asociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_asociadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_asociadoActionPerformed

    private void txt_rnc_asociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rnc_asociadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rnc_asociadoActionPerformed

    private void txt_moneda_asociadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_moneda_asociadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_moneda_asociadoActionPerformed

    private void txt_cod_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_personaActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
         // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_asociado.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("asociado", "Reporte asociado");

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
      String cod = txt_cod_asociado.getText();
        String rnc = txt_rnc_asociado.getText();
        String mone = txt_moneda_asociado.getText();
        String cod_per = txt_cod_persona.getText();
        String estado = String.valueOf(Cbox_estado_asociado.getSelectedIndex());

                
        if(rnc.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el rnc");
        }
        
        else if(cod_per.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega una el codigo de la persona");
        }      
        else if(RevisarAsociado(cod))
        {
            JOptionPane.showMessageDialog(null, "Este asociado ya existe");
        }
          else if(mone.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega la moneda");
        }      
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `asociado`(`cod_asoc`,`rnc_asoc`, `moneda_asoc`, `estado_asoc`,`cod_per`) VALUES (?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, rnc);
            ps.setString(3, mone);
            ps.setString(4, estado);
            ps.setString(5, cod_per);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo asociado Agregado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_asociado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       // con este boton se elimina un registro de la tabla
        String cod = (String) asociado.getValueAt(table_asociado.getSelectedRow(),0) ;
        PreparedStatement ps;
        String query = "delete from asociado where Cod_asoc=?";
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
            Logger.getLogger(frm_asociado.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        

//      -------------------------------fin--------------------------------------                                        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
                //  llamando a la funcion filtrar datos por el rnc 
        filtrardatos(txt_buscar.getText());
//        ------------fin----------------------
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void table_asociadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_asociadoMouseClicked
       // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_asociado.rowAtPoint(evt.getPoint()); 
       
          txt_rnc_asociado.setText(table_asociado.getValueAt(filaseleccionada,1).toString());
          txt_moneda_asociado.setText(table_asociado.getValueAt(filaseleccionada,2).toString());
           Cbox_estado_asociado.setSelectedItem(table_asociado.getValueAt(filaseleccionada,3)); 
           txt_cod_persona.setText(table_asociado.getValueAt(filaseleccionada,4).toString());    
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_asociadoMouseClicked

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
            java.util.logging.Logger.getLogger(frm_asociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_asociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_asociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_asociado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_asociado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbox_estado_asociado;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_cod_asociado;
    private javax.swing.JLabel label_cod_persona;
    private javax.swing.JLabel label_estado_asociado;
    private javax.swing.JLabel label_imgfondo;
    private javax.swing.JLabel label_listadeasociados;
    private javax.swing.JLabel label_listadepersona;
    private javax.swing.JLabel label_moneda_asociado;
    private javax.swing.JLabel label_rentcar;
    private javax.swing.JLabel label_rentcar1;
    private javax.swing.JLabel label_rnc_asociado;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_asociado;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod_asociado;
    private javax.swing.JTextField txt_cod_persona;
    private javax.swing.JTextField txt_moneda_asociado;
    private javax.swing.JTextField txt_rnc_asociado;
    // End of variables declaration//GEN-END:variables
}
