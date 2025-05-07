/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Clases;
import Gestiones.GestionCarritoCompras;
import Gestiones.GestionInventario;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jazmi
 */
public class Pago implements Serializable {
    private int codigoPago;
    private Cliente cliente;
    private GestionCarritoCompras carrito;
    private double subTotal;       // Suma de productos sin impuestos/descuentos
    private double descuento;      
    private double impuesto;       
    private double totalPagar;     // Total después de descuentos e impuestos
    private String metodoPago;     // EFECTIVO o TRANSFERENCIA
    private double montoRecibido;  // Solo para EFECTIVO
    private double cambio;         // Solo para EFECTIVO
    private String estado;         // PENDIENTE, EXITOSO, FALLIDO
    private String numeroCuenta;   // Solo para TRANSFERENCIA
    private String cvv;            // Solo para TRANSFERENCIA
    private Date fechaPago;
    private String cli;

    public Pago() {
        this.fechaPago = new Date();
        this.estado = "PENDIENTE";
        this.descuento = 0;
        this.impuesto = 0;
    }

    public Pago(Cliente cliente, GestionCarritoCompras carrito, String metodoPago) {
        this();
        this.cliente = cliente;
        this.cli = cli;
        this.carrito = carrito;
        this.metodoPago = metodoPago;
        calcularSubTotal();
        calcularTotalPagar();
    }

    // Métodos de negocio
    public void calcularSubTotal() {
        if (carrito == null || carrito.getCarritoComp().isEmpty()) {
            throw new IllegalStateException("El carrito no puede estar vacío");
        }
        
        this.subTotal = carrito.getCarritoComp().stream()
            .mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidadCompra())
            .sum();
    }

    public void calcularTotalPagar() {
        this.totalPagar = subTotal;
        
        // Aplicar descuento
        if (descuento > 0) {
            this.totalPagar -= (subTotal * (descuento / 100));
        }
        
        // Aplicar impuesto
        if (impuesto > 0) {
            this.totalPagar += (subTotal * (impuesto / 100));
        }
    }

    public void calcularCambio() {
        if (!"EFECTIVO".equals(metodoPago)) {
            this.cambio = 0;
            return;
        }
        
        if (montoRecibido < totalPagar) {
            throw new IllegalArgumentException("Monto recibido es insuficiente");
        }
        
        this.cambio = montoRecibido - totalPagar;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void validarStock(GestionInventario gestionInventario) throws IllegalStateException {
        for (CarritoCompras item : carrito.getCarritoComp()) {
            Inventario productoEnInventario = gestionInventario.buscar(item.getProducto().getCodigoInventario());
            
            if (productoEnInventario == null) {
                throw new IllegalStateException("Producto no encontrado en inventario: " + 
                    item.getProducto().getNombreProducto());
            }
            
            if (productoEnInventario.getStock() < item.getCantidadCompra()) {
                throw new IllegalStateException("Stock insuficiente para: " + 
                    item.getProducto().getNombreProducto());
            }
            
            if (productoEnInventario.getStock() < 5) {
                System.out.println("[ADVERTENCIA] Stock bajo (" + productoEnInventario.getStock() + 
                                 ") para: " + item.getProducto().getNombreProducto());
            }
        }
    }

    
    
    // Getters y Setters
    public int getCodigoPago() { return codigoPago; }
    public void setCodigoPago(int codigoPago) {
        if (codigoPago < 1) throw new IllegalArgumentException("Código inválido");
        this.codigoPago = codigoPago;
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente no puede ser nulo");
        this.cliente = cliente;
    }

    public GestionCarritoCompras getCarrito() { return carrito; }
    public void setCarrito(GestionCarritoCompras carrito) {
        if (carrito == null || carrito.getCarritoComp().isEmpty()) {
            throw new IllegalArgumentException("Carrito no puede estar vacío");
        }
        this.carrito = carrito;
        calcularSubTotal();
        calcularTotalPagar();
    }

    public double getSubTotal() { return subTotal; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) {
        if (descuento < 0 || descuento > 100) throw new IllegalArgumentException("Descuento inválido");
        this.descuento = descuento;
        calcularTotalPagar();
    }

    public double getImpuesto() { return impuesto; }
    public void setImpuesto(double impuesto) {
        if (impuesto < 0) throw new IllegalArgumentException("Impuesto no puede ser negativo");
        this.impuesto = impuesto;
        calcularTotalPagar();
    }

    public double getTotalPagar() { return totalPagar; }

    public String getMetodoPago() { return metodoPago; }  
    
    public void setMetodoPago(String metodoPago) {
    if (metodoPago == null || (!"EFECTIVO".equals(metodoPago.toUpperCase()) && !"TRANSFERENCIA".equals(metodoPago.toUpperCase()))) {
        throw new IllegalArgumentException("Método de pago no válido");
    }
    this.metodoPago = metodoPago.toUpperCase();
}

    public double getMontoRecibido() { return montoRecibido; }
    public void setMontoRecibido(double montoRecibido) {
        if (montoRecibido < 0) throw new IllegalArgumentException("Monto no puede ser negativo");
        this.montoRecibido = montoRecibido;
        if ("EFECTIVO".equals(metodoPago)) {
            calcularCambio();
        }
    }

    public double getCambio() { return cambio; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) {
        if (!"PENDIENTE".equals(estado) && !"EXITOSO".equals(estado) && !"FALLIDO".equals(estado)) {
            throw new IllegalArgumentException("Estado no válido");
        }
        this.estado = estado;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCli() {
        return cli;
    }

    public void setCli(String cli) {
        this.cli = cli;
    } 

    public Date getFechaPago() { return fechaPago; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------- DETALLE DE PAGO ----------\n")
          .append("Código: ").append(codigoPago).append("\n")
          .append("Fecha: ").append(fechaPago).append("\n")
          .append("Cliente: ").append(cliente.getNombre()).append("\n")
          .append("Estado: ").append(estado).append("\n")
          .append("Método: ").append(metodoPago).append("\n")
          .append("Subtotal: ").append(subTotal).append("\n")
          .append("Descuento: ").append(descuento).append("%\n")
          .append("Impuesto: ").append(impuesto).append("%\n")
          .append("Total a pagar: ").append(totalPagar).append("\n");

        if ("EFECTIVO".equals(metodoPago)) {
            sb.append("Monto recibido: ").append(montoRecibido).append("\n")
              .append("Cambio: ").append(cambio).append("\n");
        } else {
            sb.append("N° Cuenta: ").append(numeroCuenta).append("\n")
              .append("CVV: ").append("***").append("\n");
        }

        sb.append("\nProductos:\n");
        carrito.getCarritoComp().forEach(item -> 
            sb.append("- ").append(item.getProducto().getNombreProducto())
              .append(" x").append(item.getCantidadCompra())
              .append(" @ $").append(item.getProducto().getPrecio())
              .append("\n")
        );

        return sb.toString();
    }
   
    
}
