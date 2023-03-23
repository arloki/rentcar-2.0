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
public class frm_renta extends javax.swing.JFrame {
//declarar la jtable con el nombre de la tabla 
    DefaultTableModel renta;
//    --------------------fin-----------------------
   
    public frm_renta() {
        initComponents();
        
//        para que se vea la tabla
        this.renta =(DefaultTableModel) table_renta.getModel();
//        -------------------fin------------------ 


//             llamando la funcion de mostrardatos
              mostrardatos("");
//----------------------------fin--------------------------
    }
    
    //    funcion para filtrar datos por el codigo de renta
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        renta.addColumn("cod_renta");
        renta.addColumn("dias_solicitados_rent");
        renta.addColumn("fecha_y_hora_entrega_rent");
        renta.addColumn("fecha_devolucion_rent");
        renta.addColumn("precio_dia_rent");
        renta.addColumn("maximo_dias_rent");
        renta.addColumn("minimo_dias_rent");
        renta.addColumn("cantidad_conductores_rent");
        renta.addColumn("estado_rent");
        renta.addColumn("Cod_vh");
        renta.addColumn("precio_total_rent");
    
        
        this.table_renta.setModel(renta); 
        String sql;
        if(valor.equals("")){
            sql ="select * from renta"; 
        } else {
            sql = "select * from renta where cod_rent like  '%"+valor+"%' "; 
        }
        String [ ] datos = new String[ 11];
        
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
                datos[ 7 ]=rs.getString(8); 
                datos[ 8 ]=rs.getString(9); 
                datos[ 9 ]=rs.getString(10); 
                datos[ 10 ]=rs.getString(11); 
                
