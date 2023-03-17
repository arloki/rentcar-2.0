/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
/**
 *
 * @author arlette
 */
public class frm_usu extends javax.swing.JFrame {
    
//declarar la jtable con el nombre de la tabla 
    DefaultTableModel usuario;
//    --------------------fin-----------------------
    
    public frm_usu() {
        initComponents();
        
//        para que se vea la tabla 
        this.usuario =( DefaultTableModel) table_usu.getModel();
//        ----------------------------fin------------------------------

// llamando a la funcion mostrardatos 
mostrardatos("");
//--------------fin----------------

    }
//    funcion para filtrar los datos
    public final void filtrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        usuario.addColumn("Cod_usuario");
        usuario.addColumn("Usuario");
        usuario.addColumn("Nombre_usu");
        usuario.addColumn("Apellido_usu");
        usuario.addColumn("Contraseña");
        usuario.addColumn("Correo");
        usuario.addColumn("Rol");
        
        this.table_usu.setModel(usuario); 
        String sql;
        if(valor.equals("")){
            sql ="select * from usuario"; 
        } else {
            sql = "select * from usuario where Nombre_usu like  '%"+valor+"%' "; 
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
                
                usuario.addRow(datos);
            }
            table_usu.setModel(usuario);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_usu.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
    
//    ------------fin-----------
    
//    funcion para mostrar datos
    public final void mostrardatos(String valor){
      MyConnection cc = new MyConnection();  
        Connection cn =  MyConnection.getConnection(); 
        
//        llamando a la funcion refescar tabla
                refrescartabla();
//        --------------------------------fin-----------------
        usuario.addColumn("Cod_usuario");
        usuario.addColumn("Usuario");
        usuario.addColumn("Nombre_usu");
        usuario.addColumn("Apellido_usu");
        usuario.addColumn("Contraseña");
        usuario.addColumn("Correo");
        usuario.addColumn("Rol");
        
        this.table_usu.setModel(usuario); 
        String sql;
        if(valor.equals("")){
            sql ="select * from usuario"; 
        } else {
            sql = "select * from usuario where Usuario= '"+valor+"' "; 
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
                
                usuario.addRow(datos);
            }
            table_usu.setModel(usuario);
    } catch (SQLException ex) {  
               Logger.getLogger(frm_usu.class.getName()).log(Level.SEVERE,null,ex);
                     JOptionPane.showMessageDialog(null, "error "+ex);
        
    }
        }  
//    --------------------fin----------------------------
    
//    para refrescar la tabla
    public void refrescartabla() {  
        try {  
            usuario.setColumnCount(0);
            usuario.setRowCount(0);
            table_usu.revalidate();
        }  catch (Exception ex) {  
                JOptionPane.showMessageDialog(null, "error "+ex);
     
    } 
    }
//    -----------------------------fin----------------------
    
    public boolean RevisarUsuario(String usuario){
        //Funcion para Revisar si un registro existe dentro de la BD
        PreparedStatement ps;
        ResultSet rs;
        boolean checkUser = false;
        String query = "SELECT * FROM `usuario` WHERE `Nombre_usu` =?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, usuario);
            
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
            txt_codigo.setText("");
            txt_usu.setText("");
          txt_usu.setText("");
        txt_nombre.setText("");
        txt_apellido.setText("");
         txtp_contra.setText("");
        txt_correo.setText("");
        cmbox_rol.setSelectedIndex(0); 
 
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

        lbl_titulo = new javax.swing.JLabel();
        lbl_rol = new javax.swing.JLabel();
        lbl_nom = new javax.swing.JLabel();
        lbl_correo = new javax.swing.JLabel();
        lbl_contra = new javax.swing.JLabel();
        lbl_ape = new javax.swing.JLabel();
        lbl_usu = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        cmbox_rol = new javax.swing.JComboBox<>();
        btn_guardar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_usu = new javax.swing.JTable();
        txtp_contra = new javax.swing.JPasswordField();
        lbl_codigo = new javax.swing.JLabel();
        txt_usu = new javax.swing.JTextField();
        lbl_buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        txt_codigo = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_titulo.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        lbl_titulo.setText("Control Usuario");
        getContentPane().add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 19, -1, -1));

        lbl_rol.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_rol.setText(" rol:");
        getContentPane().add(lbl_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 342, -1, -1));

        lbl_nom.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_nom.setText("nombre:");
        getContentPane().add(lbl_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 161, -1, -1));

        lbl_correo.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_correo.setText("correo:");
        getContentPane().add(lbl_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 296, -1, -1));

        lbl_contra.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_contra.setText("contraseña:");
        getContentPane().add(lbl_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 250, -1, -1));

        lbl_ape.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_ape.setText("apellido:");
        getContentPane().add(lbl_ape, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 204, -1, -1));

        lbl_usu.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_usu.setText("usuario:");
        getContentPane().add(lbl_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 115, -1, -1));

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 175, 184, -1));

        txt_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellidoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 218, 184, -1));

        cmbox_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "elige", " 1 admin", " 2 usuario" }));
        cmbox_rol.setToolTipText("");
        getContentPane().add(cmbox_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 356, 185, -1));

        btn_guardar.setText("guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, -1, -1));

        btn_editar.setText("editar");
        btn_editar.setActionCommand("guardar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, -1, -1));

        btn_borrar.setText("borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, -1, -1));

        table_usu.setFont(new java.awt.Font("Yu Gothic", 0, 14)); // NOI18N
        table_usu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_usu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_usuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_usu);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 57, 450, 411));
        getContentPane().add(txtp_contra, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 264, 150, -1));

        lbl_codigo.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_codigo.setText("codigo");
        getContentPane().add(lbl_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 69, -1, -1));

        txt_usu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuActionPerformed(evt);
            }
        });
        getContentPane().add(txt_usu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 184, -1));

        lbl_buscar.setFont(new java.awt.Font("Yu Gothic", 0, 24)); // NOI18N
        lbl_buscar.setText("buscar:");
        getContentPane().add(lbl_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 11, -1, -1));

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
        getContentPane().add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 25, 121, -1));

        txt_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 184, -1));

        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });
        getContentPane().add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // con este boton se actualiza el registro 
       
        String no = (String) usuario.getValueAt(table_usu.getSelectedRow(),0) ;
        String usu = txt_usu.getText();
        String cont = String.valueOf(txtp_contra.getPassword());
        String nom = txt_nombre.getText();
        String ape = txt_apellido.getText();
        String cor = txt_correo.getText();
        String rol = String.valueOf(cmbox_rol.getSelectedIndex());

        PreparedStatement ps;
        String query = "UPDATE usuario SET Usuario=? , Nombre_usu=? , Apellido_usu=? , Contraseña=? , Correo=? , Rol=?";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
          
            ps.setString(1, usu);
            ps.setString(2, nom);
            ps.setString(3, ape);
            ps.setString(4, cont);
            ps.setString(5, cor);
            ps.setString(6, rol);
             ps.setString(7,no);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Registro actualizado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_usu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        
