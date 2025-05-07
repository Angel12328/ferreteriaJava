/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Clases;

import java.io.Serializable;

public abstract class Persona implements Serializable {

    //Las variables
    protected int codigo;
    protected String nombre;
    protected String telefono;

    //El constructor
    public Persona() {
    }

    public Persona(int codigo, String nombre, String telefono) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo < 1) {
            throw new IllegalArgumentException("El codigo no puede ser negativo");
        } else {
            this.codigo = codigo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre.equals("")) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        } else {
            this.nombre = nombre;
        }

    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //el toString 
    @Override
    public String toString() {
        return "[codigo=" + codigo + ", nombre=" + nombre + ", telefono=" + telefono
                + "]";
    }

}
