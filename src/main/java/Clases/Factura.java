/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Clases;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public class Factura implements Serializable {

    //variables
    private int codigoFactura;
    private Date fecha;
    private Cliente cliente;
    private Empleado empleado;
    private double montoTotal;
    private double impuesto;
    private double descuento;
    private double subtotal;

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    private LinkedList<CarritoCompras> carrito = new LinkedList<>(); //CORREGIR AQUI ES UN LIKENLIST<CarritoCompras>

    //constructor
    public Factura() {
    }

    public Factura(int codigoFactura, Date fecha, Cliente cliente, Empleado empleado, double montoTotal, double impuesto, double descuento, double subtotal) {
        this.codigoFactura = codigoFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.empleado = empleado;
        this.montoTotal = montoTotal;
        this.impuesto = impuesto;
        this.descuento = descuento;
        this.subtotal = subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public LinkedList<CarritoCompras> getCarrito() {
        return carrito;
    }

    public void setCarrito(LinkedList<CarritoCompras> carrito) {
        this.carrito = carrito;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(int codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder factura = new StringBuilder();

        factura.append("---------- FACTURA ----------\n");
        factura.append("Código: ").append(codigoFactura).append("\n");
        factura.append("Fecha: ").append(fecha).append("\n");
        factura.append("Cliente: ").append(cliente.getNombre()).append("\n");
        factura.append("Empleado: ").append(empleado.getNombre()).append("\n");

        for (int i = 0; i < carrito.size(); i++) {
            factura.append(carrito.get(i));
        }

        factura.append("Impuesto S/V: ").append(this.impuesto).append("\n");
        factura.append("Monto Total: L").append(montoTotal).append("\n");
        factura.append("----------------------------");
        
        
        return factura.toString();

        /*+ "Código: " + codigoFactura + "\n"
                + "Fecha: " + fecha + "\n"
                + "Cliente: " + cliente.getNombre()+"\n"
                + "Empleado: " + empleado.getNombre() + "\n"
                + carrito.toString() + "\n" +
                
                + "Impuesto S/V: " + this.impuesto + "\n"
                + "Monto Total: L" + (montoTotal) + "\n"
                + "----------------------------";
         */
    }

}
