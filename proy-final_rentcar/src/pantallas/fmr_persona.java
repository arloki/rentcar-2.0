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
public class fmr_persona extends javax.swing.JFrame {
    
     DefaultTableModel persona;
    /**
     * Creates new form fmr_persona
     */
    public fmr_persona() {
        initComponents();
        this.persona =( DefaultTableModel) table_persona.getModel();
        // llamando a la funcion mostrardatos 
        Mostrardatos("");
        // FIN
    }
    
      public final void Mostrardatos(String valor){
        MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        persona.addColumn("Cod_persona");
        persona.addColumn("Nombre");
        persona.addColumn("Telefono");
        persona.addColumn("Correo");
        persona.addColumn("Fecha_nacimiento");
        persona.addColumn("Direccion");
        persona.addColumn("Cod_pais");
        persona.addColumn("Cod_municipio");
        persona.addColumn("Cedula"); 
        persona.addColumn("Apellido");
        persona.addColumn("Celular");
        persona.addColumn("Sexo");
        persona.addColumn("Pasaporte");
        persona.addColumn("Cod_sector");
        persona.addColumn("Cod_provincia");
         
        this.table_persona.setModel(persona); 
        String sql;
        if(valor.equals("")){
            sql ="select * from persona"; 
        } else {
            sql = "select * from persona where cod_per like '"+valor+"' "; 
        }
        String [] datos = new String[16];
        
        try{
             Statement st= cn.createStatement();
       ResultSet rs= st.executeQuery(sql);
            
            while(rs.next() ){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2); 
                datos[2]=rs.getString(3); 
                datos[3]=rs.getString(4); 
                datos[4]=rs.getString(5); 
                datos[5]=rs.getString(6); 
                datos[6]=rs.getString(7); 
                datos[7]=rs.getString(8); 
                datos[8]=rs.getString(9); 
                datos[9]=rs.getString(10); 
                datos[10]=rs.getString(11); 
                datos[11]=rs.getString(12); 
                datos[12]=rs.getString(13); 
                datos[13]=rs.getString(14); 
                datos[14]=rs.getString(15); 
                datos[15]=rs.getString(16); 
               
                
                 
                      
                     
                
                persona.addRow(datos);
            }
            table_persona.setModel(persona);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_cliente.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
      
      }
      public boolean RevisarPersona(String Persona){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `persona` WHERE `cedula_per` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, Persona);
            
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
            txt_codpersona.setText("");
            txt_cedula.setText("");
          txt_tel.setText("");
        txt_nombre.setText("");
        txt_apellido.setText("");
         txt_celular.setText("");
        txt_correo.setText("");
        txt_direccion.setText("");
        txt_fechanac.setText("");
        txt_pasaporte.setText("");
        txt_correo.setText("");
        combobox_sexo.setSelectedIndex(0); 
 
        } catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
       
    } 
