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
public class frm_factura_renta extends javax.swing.JFrame {

    /**
     * Creates new form frm_factura_renta
     */
    public frm_factura_renta() {
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
        jLabel_imgfondo = new javax.swing.JLabel();

        btn_print1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-imprimir-50.png")); // NOI18N

        btn_edit.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-editar-50.png")); // NOI18N

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N

        btn_delete.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-eliminar-50.png")); // NOI18N

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

        btn_print2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-imprimir-50.png")); // NOI18N

        btn_edit1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-editar-50.png")); // NOI18N

        btn_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N

        btn_delete1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-eliminar-50.png")); // NOI18N

        btn_salida.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icon_salida.png")); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_rentcar1)
                                .addGap(27, 27, 27)
                                .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_print2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_guardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                        .addComponent(txt_Num_fact, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(549, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_rentcar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_salida))
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
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_print2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 900, 460));

        jLabel_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        getContentPane().add(jLabel_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 520));

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
    private javax.swing.JTextField txt_Cod_cliente;
    private javax.swing.JTextField txt_Num_fact;
    private javax.swing.JTextField txt_cod_renta;
    private javax.swing.JTextField txt_fecha_hora_factura;
    private javax.swing.JTextField txt_ncf_factura;
    private javax.swing.JTextField txt_rnc_factura;
    private javax.swing.JTextField txt_tipo_factura;
    // End of variables declaration//GEN-END:variables
}