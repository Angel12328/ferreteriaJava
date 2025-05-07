/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplodenoche;

import Clases.*;
import Gestiones.*;

/**
 * @author jazmi
 */
public class EjemploDeNoche {

    public static void main(String[] args) {
        GestionInventario gestionInventario = new GestionInventario();
        GestionPago gestionPago = new GestionPago();
        
        Proveedor proveedor = new Proveedor(1, "Proveedor Test", "555-1234");
        Inventario producto = new Inventario(101, "Martillo", 15.99, 10, proveedor);
        gestionInventario.agregarInventario(producto);

        Cliente cliente = new Cliente(1, "Cliente Test", "555-5678");

        Venta venta = new Venta(1001, cliente, producto );
        venta.setInventario(producto);

        /*Pago pago = new Pago(5001, venta, 15.99, "EFECTIVO");
        pago.setMontoRecibido(20.00);
        gestionPago.agregarPago(pago);

        System.out.println("=== ANTES DEL PAGO ===");
        System.out.println("Stock inicial: " + producto.getStock());
        System.out.println("Estado pago: " + pago.getEstado());
        
        boolean resultado = gestionPago.procesarPago(5001, gestionInventario);
  
        System.out.println("\n=== DESPUÉS DEL PAGO ===");
        System.out.println("Resultado del pago: " + (resultado ? "APROBADO" : "RECHAZADO"));
        System.out.println("Stock actualizado: " + producto.getStock());
        System.out.println("Estado pago: " + pago.getEstado());
        System.out.println("Cambio: " + pago.calcularCambio());

        System.out.println("\n=== PRUEBAS DE BÚSQUEDA ===");
        System.out.println("Buscar por código pago: " + gestionPago.buscarPorCodigo(5001));
        System.out.println("Buscar por código venta: " + gestionPago.buscarPorVenta(1001));
        System.out.println("Venta pagada?: " + gestionPago.ventaPagada(1001));*/
    
    }
}
