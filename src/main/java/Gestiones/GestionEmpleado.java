/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Gestiones;

import Clases.*;
import java.io.Serializable;
import java.util.LinkedList;

public class GestionEmpleado implements Serializable {

    //Definiendo la lista
    private LinkedList<Empleado> empleados = new LinkedList<>();

    public int buscarEmpleado(int codigo) {
        int posicion = -1;
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getCodigo() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public boolean agregarEmpleado(Empleado empleado) {

        if (buscarEmpleado(empleado.getCodigo()) == -1) {
            empleados.add(empleado);
            return true;
        } else {
            return false;
        }
    }

    public Empleado getEmpleadoByIndex(int indice) {
        return empleados.get(indice);
    }

    //Hace uso del buscarPorCodigo para aplicar la modificacion 
    public boolean modificarEmpleado(Empleado empleadoMod, int posicion) {
        if (posicion < 0 || posicion > empleados.size()) {
            return false;
        } else {
            int posicionEncontrada = buscarEmpleado(empleadoMod.getCodigo());

            if (posicionEncontrada == -1 || posicionEncontrada == posicion) {
                empleados.set(posicion, empleadoMod);
                return true;
            } else {
                return false;
            }
        }
    }

    //este es para la tabla del form
    public Object[][] getArrayGestion() {
        Object[][] array = new Object[this.empleados.size()][7];
        for (int i = 0; i < empleados.size(); i++) {
            array[i][0] = empleados.get(i).getCodigo();
            array[i][1] = empleados.get(i).getNombre();
            array[i][2] = empleados.get(i).getTelefono();
            array[i][3] = empleados.get(i).getDireccion();
            array[i][4] = empleados.get(i).getCorreo();
            array[i][5] = empleados.get(i).getCargo();
            array[i][6] = empleados.get(i).getSalario();

        }
        return array;
    }

    public Empleado buscar(int codigoEmpleado) {
        int posicion = buscarEmpleado(codigoEmpleado);
        if (posicion == -1) {
            return null;
        } else {
            return empleados.get(posicion);
        }
    }

    public boolean eliminarEmpleado(int indice) {
        empleados.remove(indice);
        return true;
    }

    public String getInfoReporte() {
        String _resultado = "";
        for (int i = 0; i < empleados.size(); i++) {
            _resultado += empleados.get(i).toString() + "\n";
        }
        return _resultado;
    }

    public LinkedList<Empleado> getEmpleados() {
        return empleados;
    }
}
