/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package GUI;

import Arboles.ArbolBinario;
import Clases.Inventario;
import Gestiones.*;
import Util.AdminSerializacion;
import java.awt.Color;
import java.awt.Dimension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;


/**
 *
 * @author 20241900037 Bayron Alejandro Torres Valladares
 */
public class MDIPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MDIPrincipal ubicar todas las gestiones
     */
    public static GestionCliente gCliente = new GestionCliente();
    public static GestionEmpleado gEmpleado = new GestionEmpleado();
    public static GestionProveedor gProveedor = new GestionProveedor();

    // Crear las Gestiones las cuales son dependientes de las anteriores
    public static GestionInventario gInventario = new GestionInventario();
    public static GestionVenta gVenta = new GestionVenta();
    public static GestionFactura gFactura=new GestionFactura();
    public static ArbolBinario arbolInventario=new ArbolBinario();
    public static LinkedList<Inventario> gLBI=new LinkedList<Inventario>();
    public static GestionCarritoCompras gCarrito=new GestionCarritoCompras();
    public static GestionPago gPago=new GestionPago();
    
    
    public static frmCarrito _frmCarrito=new frmCarrito();
    public static frmPago frmPago =new frmPago();
    public static frmFactura frmFactura =new frmFactura();
    public static frmVenta frmVenta =new frmVenta();
    
    
    public MDIPrincipal() {
        initComponents();
        InitStyles();
        SetDate();
        
       
 
        this.setTitle(" ");
        super.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

        //De-serializacion *
        try {
            //* inventarioArbol
            arbolInventario = (ArbolBinario) AdminSerializacion.de_serealizacion("gInventarioArbol.obj");
            if (arbolInventario == null) {
                arbolInventario = new ArbolBinario();
            }
            //* de empleado
            gEmpleado = (GestionEmpleado) AdminSerializacion.de_serealizacion("gEmpleado.obj");
            if (gEmpleado == null) {
                gEmpleado = new GestionEmpleado();
            }

            //* de Cliente
            gCliente = (GestionCliente) AdminSerializacion.de_serealizacion("gCliente.obj");
            if (gCliente == null) {
                gCliente = new GestionCliente();
            }

            //* de proveedor
            gProveedor = (GestionProveedor) AdminSerializacion.de_serealizacion("gProveedor.obj");
            if (gProveedor == null) {
                gProveedor = new GestionProveedor();
            }

            //* de Inventario
            gInventario = (GestionInventario) AdminSerializacion.de_serealizacion("gInventario.obj");
            if (gInventario == null) {
                gInventario = new GestionInventario();
            }
            
            //* de Venta
            gVenta = (GestionVenta) AdminSerializacion.de_serealizacion("gVenta.obj");
            if (gVenta == null) {
                gVenta = new GestionVenta();

            }
            
            //* factura
            gFactura = (GestionFactura) AdminSerializacion.de_serealizacion("gFactura.obj");
            if (gFactura == null) {
                gFactura = new GestionFactura();
            }
            
            //* carrito de compras
            gCarrito = (GestionCarritoCompras) AdminSerializacion.de_serealizacion("gCarrito.obj");
            if (gCarrito == null) {
                gCarrito = new GestionCarritoCompras();
            }
            
            //* pago
            gPago = (GestionPago) AdminSerializacion.de_serealizacion("gPago.obj");
            if (gPago == null) {
                gPago = new GestionPago();
            }
            
            //* el likendlist del filtro de busqueda
            gLBI= (LinkedList<Inventario>) AdminSerializacion.de_serealizacion("gInventarioLB.obj");
            if (gLBI == null) {
                gLBI = new LinkedList<Inventario>();
            }
        } catch (Exception e) {

        }
    }
    

    
    private void InitStyles() {
      
        navText.putClientProperty("FlatLaf.style", "font: bold $h3.regular.font");
        navText.setForeground(Color.white);
        dateText.putClientProperty("FlatLaf.style", "font: 24 $light.font");
        dateText.setForeground(Color.white);
        appName.putClientProperty("FlatLaf.style", "font: bold $h1.regular.font");
        appName.setForeground(Color.white);
    }
    
    private void SetDate() {
        LocalDate now = LocalDate.now();
        Locale spanishLocale = new Locale("es", "ES");
        dateText.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mnuInventarios1 = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mnuPrin = new javax.swing.JButton();
        mnuEmpleados1 = new javax.swing.JButton();
        mnuInventarios2 = new javax.swing.JButton();
        mnuProveedores1 = new javax.swing.JButton();
        mnuVentas1 = new javax.swing.JButton();
        exitMenuItem1 = new javax.swing.JButton();
        appName = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        dateText = new javax.swing.JLabel();
        navText = new javax.swing.JLabel();
        navText1 = new javax.swing.JLabel();

        mnuInventarios1.setBackground(new java.awt.Color(21, 101, 192));
        mnuInventarios1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mnuInventarios1.setForeground(new java.awt.Color(255, 255, 255));
        mnuInventarios1.setText("Inventario");
        mnuInventarios1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        mnuInventarios1.setBorderPainted(false);
        mnuInventarios1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuInventarios1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuInventarios1.setIconTextGap(13);
        mnuInventarios1.setInheritsPopupMenu(true);
        mnuInventarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInventarios1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        mnuPrin.setBackground(new java.awt.Color(0, 102, 102));
        mnuPrin.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        mnuPrin.setForeground(new java.awt.Color(255, 255, 255));
        mnuPrin.setText("Principal");
        mnuPrin.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mnuPrin.setBorderPainted(false);
        mnuPrin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuPrin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuPrin.setIconTextGap(13);
        mnuPrin.setInheritsPopupMenu(true);
        mnuPrin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrinActionPerformed(evt);
            }
        });

        mnuEmpleados1.setBackground(new java.awt.Color(0, 102, 102));
        mnuEmpleados1.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        mnuEmpleados1.setForeground(new java.awt.Color(255, 255, 255));
        mnuEmpleados1.setText("Empleados");
        mnuEmpleados1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mnuEmpleados1.setBorderPainted(false);
        mnuEmpleados1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuEmpleados1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuEmpleados1.setIconTextGap(13);
        mnuEmpleados1.setInheritsPopupMenu(true);
        mnuEmpleados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEmpleados1ActionPerformed(evt);
            }
        });

        mnuInventarios2.setBackground(new java.awt.Color(0, 102, 102));
        mnuInventarios2.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        mnuInventarios2.setForeground(new java.awt.Color(255, 255, 255));
        mnuInventarios2.setText("Inventario");
        mnuInventarios2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mnuInventarios2.setBorderPainted(false);
        mnuInventarios2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuInventarios2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuInventarios2.setIconTextGap(13);
        mnuInventarios2.setInheritsPopupMenu(true);
        mnuInventarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInventarios2ActionPerformed(evt);
            }
        });

        mnuProveedores1.setBackground(new java.awt.Color(0, 102, 102));
        mnuProveedores1.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        mnuProveedores1.setForeground(new java.awt.Color(255, 255, 255));
        mnuProveedores1.setText("Proveedores");
        mnuProveedores1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mnuProveedores1.setBorderPainted(false);
        mnuProveedores1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuProveedores1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuProveedores1.setIconTextGap(13);
        mnuProveedores1.setInheritsPopupMenu(true);
        mnuProveedores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProveedores1ActionPerformed(evt);
            }
        });

        mnuVentas1.setBackground(new java.awt.Color(0, 102, 102));
        mnuVentas1.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        mnuVentas1.setForeground(new java.awt.Color(255, 255, 255));
        mnuVentas1.setText("Ventas");
        mnuVentas1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        mnuVentas1.setBorderPainted(false);
        mnuVentas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mnuVentas1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        mnuVentas1.setIconTextGap(13);
        mnuVentas1.setInheritsPopupMenu(true);
        mnuVentas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuVentas1ActionPerformed(evt);
            }
        });

        exitMenuItem1.setBackground(new java.awt.Color(0, 102, 102));
        exitMenuItem1.setFont(new java.awt.Font("Javanese Text", 1, 18)); // NOI18N
        exitMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        exitMenuItem1.setText("Salir del Sistema");
        exitMenuItem1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        exitMenuItem1.setBorderPainted(false);
        exitMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitMenuItem1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        exitMenuItem1.setIconTextGap(13);
        exitMenuItem1.setInheritsPopupMenu(true);
        exitMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItem1ActionPerformed(evt);
            }
        });

        appName.setBackground(new java.awt.Color(255, 255, 255));
        appName.setFont(new java.awt.Font("Javanese Text", 1, 20)); // NOI18N
        appName.setForeground(new java.awt.Color(255, 255, 255));
        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setText("Grupo #1");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(appName, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(mnuVentas1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mnuProveedores1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(mnuEmpleados1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mnuPrin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mnuInventarios2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitMenuItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(appName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mnuPrin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(mnuEmpleados1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(mnuInventarios2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(mnuProveedores1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(mnuVentas1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(exitMenuItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));
        jPanel3.setFont(new java.awt.Font("Javanese Text", 0, 18)); // NOI18N

        dateText.setFont(new java.awt.Font("Javanese Text", 0, 20)); // NOI18N
        dateText.setText("{dayname} {day} de {month} de {year}");

        navText.setFont(new java.awt.Font("Javanese Text", 1, 20)); // NOI18N
        navText.setText("Bienvenido a Nuestro Sistema");

        navText1.setFont(new java.awt.Font("Javanese Text", 0, 20)); // NOI18N
        navText1.setForeground(new java.awt.Color(255, 255, 255));
        navText1.setText("Ferretería Java");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(navText1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(navText, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(navText1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(dateText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        desktopPane.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuPrinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrinActionPerformed

    }//GEN-LAST:event_mnuPrinActionPerformed

    private void mnuEmpleados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEmpleados1ActionPerformed

        frmEmpleado frm1 = new frmEmpleado();
        Dimension jInternal = frm1.getSize();

        Dimension desktopSize = this.getSize();

        frm1.setLocation((desktopSize.width - jInternal.width) / 2, (desktopSize.height - jInternal.height) / 2);

        this.desktopPane.add(frm1);
        frm1.setVisible(true);
    }//GEN-LAST:event_mnuEmpleados1ActionPerformed

    private void mnuInventarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInventarios1ActionPerformed

        //funcion para ejecutar el formulario de gestion de funciones

        frmInventario frm1 = new frmInventario();
        Dimension jInternal = frm1.getSize();

        Dimension desktopSize = this.getSize();

        frm1.setLocation((desktopSize.width - jInternal.width) / 2, (desktopSize.height - jInternal.height) / 2);

        frm1.setVisible(true);
    }//GEN-LAST:event_mnuInventarios1ActionPerformed

    private void mnuInventarios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInventarios2ActionPerformed

        //funcion para ejecutar el formulario de gestion de funciones

        frmInventario frm1 = new frmInventario();
        Dimension jInternal = frm1.getSize();

        Dimension desktopSize = this.getSize();

        frm1.setLocation((desktopSize.width - jInternal.width) / 2, (desktopSize.height - jInternal.height) / 2);

        this.desktopPane.add(frm1);
        frm1.setVisible(true);
    }//GEN-LAST:event_mnuInventarios2ActionPerformed

    private void mnuProveedores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProveedores1ActionPerformed

         frmProveedor frm1 = new frmProveedor();
        Dimension jInternal = frm1.getSize();

        Dimension desktopSize = this.getSize();

        frm1.setLocation((desktopSize.width - jInternal.width) / 2, (desktopSize.height - jInternal.height) / 2);

        this.desktopPane.add(frm1);
        frm1.setVisible(true);
    }//GEN-LAST:event_mnuProveedores1ActionPerformed

    private void mnuVentas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuVentas1ActionPerformed

        frmVenta frm1 = new frmVenta();
        Dimension jInternal = frm1.getSize();

        Dimension desktopSize = this.getSize();

        frm1.setLocation((desktopSize.width - jInternal.width) / 2, (desktopSize.height - jInternal.height) / 2);

        this.desktopPane.add(frm1);
        frm1.setVisible(true);
    }//GEN-LAST:event_mnuVentas1ActionPerformed

    private void exitMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItem1ActionPerformed

        System.exit(0);
    }//GEN-LAST:event_exitMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MDIPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MDIPrincipal().setVisible(true);
            }
        });
    }
    
    
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appName;
    private javax.swing.JLabel dateText;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JButton exitMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mnuEmpleados1;
    private javax.swing.JButton mnuInventarios1;
    private javax.swing.JButton mnuInventarios2;
    private javax.swing.JButton mnuPrin;
    private javax.swing.JButton mnuProveedores1;
    private javax.swing.JButton mnuVentas1;
    private javax.swing.JLabel navText;
    private javax.swing.JLabel navText1;
    // End of variables declaration//GEN-END:variables

}
