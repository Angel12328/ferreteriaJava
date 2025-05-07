/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import Clases.Inventario;
import java.io.Serializable;

/**
 *
 * @author angel
 */
public class Nodo implements Serializable{
    private Inventario _producto;
    private Nodo _padre;
    private Nodo _izq,_der;
    private int _nivel;
    private boolean _esIzq;
    private boolean _esDer;
    private boolean _esHoja;

    public Nodo() {
    }

    public Nodo(Inventario _producto, Nodo _padre, Nodo _izq, Nodo _der, int _nivel, boolean _esIzq, boolean _esDer, boolean _esHoja) {
        this._producto = _producto;
        this._padre = _padre;
        this._izq = _izq;
        this._der = _der;
        this._nivel = _nivel;
        this._esIzq = _esIzq;
        this._esDer = _esDer;
        this._esHoja = _esHoja;
    }

    public Inventario getProducto() {
        return _producto;
    }

    public Nodo getPadre() {
        return _padre;
    }

    public Nodo getIzq() {
        return _izq;
    }

    public Nodo getDer() {
        return _der;
    }

    public int getNivel() {
        return _nivel;
    }

    public boolean isEsIzq() {
        return _esIzq;
    }

    public boolean isEsDer() {
        return _esDer;
    }

    public boolean isEsHoja() {
        return _esHoja;
    }

    public void setProducto(Inventario _producto) {
        this._producto = _producto;
    }

    public void setPadre(Nodo _padre) {
        this._padre = _padre;
    }

    public void setIzq(Nodo _izq) {
        this._izq = _izq;
    }

    public void setDer(Nodo _der) {
        this._der = _der;
    }

    public void setNivel(int _nivel) {
        this._nivel = _nivel;
    }

    public void setEsIzq(boolean _esIzq) {
        this._esIzq = _esIzq;
    }

    public void setEsDer(boolean _esDer) {
        this._esDer = _esDer;
    }

    public void setEsHoja(boolean _esHoja) {
        this._esHoja = _esHoja;
    }

    @Override
    public String toString() {
        return "Nodo{" + "_producto=" + _producto + ", _padre=" + _padre + ", _izq=" + _izq + ", _der=" + _der + ", _nivel=" + _nivel + ", _esIzq=" + _esIzq + ", _esDer=" + _esDer + ", _esHoja=" + _esHoja + '}';
    }

    
    
      
    
}


