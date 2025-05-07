/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Gestiones;

import Arboles.ArbolBinario;
import Clases.*;
import GUI.MDIPrincipal;
import Main.Main;
import Util.AdminSerializacion;
import java.io.Serializable;
import java.util.LinkedList;

public class GestionInventario implements Serializable {
    // Instanciar un arbol para que almancene los productos
    private LinkedList<Inventario> inventarios = new LinkedList<>();
    //private ArbolBinario inventario=new ArbolBinario();

    public int buscarInventario(int codigo) {
        int posicion = -1;
        for (int i = 0; i < inventarios.size(); i++) {
            if (inventarios.get(i).getCodigoInventario() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    //para trabajar en la seccion de venta
    public void buscarInventarioPorNombre(String nomProduct,String _busqueda) {
        Inventario auxInv=new Inventario();
        auxInv.setNombreProducto(nomProduct);
        MDIPrincipal.arbolInventario.buscarProductoInOrden(MDIPrincipal.arbolInventario.getRaiz(), auxInv, MDIPrincipal.gLBI,_busqueda);
    }
    //para la seccion de venta
    public boolean agregarInventario(Inventario inventario) {
        MDIPrincipal.arbolInventario.agregar(inventario);
        //AdminSerializacion.serializacion(Main.gArbolInv, "gArbolInv.obj");
        if (buscarInventario(inventario.getCodigoInventario()) == -1) {
            inventarios.add(inventario);
            return true;
        } else {
            return false;
        }
    }

    public Inventario getInventarioByIndex(int indice) {
        return inventarios.get(indice);
    }

    //Hace uso del buscarPorCodigo para aplicar la modificacion 
    public boolean modificarInventario(Inventario inventarioMod, int posicion) {
        MDIPrincipal.arbolInventario.modificarPorductoArbol(MDIPrincipal.arbolInventario.getRaiz(), inventarioMod);
        if (posicion < 0 || posicion > inventarios.size()) {
            return false;
        } else {
            int posicionEncontrada = buscarInventario(inventarioMod.getCodigoInventario());

            if (posicionEncontrada == -1 || posicionEncontrada == posicion) {
                inventarios.set(posicion, inventarioMod);
                return true;
            } else {
                return false;
            }
        }
    }

    //este es para la tabla del form
    public Object[][] getArrayGestion() {
        Object[][] array = new Object[this.inventarios.size()][5];
        for (int i = 0; i < inventarios.size(); i++) {
            array[i][0] = inventarios.get(i).getCodigoInventario();
            array[i][1] = inventarios.get(i).getNombreProducto();
            array[i][2] = inventarios.get(i).getPrecio();
            array[i][3] = inventarios.get(i).getStock();
            array[i][4] = inventarios.get(i).getProveedor().getEmpresa();
        }
        return array;
    }
    
    //este es para la tabla del form en al busqueda hecha por el cliente
    public Object[][] getArrayGestionFiltro() {
        Object[][] array = new Object[MDIPrincipal.gLBI.size()][2];
        for (int i = 0; i < MDIPrincipal.gLBI.size(); i++) {
            array[i][0] = MDIPrincipal.gLBI.get(i).getNombreProducto();
            array[i][1] = MDIPrincipal.gLBI.get(i).getPrecio();

        }
        return array;
    }

    public Inventario buscar(int codigoInventario) {
        int posicion = buscarInventario(codigoInventario);
        if (posicion == -1) {
            return null;
        } else {
            return inventarios.get(posicion);
        }
    }

    public boolean eliminarInventario(int indice) {
        inventarios.remove(indice);
        
        return true;
    }

    public String getInfoReporte() {
        String _resultado = "";
        for (int i = 0; i < inventarios.size(); i++) {
            _resultado += inventarios.get(i).toString() + "\n";
        }
        return _resultado;
    }

    public LinkedList<Inventario> getInventarios() {
        return inventarios;
    }
}
