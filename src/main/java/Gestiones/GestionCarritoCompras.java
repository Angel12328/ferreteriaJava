/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;

import Clases.CarritoCompras;
import GUI.MDIPrincipal;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author angel
 */
public class GestionCarritoCompras implements Serializable{
    private LinkedList<CarritoCompras> carritoComp=new LinkedList<CarritoCompras>();
    
    
    
    public void agregar(CarritoCompras _producto){
        carritoComp.add(_producto);
    }
    
    public void mostrarCarrito(){
        for (int i = 0; i < carritoComp.size(); i++) {
            System.out.println(carritoComp.get(i).toString());
        }
    }

    public Object[][] getArrayGestion() {
        Object[][] array = new Object[this.carritoComp.size()][3];
        for (int i = 0; i < this.carritoComp.size(); i++) {
            array[i][0] = this.carritoComp.get(i).getProducto().getNombreProducto();
            array[i][1] = this.carritoComp.get(i).getCantidadCompra();
            array[i][2] = this.carritoComp.get(i).getProducto().getPrecio();

        }
        return array;
    }
    
    public Object[][] getArrayGestionFactura() {
        Object[][] array = new Object[this.carritoComp.size()][4];
        for (int i = 0; i < this.carritoComp.size(); i++) {
            array[i][0] = this.carritoComp.get(i).getProducto().getNombreProducto();
            array[i][1] = this.carritoComp.get(i).getCantidadCompra();
            array[i][2] = this.carritoComp.get(i).getProducto().getPrecio();
            array[i][3] = Math.round((this.carritoComp.get(i).getProducto().getPrecio()*this.carritoComp.get(i).getCantidadCompra())*100.0)/100.0;

        }
        return array;
    }

    @Override
    public String toString() {
        return "GestionCarritoCompras{" + "carritoComp=" + carritoComp.toString() + '}';
    }


    public LinkedList<CarritoCompras> getCarritoComp() {
        return carritoComp;
    }

}
