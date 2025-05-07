/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;

import Clases.Venta;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author bayron
 */
public class GestionVenta implements Serializable {

    private LinkedList<Venta> ventas = new LinkedList<>();

    public int buscarVenta(int codigo) {
        int posicion = -1;
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getCodigoVenta() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public boolean agregarVenta(Venta venta) {

        if (buscarVenta(venta.getCodigoVenta()) == -1) {
            ventas.add(venta);
            return true;
        } else {
            return false;
        }
    }

    public Venta getVentaByIndex(int indice) {
        return ventas.get(indice);
    }

    //Hace uso del buscarPorCodigo para aplicar la modificacion 
    public boolean modificarVenta(Venta ventaMod, int posicion) {
        if (posicion < 0 || posicion > ventas.size()) {
            return false;
        } else {
            int posicionEncontrada = buscarVenta(ventaMod.getCodigoVenta());

            if (posicionEncontrada == -1 || posicionEncontrada == posicion) {
                ventas.set(posicion, ventaMod);
                return true;
            } else {
                return false;
            }
        }
    }

    //este es para la tabla del form
    public Object[][] getArrayGestion() {
        Object[][] array = new Object[this.ventas.size()][3];
        for (int i = 0; i < ventas.size(); i++) {
            array[i][0] = ventas.get(i).getCodigoVenta();
            array[i][1] = ventas.get(i).getCliente().getNombre();
            array[i][2] = ventas.get(i).getInventario().getNombreProducto();

        }
        return array;
    }

    public Venta buscar(int codigoVenta) {
        int posicion = buscarVenta(codigoVenta);
        if (posicion == -1) {
            return null;
        } else {
            return ventas.get(posicion);
        }
    }

    public boolean eliminarVenta(int indice) {
        ventas.remove(indice);
        return true;
    }

    public String getInfoReporte() {
        String _resultado = "";
        for (int i = 0; i < ventas.size(); i++) {
            _resultado += ventas.get(i).toString() + "\n";
        }
        return _resultado;
    }

    public LinkedList<Venta> getVentas() {
        return ventas;
    }
}