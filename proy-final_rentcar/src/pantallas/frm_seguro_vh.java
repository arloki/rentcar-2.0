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
public class frm_seguro_vh extends javax.swing.JFrame {
// declarado la jtable con el nombre de la tabla
    DefaultTableModel seguro;
//    ----------------------fin----------
    
    public frm_seguro_vh() {
        initComponents();
        
//        para que se vea la tabla 
             this.seguro =(DefaultTableModel) table_seg.getModel();
//             --------------------fin-----------------

//funcion para mostrardatos de la tabla    
        mostrardatos("");
//    - - - - fin-----------------------------------
    }
    
      //    funcion para filtrar datos por el codigo de seguro
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        seguro.addColumn("cod_seg");
        seguro.addColumn("fecha_emision_seg");
        seguro.addColumn("fecha_renovacion_seg");
        seguro.addColumn(" poliza_seg");
        seguro.addColumn("estado_seg");
        seguro.addColumn("cod_comp");
        seguro.addColumn("cod_tipo_seg");
        
        this.table_seg.setModel(seguro); 
        String sql;
        if(valor.equals("")){
            sql ="select * from seguro_vh"; 
        } else {
            sql = "select * from seguro_vh where cod_seg  like  '%"+valor+"%' "; 
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
                
                seguro.addRow(datos);
            }
            table_seg.setModel(seguro);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_seguro_vh.class.getName()).log(Level.SEVERE,null,ex);
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
        seguro.addColumn("cod_seg");
        seguro.addColumn("fecha_emision_seg");
        seguro.addColumn("fecha_renovacion_seg");
        seguro.addColumn(" poliza_seg");
        seguro.addColumn("estado_seg");
        seguro.addColumn("cod_comp");
        seguro.addColumn("cod_tipo_seg");
        
        this.table_seg.setModel(seguro); 
        String sql;
        if(valor.equals("")){
            sql ="select * from seguro_vh"; 
        } else {
            sql = "select * from seguro_vh where cod_seg= '"+valor+"' "; 
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
                
                seguro.addRow(datos);
            }
            table_seg.setModel(seguro);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_seguro_vh.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            seguro.setColumnCount(0);
            seguro.setRowCount(0);
            table_seg.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
     public boolean RevisarSeguro(String seguro){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `seguro_vh` WHERE `cod_seg` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, seguro);
            
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
           txt_cod_seguro.setText("");
           txt_Fecha_emision.setText("");
          txt_Fecha_renovacion.setText("");
         txt_poliza.setText("");
       txt_cod_compania.setText("");
         txt_cod_tiposeguro.setText("");
        cbox_estado.setSelectedIndex(0); 
 
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
        label_listadeseguro = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_rentcar1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label_cod_seguro = new javax.swing.JLabel();
        txt_cod_seguro = new javax.swing.JTextField();
        label_Fecha_emision = new javax.swing.JLabel();
        txt_Fecha_emision = new javax.swing.JTextField();
        label_Fecha_renovacion = new javax.swing.JLabel();
        txt_Fecha_renovacion = new javax.swing.JTextField();
        label_poliza = new javax.swing.JLabel();
        txt_poliza = new javax.swing.JTextField();
        label_estado_seguro = new javax.swing.JLabel();
        label_cod_compania = new javax.swing.JLabel();
        txt_cod_compania = new javax.swing.JTextField();
        label_cod_tiposeguro = new javax.swing.JLabel();
        txt_cod_tiposeguro = new javax.swing.JTextField();
        cbox_estado = new javax.swing.JComboBox<>();
        btn_print2 = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_guardar1 = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_seg = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel_imgfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_listadeseguro.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listadeseguro.setForeground(new java.awt.Color(0, 102, 102));
        label_listadeseguro.setText("Lista de seguros");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        label_rentcar1.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar1.setText("Rent a Car U&S");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        label_cod_seguro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_seguro.setText("Cod_seg:");

        txt_cod_seguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_seguroActionPerformed(evt);
            }
        });

        label_Fecha_emision.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Fecha_emision.setText("Fecha_emision:");

        txt_Fecha_emision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Fecha_emisionActionPerformed(evt);
            }
        });

        label_Fecha_renovacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Fecha_renovacion.setText("Fecha_renovacion:");

        txt_Fecha_renovacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Fecha_renovacionActionPerformed(evt);
            }
        });

        label_poliza.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_poliza.setText("Poliza:");

        txt_poliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_polizaActionPerformed(evt);
            }
        });

        label_estado_seguro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_estado_seguro.setText("Estado:");

        label_cod_compania.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_compania.setText("Cod_compañia:");

        txt_cod_compania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_companiaActionPerformed(evt);
            }
        });

        label_cod_tiposeguro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_tiposeguro.setText("Cod_tipo_seg:");

        txt_cod_tiposeguro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_tiposeguroActionPerformed(evt);
            }
        });

        cbox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "activo ", "inactivo" }));

        btn_print2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print2ActionPerformed(evt);
            }
        });

        btn_edit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-50.png"))); // NOI18N

        btn_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N
        btn_guardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar1ActionPerformed(evt);
            }
        });

        btn_delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-50.png"))); // NOI18N
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });

        btn_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_salida.png"))); // NOI18N

        table_seg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_seg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_segMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_seg);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_rentcar1))
                        .addGap(28, 28, 28)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(label_listadeseguro)
                        .addGap(138, 138, 138)
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_print2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label_poliza, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_estado_seguro, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_poliza)
                                            .addComponent(cbox_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_Fecha_emision)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Fecha_emision))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_cod_seguro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_cod_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_Fecha_renovacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_Fecha_renovacion))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_cod_compania)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_cod_compania, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_cod_tiposeguro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_cod_tiposeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_rentcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label_listadeseguro)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_buscar)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_seguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_seguro))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Fecha_emision)
                            .addComponent(txt_Fecha_emision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Fecha_renovacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Fecha_renovacion))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_poliza)
                            .addComponent(txt_poliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_estado_seguro)
                            .addComponent(cbox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_cod_compania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_compania, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_tiposeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_tiposeguro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_delete1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_print2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 25, 920, 460));

        jLabel_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(jLabel_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 510));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cod_seguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_seguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_seguroActionPerformed

    private void txt_Fecha_emisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Fecha_emisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Fecha_emisionActionPerformed

    private void txt_Fecha_renovacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Fecha_renovacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Fecha_renovacionActionPerformed

    private void txt_polizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_polizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_polizaActionPerformed

    private void txt_cod_companiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_companiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_companiaActionPerformed

    private void txt_cod_tiposeguroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_tiposeguroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_tiposeguroActionPerformed

    private void btn_print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print2ActionPerformed
         // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_seguro_vh.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("seguro vehiculo ", "Reporte seguro cliente");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_print2ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        //  llamando a la funcion filtrar datos
        filtrardatos(txt_buscar.getText());
        //        ------------fin----------------------
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
       // con este boton cada vez que se llena el formulario  se llena en la base de datos 
        String cod = txt_cod_seguro.getText();
        String emi = txt_Fecha_emision.getText(); // se llena empezando por el año 
        String reno = txt_Fecha_renovacion.getText(); //  se llena empezando por el año 
        String poli = txt_poliza.getText();  
        String comp = txt_cod_compania.getText();
        String tipo=  txt_cod_tiposeguro.getText();
        String estado= String.valueOf(cbox_estado.getSelectedIndex());

                
        if(cod.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el codigo del seguro");
        }
        
        else if(comp.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el codigo de la compañia");
        }      
        else if(RevisarSeguro(cod))
        {
            JOptionPane.showMessageDialog(null, "Este seguro ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `seguro_vh`(`cod_seg`,`fecha_emision_seg`, `fecha_renovacion_seg`, `poliza_seg`, `estado_seg`, `cod_comp`, `cod_tipo_seg`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, emi);
            ps.setString(3,reno );
            ps.setString(4, poli);
            ps.setString(5, poli);
            ps.setString(6, estado);
            ps.setString(7, tipo);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo seguro Agregado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_seguro_vh.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
       // con este boton se elimina un registro de la tabla
        String cod = (String) seguro.getValueAt(table_seg.getSelectedRow(),0) ;
        PreparedStatement ps;
        String query = "delete from seguro_vh where cod_seg=?";
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
            Logger.getLogger(frm_seguro_vh.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        

//      -------------------------------fin--------------------------------------

    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void table_segMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_segMouseClicked
         // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_seg.rowAtPoint(evt.getPoint()); 
    
          txt_Fecha_emision.setText(table_seg.getValueAt(filaseleccionada,1).toString());
        txt_Fecha_renovacion.setText(table_seg.getValueAt(filaseleccionada,2).toString());
           txt_poliza.setText(table_seg.getValueAt(filaseleccionada,3).toString()); 
           txt_cod_compania.setText(table_seg.getValueAt(filaseleccionada,5).toString()); 
             cbox_estado.setSelectedItem(table_seg.getValueAt(filaseleccionada,4)); 
            txt_cod_tiposeguro.setText(table_seg.getValueAt(filaseleccionada,6).toString()); 
             
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_segMouseClicked

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
            java.util.logging.Logger.getLogger(frm_seguro_vh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_seguro_vh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_seguro_vh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_seguro_vh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_seguro_vh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_print2;
    private javax.swing.JButton btn_salida;
    private javax.swing.JComboBox<String> cbox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_imgfondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Fecha_emision;
    private javax.swing.JLabel label_Fecha_renovacion;
    private javax.swing.JLabel label_cod_compania;
    private javax.swing.JLabel label_cod_seguro;
    private javax.swing.JLabel label_cod_tiposeguro;
    private javax.swing.JLabel label_estado_seguro;
    private javax.swing.JLabel label_listadeseguro;
    private javax.swing.JLabel label_poliza;
    private javax.swing.JLabel label_rentcar1;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_seg;
    private javax.swing.JTextField txt_Fecha_emision;
    private javax.swing.JTextField txt_Fecha_renovacion;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod_compania;
    private javax.swing.JTextField txt_cod_seguro;
    private javax.swing.JTextField txt_cod_tiposeguro;
    private javax.swing.JTextField txt_poliza;
    // End of variables declaration//GEN-END:variables
}
