/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */

package Clases;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

    //El constructor
	
    public Cliente(){
        //constructo por defecto
    }
    public Cliente(int codigo, String nombre, String telefono) {
    super(codigo, nombre, telefono);
    }

    

    //el toString
    @Override
    public String toString() {
        return "---------- CLIENTE ----------\n" +
                "Código: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Teléfono: " + telefono + "\n" +
                "----------------------------";
    }

}
