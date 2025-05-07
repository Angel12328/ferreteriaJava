/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arboles;

import Clases.Inventario;
import java.io.Serializable;
import java.util.LinkedList;


/**
 *
 * @author angel
 */
public class ArbolBinario implements Serializable{
    private Nodo _raiz;
    int _nivel;
    public ArbolBinario() {
        this._raiz=null;
    }

    public Nodo getRaiz() {
        return _raiz;
    }
    
    public boolean estaVacio(){  
        return this._raiz==null;
    }
    
    public void agregar(Inventario _producSet){
        if (this.estaVacio()){
            //para nodo raiz
            Nodo nodo=new Nodo();
            nodo.setProducto(_producSet);
            nodo.setNivel(0);
            this._raiz=nodo;
            this._nivel=0;
            System.out.println("\nPRODUCTO AGREGADO CORRECTAMENTE\n");
        }else{
            if(this.inOrdenVerif(_raiz, _producSet)==false){
                //si el nivel tiene el numero maximo de nodos
                if(this.numNodosNiv(_raiz, _nivel)==Math.pow(2, _nivel)){
                    //wdwdw
                    this._nivel++;
                    Nodo _nodoCap;
                    Nodo _newNodo= new Nodo();
                    _nodoCap=this.inOrdenCaptNod(this._raiz);
                    
                    _newNodo.setProducto(_producSet);
                    _newNodo.setNivel(_nivel);
                    
                    //si solo esta la raiz es el padre del nodo add 
                    if(this._raiz.getIzq()==null|| this._raiz.getDer()==null){
                        _newNodo.setPadre(this._raiz);
                    } 
                    else{
                        _newNodo.setPadre(_nodoCap);
                    }
                    
                    //agrega las referencias
                    if(_nodoCap.getIzq()==null){
                        _nodoCap.setIzq(_newNodo);
                    }else{
                        _nodoCap.setDer(_newNodo);
                    }
                    System.out.println("\nPRODUCTO AGREGADO CORRECTAMENTE\n");
                    //si el nivel no ha completado el maximo de nodos
                }else if(this.numNodosNiv(_raiz, _nivel)<=Math.pow(2, _nivel)){
                    Nodo _nodoCap;
                    Nodo _newNodo= new Nodo();
                    _nodoCap=this.inOrdenCaptNod(this._raiz);
                    
                    _newNodo.setProducto(_producSet);
                    _newNodo.setNivel(_nivel);
                    
                   //si solo esta la raiz es el padre del nodo add 
                    if(this._raiz.getIzq()==null|| this._raiz.getDer()==null){
                        _newNodo.setPadre(this._raiz);
                    } 
                    else{
                        _newNodo.setPadre(_nodoCap.getPadre());
                    }
                    
                    //agrega las referencias
                    if(_nodoCap.getIzq()==null){
                        _nodoCap.setIzq(_newNodo);
                    }else{
                        _nodoCap.setDer(_newNodo);
                    }
                    System.out.println("\nPRODUCTO AGREGADO CORRECTAMENTE\n");
                }else{
                    System.out.println("\nPRODUCTO FUE AGREGADO\n");
                }
                
            }
            else{
                System.out.println("\nPRODUCTO YA ESTA EN EL SISTEMA\n");
            }
        }
    }
    
    //Verifica inOrden si el codigo del nodo ingresado ya esta
    public boolean inOrdenVerif(Nodo _raiz,Inventario _producSet){
        // para al ser null el nodo
        if(_raiz==null){
            return false;
        }
        
        // se mueve en el subarbol derecho
        if(this.inOrdenVerif(_raiz.getIzq(), _producSet)){
            return true;
        
        }
        
        // analiza el nodo actual 
        if (_raiz.getProducto().getCodigoInventario()==_producSet.getCodigoInventario()){
            return true;
        }
        
        //Si  no esta en el subarbol derecho busca en el subarbol derercho
        return this.inOrdenVerif(_raiz.getDer(), _producSet);
        
        
    }
    