//        ------------------------------------fin-------------------------------------
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // con este boton cada vez que se llena el formulario  se llena en la base de datos 
      String cod = txt_codigo.getText();
        String usu = txt_usu.getText();
        String cont = String.valueOf(txtp_contra.getPassword());
        String nom = txt_nombre.getText();
        String ape = txt_apellido.getText();
        String cor = txt_correo.getText();
        String rol = String.valueOf(cmbox_rol.getSelectedIndex());

                
        if(usu.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega un Usuario");
        }
        
        else if(cont.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Agrega una Contraseña");
        }      
        else if(RevisarUsuario(usu))
        {
            JOptionPane.showMessageDialog(null, "Este Usuario ya existe");
        }
        else{
        PreparedStatement ps;
        String query = "INSERT INTO `usuario`(`Cod_usu`,`Usuario`, `Nombre_usu`, `Apellido_usu`, `Contraseña`, `Correo`, `Rol`) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            
              ps.setString(1, cod);
            ps.setString(2, usu);
            ps.setString(3, nom);
            ps.setString(4, ape);
            ps.setString(5, cont);
            ps.setString(6, cor);
            ps.setString(7, rol);
            if(ps.executeUpdate() > 0)
            {
                JOptionPane.showMessageDialog(null, "Nuevo Usuario Agregado");
               
//                llamando a las funciones de limpiar los datos y mostrar datos
                limpiar();
                mostrardatos(""); 
//                ----------------------------fin----------------------------------------
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(frm_usu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        }
//       -------------------------------fin---------------------------------- 
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_usuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        // con este boton se elimina un registro de la tabla
        String cod = (String) usuario.getValueAt(table_usu.getSelectedRow(),0) ;
    

        PreparedStatement ps;
        String query = "delete from usuario where Cod_usu=?";
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
            Logger.getLogger(frm_usu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "error "+ex);
            }
        
        

//      -------------------------------fin--------------------------------------
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void table_usuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_usuMouseClicked
        // cuando se seleccione una fila en la tabla se pone en el formulario
        int filaseleccionada=table_usu.rowAtPoint(evt.getPoint()); 
        
        
         txt_usu.setText(table_usu.getValueAt(filaseleccionada,1).toString());
          txt_nombre.setText(table_usu.getValueAt(filaseleccionada,2).toString());
           txt_apellido.setText(table_usu.getValueAt(filaseleccionada,3).toString());
            txtp_contra.setText(table_usu.getValueAt(filaseleccionada,4).toString()); 
             txt_correo.setText(table_usu.getValueAt(filaseleccionada,5).toString()); 
             cmbox_rol.setSelectedItem(table_usu.getValueAt(filaseleccionada,6)); 
             
             
//       ----------------------------fin-----------------------------------------------
            
    }//GEN-LAST:event_table_usuMouseClicked

    private void txt_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigoActionPerformed

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

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
            java.util.logging.Logger.getLogger(frm_usu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_usu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_usu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_usu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_usu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JComboBox<String> cmbox_rol;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_ape;
    private javax.swing.JLabel lbl_buscar;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_contra;
    private javax.swing.JLabel lbl_correo;
    private javax.swing.JLabel lbl_nom;
    private javax.swing.JLabel lbl_rol;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel lbl_usu;
    private javax.swing.JTable table_usu;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_usu;
    private javax.swing.JPasswordField txtp_contra;
    // End of variables declaration//GEN-END:variables
}
