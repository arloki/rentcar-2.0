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
public class frm_pago_renta extends javax.swing.JFrame {
//    declarando la jtable con el nombre de la tabla
    DefaultTableModel pago;
//--------------------fin---------------------
    
    
    public frm_pago_renta() {
        initComponents();
        
//        para que se vea la tabla
        this.pago =(DefaultTableModel) table_pago.getModel();
        //------------------fin------------------------------
        
        // llamando a la funcion de mostrardatos
        mostrardatos("");
        //----------------------fin-----------------------
        
    }
    
      //    funcion para filtrar datos por el num de pago
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        pago.addColumn("num_pagorent");
        pago.addColumn("tipo_pago");
        pago.addColumn("forma_de_pago");
        pago.addColumn("moneda_pag");
        pago.addColumn("monto_a_pagar");
        pago.addColumn("cod_cli");
       
        
        
        this.table_pago.setModel(pago); 
        String sql;
        if(valor.equals("")){
            sql ="select * from pago_rent"; 
        } else {
            sql = "select * from pago_rent where num_pagorent like  '%"+valor+"%'"; 
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
               
                
                pago.addRow(datos);
            }
            table_pago.setModel(pago);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_pago_renta.class.getName()).log(Level.SEVERE,null,ex);
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
        pago.addColumn("num_pagorent");
        pago.addColumn("tipo_pago");
        pago.addColumn("forma_de_pago");
        pago.addColumn("moneda_pag");
        pago.addColumn("monto_a_pagar");
        pago.addColumn("cod_cli");
       
        
        
        this.table_pago.setModel(pago); 
        String sql;
        if(valor.equals("")){
            sql ="select * from pago_rent"; 
        } else {
            sql = "select * from pago_rent where num_pagorent= '"+valor+"' "; 
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
               
                
                pago.addRow(datos);
            }
            table_pago.setModel(pago);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_pago_renta.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            pago.setColumnCount(0);
            pago.setRowCount(0);
            table_pago.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
    
     public boolean RevisarPago(String pago){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `pago_rent` WHERE `num_pagorent` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, pago);
            
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
          txt_Num_pago.setText("");
           txt_tipo_pago.setText("");
         txt_forma_de_pago.setText("");
         txt_moneda_pag.setText("");
        txt_monto_a_pagar.setText("");
         txt_cod_cliente.setText("");
 
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
        label_rentcar1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_listadefactura = new javax.swing.JLabel();
        label_Num_pago = new javax.swing.JLabel();
        txt_Num_pago = new javax.swing.JTextField();
        label_tipo_pago = new javax.swing.JLabel();
        txt_tipo_pago = new javax.swing.JTextField();
        label_moneda_pag = new javax.swing.JLabel();
        txt_moneda_pag = new javax.swing.JTextField();
        label_forma_de_pago = new javax.swing.JLabel();
        txt_forma_de_pago = new javax.swing.JTextField();
        label_monto_a_pagar = new javax.swing.JLabel();
        txt_monto_a_pagar = new javax.swing.JTextField();
        label_cod_cliente = new javax.swing.JLabel();
        txt_cod_cliente = new javax.swing.JTextField();
        btn_print2 = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_guardar1 = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pago = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        lbl_buscar = new javax.swing.JLabel();
        jLabel_imgfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_rentcar1.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar1.setText("Rent a Car U&S");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        label_listadefactura.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listadefactura.setForeground(new java.awt.Color(0, 102, 102));
        label_listadefactura.setText("Registro de pagos");

        label_Num_pago.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Num_pago.setText("Num_pago:");

        txt_Num_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Num_pagoActionPerformed(evt);
            }
        });

        label_tipo_pago.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_tipo_pago.setText("Tipo_pago:");

        txt_tipo_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tipo_pagoActionPerformed(evt);
            }
        });

        label_moneda_pag.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_moneda_pag.setText("Moneda_pago:");

        txt_moneda_pag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_moneda_pagActionPerformed(evt);
            }
        });

        label_forma_de_pago.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_forma_de_pago.setText("Forma_de_pago:");

        txt_forma_de_pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_forma_de_pagoActionPerformed(evt);
            }
        });

        label_monto_a_pagar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_monto_a_pagar.setText("Monto_a_pagar:");

        txt_monto_a_pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_monto_a_pagarActionPerformed(evt);
            }
        });

        label_cod_cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_cliente.setText("Cod_cliente:");

        txt_cod_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_clienteActionPerformed(evt);
            }
        });

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        table_pago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_pago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_pagoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_pago);

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

        lbl_buscar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_buscar.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_cod_cliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_Num_pago)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_Num_pago))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_tipo_pago)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_tipo_pago))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_forma_de_pago)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_forma_de_pago))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_moneda_pag)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_moneda_pag))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_monto_a_pagar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_monto_a_pagar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                            .addComponent(label_listadefactura, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_print2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label_rentcar1))
                                .addGap(18, 18, 18)
                                .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_rentcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_listadefactura)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Num_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Num_pago))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_tipo_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_tipo_pago, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_forma_de_pago)
                            .addComponent(txt_forma_de_pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_moneda_pag)
                            .addComponent(txt_moneda_pag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_monto_a_pagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_monto_a_pagar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_cliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_delete1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_guardar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_edit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_print2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_buscar)
                                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 910, 440));

        jLabel_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(jLabel_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Num_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Num_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Num_pagoActionPerformed

    private void txt_tipo_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tipo_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tipo_pagoActionPerformed

    private void txt_moneda_pagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_moneda_pagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_moneda_pagActionPerformed

    private void txt_forma_de_pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_forma_de_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_forma_de_pagoActionPerformed

    private void txt_monto_a_pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_monto_a_pagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_monto_a_pagarActionPerformed

    private void txt_cod_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_clienteActionPerformed

    private void btn_print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print2ActionPerformed
              // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_pago_renta.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("pago renta ", "Reporte pago renta");

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
      String num = txt_Num_pago.getText();
        String tipo = txt_tipo_pago.getText();
        String forma = txt_forma_de_pago.getText();
        String mone = txt_moneda_pag.getText();  //el año de salida se llena empezando por el año 
        String monto = txt_monto_a_pagar.getText();
        String cod_cli = txt_cod_cliente.getText();
     

                
        if(num.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el numero de pago");
        }
        
        else if(monto.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el monto del pago");
        }      
        else if(RevisarPago(num))
        {
            JOptionPane.showMessageDialog(null, "Este pago ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `pago_rent`(`num_pagorent`,`tipo_pago`, `forma_de_pago`, `moneda_pag`, `monto_a_pagar`, `cod_cli`) VALUES (?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, num);
            ps.setString(2, tipo);
            ps.setString(3,forma );
            ps.setString(4, mone);
            ps.setString(5, monto);
            ps.setString(6, cod_cli);
            
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo pago realizado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_pago_renta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
         // con este boton se elimina un registro de la tabla
        String cod = (String) pago.getValueAt(table_pago.getSelectedRow(),0) ;
        PreparedStatement ps;
        String query = "delete from pago_rent where num_pagorent=?";
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
            Logger.getLogger(frm_pago_renta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        

//      -------------------------------fin--------------------------------------
    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void table_pagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_pagoMouseClicked
         // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_pago.rowAtPoint(evt.getPoint()); 
        
        
          txt_tipo_pago.setText(table_pago.getValueAt(filaseleccionada,1).toString());
         txt_forma_de_pago.setText(table_pago.getValueAt(filaseleccionada,2).toString());
            txt_moneda_pag.setText(table_pago.getValueAt(filaseleccionada,3).toString()); 
           txt_monto_a_pagar.setText(table_pago.getValueAt(filaseleccionada,4).toString()); 
             txt_cod_cliente.setText(table_pago.getValueAt(filaseleccionada,5).toString()); 
      
             
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_pagoMouseClicked

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
            java.util.logging.Logger.getLogger(frm_pago_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pago_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pago_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pago_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_pago_renta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_print2;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_imgfondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Num_pago;
    private javax.swing.JLabel label_cod_cliente;
    private javax.swing.JLabel label_forma_de_pago;
    private javax.swing.JLabel label_listadefactura;
    private javax.swing.JLabel label_moneda_pag;
    private javax.swing.JLabel label_monto_a_pagar;
    private javax.swing.JLabel label_rentcar1;
    private javax.swing.JLabel label_tipo_pago;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_pago;
    private javax.swing.JTextField txt_Num_pago;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod_cliente;
    private javax.swing.JTextField txt_forma_de_pago;
    private javax.swing.JTextField txt_moneda_pag;
    private javax.swing.JTextField txt_monto_a_pagar;
    private javax.swing.JTextField txt_tipo_pago;
    // End of variables declaration//GEN-END:variables
}
