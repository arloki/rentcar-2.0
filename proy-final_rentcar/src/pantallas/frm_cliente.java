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
public class frm_cliente extends javax.swing.JFrame {
//declarar la jtable con el nombre de la tabla 
    DefaultTableModel cliente;
//    --------------------fin-----------------------
    
    public frm_cliente() {
        initComponents();
        
        //        para que se vea la tabla 
        this.cliente =( DefaultTableModel) table_cliente.getModel();
//        ----------------------------fin------------------------------

// llamando a la funcion mostrardatos 
mostrardatos("");
//--------------fin----------------

    }
    
    //    funcion para filtrar datos por el numero de licencia 
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        cliente.addColumn("cod_cli");
        cliente.addColumn("num_lic");
        cliente.addColumn("fecha_emision_lic");
        cliente.addColumn("fecha_expiracion_lic");
        cliente.addColumn("categoria_lic");
        cliente.addColumn("estado_cli");
        cliente.addColumn("cod_per");
           
        this.table_cliente.setModel(cliente); 
        String sql;
        if(valor.equals("")){
            sql ="select * from cliente"; 
        } else {
            sql = "select * from cliente where num_lic like  '%"+valor+"%' "; 
        }
        String [ ] datos = new String[ 7];
        
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
                datos[ 6 ]=rs.getString(7);  
                
                cliente.addRow(datos);
            }
            table_cliente.setModel(cliente);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_cliente.class.getName()).log(Level.SEVERE,null,ex);
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
        cliente.addColumn("cod_cli");
        cliente.addColumn("num_lic");
        cliente.addColumn("fecha_emision_lic");
        cliente.addColumn("fecha_expiracion_lic");
        cliente.addColumn("categoria_lic");
        cliente.addColumn("estado_cli");
        cliente.addColumn("cod_per");
           
        this.table_cliente.setModel(cliente); 
        String sql;
        if(valor.equals("")){
            sql ="select * from cliente"; 
        } else {
            sql = "select * from cliente where num_lic= '"+valor+"' "; 
        }
        String [ ] datos = new String[ 7];
        
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
                datos[ 6 ]=rs.getString(7);  
                
                cliente.addRow(datos);
            }
            table_cliente.setModel(cliente);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_cliente.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
     public boolean RevisarCliente(String cliente){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `cliente` WHERE `cod_cli` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, cliente);
            
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
            txt_Cod_cliente.setText("");
            txt_num_licencia.setText("");
         txt_Fecha_emision_lic.setText("");
        txt_fecha_expiracion_lic.setText("");
        txt_Categoria_lic.setText("");
         txt_Cod_persona.setText("");
        cbox_estado.setSelectedIndex(0); 
 
        } catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
       
    } 
