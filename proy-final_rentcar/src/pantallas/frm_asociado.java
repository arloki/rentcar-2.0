/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

/**
 *
 * @author user
 */
public class frm_asociado extends javax.swing.JFrame {

    /**
     * Creates new form frm_asociado
     */
    public frm_asociado() {
        initComponents();
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

        btn_print.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-imprimir-50.png")); // NOI18N

        btn_edit.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-editar-50.png")); // NOI18N
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_delete.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-eliminar-50.png")); // NOI18N

        btn_salida.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icon_salida.png")); // NOI18N

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N

        label_rentcar1.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar1.setText("Rent a Car U&S");

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setAlignmentX(1.0F);
        jSeparator2.setAlignmentY(1.0F);

        label_listadeasociados.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_listadeasociados.setForeground(new java.awt.Color(0, 102, 102));
        label_listadeasociados.setText("Registro de asociados");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

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
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_listadeasociados)
                                        .addGap(50, 50, 50))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(label_rentcar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(497, Short.MAX_VALUE))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_salida)
                            .addComponent(label_rentcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JTextField txt_cod_asociado;
    private javax.swing.JTextField txt_cod_persona;
    private javax.swing.JTextField txt_moneda_asociado;
    private javax.swing.JTextField txt_rnc_asociado;
    // End of variables declaration//GEN-END:variables
}