/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;


import Clases.Factura;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author angel
 */
public class GestionFactura implements Serializable {
    private LinkedList<Factura> facturas = new LinkedList<>();
    
    private int  _numFacturas;

    public LinkedList<Factura> getFacturas() {
        return facturas;
    }
    
    public int buscarFactura(int codigo) {
        int posicion = -1;
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getCodigoFactura() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    
    public boolean agregarFactura(Factura factura) {
        
        //AdminSerializacion.serializacion(Main.gArbolInv, "gArbolInv.obj");
        if (buscarFactura(factura.getCodigoFactura()) == -1) {
            facturas.add(factura);
            return true;
        } else {
            return false;
        }
    }
    
    public Factura getInventarioByIndex(int indice) {
        return facturas.get(indice);
    }
    
    public String getInfoReporte() {
        String _resultado = "";
        for (int i = 0; i < facturas.size(); i++) {
            _resultado += facturas.get(i).toString() + "\n";
        }
        return _resultado;
    }
}