//        -----------------------fin------------------------------
    } 

         //    funcion para filtrar datos por el rnc 
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
       persona.addColumn("Cod_asociado");
       persona.addColumn("rnc_asoc");
       persona.addColumn("moneda_asoc");
       persona.addColumn("estado_asoc");
       persona.addColumn("cod_per");
       this.table_persona.setModel(persona); 
        String sql;
        if(valor.equals("")){
            sql ="select * from persona"; 
        } else {
            sql = "select * from persona where cod_per like  '%"+valor+"%' "; 
        }
        String [ ] datos = new String[16];
        
        try{
             Statement st= cn.createStatement();
       ResultSet rs= st.executeQuery(sql);
            
            while(rs.next() ){
                datos[0]=rs.getString(1); 
                datos[1]=rs.getString(2); 
                datos[2]=rs.getString(3); 
                datos[3]=rs.getString(4); 
                datos[4]=rs.getString(5); 
                datos[5]=rs.getString(6); 
                datos[6]=rs.getString(7); 
                datos[7]=rs.getString(8); 
                datos[8]=rs.getString(9); 
                datos[9]=rs.getString(10); 
                datos[10]=rs.getString(11); 
                datos[11]=rs.getString(12); 
                datos[12]=rs.getString(13); 
                datos[13]=rs.getString(14); 
                datos[14]=rs.getString(15); 
                datos[15]=rs.getString(16); 
                
                persona.addRow(datos);
            }
            table_persona.setModel(persona);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_asociado.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
       
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            persona.setColumnCount(0);
            persona.setRowCount(0);
            table_persona.revalidate();
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

        label_ususrio6 = new javax.swing.JLabel();
        txt_usuario5 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        label_nombre = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        label_apellido = new javax.swing.JLabel();
        txt_apellido = new javax.swing.JTextField();
        label_codpersona = new javax.swing.JLabel();
        txt_codpersona = new javax.swing.JTextField();
        label_cedula = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        label_sexo = new javax.swing.JLabel();
        combobox_sexo = new javax.swing.JComboBox<>();
        label_fecha_Nac = new javax.swing.JLabel();
        txt_fechanac = new javax.swing.JTextField();
        label_telefono = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        label_correo = new javax.swing.JLabel();
        txt_correo = new javax.swing.JTextField();
        label_pasaporte = new javax.swing.JLabel();
        txt_pasaporte = new javax.swing.JTextField();
        label_direccion = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        btn_salida = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        label_correo1 = new javax.swing.JLabel();
        txt_celular = new javax.swing.JTextField();
        label_direccion1 = new javax.swing.JLabel();
        txt_cod_sector = new javax.swing.JTextField();
        label_direccion2 = new javax.swing.JLabel();
        txt_Cod_municipio = new javax.swing.JTextField();
        label_Cod_provincia = new javax.swing.JLabel();
        txt_direccion3 = new javax.swing.JTextField();
        label_direccion4 = new javax.swing.JLabel();
        txt_direccion4 = new javax.swing.JTextField();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        label_rentcar = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_listadepersona = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_persona = new javax.swing.JTable();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();

        label_ususrio6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_ususrio6.setText("Fecha nacimiento:");

        txt_usuario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuario5ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_nombre.setText("Nombre:");

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });

        label_apellido.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_apellido.setText(" Apellido:");

        txt_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellidoActionPerformed(evt);
            }
        });

        label_codpersona.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_codpersona.setText("Cod_persona:");

        txt_codpersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codpersonaActionPerformed(evt);
            }
        });

        label_cedula.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cedula.setText("Cedula:");

        txt_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaActionPerformed(evt);
            }
        });

        label_sexo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_sexo.setText(" Sexo:");

        combobox_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "Femenino", "Masculino", " " }));

        label_fecha_Nac.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_fecha_Nac.setText("Fecha nacimiento:");

        txt_fechanac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechanacActionPerformed(evt);
            }
        });

        label_telefono.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_telefono.setText("Telefono:");

        txt_tel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telActionPerformed(evt);
            }
        });

        label_correo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_correo.setText("Correo:");

        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });

        label_pasaporte.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_pasaporte.setText(" Pasaporte:");

        txt_pasaporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pasaporteActionPerformed(evt);
            }
        });

        label_direccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_direccion.setText("Direccion:");

        txt_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccionActionPerformed(evt);
            }
        });

        btn_salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon_salida.png"))); // NOI18N

        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-imprimir-50.png"))); // NOI18N
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        label_correo1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_correo1.setText(" Celular:");

        txt_celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_celularActionPerformed(evt);
            }
        });

        label_direccion1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_direccion1.setText("Cod_sector:");

        txt_cod_sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_sectorActionPerformed(evt);
            }
        });

        label_direccion2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_direccion2.setText("Cod_municipio:");

        txt_Cod_municipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_municipioActionPerformed(evt);
            }
        });

        label_Cod_provincia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_provincia.setText("Cod_provincia:");

        txt_direccion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccion3ActionPerformed(evt);
            }
        });

        label_direccion4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_direccion4.setText("Cod_pais:");

        txt_direccion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_direccion4ActionPerformed(evt);
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

        label_listadepersona.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listadepersona.setForeground(new java.awt.Color(0, 102, 102));
        label_listadepersona.setText("Registro de personas");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        table_persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_persona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_personaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_persona);

        lbl_buscar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_buscar.setText("Buscar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(label_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label_correo1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(83, 83, 83)
                                    .addComponent(txt_Cod_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label_Cod_provincia)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_direccion3))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label_direccion4)
                                        .addComponent(label_direccion))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label_direccion1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_cod_sector))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_fecha_Nac, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_correo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_sexo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(combobox_sexo, 0, 151, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_pasaporte)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_pasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_nombre)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label_apellido))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_codpersona)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_codpersona, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label_cedula)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_apellido)
                                        .addComponent(txt_cedula, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label_rentcar)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(28, 28, 28)
                                            .addComponent(label_listadepersona)))
                                    .addGap(37, 37, 37)
                                    .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_direccion2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_direccion4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1393, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(lbl_buscar)
                        .addGap(18, 18, 18)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_rentcar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_buscar)
                    .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_listadepersona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_codpersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_codpersona)
                    .addComponent(label_cedula)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_nombre)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_apellido)
                        .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_telefono)
                    .addComponent(txt_celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_correo1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_correo)
                        .addComponent(label_sexo))
                    .addComponent(combobox_sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_fecha_Nac)
                    .addComponent(txt_pasaporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_pasaporte))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_direccion)
                    .addComponent(txt_cod_sector, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_direccion1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Cod_municipio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_direccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_Cod_provincia)
                    .addComponent(label_direccion4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_direccion4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_direccion2))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_print, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 1860, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoActionPerformed

    private void txt_codpersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codpersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codpersonaActionPerformed

    private void txt_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaActionPerformed

    private void txt_fechanacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechanacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechanacActionPerformed

    private void txt_usuario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuario5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuario5ActionPerformed

    private void txt_telActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telActionPerformed

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

    private void txt_pasaporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pasaporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pasaporteActionPerformed

    private void txt_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionActionPerformed

    private void txt_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_celularActionPerformed

    private void txt_cod_sectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_sectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_sectorActionPerformed

    private void txt_Cod_municipioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_municipioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cod_municipioActionPerformed

    private void txt_direccion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccion3ActionPerformed

    private void txt_direccion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_direccion4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccion4ActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
         // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_persona.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("persona", "Reporte persona");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    
        
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here
        Mostrardatos("");
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void table_personaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_personaMouseClicked
        // TODO add your handling code here:
        // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_persona.rowAtPoint(evt.getPoint()); 
       
          
           txt_codpersona.setText(table_persona.getValueAt(filaseleccionada,1).toString());
            txt_cedula.setText(table_persona.getValueAt(filaseleccionada,2).toString());
          txt_tel.setText(table_persona.getValueAt(filaseleccionada,3).toString());
        txt_nombre.setText(table_persona.getValueAt(filaseleccionada,4).toString());
        txt_apellido.setText(table_persona.getValueAt(filaseleccionada,5).toString());
         txt_celular.setText(table_persona.getValueAt(filaseleccionada,6).toString());
        txt_correo.setText(table_persona.getValueAt(filaseleccionada,7).toString());
        txt_direccion.setText(table_persona.getValueAt(filaseleccionada,8).toString());
        txt_fechanac.setText(table_persona.getValueAt(filaseleccionada,9).toString());
        txt_pasaporte.setText(table_persona.getValueAt(filaseleccionada,10).toString());
        txt_correo.setText(table_persona.getValueAt(filaseleccionada,11).toString());
        combobox_sexo.setSelectedIndex(0);  
