/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import Clases.CarritoCompras;
import Clases.Cliente;
import Clases.Empleado;
import Clases.Factura;
import Clases.Pago;
import GUI.MDIPrincipal;
import Gestiones.GestionCarritoCompras;
import Util.AdminArchivos;
import Util.AdminSerializacion;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author 20241900037 Bayron Alejandro Torres Valladares
 */
public class frmPago extends javax.swing.JInternalFrame {

    private boolean _agregando;
    private GestionCarritoCompras carritoActual;
    private Cliente clienteActual;

    //intancia de factura
    private Factura facturaCache = new Factura();

    public frmPago() {
        initComponents();
        this.setTitle("Gestión de Pagos");

        ButtonGroup grupoMetodosPago = new ButtonGroup();
        grupoMetodosPago.add(optEfectivo);
        grupoMetodosPago.add(optTransferencia);

        configurarAutocalculables();
        cargarDatosIniciales();
        deshabilitarCamposPago();

        txtMontoRec.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                calcularCambio();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                calcularCambio();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                calcularCambio();
            }
        });
    }

    private void cargarDatosIniciales() {
        txtCodigoPago.setText(String.valueOf(MDIPrincipal.gPago.getPagos().size() + 1));
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));

        if (MDIPrincipal.gCarrito != null) {
            carritoActual = MDIPrincipal.gCarrito;
            actualizarTotales(); // Para actualizar los calculos automáticamente
        }

        // Limpiar otros campos
        txtMontoRec.setText("");
        txtCambio.setText("Cambio: $0.00");
        txtCuentaNumero.setText("");
        txtCvv.setText("");
        txtMonto.setText("");
        txtCliente.setText("");
    }

    private void actualizarTotales() {
        if (carritoActual != null && !carritoActual.getCarritoComp().isEmpty()) {
            // Calcular subtotal
            double subTotal = carritoActual.getCarritoComp().stream()
                    .mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidadCompra())
                    .sum();

            // Calcular descuento 
            double descuento = 0;
            int totalProductos = carritoActual.getCarritoComp().stream()
                    .mapToInt(CarritoCompras::getCantidadCompra)
                    .sum();

            if (totalProductos > 6) {
                descuento = 5;
                facturaCache.setDescuento(descuento);
            } else {
                facturaCache.setDescuento(0);
            }

            // Calcular impuesto (12%)
            double impuesto = subTotal * 0.12;

            // Calcular total
            double total = (subTotal - (subTotal * (descuento / 100))) + impuesto;

            // Actualizar campos
            txtSubTotal.setText(String.format("$%.2f", subTotal));
            txtImpuesto.setText(String.format("$%.2f", impuesto));
            txtDescuento.setText(String.format("%.2f%%", descuento));
            txtTotalPagar.setText(String.format("$%.2f", total));

            if (optTransferencia.isSelected()) {
                txtMonto.setText(String.format("$%.2f", total));
            }
            facturaCache.setSubtotal(subTotal);
            facturaCache.setImpuesto(impuesto);
            facturaCache.setMontoTotal(total);
        }
    }

    private void calcularCambio() {
        if (!optEfectivo.isSelected() || !txtMontoRec.isEnabled()) {
            return;
        }

        try {
            String montoText = txtMontoRec.getText().trim();
            if (!montoText.isEmpty()) {
                double montoRecibido = Double.parseDouble(montoText);
                double total = Double.parseDouble(txtTotalPagar.getText().replace("$", "").trim());

                if (montoRecibido < total) {
                    txtCambio.setText("Monto insuficiente");
                    txtCambio.setForeground(Color.RED);
                } else {
                    double cambio = montoRecibido - total;
                    txtCambio.setText(String.format("Cambio: $%.2f", cambio));
                    txtCambio.setForeground(Color.BLACK);
                }
            }
        } catch (NumberFormatException e) {
            txtCambio.setText("Monto inválido");
            txtCambio.setForeground(Color.RED);
        }
    }

    private void configurarAutocalculables() {
        txtCodigoPago.setEditable(false);
        //.setEditable(false);
        txtSubTotal.setEditable(false);
        txtImpuesto.setEditable(false);
        txtDescuento.setEditable(false);
        txtTotalPagar.setEditable(false);
        txtMonto.setEditable(false);
        txtCambio.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGroupMetodoPago = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoPago = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtImpuesto = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();
        optEfectivo = new javax.swing.JRadioButton();
        optTransferencia = new javax.swing.JRadioButton();
        txtFecha = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtMontoRec = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCuentaNumero = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCvv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnCancelarPago = new javax.swing.JButton();
        btnGenerarFactura = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtVendedor = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel1.setText("Código de Pago:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel3.setText("SubTotal:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel5.setText("Total a Pagar:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel6.setText("Método de Pago");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel7.setText("Impuesto:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel8.setText("Descuento:");

        txtCodigoPago.setEditable(false);
        txtCodigoPago.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigoPago.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtCodigoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPagoActionPerformed(evt);
            }
        });

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        txtImpuesto.setEditable(false);
        txtImpuesto.setBackground(new java.awt.Color(255, 255, 255));
        txtImpuesto.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtDescuento.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalPagar.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel4.setText("Fecha");

        optEfectivo.setBackground(new java.awt.Color(255, 255, 255));
        rbGroupMetodoPago.add(optEfectivo);
        optEfectivo.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        optEfectivo.setText("Efectivo");
        optEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optEfectivoActionPerformed(evt);
            }
        });

        optTransferencia.setBackground(new java.awt.Color(255, 255, 255));
        rbGroupMetodoPago.add(optTransferencia);
        optTransferencia.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        optTransferencia.setText("Tranferencia");
        optTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optTransferenciaActionPerformed(evt);
            }
        });

        txtFecha.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtFecha.setText("jLabel9");

        btnNuevo.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnNuevo.setText("Generar Pago");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel9.setText("Monto Recibido:");

        txtMontoRec.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtMontoRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoRecActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel10.setText("Cambio:");

        txtCambio.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel11.setText("Número de Cuenta:");

        txtCuentaNumero.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtCuentaNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaNumeroActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel12.setText("CVV:");

        txtCvv.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtCvv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCvvActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel13.setText("Monto a Debitar:");

        txtMonto.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        btnCancelarPago.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnCancelarPago.setText("Cancelar Pago");
        btnCancelarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPagoActionPerformed(evt);
            }
        });

        btnGenerarFactura.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel14.setText("Nombre Cliente:");

        txtCliente.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel15.setText("Código del vendedor que lo atendio:");

        txtVendedor.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        txtVendedor.setText("0");
        txtVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVendedorActionPerformed(evt);
            }
        });

        btnAtras.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCuentaNumero))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13)
                                                .addGap(15, 15, 15))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnNuevo)
                                                .addGap(103, 103, 103)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnCancelarPago)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(16, 16, 16)
                                                        .addComponent(btnAtras)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnGenerarFactura)
                                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(13, 13, 13))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMontoRec, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(13, 13, 13))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(220, 220, 220))))
                                    .addComponent(txtSubTotal)
                                    .addComponent(txtImpuesto)
                                    .addComponent(txtDescuento)
                                    .addComponent(txtTotalPagar)
                                    .addComponent(txtCodigoPago)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(optEfectivo)
                                                .addGap(18, 18, 18)
                                                .addComponent(optTransferencia))
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtCliente)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotalPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(optEfectivo)
                    .addComponent(optTransferencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMontoRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCuentaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtCvv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnCancelarPago)
                    .addComponent(btnGenerarFactura))
                .addGap(13, 13, 13)
                .addComponent(btnAtras)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optTransferenciaActionPerformed

        txtCuentaNumero.setEnabled(true);
        txtCvv.setEnabled(true);
        txtMonto.setEnabled(true);

        // Deshabilitar campos de efectivo
        txtMontoRec.setEnabled(false);
        txtCambio.setEnabled(false);

        // Limpiar campos de efectivo
        txtMontoRec.setText("");
        txtCambio.setText("Cambio: $0.00");

        // Mostrar monto a debitar 
        if (!txtTotalPagar.getText().isEmpty()) {
            txtMonto.setText(txtTotalPagar.getText());
        }

        txtCuentaNumero.requestFocus();

    }//GEN-LAST:event_optTransferenciaActionPerformed

    private void optEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optEfectivoActionPerformed
        txtMontoRec.setEnabled(true);
        txtCambio.setEnabled(true);

        // Deshabilitar campos de transferencia
        txtCuentaNumero.setEnabled(false);
        txtCvv.setEnabled(false);
        txtMonto.setEnabled(false);

        // Limpiar campos de transferencia
        txtCuentaNumero.setText("");
        txtCvv.setText("");
        txtMonto.setText("");

        txtMontoRec.requestFocus();

    }//GEN-LAST:event_optEfectivoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        this._agregando = true;
        estadoControles(true);
        estadoBotones(false);

        // Limpiar todos los campos
        txtCodigoPago.setText(String.valueOf(MDIPrincipal.gPago.getPagos().size() + 1));
        txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
        txtSubTotal.setText("");
        txtCliente.setText("");
        txtImpuesto.setText("");
        txtDescuento.setText("0");
        txtTotalPagar.setText("");
        txtMontoRec.setText("");
        txtCambio.setText("Cambio: $0.00");
        txtCuentaNumero.setText("");
        txtCvv.setText("");
        txtMonto.setText("");

        // Resetear selección de método de pago
        optEfectivo.setSelected(false);
        optTransferencia.setSelected(false);

        txtCliente.setEditable(true);
        txtCliente.requestFocus();

        // Deshabilitar campos de pago hasta seleccionar método
        txtMontoRec.setEnabled(false);
        txtCambio.setEnabled(false);
        txtCuentaNumero.setEnabled(false);
        txtCvv.setEnabled(false);
        txtMonto.setEnabled(false);

        if (MDIPrincipal.gCarrito != null) {
            carritoActual = MDIPrincipal.gCarrito;
            //System.out.println(carritoActual.toString());
            actualizarTotales();
        }

    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtCodigoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoPagoActionPerformed

    private void txtCvvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCvvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCvvActionPerformed

    private void txtCuentaNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCuentaNumeroActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        try {

            // Validar campos según método de pago seleccionado
            if (optEfectivo.isSelected()) {
                if (txtMontoRec.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Ingrese el monto recibido.");
                    return;
                }

                try {
                    double montoRecibido = Double.parseDouble(txtMontoRec.getText());
                    double total = Double.parseDouble(txtTotalPagar.getText().replace("$", ""));

                    if (montoRecibido < total) {
                        JOptionPane.showMessageDialog(this, "El monto recibido es insuficiente.");
                        return;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
                    return;
                }
            } else if (optTransferencia.isSelected()) {
                if (txtCuentaNumero.getText().trim().isEmpty() || txtCvv.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Complete todos los datos de transferencia.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un método de pago.");
                return;
            }

            // Validar cliente
            if (txtCliente.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del cliente.");
                return;
            }

            clienteActual = new Cliente();
            clienteActual.setNombre(txtCliente.getText());

            // Crear y guardar el pago
            Pago pago = crearPagoDesdeFormulario();

            if (MDIPrincipal.gPago.agregarPago(pago)) {

                Date fecha = new Date();
                facturaCache.setFecha(fecha);
                facturaCache.setCliente(clienteActual);

                Empleado empleado = new Empleado();
                empleado = MDIPrincipal.gEmpleado.buscar(Integer.parseInt(this.txtVendedor.getText()));
                if (empleado == null) {
                    Empleado empleadoaux = new Empleado();
                    empleadoaux.setNombre("N/D");
                    facturaCache.setEmpleado(empleadoaux);
                } else {
                    facturaCache.setEmpleado(empleado);
                }

                facturaCache.setCarrito(MDIPrincipal.gCarrito.getCarritoComp());
                facturaCache.setCodigoFactura(MDIPrincipal.gFactura.getFacturas().size() + 1);

                //Se agrega la factura al sistema
                MDIPrincipal.gFactura.agregarFactura(facturaCache);

                // Serializar datos
                AdminSerializacion.serializacion(MDIPrincipal.gPago, "gPago.obj");
                AdminSerializacion.serializacion(MDIPrincipal.gFactura, "gFactura.obj");

                //Reduccion de la cantidades compradas del inventario

                for (int i = 0; i < MDIPrincipal.gCarrito.getCarritoComp().size(); i++) {
                    //REDUCCION EN EL ARBOL

                    MDIPrincipal.arbolInventario.buscarProductoInOrdenPorCod(MDIPrincipal.arbolInventario.getRaiz(), MDIPrincipal.gCarrito.getCarritoComp().get(i).getProducto().getCodigoInventario())
                            .getProducto()
                            .setStock(MDIPrincipal.gCarrito.getCarritoComp().get(i).getProducto().getStock()
                                    - MDIPrincipal.gCarrito.getCarritoComp().get(i).getCantidadCompra()
                            );
                    //MDIPrincipal.gCarrito.getCarritoComp().get(i);

                    //REDUCCION EN EL LIKENDLIST
                    MDIPrincipal.gInventario.getInventarios()
                            .get(MDIPrincipal.gInventario.buscarInventario(MDIPrincipal.gCarrito.getCarritoComp().get(i).getProducto().getCodigoInventario()))
                            .setStock(MDIPrincipal.gCarrito.getCarritoComp().get(i).getProducto().getStock()
                            );

                }
                

                //serializar el arbol e inventario
                AdminSerializacion.serializacion(MDIPrincipal.arbolInventario, "gInventarioArbol.obj");
                AdminSerializacion.serializacion(MDIPrincipal.gInventario, "gInventario.obj");
                
                
                
                this.getDesktopPane().remove(MDIPrincipal.frmFactura);
                this.getDesktopPane().add(MDIPrincipal.frmFactura);

                int x = (this.getDesktopPane().getWidth() - MDIPrincipal.frmFactura.getWidth()) / 2;
                int y = (this.getDesktopPane().getHeight() - MDIPrincipal.frmFactura.getHeight()) / 2;
                MDIPrincipal.frmFactura.setLocation(x, y);

                //Llama a la ventana de factura
                this.getDesktopPane().remove(MDIPrincipal.frmFactura); // solo si ya está agregado
                this.getDesktopPane().add(MDIPrincipal.frmFactura);
                MDIPrincipal.frmFactura.setVisible(true);

                //Busca la factura guardada
                //MDIPrincipal.gFactura.buscarFactura(facturaCache.getCodigoFactura());
                MDIPrincipal.frmFactura.mostrarElemento(facturaCache);
                MDIPrincipal.frmFactura.actualizarElementosTabla();

                System.out.println("ANTES DE BORRAR EL CARRITO" + MDIPrincipal.gCarrito.getCarritoComp().size());

                AdminArchivos adminA = new AdminArchivos();
                adminA.setNombreArchivo("Reporte Factura.txt");
                adminA.setContenido(MDIPrincipal.gFactura.getInfoReporte());
                adminA.escribir();

                JOptionPane.showMessageDialog(this, "Reporte generado correctamente");
                
                //Borrado del carrito
                MDIPrincipal.gCarrito.getCarritoComp().clear();
                AdminSerializacion.serializacion(MDIPrincipal.gCarrito, "gCarrito.obj");
                System.out.println("DESPUES DE BORRAR EL CARRITO" + MDIPrincipal.gCarrito.getCarritoComp().size());

                //borrar el cache de la factura
                facturaCache = new Factura();

                // Limpiar y resetear formulario
                cargarDatosIniciales();
                deshabilitarCamposPago();
                estadoBotones(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al procesar el pago");
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    private void btnCancelarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPagoActionPerformed
        limpiarFormulario(); // Primero limpiar el formulario
    
        int x = (this.getDesktopPane().getWidth() - MDIPrincipal.frmVenta.getWidth()) / 2;
        int y = (this.getDesktopPane().getHeight() - MDIPrincipal.frmVenta.getHeight()) / 2;
        MDIPrincipal.frmVenta.setLocation(x, y);

        this.getDesktopPane().remove(MDIPrincipal.frmVenta);
        this.getDesktopPane().add(MDIPrincipal.frmVenta);
        MDIPrincipal.frmVenta.setVisible(true);
        MDIPrincipal.frmVenta.actualizarElementosTabla();
        this.dispose();
    }//GEN-LAST:event_btnCancelarPagoActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioActionPerformed


    }//GEN-LAST:event_txtCambioActionPerformed

    private void txtMontoRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoRecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoRecActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVendedorActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        limpiarFormulario(); // Primero limpiar el formulario
    
        int x = (this.getDesktopPane().getWidth() - MDIPrincipal._frmCarrito.getWidth()) / 2;
        int y = (this.getDesktopPane().getHeight() - MDIPrincipal._frmCarrito.getHeight()) / 2;
        MDIPrincipal._frmCarrito.setLocation(x, y);       

        this.getDesktopPane().remove(MDIPrincipal._frmCarrito);
        this.getDesktopPane().add(MDIPrincipal._frmCarrito);
        MDIPrincipal._frmCarrito.setVisible(true);
        MDIPrincipal._frmCarrito.actualizarElementosTabla();
        this.dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    /*Este metodo muestra los elemento en pantalla
    segun el objeto enviado*/
    public void mostrarElemento(Pago _pago) {
        this.txtCodigoPago.setText(Integer.toString(_pago.getCodigoPago()));
        this.txtSubTotal.setText(Double.toString(_pago.getSubTotal()));
        this.txtImpuesto.setText(Double.toString(_pago.getImpuesto()));
        this.txtDescuento.setText(Double.toString(_pago.getDescuento()));
        this.txtTotalPagar.setText(Double.toString(_pago.getTotalPagar()));
        this.lblCliente.setText(_pago.getCliente().getNombre() + " " + _pago.getCliente().getTelefono());
    }

    public void estadoControles(boolean _estado) {
        this.txtCodigoPago.setEditable(_estado);
        this.optEfectivo.setEnabled(_estado);
        this.optTransferencia.setEnabled(_estado);
        this.txtSubTotal.setEditable(_estado);
        this.txtImpuesto.setEditable(_estado);
        this.txtDescuento.setEditable(_estado);
        this.txtTotalPagar.setEditable(_estado);
    }

    public void estadoBotones(boolean _estado) {

        this.btnNuevo.setEnabled(_estado);
    }

    private void deshabilitarCamposPago() {
        txtMontoRec.setEnabled(false);
        txtCliente.setEditable(false);
        txtCuentaNumero.setEnabled(false);
        txtCvv.setEnabled(false);
        txtMonto.setEnabled(false);
        txtCambio.setText("Cambio: $0.00");
    }

    private Pago crearPagoDesdeFormulario() {
        Pago pago = new Pago();
        pago.setFechaPago(new Date());
        pago.setCodigoPago(Integer.parseInt(txtCodigoPago.getText()));
        pago.setCliente(clienteActual);
        pago.setCarrito(carritoActual);
        pago.setSubTotal(Double.parseDouble(txtSubTotal.getText().replace("$", "")));
        pago.setImpuesto(Double.parseDouble(txtImpuesto.getText().replace("$", "")));
        pago.setDescuento(Double.parseDouble(txtDescuento.getText().replace("%", "")));
        pago.setTotalPagar(Double.parseDouble(txtTotalPagar.getText().replace("$", "")));

        if (optEfectivo.isSelected()) {
            pago.setMetodoPago("EFECTIVO");
            pago.setMontoRecibido(Double.parseDouble(txtMontoRec.getText()));
            pago.calcularCambio();
        } else {
            pago.setMetodoPago("TRANSFERENCIA");
            pago.setNumeroCuenta(txtCuentaNumero.getText());
            pago.setCvv(txtCvv.getText());
            pago.setMontoRecibido(Double.parseDouble(txtTotalPagar.getText().replace("$", "")));
        }

        return pago;
    }

    private void limpiarFormulario() {
    // Limpiar campos pero mantener los cálculos del carrito
    txtCodigoPago.setText(String.valueOf(MDIPrincipal.gPago.getPagos().size() + 1));
    txtFecha.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
    txtCliente.setText("");
    txtMontoRec.setText("");
    txtCambio.setText("Cambio: $0.00");
    txtCuentaNumero.setText("");
    txtCvv.setText("");
    txtMonto.setText("");

    // Resetear selección de método de pago
    optEfectivo.setSelected(false);
    optTransferencia.setSelected(false);

    // Deshabilitar campos de pago
    deshabilitarCamposPago();

    if (MDIPrincipal.gCarrito != null && !MDIPrincipal.gCarrito.getCarritoComp().isEmpty()) {
        carritoActual = MDIPrincipal.gCarrito;
        actualizarTotales();
    } else {
        txtSubTotal.setText("");
        txtImpuesto.setText("");
        txtDescuento.setText("0");
        txtTotalPagar.setText("");
    }
    
    _agregando = false;
    clienteActual = null;
    estadoBotones(true); 
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCancelarPago;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JRadioButton optEfectivo;
    private javax.swing.JRadioButton optTransferencia;
    private javax.swing.ButtonGroup rbGroupMetodoPago;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCodigoPago;
    private javax.swing.JTextField txtCuentaNumero;
    private javax.swing.JTextField txtCvv;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JTextField txtImpuesto;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoRec;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalPagar;
    private javax.swing.JTextField txtVendedor;
    // End of variables declaration//GEN-END:variables
}