    //modifica un producto en el arbol
    public boolean modificarPorductoArbol(Nodo _raiz,Inventario _producSet){
        // para al ser null el nodo
        if(_raiz==null){
            return false;
        }
        
        // se mueve en el subarbol derecho
        if(this.modificarPorductoArbol(_raiz.getIzq(), _producSet)){
            return true;
        
        }
        
        // analiza el nodo actual 
        if (_raiz.getProducto().getCodigoInventario()==_producSet.getCodigoInventario()){
            _raiz.setProducto(_producSet);
            return true;
        }
        
        //Si  no esta en el subarbol derecho busca en el subarbol derercho
        return this.modificarPorductoArbol(_raiz.getDer(), _producSet);
        
        
    }

    
    // da el numero de nodos en un nivel
    public int numNodosNiv(Nodo _nodo,int _nivelBusc){
        //no cuanta el nodo si es nulo
        if(_nodo==null){
            return 0;
        }
        //va contando si va coincidiendo con el nivel buscado
        if(_nodo.getNivel()==_nivelBusc){
            return 1;
        }
        // retornara el numero de nodos del nivel
        return this.numNodosNiv(_nodo.getIzq(),_nivelBusc)+ this.numNodosNiv(_nodo.getDer(), _nivelBusc);
    }
    
    //da un nodo antes del ultimo nivel que tiene alguno o todos sus referencias nodos der y izq null
    public Nodo inOrdenCaptNod(Nodo _nodo){
        if(_nodo==null){
            return null;
        }
        
        Nodo aux=this.inOrdenCaptNod(_nodo.getIzq());
        if(aux!=null){
            return aux;
        }
        if(_nodo.getNivel()<this._nivel && (_nodo.getIzq()==null ||_nodo.getDer()==null)){
            return _nodo;
        }
        return this.inOrdenCaptNod(_nodo.getDer());
    }
    
    //busca producto por codigo
    public Nodo buscarProductoInOrdenPorCod(Nodo _nodo,int _codProduc){
        if(_nodo==null){
            return null;           
        }
        
        Nodo nodIzq=this.buscarProductoInOrdenPorCod(_nodo.getIzq(), _codProduc); // 1/ al aplicarlo solo lo haria con this.buscarProductoInOrden(_nodo.getIzq(), _producSet);
        if(nodIzq!=null){
            return nodIzq;
        }
        
        if(_nodo.getProducto().getCodigoInventario()==_codProduc){
            return _nodo; //aca mas adelante puedo almacenarla en una lista etc. 1/
        }
        
        return this.buscarProductoInOrdenPorCod(_nodo.getDer(), _codProduc); // 1/ al aplicarlo solo lo haria con this.buscarProductoInOrden(_nodo.getDer(), _producSet);
        
    }
    

    //busca por nombre de producto
    public void buscarProductoInOrden(Nodo _nodo,Inventario _producSet,LinkedList<Inventario> _listInv,String _busqueda){
        if(_nodo==null){
            return;           
        }
        
        this.buscarProductoInOrden(_nodo.getIzq(), _producSet, _listInv,_busqueda);
        
        if(_nodo.getProducto().getNombreProducto().substring(0, _busqueda.length()).equals(_busqueda)){
            _listInv.add(_nodo.getProducto());
        }
        
        this.buscarProductoInOrden(_nodo.getDer(), _producSet,_listInv,_busqueda); 
        
    }
    
    
     
    public void mostrarInOrden(Nodo nodo){
        if(nodo==null){
            return;
        }
        this.mostrarInOrden(nodo.getIzq());
        System.out.println("Producto: " + nodo.getProducto().getNombreProducto());
        this.mostrarInOrden(nodo.getDer());
    }

    @Override
    public String toString() {
        return "ArbolBinario{" + "_raiz=" + _raiz + ", _nivel=" + _nivel + '}';
    }
    
    
}
