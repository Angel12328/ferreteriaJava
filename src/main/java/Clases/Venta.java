/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author bayron
 */
public class Venta implements Serializable {

    //Variable
    private int codigoVenta;
    private Cliente cliente;
    private Inventario inventario;

    //Constructor

    public Venta() {
    }
    

    public Venta(int codigoVenta, Cliente cliente, Inventario inventario) {
        this.codigoVenta = codigoVenta;
        this.cliente = cliente;
        this.inventario = inventario;
    }
    

    //getters y setters
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {

        if (codigoVenta < 1) {
            throw new IllegalArgumentException("El codigo no puede ser negativo");
        } else {
            this.codigoVenta = codigoVenta;
        }

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException("El cliente es obligatorio");
        } else {
            this.cliente = cliente;
        }

    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        
        if (inventario == null) {
            throw new IllegalArgumentException("El producto es obligatorio");
        } else {
            this.inventario = inventario;
        }
        
    }

    //toString
    @Override
    public String toString() {
        return "---------- VENTA ----------\n"
                + "Código: " + codigoVenta + "\n"
                + "Cliente: " + cliente.getNombre() + "\n"
                + "Producto: " + inventario.getNombreProducto() + "\n"
                + "----------------------------";
    }

}