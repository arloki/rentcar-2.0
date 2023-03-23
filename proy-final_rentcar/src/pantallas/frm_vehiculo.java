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
public class frm_vehiculo extends javax.swing.JFrame {

    //declarar la jtable con el nombre de la tabla 
    DefaultTableModel vehiculo;
//    --------------------fin-----------------------
    /**
     * Creates new form frm_vehiculo
     */
    public frm_vehiculo() {
        initComponents();
        
        //        para que se vea la tabla 
        this.vehiculo =( DefaultTableModel) table_vh.getModel();
//        ----------------------------fin------------------------------

// llamando a la funcion mostrardatos 
                          mostrardatos("");
//--------------fin----------------
    }
    
    //    funcion para filtrar datos por la matricula
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        vehiculo.addColumn("Cod_vh");
        vehiculo.addColumn(" matricula_vh");
        vehiculo.addColumn("ano_de_salida_vh");
        vehiculo.addColumn("distintivo_vh");
        vehiculo.addColumn("categoria_vh");
        vehiculo.addColumn("estado_vh");
        vehiculo.addColumn("cod_marca");
        
        
        this.table_vh.setModel(vehiculo); 
        String sql;
        if(valor.equals("")){
            sql ="select * from vehiculo"; 
        } else {
            sql = "select * from vehiculo where matricula_vh like  '%"+valor+"%' "; 
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
                
                vehiculo.addRow(datos);
            }
            table_vh.setModel(vehiculo);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_vehiculo.class.getName()).log(Level.SEVERE,null,ex);
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
        vehiculo.addColumn("Cod_vh");
        vehiculo.addColumn(" matricula_vh");
        vehiculo.addColumn("ano_de_salida_vh");
        vehiculo.addColumn("distintivo_vh");
        vehiculo.addColumn("categoria_vh");
        vehiculo.addColumn("estado_vh");
        vehiculo.addColumn("cod_marca");
        
        
        this.table_vh.setModel(vehiculo); 
        String sql;
        if(valor.equals("")){
            sql ="select * from vehiculo"; 
        } else {
            sql = "select * from vehiculo where matricula_vh= '"+valor+"' "; 
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
                
                vehiculo.addRow(datos);
            }
            table_vh.setModel(vehiculo);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_vehiculo.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            vehiculo.setColumnCount(0);
            vehiculo.setRowCount(0);
            table_vh.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
    public boolean RevisarVehiculo(String vehiculo){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `vehiculo` WHERE `matricula_vh` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, vehiculo);
            
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
           txt_cod_vh.setText("");
           txt_Año_salida.setText("");
          txt_Categoria.setText("");
         txt_cod_marca.setText("");
        txt_Matricula.setText("");
         txt_distintivo.setText("");
        Cbox_estado_vh.setSelectedIndex(0); 
 
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
        label_Cod_vehiculo = new javax.swing.JLabel();
        txt_cod_vh = new javax.swing.JTextField();
        label_Matricula = new javax.swing.JLabel();
        txt_Matricula = new javax.swing.JTextField();
        label_Año_salida = new javax.swing.JLabel();
        txt_Año_salida = new javax.swing.JTextField();
        label_apellido = new javax.swing.JLabel();
        txt_distintivo = new javax.swing.JTextField();
        label_Categoria = new javax.swing.JLabel();
        txt_Categoria = new javax.swing.JTextField();
        label_Estado = new javax.swing.JLabel();
        Cbox_estado_vh = new javax.swing.JComboBox<>();
        label_telefono2 = new javax.swing.JLabel();
        txt_cod_marca = new javax.swing.JTextField();
        btn_delete = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        btn_print1 = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        label_rentcar1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        label_listadeasociados = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_vh = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel_imgfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Cod_vehiculo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_vehiculo.setText("Cod_vehiculo:");

        txt_cod_vh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_vhActionPerformed(evt);
            }
        });

        label_Matricula.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Matricula.setText("Matricula:");

        txt_Matricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_MatriculaActionPerformed(evt);
            }
        });

        label_Año_salida.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Año_salida.setText("Año salida:");

        txt_Año_salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Año_salidaActionPerformed(evt);
            }
        });

        label_apellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_apellido.setText("Distintivo:");

        txt_distintivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_distintivoActionPerformed(evt);
            }
        });

        label_Categoria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Categoria.setText("Categoria:");

        txt_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CategoriaActionPerformed(evt);
            }
        });

        label_Estado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Estado.setText("Estado:");

        Cbox_estado_vh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elegir", "activo", "inactivo" }));

        label_telefono2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_telefono2.setText("Cod_marca:");

        txt_cod_marca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_marcaActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-50.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_salida.png"))); // NOI18N

        btn_print1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print1ActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-50.png"))); // NOI18N

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
        label_listadeasociados.setText("Registro de vehiculo");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        table_vh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_vh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_vhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_vh);

        lbl_buscar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_buscar.setText("Buscar:");

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
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
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_print1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_Cod_vehiculo)
                            .addComponent(label_Año_salida)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(txt_cod_vh, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_telefono2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_cod_marca))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_Categoria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_Año_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_Matricula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Matricula))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_apellido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_distintivo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(label_Estado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Cbox_estado_vh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_rentcar1)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label_listadeasociados)
                                .addGap(62, 62, 62)))
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_rentcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_listadeasociados))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_vh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Cod_vehiculo))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Año_salida)
                            .addComponent(txt_Año_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Categoria)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Matricula)
                            .addComponent(txt_Matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_apellido)
                            .addComponent(txt_distintivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Estado)
                            .addComponent(Cbox_estado_vh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cod_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_telefono2))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_edit, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_print1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_buscar)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 1070, 390));

        jLabel_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(jLabel_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_vhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_vhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_vhActionPerformed

    private void txt_MatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_MatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_MatriculaActionPerformed

    private void txt_Año_salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Año_salidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Año_salidaActionPerformed

    private void txt_distintivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_distintivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_distintivoActionPerformed

    private void txt_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_CategoriaActionPerformed

    private void txt_cod_marcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_marcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_marcaActionPerformed

    private void btn_print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print1ActionPerformed
       // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_vehiculo.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("vehiculo ", "Reporte vehiculo");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_print1ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
          // con este boton cada vez que se llena el formulario  se llena en la base de datos 
        String cod = txt_cod_vh.getText();
        String matri = txt_Matricula.getText();
        String cod_mar = txt_cod_marca.getText();
        String salida = txt_Año_salida.getText();  //el año de salida se llena empezando por el año 
        String dis = txt_distintivo.getText();
        String cat = txt_Categoria.getText();
        String estado= String.valueOf(Cbox_estado_vh.getSelectedIndex());

                
        if(cod.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el codigo al vehiculo");
        }
        
        else if(matri.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega la matricula del vehiculo");
        }      
        else if(RevisarVehiculo(cod))
        {
            JOptionPane.showMessageDialog(null, "Este vehiculo ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `vehiculo`(`Cod_vh`,`matricula_vh`, `ano_de_salida_vh`, `distintivo_vh`, `categoria_vh`, `estado_vh`, `cod_marca`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, matri);
            ps.setString(3,salida );
            ps.setString(4, dis);
            ps.setString(5, cat);
            ps.setString(6, estado);
            ps.setString(7, cod_mar);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo vehiculo Agregado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
         // con este boton se elimina un registro de la tabla
        String cod = (String) vehiculo.getValueAt(table_vh.getSelectedRow(),0) ;
        PreparedStatement ps;
        String query = "delete from vehiculo where Cod_vh=?";
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
            Logger.getLogger(frm_vehiculo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        

//      -------------------------------fin--------------------------------------
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void table_vhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_vhMouseClicked
         // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_vh.rowAtPoint(evt.getPoint()); 
        
        
          txt_Matricula.setText(table_vh.getValueAt(filaseleccionada,1).toString());
         txt_Año_salida.setText(table_vh.getValueAt(filaseleccionada,2).toString());
           txt_distintivo.setText(table_vh.getValueAt(filaseleccionada,3).toString()); 
           txt_Categoria.setText(table_vh.getValueAt(filaseleccionada,4).toString()); 
             Cbox_estado_vh.setSelectedItem(table_vh.getValueAt(filaseleccionada,5)); 
             txt_cod_marca.setText(table_vh.getValueAt(filaseleccionada,6).toString()); 
             
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_vhMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
       //  llamando a la funcion filtrar datos
        filtrardatos(txt_buscar.getText());
//        ------------fin----------------------
    }//GEN-LAST:event_txt_buscarKeyReleased

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
            java.util.logging.Logger.getLogger(frm_vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_vehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_vehiculo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbox_estado_vh;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_print1;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_imgfondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_Año_salida;
    private javax.swing.JLabel label_Categoria;
    private javax.swing.JLabel label_Cod_vehiculo;
    private javax.swing.JLabel label_Estado;
    private javax.swing.JLabel label_Matricula;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_listadeasociados;
    private javax.swing.JLabel label_rentcar1;
    private javax.swing.JLabel label_telefono2;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_vh;
    private javax.swing.JTextField txt_Año_salida;
    private javax.swing.JTextField txt_Categoria;
    private javax.swing.JTextField txt_Matricula;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod_marca;
    private javax.swing.JTextField txt_cod_vh;
    private javax.swing.JTextField txt_distintivo;
    // End of variables declaration//GEN-END:variables
}
