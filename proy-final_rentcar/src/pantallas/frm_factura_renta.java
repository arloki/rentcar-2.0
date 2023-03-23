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
public class frm_factura_renta extends javax.swing.JFrame {
// declarado la jtable con el nombre de la tabla
    DefaultTableModel factura;
//    ----------------------fin----------
   
    public frm_factura_renta() {
        initComponents();
        
        //        para que se vea la tabla 
             this.factura =(DefaultTableModel) table_factura.getModel();
//             --------------------fin-----------------

//funcion para mostrardatos de la tabla    
        mostrardatos("");
//    - - - - fin-----------------------------------
    }
    
     //    funcion para filtrar datos por el num de fac
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
      factura.addColumn("num_fact");
      factura.addColumn("fecha_hora_fact");
      factura.addColumn("tipo_fact");
      factura.addColumn("rnc_fact"); 
      factura.addColumn("ncf_fact");
      factura.addColumn(" cod_rent");
      factura.addColumn("cod_cli");
          
        
        this.table_factura.setModel(factura); 
        String sql;
        if(valor.equals("")){
            sql ="select * from factura_rent"; 
        } else {
            sql = "select * from factura_rent where num_fact  like  '%"+valor+"%' "; 
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
                
                factura.addRow(datos);
            }
            table_factura.setModel(factura);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_factura_renta.class.getName()).log(Level.SEVERE,null,ex);
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
      factura.addColumn("num_fact");
      factura.addColumn("fecha_hora_fact");
      factura.addColumn("tipo_fact");
      factura.addColumn("rnc_fact"); 
      factura.addColumn("ncf_fact");
      factura.addColumn(" cod_rent");
      factura.addColumn("cod_cli");
          
        
        this.table_factura.setModel(factura); 
        String sql;
        if(valor.equals("")){
            sql ="select * from factura_rent"; 
        } else {
            sql = "select * from factura_rent where num_fact= '"+valor+"' "; 
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
                
                factura.addRow(datos);
            }
            table_factura.setModel(factura);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_factura_renta.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            factura.setColumnCount(0);
            factura.setRowCount(0);
            table_factura.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