//        -----------------------fin------------------------------
    } 
    
    //    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            cliente.setColumnCount(0);
            cliente.setRowCount(0);
            table_cliente.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        label_listadeclientes = new javax.swing.JLabel();
        label_Cod_cliente = new javax.swing.JLabel();
        txt_Cod_cliente = new javax.swing.JTextField();
        label_Num_licencia = new javax.swing.JLabel();
        txt_num_licencia = new javax.swing.JTextField();
        label_Categoria_lic = new javax.swing.JLabel();
        txt_Categoria_lic = new javax.swing.JTextField();
        label_Fecha_emision_lic = new javax.swing.JLabel();
        txt_Fecha_emision_lic = new javax.swing.JTextField();
        label_Cod_persona = new javax.swing.JLabel();
        txt_Cod_persona = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        label_Estado_cliente = new javax.swing.JLabel();
        txt_fecha_expiracion_lic = new javax.swing.JTextField();
        label_apellido1 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        label_rentcar = new javax.swing.JLabel();
        cbox_estado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_cliente = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        Label_imgfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        label_listadeclientes.setFont(new java.awt.Font("Goudy Old Style", 0, 22)); // NOI18N
        label_listadeclientes.setForeground(new java.awt.Color(0, 102, 102));
        label_listadeclientes.setText("Registro de clientes");

        label_Cod_cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_cliente.setText("Cod_cliente:");

        txt_Cod_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_clienteActionPerformed(evt);
            }
        });

        label_Num_licencia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Num_licencia.setText("Num_licencia:");

        txt_num_licencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_num_licenciaActionPerformed(evt);
            }
        });

        label_Categoria_lic.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Categoria_lic.setText("Categoria_lic:");

        txt_Categoria_lic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Categoria_licActionPerformed(evt);
            }
        });

        label_Fecha_emision_lic.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Fecha_emision_lic.setText("Fecha_emision_lic:");

        txt_Fecha_emision_lic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Fecha_emision_licActionPerformed(evt);
            }
        });

        label_Cod_persona.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_persona.setText("     Cod_persona:");

        txt_Cod_persona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_personaActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-50.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_salida.png"))); // NOI18N
        btn_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salidaActionPerformed(evt);
            }
        });

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-50.png"))); // NOI18N

        label_Estado_cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Estado_cliente.setText("Estado_cliente:");

        txt_fecha_expiracion_lic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_expiracion_licActionPerformed(evt);
            }
        });

        label_apellido1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_apellido1.setText("Fecha_expiracion_lic:");

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);

        label_rentcar.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar.setText("Rent a Car U&S");

        cbox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elegir", "activo", "inactivo" }));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        table_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_cliente);

        lbl_buscar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_buscar.setText("buscar:");

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_rentcar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label_Categoria_lic)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_Categoria_lic, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label_Cod_cliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_Cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label_Num_licencia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_num_licencia, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label_Fecha_emision_lic)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Fecha_emision_lic, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label_apellido1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_fecha_expiracion_lic, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label_Estado_cliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(label_listadeclientes)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(label_Cod_persona)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_Cod_persona, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(label_rentcar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_listadeclientes)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Cod_cliente)
                            .addComponent(txt_Cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Num_licencia)
                            .addComponent(txt_num_licencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Fecha_emision_lic)
                            .addComponent(txt_Fecha_emision_lic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_apellido1)
                            .addComponent(txt_fecha_expiracion_lic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Categoria_lic)
                            .addComponent(txt_Categoria_lic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Estado_cliente)
                            .addComponent(cbox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Cod_persona)
                            .addComponent(txt_Cod_persona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_print, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_buscar)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 800, 480));

        Label_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(Label_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Cod_personaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_personaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cod_personaActionPerformed

    private void txt_Fecha_emision_licActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Fecha_emision_licActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Fecha_emision_licActionPerformed

    private void txt_Categoria_licActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Categoria_licActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Categoria_licActionPerformed

    private void txt_num_licenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_num_licenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_num_licenciaActionPerformed

    private void txt_Cod_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cod_clienteActionPerformed

    private void txt_fecha_expiracion_licActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_expiracion_licActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_expiracion_licActionPerformed

    private void btn_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_salidaActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed

        // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_cliente.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("cliente", "Reporte cliente");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
//    ----------------------------fin------------------------------------------------
        
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
                // con este boton cada vez que se llena el formulario  se llena en la base de datos 
      String cod = txt_Cod_cliente.getText();
        String lic = txt_num_licencia.getText();
        String emi= txt_Fecha_emision_lic.getText();
        String fecha = txt_fecha_expiracion_lic.getText();
        String cat = txt_Categoria_lic.getText();
          String cod_per = txt_Cod_persona.getText();
        String estado = String.valueOf(cbox_estado.getSelectedIndex());

                
        if(cod.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el codigo del cliente");
        }
        
        else if(lic.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el numero de licencia");
        }      
        else if(RevisarCliente(cod))
        {
            JOptionPane.showMessageDialog(null, "Este cliente ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `cliente`(`cod_cli`,`num_lic`, `fecha_emision_lic`, `fecha_expiracion_lic`, `categoria_lic`, `estado_cli`, `cod_per`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, lic);
            ps.setString(3, emi);
            ps.setString(4, fecha);
            ps.setString(5, cat);
            ps.setString(6, estado);
            ps.setString(7, cod_per);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo cliente Agregado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // con este boton se elimina un registro de la tabla
        String cod = (String) cliente.getValueAt(table_cliente.getSelectedRow(),0) ;
    

        PreparedStatement ps;
        String query = "delete from cliente where cod_cli=?";
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
            Logger.getLogger(frm_cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
//      -------------------------------fin--------------------------------------
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        //  llamando a la funcion filtrar datos
        filtrardatos(txt_buscar.getText());
//        ------------fin----------------------
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void table_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clienteMouseClicked
         // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_cliente.rowAtPoint(evt.getPoint()); 
        
         txt_num_licencia.setText(table_cliente.getValueAt(filaseleccionada,1).toString());
         txt_Fecha_emision_lic.setText(table_cliente.getValueAt(filaseleccionada,2).toString());
         txt_fecha_expiracion_lic.setText(table_cliente.getValueAt(filaseleccionada,3).toString());
          txt_Categoria_lic.setText(table_cliente.getValueAt(filaseleccionada,4).toString());
          cbox_estado.setSelectedItem(table_cliente.getValueAt(filaseleccionada,5)); 
          txt_Cod_persona.setText(table_cliente.getValueAt(filaseleccionada,6).toString());
          
             
             
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_clienteMouseClicked

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
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_imgfondo;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_salida;
    private javax.swing.JComboBox<String> cbox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Categoria_lic;
    private javax.swing.JLabel label_Cod_cliente;
    private javax.swing.JLabel label_Cod_persona;
    private javax.swing.JLabel label_Estado_cliente;
    private javax.swing.JLabel label_Fecha_emision_lic;
    private javax.swing.JLabel label_Num_licencia;
    private javax.swing.JLabel label_apellido1;
    private javax.swing.JLabel label_listadeclientes;
    private javax.swing.JLabel label_rentcar;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_cliente;
    private javax.swing.JTextField txt_Categoria_lic;
    private javax.swing.JTextField txt_Cod_cliente;
    private javax.swing.JTextField txt_Cod_persona;
    private javax.swing.JTextField txt_Fecha_emision_lic;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_fecha_expiracion_lic;
    private javax.swing.JTextField txt_num_licencia;
    // End of variables declaration//GEN-END:variables
}
