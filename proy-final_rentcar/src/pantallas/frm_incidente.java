/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
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
public class frm_incidente extends javax.swing.JFrame {

    /**
     * Creates new form frm_incidente
     */
    public frm_incidente() {
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

        btn_print2 = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_guardar1 = new javax.swing.JButton();
        btn_delete1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_registro_incidentes = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_rentcar1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label_Cod_incidente = new javax.swing.JLabel();
        txt_Cod_incidente = new javax.swing.JTextField();
        label_fecha = new javax.swing.JLabel();
        txt_fecha = new javax.swing.JTextField();
        label_descripcion = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        label_tipo = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JTextField();
        label_estado = new javax.swing.JLabel();
        label_cotizacion_daños = new javax.swing.JLabel();
        txt_cotizacion_daños = new javax.swing.JTextField();
        label_costo_daños = new javax.swing.JLabel();
        txt_costo_daños = new javax.swing.JTextField();
        label_dias_excedidos = new javax.swing.JLabel();
        txt_dias_excedidos = new javax.swing.JTextField();
        label_costo_exc_dias = new javax.swing.JLabel();
        txt_costo_exc_dias = new javax.swing.JTextField();
        label_costo_deducible = new javax.swing.JLabel();
        txt_costo_deducible = new javax.swing.JTextField();
        label_cod_renta = new javax.swing.JLabel();
        txt_cod_renta = new javax.swing.JTextField();
        label_Cod_cliente = new javax.swing.JLabel();
        txt_Cod_cliente = new javax.swing.JTextField();
        Cbox_estado = new javax.swing.JComboBox<>();
        btn_print3 = new javax.swing.JButton();
        btn_edit2 = new javax.swing.JButton();
        btn_guardar2 = new javax.swing.JButton();
        btn_delete2 = new javax.swing.JButton();
        btn_salida = new javax.swing.JButton();
        jLabel_imgfondo = new javax.swing.JLabel();

        btn_print2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-imprimir-50.png")); // NOI18N

        btn_edit1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-editar-50.png")); // NOI18N

        btn_guardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N

        btn_delete1.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-eliminar-50.png")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_registro_incidentes.setFont(new java.awt.Font("Goudy Old Style", 0, 26)); // NOI18N
        label_registro_incidentes.setForeground(new java.awt.Color(0, 102, 102));
        label_registro_incidentes.setText("Registro de incidentes");

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        label_rentcar1.setFont(new java.awt.Font("Californian FB", 0, 30)); // NOI18N
        label_rentcar1.setText("Rent a Car U&S");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-embotellamiento-50 (1).png"))); // NOI18N

        label_Cod_incidente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_incidente.setText("Cod_comp:");

        txt_Cod_incidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_incidenteActionPerformed(evt);
            }
        });

        label_fecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_fecha.setText("Fecha:");

        txt_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechaActionPerformed(evt);
            }
        });

        label_descripcion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_descripcion.setText("Descripcion:");

        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });

        label_tipo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_tipo.setText("Tipo:");

        txt_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tipoActionPerformed(evt);
            }
        });

        label_estado.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_estado.setText("Estado:");

        label_cotizacion_daños.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cotizacion_daños.setText("Cotizacion_daños:");

        txt_cotizacion_daños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cotizacion_dañosActionPerformed(evt);
            }
        });

        label_costo_daños.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_costo_daños.setText("costo_daños:");

        txt_costo_daños.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costo_dañosActionPerformed(evt);
            }
        });

        label_dias_excedidos.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_dias_excedidos.setText("Dias_excedidos:");

        txt_dias_excedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dias_excedidosActionPerformed(evt);
            }
        });

        label_costo_exc_dias.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_costo_exc_dias.setText("Costo_exc_dias:");

        txt_costo_exc_dias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costo_exc_diasActionPerformed(evt);
            }
        });

        label_costo_deducible.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_costo_deducible.setText("Costo_deducible:");

        txt_costo_deducible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costo_deducibleActionPerformed(evt);
            }
        });

        label_cod_renta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_cod_renta.setText("Cod_renta:");

        txt_cod_renta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cod_rentaActionPerformed(evt);
            }
        });

        label_Cod_cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_Cod_cliente.setText("Cod_cliente:");

        txt_Cod_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Cod_clienteActionPerformed(evt);
            }
        });

        Cbox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elegir", "activo ", "inactivo" }));

        btn_print3.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-imprimir-50.png")); // NOI18N
        btn_print3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_print3ActionPerformed(evt);
            }
        });

        btn_edit2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-editar-50.png")); // NOI18N

        btn_guardar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-guardar-50.png"))); // NOI18N

        btn_delete2.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icons8-eliminar-50.png")); // NOI18N

        btn_salida.setIcon(new javax.swing.ImageIcon("C:\\Users\\user\\Documents\\NetBeansProjects\\rentacar\\proy-final_rentcar\\src\\imagenes\\icon_salida.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_print3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(107, 107, 107)
                            .addComponent(label_rentcar1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(115, 115, 115)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_registro_incidentes)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_cotizacion_daños)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_cotizacion_daños))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_estado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Cbox_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_tipo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_tipo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_descripcion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_descripcion))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_fecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_fecha))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(label_Cod_incidente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_Cod_incidente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_costo_deducible)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_costo_deducible))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_cod_renta)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_cod_renta))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(label_Cod_cliente)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txt_Cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btn_salida, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(label_costo_daños)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_costo_daños))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(label_dias_excedidos)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_dias_excedidos))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(label_costo_exc_dias)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txt_costo_exc_dias, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))))))))
                .addContainerGap(557, Short.MAX_VALUE))
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 6, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_salida)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_registro_incidentes)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Cod_incidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Cod_incidente))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_fecha, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_descripcion)
                            .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_costo_daños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_costo_daños))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dias_excedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_dias_excedidos))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_costo_exc_dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_costo_exc_dias))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_tipo)
                            .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_estado)
                            .addComponent(Cbox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cotizacion_daños, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cotizacion_daños)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_costo_deducible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_costo_deducible))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod_renta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_cod_renta))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Cod_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_Cod_cliente))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_delete2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_guardar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_edit2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_print3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1070, 480));

        jLabel_imgfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mercedes_benz.jpg"))); // NOI18N
        jLabel_imgfondo.setText(" ");
        getContentPane().add(jLabel_imgfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_Cod_incidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_incidenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cod_incidenteActionPerformed

    private void txt_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechaActionPerformed

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void txt_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tipoActionPerformed

    private void txt_cotizacion_dañosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cotizacion_dañosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cotizacion_dañosActionPerformed

    private void txt_costo_dañosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costo_dañosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costo_dañosActionPerformed

    private void txt_dias_excedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dias_excedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dias_excedidosActionPerformed

    private void txt_costo_exc_diasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costo_exc_diasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costo_exc_diasActionPerformed

    private void txt_costo_deducibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costo_deducibleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costo_deducibleActionPerformed

    private void txt_cod_rentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cod_rentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cod_rentaActionPerformed

    private void txt_Cod_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Cod_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Cod_clienteActionPerformed

    private void btn_print3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_print3ActionPerformed
            // codigo para imprimir reporte 
               Connection con= MyConnection.getConnection();
        try{
            JasperReport jr = (JasperReport) JRLoader.loadObject(frm_cliente.class.getResource("/reportes/rpt_incidente.jasper"));
            Map parametros = new HashMap<>();
            parametros.put("incidente ", "Reporte incidente");

            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        }
        catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
    }//GEN-LAST:event_btn_print3ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_incidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_incidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_incidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_incidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_incidente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbox_estado;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_delete2;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_edit2;
    private javax.swing.JButton btn_guardar1;
    private javax.swing.JButton btn_guardar2;
    private javax.swing.JButton btn_print2;
    private javax.swing.JButton btn_print3;
    private javax.swing.JButton btn_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_imgfondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_Cod_cliente;
    private javax.swing.JLabel label_Cod_incidente;
    private javax.swing.JLabel label_cod_renta;
    private javax.swing.JLabel label_costo_daños;
    private javax.swing.JLabel label_costo_deducible;
    private javax.swing.JLabel label_costo_exc_dias;
    private javax.swing.JLabel label_cotizacion_daños;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel label_dias_excedidos;
    private javax.swing.JLabel label_estado;
    private javax.swing.JLabel label_fecha;
    private javax.swing.JLabel label_registro_incidentes;
    private javax.swing.JLabel label_rentcar1;
    private javax.swing.JLabel label_tipo;
    private javax.swing.JTextField txt_Cod_cliente;
    private javax.swing.JTextField txt_Cod_incidente;
    private javax.swing.JTextField txt_cod_renta;
    private javax.swing.JTextField txt_costo_daños;
    private javax.swing.JTextField txt_costo_deducible;
    private javax.swing.JTextField txt_costo_exc_dias;
    private javax.swing.JTextField txt_cotizacion_daños;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_dias_excedidos;
    private javax.swing.JTextField txt_fecha;
    private javax.swing.JTextField txt_tipo;
    // End of variables declaration//GEN-END:variables
}