                renta.addRow(datos);
            }
            table_renta.setModel(renta);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_renta.class.getName()).log(Level.SEVERE,null,ex);
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
        renta.addColumn("cod_renta");
        renta.addColumn("dias_solicitados_rent");
        renta.addColumn("fecha_y_hora_entrega_rent");
        renta.addColumn("fecha_devolucion_rent");
        renta.addColumn("precio_dia_rent");
        renta.addColumn("maximo_dias_rent");
        renta.addColumn("minimo_dias_rent");
        renta.addColumn("cantidad_conductores_rent");
        renta.addColumn("estado_rent");
        renta.addColumn("Cod_vh");
        renta.addColumn("precio_total_rent");
    
        
        this.table_renta.setModel(renta); 
        String sql;
        if(valor.equals("")){
            sql ="select * from renta"; 
        } else {
            sql = "select * from renta where cod_rent= '"+valor+"' "; 
        }
        String [ ] datos = new String[ 11];
        
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
                datos[ 7 ]=rs.getString(8); 
                datos[ 8 ]=rs.getString(9); 
                datos[ 9 ]=rs.getString(10); 
                datos[ 10 ]=rs.getString(11); 
                
                renta.addRow(datos);
            }
            table_renta.setModel(renta);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_renta.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            renta.setColumnCount(0);
            renta.setRowCount(0);
            table_renta.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
     public boolean RevisarRenta(String renta){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `renta` WHERE `cod_rent` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, renta);
            
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
            txt_Cod_renta.setText("");
            txt_Dias_solic_rent.setText("");
          txt_Fecha_y_hora_entrega.setText("");
        txt_Fecha_devolucion.setText("");
        txt_precio_dia.setText("");
        txt_Maximo_dias.setText("");
        txt_Minimo_dias.setText("");
        txt_cod_vehiculo.setText("");
        txt_precio_total.setText("");
        Cbox_Cantidad_conductores.setSelectedIndex(0); 
        Cbox_estado_renta.setSelectedIndex(0); 
 
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
        label_Cod_renta = new javax.swing.JLabel();
        txt_Cod_renta = new javax.swing.JTextField();
        label_Dias_solic_rent = new javax.swing.JLabel();
        txt_Dias_solic_rent = new javax.swing.JTextField();
        label_Fecha_y_hora_entrega = new javax.swing.JLabel();
        txt_Fecha_y_hora_entrega = new javax.swing.JTextField();
        label_Fecha_devolucion = new javax.swing.JLabel();
        txt_Fecha_devolucion = new javax.swing.JTextField();
        label_Maximo_dias = new javax.swing.JLabel();
        txt_Maximo_dias = new javax.swing.JTextField();
        label_Minimo_dias = new javax.swing.JLabel();
        txt_Minimo_dias = new javax.swing.JTextField();
        label_Cantidad_conductores = new javax.swing.JLabel();
        label_precio_total = new javax.swing.JLabel();
        txt_precio_total = new javax.swing.JTextField();
        label_cod_vehiculo = new javax.swing.JLabel();
        txt_cod_vehiculo = new javax.swing.JTextField();
        label_Estado_renta = new javax.swing.JLabel();
        label_listaderentas = new javax.swing.JLabel();
        label_precio_dia = new javax.swing.JLabel();
        txt_precio_dia = new javax.swing.JTextField();
        Cbox_Cantidad_conductores = new javax.swing.JComboBox<>();
        Cbox_estado_renta = new javax.swing.JComboBox<>();
        btn_salida = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        label_rentcar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_renta = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        label_imgfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_Cod_renta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_renta.setText("Cod_renta:");

        txt_Cod_renta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_rentaActionPerformed(evt);
            }
        });

        label_Dias_solic_rent.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Dias_solic_rent.setText(" Dias_solic_rent:");

        txt_Dias_solic_rent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Dias_solic_rentActionPerformed(evt);
            }
        });

        label_Fecha_y_hora_entrega.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Fecha_y_hora_entrega.setText("Fecha y hora entrega:");

        txt_Fecha_y_hora_entrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Fecha_y_hora_entregaActionPerformed(evt);
            }
        });

        label_Fecha_devolucion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Fecha_devolucion.setText(" Fecha devolucion:");

        txt_Fecha_devolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Fecha_devolucionActionPerformed(evt);
            }
        });

        label_Maximo_dias.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Maximo_dias.setText("Maximo dias:");

        txt_Maximo_dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Maximo_diasActionPerformed(evt);
            }
        });

        label_Minimo_dias.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Minimo_dias.setText("Minimo dias:");

        txt_Minimo_dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Minimo_diasActionPerformed(evt);
            }
        });

        label_Cantidad_conductores.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cantidad_conductores.setText("Cant_conductores:");

        label_precio_total.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_precio_total.setText(" precio total:");

        txt_precio_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precio_totalActionPerformed(evt);
            }
        });

        label_cod_vehiculo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_vehiculo.setText(" Cod_vehiculo:");

        txt_cod_vehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_vehiculoActionPerformed(evt);
            }
        });

        label_Estado_renta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Estado_renta.setText("Estado_renta:");

        label_listaderentas.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listaderentas.setForeground(new java.awt.Color(0, 102, 102));
        label_listaderentas.setText("Regristo de rentas");

        label_precio_dia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_precio_dia.setText("Precio dia:");

        txt_precio_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_precio_diaActionPerformed(evt);
            }
        });

        Cbox_Cantidad_conductores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elegir", "1", "2" }));

        Cbox_estado_renta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elegir", "activo", "inactivo" }));

        btn_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_salida.png"))); // NOI18N

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-editar-50.png"))); // NOI18N

        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-50.png"))); // NOI18N
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        label_rentcar.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar.setText("Rent a Car U&S");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setAlignmentX(1.0F);
        jSeparator1.setAlignmentY(1.0F);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        table_renta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_renta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_rentaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_renta);

        lbl_buscar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_buscar.setText("Buscar:");

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
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_rentcar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(label_listaderentas))
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_Dias_solic_rent)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_Dias_solic_rent))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(label_Cod_renta)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_Cod_renta, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(label_Fecha_y_hora_entrega)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Fecha_y_hora_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_Fecha_devolucion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Fecha_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_precio_dia)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt_precio_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_Maximo_dias)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_Maximo_dias, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_Estado_renta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cbox_estado_renta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_Minimo_dias)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_Minimo_dias))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_Cantidad_conductores)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Cbox_Cantidad_conductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_cod_vehiculo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_cod_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_precio_total)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_precio_total, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbl_buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_rentcar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_listaderentas)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_Cod_renta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_Cod_renta))
                                    .addGap(39, 39, 39)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(label_Fecha_y_hora_entrega)
                                        .addComponent(txt_Fecha_y_hora_entrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_Dias_solic_rent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_Dias_solic_rent))
                                    .addGap(33, 33, 33)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_Fecha_devolucion)
                                    .addComponent(txt_Fecha_devolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_precio_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_precio_dia)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_Maximo_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_Maximo_dias)))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_Minimo_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_Minimo_dias))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label_cod_vehiculo)
                                            .addComponent(txt_cod_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(label_Cantidad_conductores)
                                                .addComponent(Cbox_Cantidad_conductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(label_Estado_renta)
                                                .addComponent(Cbox_estado_renta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(33, 33, 33)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_precio_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_precio_total))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_print, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_edit, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_delete)
                                .addComponent(btn_guardar))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_buscar)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1150, 440));

        label_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        label_imgfondo.setPreferredSize(new java.awt.Dimension(1500, 801));
        getContentPane().add(label_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Cod_rentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_rentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cod_rentaActionPerformed

    private void txt_Dias_solic_rentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Dias_solic_rentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Dias_solic_rentActionPerformed

    private void txt_Fecha_y_hora_entregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Fecha_y_hora_entregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Fecha_y_hora_entregaActionPerformed

    private void txt_Fecha_devolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Fecha_devolucionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Fecha_devolucionActionPerformed

    private void txt_Maximo_diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Maximo_diasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Maximo_diasActionPerformed

    private void txt_Minimo_diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Minimo_diasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Minimo_diasActionPerformed

    private void txt_precio_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precio_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precio_totalActionPerformed

    private void txt_cod_vehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_vehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_vehiculoActionPerformed

    private void txt_precio_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_precio_diaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_precio_diaActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
            // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_renta.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("renta ", "Reporte renta");

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
      String cod = txt_Cod_renta.getText();
        String soli =  txt_Dias_solic_rent.getText();
        String fecha_hora = txt_Fecha_y_hora_entrega.getText();
        String fecha= txt_Fecha_devolucion.getText();
        String precio = txt_precio_dia.getText();
        String max=txt_Maximo_dias.getText();
        String min =txt_Minimo_dias.getText();
        String cod_vh =txt_cod_vehiculo.getText();
        String total =txt_precio_total.getText(); 
        String cant = String.valueOf(Cbox_Cantidad_conductores.getSelectedIndex());
        String estado = String.valueOf(Cbox_estado_renta.getSelectedIndex());

                
        if(cod.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un codigo a la renta");
        }
        
        else if(soli.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega una fecha de solicitud");
        }     
        else if(fecha_hora.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega la fecha de la entrega");
        }     
        else if(fecha.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega una fecha de devolucion");
        }     
        else if(max.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el maximo de dias de la renta"); 
        }     
        else if(min.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el codigo del vehiculo"); 
        }     
        else if(cod_vh.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el maximo de dias de la renta"); 
        }   
        else if(precio.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega el precio por dia"); 
        }     
        else if(RevisarRenta(cod))
        {
            JOptionPane.showMessageDialog(null, "Esta renta ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `renta`(`cod_rent`,`dias_solicitados_rent`, `fecha_y_hora_entrega_rent`, `fecha_devolucion_rent`, `precio_dia_rent`, `maximo_dias_rent`, `minimo_dias_rent`, `cantidad_conductores_rent`, `estado_rent`, `Cod_vh`, `precio_total_rent`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, soli);
            ps.setString(3, fecha_hora);
            ps.setString(4, fecha);
            ps.setString(5, precio);
            ps.setString(6, max);
            ps.setString(7, min);
            ps.setString(8, cant);
            ps.setString(9, estado);
            ps.setString(10, cod_vh);
            ps.setString(11, total);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nueva renta Agregada");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_renta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // con este boton se elimina un registro de la tabla
        String cod = (String) renta.getValueAt(table_renta.getSelectedRow(),0) ;
    

        PreparedStatement ps;
        String query = "delete from renta where cod_rent=?";
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
            Logger.getLogger(frm_renta.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        

//      -------------------------------fin--------------------------------------
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
       //  llamando a la funcion filtrar datos
        filtrardatos(txt_buscar.getText());
//        ------------fin----------------------
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void table_rentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_rentaMouseClicked
        // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_renta.rowAtPoint(evt.getPoint()); 
       
         txt_Dias_solic_rent.setText(table_renta.getValueAt(filaseleccionada,1).toString());
           txt_Fecha_y_hora_entrega.setText(table_renta.getValueAt(filaseleccionada,2).toString());
            txt_Fecha_devolucion.setText(table_renta.getValueAt(filaseleccionada,3).toString()); 
             txt_precio_dia.setText(table_renta.getValueAt(filaseleccionada,4).toString()); 
             txt_Maximo_dias.setText(table_renta.getValueAt(filaseleccionada,5).toString()); 
               txt_Minimo_dias.setText(table_renta.getValueAt(filaseleccionada,6).toString()); 
            Cbox_Cantidad_conductores.setSelectedItem(table_renta.getValueAt(filaseleccionada,7)); 
               Cbox_estado_renta.setSelectedItem(table_renta.getValueAt(filaseleccionada,8)); 
           txt_cod_vehiculo.setText(table_renta.getValueAt(filaseleccionada,9).toString()); 
             txt_precio_total.setText(table_renta.getValueAt(filaseleccionada,10).toString()); 
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_rentaMouseClicked

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
            java.util.logging.Logger.getLogger(frm_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_renta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_renta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbox_Cantidad_conductores;
    private javax.swing.JComboBox<String> Cbox_estado_renta;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Cantidad_conductores;
    private javax.swing.JLabel label_Cod_renta;
    private javax.swing.JLabel label_Dias_solic_rent;
    private javax.swing.JLabel label_Estado_renta;
    private javax.swing.JLabel label_Fecha_devolucion;
    private javax.swing.JLabel label_Fecha_y_hora_entrega;
    private javax.swing.JLabel label_Maximo_dias;
    private javax.swing.JLabel label_Minimo_dias;
    private javax.swing.JLabel label_cod_vehiculo;
    private javax.swing.JLabel label_imgfondo;
    private javax.swing.JLabel label_listaderentas;
    private javax.swing.JLabel label_precio_dia;
    private javax.swing.JLabel label_precio_total;
    private javax.swing.JLabel label_rentcar;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_renta;
    private javax.swing.JTextField txt_Cod_renta;
    private javax.swing.JTextField txt_Dias_solic_rent;
    private javax.swing.JTextField txt_Fecha_devolucion;
    private javax.swing.JTextField txt_Fecha_y_hora_entrega;
    private javax.swing.JTextField txt_Maximo_dias;
    private javax.swing.JTextField txt_Minimo_dias;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cod_vehiculo;
    private javax.swing.JTextField txt_precio_dia;
    private javax.swing.JTextField txt_precio_total;
    // End of variables declaration//GEN-END:variables
}