//       ----------------------------fin-----------------------------------------------
    }//GEN-LAST:event_table_personaMouseClicked

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
            java.util.logging.Logger.getLogger(fmr_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmr_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmr_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmr_persona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmr_persona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_salida;
    private javax.swing.JComboBox<String> combobox_sexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Cod_provincia;
    private javax.swing.JLabel label_apellido;
    private javax.swing.JLabel label_cedula;
    private javax.swing.JLabel label_codpersona;
    private javax.swing.JLabel label_correo;
    private javax.swing.JLabel label_correo1;
    private javax.swing.JLabel label_direccion;
    private javax.swing.JLabel label_direccion1;
    private javax.swing.JLabel label_direccion2;
    private javax.swing.JLabel label_direccion4;
    private javax.swing.JLabel label_fecha_Nac;
    private javax.swing.JLabel label_listadepersona;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_pasaporte;
    private javax.swing.JLabel label_rentcar;
    private javax.swing.JLabel label_sexo;
    private javax.swing.JLabel label_telefono;
    private javax.swing.JLabel label_ususrio6;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JTable table_persona;
    private javax.swing.JTextField txt_Cod_municipio;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_cod_sector;
    private javax.swing.JTextField txt_codpersona;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_direccion3;
    private javax.swing.JTextField txt_direccion4;
    private javax.swing.JTextField txt_fechanac;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_pasaporte;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JTextField txt_usuario5;
    // End of variables declaration//GEN-END:variables
}
