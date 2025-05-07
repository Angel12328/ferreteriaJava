/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestiones;
import Clases.CarritoCompras;
import Clases.Inventario;
import Clases.Pago;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * @author jazmi
 */
public class GestionPago implements Serializable {
    private LinkedList<Pago> pagos = new LinkedList<>();
    private int ultimoCodigoPago =0;

    public LinkedList<Pago> getPagos() {
        return pagos;
    }
    
    // Genera códigos consecutivos para pagos
    public int generarNuevoCodigo() {
        return this.ultimoCodigoPago++;
    }

    // Agrega un nuevo pago al sistema
    public boolean agregarPago(Pago pago) {
        if (pago == null) {
            System.out.println("Error: Pago nulo no puede ser agregado");
            return false;
        }
        
        if (buscarPago(pago.getCodigoPago()) != -1) {
            System.out.println("Error: Pago con código " + pago.getCodigoPago() + " ya existe");
            return false;
        }
        
        if (pago.getCodigoPago() <= 0) {
            pago.setCodigoPago(generarNuevoCodigo());
        }
        
        if (pago.getCarrito() == null || pago.getCarrito().getCarritoComp().isEmpty()) {
            System.out.println("Error: Carrito vacío o nulo");
            return false;
        }
        
        try {
            pago.calcularSubTotal();
            pago.calcularTotalPagar();
            
            if (pagos.add(pago)) {
                System.out.println("Pago agregado exitosamente. Código: " + pago.getCodigoPago());
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error al calcular totales: " + e.getMessage());
        }
        
        return false;
    }

    // Busca un pago por su código
    public int buscarPago(int codigo) {
        for (int i = 0; i < pagos.size(); i++) {
            if (pagos.get(i).getCodigoPago() == codigo) {
                return i;
            }
        }
        return -1;
    }

    // Procesa pago en efectivo
    public boolean procesarPagoEfectivo(int codigoPago, double montoRecibido, 
                                      GestionInventario gestionInventario) {
        Pago pago = validarPagoParaProcesar(codigoPago);
        if (pago == null) return false;

        try {
            if (montoRecibido <= 0) {
                pago.setEstado("FALLIDO");
                System.out.println("Monto recibido debe ser positivo");
                return false;
            }
            
            pago.setMontoRecibido(montoRecibido);
            pago.calcularCambio();
            
            if (pago.getCambio() < 0) {
                pago.setEstado("FALLIDO");
                System.out.println("Monto insuficiente para el pago");
                return false;
            }
            
            return procesarPagoFinal(pago, gestionInventario);
            
        } catch (Exception e) {
            manejarErrorPago(pago, e);
            return false;
        }
    }

    // Procesa pago por transferencia
    public boolean procesarPagoTransferencia(int codigoPago, String numeroCuenta, 
                                      String cvv, GestionInventario gestionInventario) {
        Pago pago = validarPagoParaProcesar(codigoPago);
        if (pago == null) return false;

        try {
            if (numeroCuenta == null || numeroCuenta.trim().isEmpty() || 
                cvv == null || cvv.trim().isEmpty()) {
                pago.setEstado("FALLIDO");
                System.out.println("Datos de transferencia incompletos");
                return false;
            }
            
            pago.setNumeroCuenta(numeroCuenta);
            pago.setCvv(cvv);
            
            return procesarPagoFinal(pago, gestionInventario);
            
        } catch (Exception e) {
            manejarErrorPago(pago, e);
            return false;
        }
    }

    // Métodos auxiliares 
    private Pago validarPagoParaProcesar(int codigoPago) {
        int posicion = buscarPago(codigoPago);
        if (posicion == -1) {
            System.out.println("Pago no encontrado con código: " + codigoPago);
            return null;
        }
        
        Pago pago = pagos.get(posicion);
        
        if (!"PENDIENTE".equals(pago.getEstado())) {
            System.out.println("Pago ya fue procesado. Estado actual: " + pago.getEstado());
            return null;
        }
        
        return pago;
    }

    private boolean procesarPagoFinal(Pago pago, GestionInventario gestionInventario) {
        try {
            pago.validarStock(gestionInventario);
            
            if (actualizarInventario(pago, gestionInventario)) {
                pago.setEstado("EXITOSO");
                registrarVenta(pago);
                System.out.println("Pago procesado exitosamente");
                return true;
            }
            
            pago.setEstado("FALLIDO");
            return false;
            
        } catch (Exception e) {
            manejarErrorPago(pago, e);
            return false;
        }
    }

    private boolean actualizarInventario(Pago pago, GestionInventario gestionInventario) {
        for (CarritoCompras item : pago.getCarrito().getCarritoComp()) {
            Inventario producto = item.getProducto();
            int pos = gestionInventario.buscarInventario(producto.getCodigoInventario());
            
            if (pos == -1) {
                System.out.println("Producto no encontrado en inventario: " + producto.getNombreProducto());
                return false;
            }
            
            Inventario inventario = gestionInventario.getInventarioByIndex(pos);
            if (inventario.getStock() < item.getCantidadCompra()) {
                System.out.println("Stock insuficiente para: " + producto.getNombreProducto());
                return false;
            }
            
            inventario.setStock(inventario.getStock() - item.getCantidadCompra());
            gestionInventario.modificarInventario(inventario, pos);
        }
        return true;
    }

    private void manejarErrorPago(Pago pago, Exception e) {
        pago.setEstado("FALLIDO");
        System.err.println("Error en procesamiento de pago: " + e.getMessage());
        e.printStackTrace();
    }

    private void registrarVenta(Pago pago) {
        System.out.println("Registrando venta para pago #" + pago.getCodigoPago());
        
    }

  
}