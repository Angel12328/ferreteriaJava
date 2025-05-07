/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Clases;

import java.io.Serializable;

public class Proveedor implements Serializable {

    //Varibles
    private int codigoProveedor;
    private String empresa;
    private String telefono;

    //Contructor
    public Proveedor() {
    }

    public Proveedor(int codigoProveedor, String empresa, String telefono) {
        this.codigoProveedor = codigoProveedor;
        this.empresa = empresa;
        this.telefono = telefono;
    }


    //getters y setters
    
    
    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {

        if (codigoProveedor < 1) {
            throw new IllegalArgumentException("El codigo no puede ser negativo.");
        } else {
            this.codigoProveedor = codigoProveedor;
        }

    }
    
    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {

        if (empresa.equals("")) {
            throw new IllegalArgumentException("La empresa es obligatoria");
        } else {
            this.empresa = empresa;
        }

    }
    
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (telefono.equals("")) {
            throw new IllegalArgumentException("El telefono es obligatorio");
        } else {
            this.telefono = telefono;
        }

    }

    //toString
    @Override
    public String toString() {
        return "---------- PROVEEDOR ----------\n"
                + "Código: " + codigoProveedor + "\n"
                + "Nombre: " + empresa + "\n"
                + "Teléfono: " + telefono + "\n"
                + "--------------------------------";
    }

}
