/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */

package Clases;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    //Las variables
    private String direccion;
    private String correo;
    private String cargo;
    private double salario;

    //El constructor
    public Empleado() {
    }

    public Empleado(int codigo, String nombre, String telefono, String direccion, String correo, String cargo, double salario) {
        super(codigo, nombre, telefono);
        this.direccion = direccion;
        this.correo = correo;
        this.cargo = cargo;
        this.salario = salario;
    }

    //getters y setters
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        
        if(direccion.equals("")){
            throw new IllegalArgumentException("La direccion es obligatoria");
        }else{
            this.direccion = direccion;
        }
        
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        
        if(direccion.equals("")){
            throw new IllegalArgumentException("El correo es obligatorio");
        }else{
            this.correo = correo;
        }
        
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        
        if(cargo.equals("")){
            throw new IllegalArgumentException("El cargo es obligatorio");
        }else{
            this.cargo = cargo;
        }
        
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        
        if(salario<1){
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }else{
            this.salario = salario;
        }
        
    }

    //el toString 
    @Override
    public String toString() {
        return "---------- EMPLEADO ----------\n"
                + "Código: " + codigo + "\n"
                + "Nombre: " + nombre + "\n"
                + "Teléfono: " + telefono + "\n"
                + "Dirección: " + direccion + "\n"
                + "Correo: " + correo + "\n"
                + "Cargo: " + cargo + "\n"
                + "Salario: " + salario + "\n"
                + "------------------------------";
    }

}