public boolean RevisarFactura(String factura){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `factura_rent` WHERE `num_fact` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, factura);
            
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
           txt_Num_fact.setText("");
           txt_fecha_hora_factura.setText("");
          txt_tipo_factura.setText("");
         txt_rnc_factura.setText("");
       txt_ncf_factura.setText("");
        txt_cod_renta.setText("");
       txt_Cod_cliente.setText("");
 
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

        btn_print1 = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_rentcar1 = new javax.swing.JLabel();
        label_listadefactura = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_Num_fact = new javax.swing.JLabel();
        txt_Num_fact = new javax.swing.JTextField();
        label_fecha_hora_factura = new javax.swing.JLabel();
        txt_fecha_hora_factura = new javax.swing.JTextField();
        label_tipo_factura = new javax.swing.JLabel();
        txt_tipo_factura = new javax.swing.JTextField();
        label_rnc_factura = new javax.swing.JLabel();
        txt_rnc_factura = new javax.swing.JTextField();
        label_ncf_factura = new javax.swing.JLabel();
        txt_ncf_factura = new javax.swing.JTextField();
        label_cod_renta = new javax.swing.JLabel();
        txt_cod_renta = new javax.swing.JTextField();
        label_Cod_cliente = new javax.swing.JLabel();
        txt_Cod_cliente = new javax.swing.JTextField();
        btn_print2 = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_guardar1 = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_factura = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        lbl_buscar = new javax.swing.JLabel();
        jLabel_imgfondo = new javax.swing.JLabel();

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_rentcar1.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar1.setText("Rent a Car U&S");

        label_listadefactura.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listadefactura.setForeground(new java.awt.Color(0, 102, 102));
        label_listadefactura.setText("Lista de factura");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        label_Num_fact.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Num_fact.setText("Num fact:");

        txt_Num_fact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Num_factActionPerformed(evt);
            }
        });

        label_fecha_hora_factura.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_fecha_hora_factura.setText("Fecha y hora fact:");

        txt_fecha_hora_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fecha_hora_facturaActionPerformed(evt);
            }
        });

        label_tipo_factura.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_tipo_factura.setText("Tipo factura:");

        txt_tipo_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tipo_facturaActionPerformed(evt);
            }
        });

        label_rnc_factura.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_rnc_factura.setText("rnc factura:");

        txt_rnc_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rnc_facturaActionPerformed(evt);
            }
        });

        label_ncf_factura.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_ncf_factura.setText("ncf factura:");

        txt_ncf_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ncf_facturaActionPerformed(evt);
            }
        });

        label_cod_renta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_renta.setText("Cod renta:");

        txt_cod_renta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_rentaActionPerformed(evt);
            }
        });

        label_Cod_cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_cliente.setText("Cod cliente:");

        txt_Cod_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_clienteActionPerformed(evt);
            }
        });

        btn_print2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print2ActionPerformed(evt);
            }
        });

        btn_edit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-50.png"))); // NOI18N
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });

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

        table_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_facturaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_factura);

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
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_rentcar1)
                        .addGap(27, 27, 27)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_fecha_hora_factura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_fecha_hora_factura))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_tipo_factura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tipo_factura))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_cod_renta)
                                    .addComponent(label_Cod_cliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_cod_renta)
                                    .addComponent(txt_Cod_cliente)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_rnc_factura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_rnc_factura))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_ncf_factura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_ncf_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_listadefactura)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_Num_fact)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_Num_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_print2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_salida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_rentcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label_listadefactura)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Num_fact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Num_fact))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_fecha_hora_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_fecha_hora_factura, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_tipo_factura)
                            .addComponent(txt_tipo_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_rnc_factura)
                            .addComponent(txt_rnc_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ncf_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_ncf_factura))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_renta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_renta))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Cod_cliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_edit1)
                            .addComponent(btn_print2)
                            .addComponent(btn_guardar1)
                            .addComponent(btn_delete1))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_buscar)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 900, 480));

        jLabel_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(jLabel_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Num_factActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Num_factActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Num_factActionPerformed

    private void txt_fecha_hora_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fecha_hora_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fecha_hora_facturaActionPerformed

    private void txt_tipo_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tipo_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tipo_facturaActionPerformed

    private void txt_rnc_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rnc_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rnc_facturaActionPerformed

    private void txt_ncf_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ncf_facturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ncf_facturaActionPerformed

    private void txt_cod_rentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_rentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_rentaActionPerformed

    private void txt_Cod_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cod_clienteActionPerformed

    private void btn_print2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print2ActionPerformed
             // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_factura_renta.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("factura renta ", "Reporte factura renta");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_print2ActionPerformed

    private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit1ActionPerformed

    private void btn_guardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar1ActionPerformed
        // con este boton cada vez que se llena el formulario  se llena en la base de datos 
        String cod = txt_Num_fact.getText();
        String fecha = txt_fecha_hora_factura.getText();  // se llena desde el año 
        String tipo = txt_tipo_factura.getText();
        String rnc = txt_rnc_factura.getText();  
        String ncf = txt_ncf_factura.getText();
        String renta= txt_cod_renta.getText();
        String cod_cli= txt_Cod_cliente.getText();
       

                
        if(cod.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el numero de factura");
        }
        
        else if(rnc.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el RNC");
        }      
        else if(RevisarFactura(cod))
        {
            JOptionPane.showMessageDialog(null, "Esta factura ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `factura_rent`(`num_fact`,`fecha_hora_fact`, `tipo_fact`, `rnc_fact`, `ncf_fact`, `cod_rent`, `cod_cli`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, fecha);
            ps.setString(3,tipo );
            ps.setString(4, rnc);
            ps.setString(5, ncf);
            ps.setString(6, renta);
            ps.setString(7, cod_cli);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nueva factura Agregada");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_factura_renta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardar1ActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        //  llamando a la funcion filtrar datos
        filtrardatos(txt_buscar.getText());
        //        ------------fin----------------------
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        // con este boton se elimina un registro de la tabla
        String cod = (String) factura.getValueAt(table_factura.getSelectedRow(),0) ;
        PreparedStatement ps;
        String query = "delete from factura_rent where num_fact=?";
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
            Logger.getLogger(frm_factura_renta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
//      -------------------------------fin--------------------------------------
    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void table_facturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_facturaMouseClicked
           // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_factura.rowAtPoint(evt.getPoint()); 
    
         txt_fecha_hora_factura.setText(table_factura.getValueAt(filaseleccionada,1).toString());
        txt_tipo_factura.setText(table_factura.getValueAt(filaseleccionada,2).toString());
          txt_rnc_factura.setText(table_factura.getValueAt(filaseleccionada,3).toString()); 
           txt_ncf_factura.setText(table_factura.getValueAt(filaseleccionada,4).toString()); 
            txt_cod_renta.setText(table_factura.getValueAt(filaseleccionada,5).toString()); 
             txt_Cod_cliente.setText(table_factura.getValueAt(filaseleccionada,6).toString()); 
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_facturaMouseClicked

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
            java.util.logging.Logger.getLogger(frm_factura_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_factura_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_factura_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_factura_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_factura_renta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_print1;
    private javax.swing.JButton btn_print2;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_imgfondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Cod_cliente;
    private javax.swing.JLabel label_Num_fact;
    private javax.swing.JLabel label_cod_renta;
    private javax.swing.JLabel label_fecha_hora_factura;
    private javax.swing.JLabel label_listadefactura;
    private javax.swing.JLabel label_ncf_factura;
    private javax.swing.JLabel label_rentcar1;
    private javax.swing.JLabel label_rnc_factura;
    private javax.swing.JLabel label_tipo_factura;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_factura;
    private javax.swing.JTextField txt_Cod_cliente;
    private javax.swing.JTextField txt_Num_fact;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod_renta;
    private javax.swing.JTextField txt_fecha_hora_factura;
    private javax.swing.JTextField txt_ncf_factura;
    private javax.swing.JTextField txt_rnc_factura;
    private javax.swing.JTextField txt_tipo_factura;
    // End of variables declaration//GEN-END:variables
}
