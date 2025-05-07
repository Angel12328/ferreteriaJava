/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author angel
 */
public class CarritoCompras implements Serializable{
    Inventario _Producto;
    int _cantidadCompra;

    public CarritoCompras() {
    }

    public CarritoCompras(Inventario _Producto, int _cantidadCompra) {
        this._Producto = _Producto;
        this._cantidadCompra = _cantidadCompra;
    }

    public Inventario getProducto() {
        return _Producto;
    }

    public int getCantidadCompra() {
        return _cantidadCompra;
    }

    public void setProducto(Inventario _Producto) {
        this._Producto = _Producto;
    }

    public void setCantidadCompra(int _cantidadCompra) {
        this._cantidadCompra = _cantidadCompra;
    }

    @Override
    public String toString() {
        return  "Producto: " + _Producto.getNombreProducto() + "\n"
                + "Precio: " + _Producto.getPrecio() + "\n"
                + "Cantidad: " + _cantidadCompra +"\n";
    }
    
}
