/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Clases;

import java.io.Serializable;

public class Inventario implements Serializable {

    //Variables
    private int codigoInventario;
    private String nombreProducto;
    private double precio;
    private int stock;
    private Proveedor proveedor;

    //Contructor
    public Inventario() {
    }

    public Inventario(int codigoInventario, String nombreProducto, double precio, int stock, Proveedor proveedor) {
        this.codigoInventario = codigoInventario;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    

    //getters y setters
    public int getCodigoInventario() {
        return codigoInventario;
    }

    public void setCodigoInventario(int codigoInventario) {

        if (codigoInventario < 1) {
            throw new IllegalArgumentException("El codigo no puede ser negativo");
        } else {
            this.codigoInventario = codigoInventario;
        }

    }

    
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {

        if (nombreProducto.equals("")) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        } else {
            this.nombreProducto = nombreProducto;
        }

    }
    
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {

        if (precio<0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        } else {
            this.precio = precio;
        }

    }
    
    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {

        if (stock<0) {
            throw new IllegalArgumentException("El Stock no puede ser negativo.");
        } else {
            this.stock = stock;
        }

    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {

        if (proveedor == null) {
            throw new IllegalArgumentException("El proveedor es obligatorio");
        } else {
            this.proveedor = proveedor;
        }

    }

    //toString
    @Override
    public String toString() {
        return "---------- INVENTARIO ----------\n"
                + "Código: " + codigoInventario + "\n"
                + "Producto: " + nombreProducto + "\n"
                + "Precio: " + precio + "\n"
                + "Stock: " + stock + "\n"
                + "Proveedor: " + proveedor.getEmpresa() + "\n"
                + "--------------------------------";
    }

}
