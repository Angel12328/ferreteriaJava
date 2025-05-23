/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import Clases.CarritoCompras;
import Clases.Inventario;
import Util.AdminSerializacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel
 */
public class frmCarrito extends javax.swing.JInternalFrame {
    private int _indiceSeleccionado;
    /**
     * Creates new form frmCarrito
     */
    public frmCarrito() {
        initComponents();
        //actualizarElementosTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        JtCarrito = new javax.swing.JTable();
        lblProducto = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnModCant = new javax.swing.JButton();
        btnIrPagar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel2.setText("FERRTERIA UNAH COMAYAGUA");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel3.setText("PRODUCTO");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel4.setText("CARRITO DE COMPRAS");

        JtCarrito.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        JtCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JtCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JtCarritoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(JtCarrito);

        lblProducto.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lblProducto.setText("N/D");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel5.setText("CANTIDAD");

        txtCantidad.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtCantidad.setText("1");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel6.setText("Modifique la cantidad de producto a comprar");

        btnModCant.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        btnModCant.setText("Modificar Cantidad");
        btnModCant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModCantActionPerformed(evt);
            }
        });

        btnIrPagar.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnIrPagar.setText("IR A PAGAR");
        btnIrPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrPagarActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnAtras.setText("ATRAS");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(378, 378, 378)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblProducto)
                                    .addGap(36, 36, 36)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(50, 50, 50)
                                    .addComponent(jLabel6)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnModCant)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIrPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(360, 360, 360))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblProducto)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnModCant))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIrPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Carrito de Compras");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnIrPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrPagarActionPerformed
        this.getDesktopPane().remove(MDIPrincipal.frmPago); 
        this.getDesktopPane().add(MDIPrincipal.frmPago);

        MDIPrincipal.frmPago.setLocation(
            (this.getDesktopPane().getWidth() - MDIPrincipal.frmPago.getWidth()) / 2,
            (this.getDesktopPane().getHeight() - MDIPrincipal.frmPago.getHeight()) / 2
        );

        MDIPrincipal.frmPago.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIrPagarActionPerformed

    private void JtCarritoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtCarritoMousePressed
        // TODO add your handling code here:
        this._indiceSeleccionado = this.JtCarrito.getSelectedRow();
        //CarritoCompras auxCarrito=new CarritoCompras();
        if (_indiceSeleccionado != -1) {
            
            //saca el producto seleccionado
            CarritoCompras aux1Carrito=MDIPrincipal.gCarrito.getCarritoComp().get(this._indiceSeleccionado);
            
            //rellena los recuadros para modicar la cantidad
            this.lblProducto.setText(aux1Carrito.getProducto().getNombreProducto());
            this.txtCantidad.setText(Integer.toString(aux1Carrito.getCantidadCompra()));
            
 
            //si se quiere eliminar el producto del carrito
            int resultado = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el producto del Carrito?", "Warning", JOptionPane.YES_NO_OPTION);
            if(resultado==JOptionPane.YES_NO_OPTION){      
                this.lblProducto.setText("N/D");
                this.txtCantidad.setText("");  
                
                JOptionPane.showMessageDialog(this,aux1Carrito.getProducto().getNombreProducto() +" eliminado del Carrito");
                
                //elimina el producto
                MDIPrincipal.gCarrito.getCarritoComp().remove(this._indiceSeleccionado);
                //serializa
                AdminSerializacion.serializacion(MDIPrincipal.gCarrito,"gCarrito.obj");
                
                //vuelve a proyetar la pantalla
                this.actualizarElementosTabla();
            }
            //mostrarElemento(_venta);

        }
    }//GEN-LAST:event_JtCarritoMousePressed

    private void btnModCantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModCantActionPerformed
        // TODO add your handling code here:
        CarritoCompras aux1Carrito=MDIPrincipal.gCarrito.getCarritoComp().get(this._indiceSeleccionado);
        if((Integer.parseInt(this.txtCantidad.getText())<= aux1Carrito.getProducto().getStock()) && Integer.parseInt(this.txtCantidad.getText())>0){
            
            aux1Carrito.setCantidadCompra(Integer.parseInt(this.txtCantidad.getText()));
            AdminSerializacion.serializacion(MDIPrincipal.gCarrito,"gCarrito.obj");
            this.actualizarElementosTabla();
        } else if (Integer.parseInt(this.txtCantidad.getText())==0) {
            JOptionPane.showMessageDialog(this,"Ingreso una cantidad de O, elimine o ingrese una cantidad valida");
        }else{
            JOptionPane.showMessageDialog(this,"Actualemente tenemos diponibles "+aux1Carrito.getProducto().getStock()+" de " + Integer.parseInt(this.txtCantidad.getText())+" que solicito");
        }
    }//GEN-LAST:event_btnModCantActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        int x = (this.getDesktopPane().getWidth() - MDIPrincipal.frmVenta.getWidth()) / 2;
        int y = (this.getDesktopPane().getHeight() - MDIPrincipal.frmVenta.getHeight()) / 2;
        MDIPrincipal.frmVenta.setLocation(x, y);



        // TODO add your handling code here:
        this.getDesktopPane().remove(MDIPrincipal.frmVenta); 
        this.getDesktopPane().add(MDIPrincipal.frmVenta);
        MDIPrincipal.frmVenta.setVisible(true);
        MDIPrincipal.frmVenta.actualizarElementosTabla();
        this.dispose(); //cierra la ventana actual
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        //Borrado del carrito
        MDIPrincipal.gCarrito.getCarritoComp().clear();
        AdminSerializacion.serializacion(MDIPrincipal.gCarrito, "gCarrito.obj");        
        
        // funcion para salirse
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    public void actualizarElementosTabla() {

        String[] titulo = {"Producto", "Cantidad","Precio"};
        
        DefaultTableModel dt = new DefaultTableModel(MDIPrincipal.gCarrito.getArrayGestion(), titulo);
        this.JtCarrito.setModel(dt);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtCarrito;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnIrPagar;
    private javax.swing.JButton btnModCant;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
