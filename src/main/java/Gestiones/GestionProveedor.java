/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Gestiones;

import Clases.*;
import java.io.Serializable;
import java.util.LinkedList;

public class GestionProveedor implements Serializable {

    private LinkedList<Proveedor> proveedores = new LinkedList<>();

    public int buscarProveedor(int codigo) {
        int posicion = -1;
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getCodigoProveedor() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public boolean agregarProveedor(Proveedor proveedor) {

        if (buscarProveedor(proveedor.getCodigoProveedor()) == -1) {
            proveedores.add(proveedor);
            return true;
        } else {
            return false;
        }
    }

    public Proveedor getProveedorByIndex(int indice) {
        return proveedores.get(indice);
    }

    //Hace uso del buscarPorCodigo para aplicar la modificacion 
    public boolean modificarProveedor(Proveedor proveedorMod, int posicion) {
        if (posicion < 0 || posicion > proveedores.size()) {
            return false;
        } else {
            int posicionEncontrada = buscarProveedor(proveedorMod.getCodigoProveedor());

            if (posicionEncontrada == -1 || posicionEncontrada == posicion) {
                proveedores.set(posicion, proveedorMod);
                return true;
            } else {
                return false;
            }
        }
    }

    //este es para la tabla del form
    public Object[][] getArrayGestion() {
        Object[][] array = new Object[this.proveedores.size()][3];
        for (int i = 0; i < proveedores.size(); i++) {
            array[i][0] = proveedores.get(i).getCodigoProveedor();
            array[i][1] = proveedores.get(i).getEmpresa();
            array[i][2] = proveedores.get(i).getTelefono();

        }
        return array;
    }

    public Proveedor buscar(int codigoProveedor) {
        int posicion = buscarProveedor(codigoProveedor);
        if (posicion == -1) {
            return null;
        } else {
            return proveedores.get(posicion);
        }
    }

    public boolean eliminarProveedor(int indice) {
        proveedores.remove(indice);
        return true;
    }

    public String getInfoReporte() {
        String _resultado = "";
        for (int i = 0; i < proveedores.size(); i++) {
            _resultado += proveedores.get(i).toString() + "\n";
        }
        return _resultado;
    }

    public LinkedList<Proveedor> getProveedores() {
        return proveedores;
    }
}
