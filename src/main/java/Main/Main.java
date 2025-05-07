/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Main;
/*
import Arboles.ArbolBinario;
import Arboles.Nodo;
import Clases.CarritoCompras;
import Clases.Inventario;
import Clases.Proveedor;
import Gestiones.GestionCarritoCompras;
import Gestiones.GestionInventario;
import Util.AdminSerializacion;
import java.util.LinkedList;
import java.util.Scanner;
*/
import java.util.Random;
public class Main {
/*
    public static ArbolBinario gArbolInv=new ArbolBinario();
    public static GestionCarritoCompras gCarrito=new GestionCarritoCompras();
    public static void main(String[] args) {
        //System.out.println("\nPRODUCTO AGREGADO CORRECTAMENTE\n");
        //Intancias de Gestiones
        try{
            gArbolInv = (ArbolBinario ) AdminSerializacion.de_serealizacion("gArbolInv.obj");
            if(gArbolInv==null){
                 gArbolInv = new ArbolBinario();
            }
        }catch(Exception e){}
        
        try{
            gCarrito = (GestionCarritoCompras ) AdminSerializacion.de_serealizacion("gCarrito.obj");
            if(gCarrito==null){
                 gCarrito= new GestionCarritoCompras();
            }
        }catch(Exception e){}        
        
        GestionInventario gInv=new GestionInventario();
        
        LinkedList<Inventario> _filtro = new LinkedList<Inventario>();
        LinkedList<Inventario> _filtro2 = new LinkedList<Inventario>();
        
        //Scanner
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        
        //Intancias de inventario
        Proveedor proveedor1=new Proveedor(1,"CLAVERA S.A","2772-4512");
        Proveedor proveedor2=new Proveedor(2,"ARGOS S.A","2772-1245");
        Proveedor proveedor3=new Proveedor(3,"INDUSTRIA AMADOR S DE R.L","2772-2347");
        Inventario produc1=new Inventario(1,"ClavosLB",10.00,500,proveedor1);
        Inventario produc2=new Inventario(2,"CementoBOLSA",150,1000,proveedor2);
        Inventario produc3=new Inventario(3,"Tuberia(3mts)",80,3000,proveedor3);
        
        gInv.agregarInventario(produc1);
        gInv.agregarInventario(produc2);
        gInv.agregarInventario(produc3);
        gArbolInv.mostrarInOrden(gArbolInv.getRaiz());
        AdminSerializacion.serializacion(gArbolInv, "gArbolInv.obj");
        
        //gArbolInv.mostrarInOrden(gArbolInv.getRaiz());
        //System.out.println(gArbolInv.getRaiz().getProducto().getCodigoInventario());
        //System.out.println(gArbolInv.getRaiz().getIzq().getProducto().getCodigoInventario());
        //System.out.println(gArbolInv.getRaiz().getDer().getProducto().getCodigoInventario());
        
        //System.out.println(gArbolInv.getRaiz().getIzq().toString());
        
        //COMPRA1
        
        System.out.println("\n BUSCANDO PRODUCTO: CementoBOLSA \n");
        gArbolInv.buscarProductoInOrden(gArbolInv.getRaiz(), produc2, _filtro,"");
        for (int i = 0; i < _filtro.size(); i++) {
            System.out.println("Codigo: " + _filtro.get(i).getCodigoInventario()+ "   Producto: "+_filtro.get(i).getNombreProducto() + "   Precio: " +_filtro.get(i).getPrecio());
        }
       
        System.out.println("Ingrese el Codigo de Producto para Agregarlo al Carrito:");
        //s1.nextLine();
        int cod1=s1.nextInt();
       
        CarritoCompras compra1=new CarritoCompras();
        CarritoCompras compra2=new CarritoCompras();
        
        Nodo nodo1=gArbolInv.buscarProductoInOrdenPorCod(gArbolInv.getRaiz(), cod1);
        compra1.setProducto(nodo1.getProducto());
        compra1.setCantidadCompra(4); //cantidad ingresada de manera 
        gCarrito.agregar(compra1);
        
        
        //COMPRA2
        System.out.println("\n BUSCANDO PRODUCTO: ClavosLB \n");
        gArbolInv.buscarProductoInOrden(gArbolInv.getRaiz(), produc1, _filtro2,"");
        for (int i = 0; i < _filtro2.size(); i++) {
            System.out.println("Codigo: " + _filtro2.get(i).getCodigoInventario()+ "   Producto: "+_filtro2.get(i).getNombreProducto() + "   Precio: " +_filtro2.get(i).getPrecio());
        }
        
        System.out.println("Ingrese el Codigo de Producto para Agregarlo al Carrito:");
        int cod2=s2.nextInt();
        
        Nodo nodo2=gArbolInv.buscarProductoInOrdenPorCod(gArbolInv.getRaiz(), cod2);
        compra2.setProducto(nodo2.getProducto());
        compra2.setCantidadCompra(2); //cantidad ingresada de manera automatica 
        gCarrito.agregar(compra2);
        gCarrito.mostrarCarrito();
        AdminSerializacion.serializacion(gCarrito, "gCarrito.obj");
       
        
    }
*/
    
    public static void main(String[] args) {
        Random rand = new Random();

        // Arreglo de proveedores: [codigo, empresa, telefono]
        Object[][] proveedores = new Object[10][3];
        for (int i = 0; i < proveedores.length; i++) {
            proveedores[i][0] = 1000 + i; // codigo
            proveedores[i][1] = "FERRETERIA-" + (char)('A' + i) + rand.nextInt(100); // empresa
            proveedores[i][2] = "99" + (rand.nextInt(9000000) + 1000000); // telefono
        }

        // Nombres base y unidades para productos
        String[] baseNombres = {
            "ALAMBRE", "CLAVO", "MARTILLO", "DESTORNILLADOR", "LLAVE-INGLESA",
            "TALADRO", "SERRUCHO", "CEMENTO", "LIMA", "TORNILLO"
        };

        String[] unidades = {
            "10MTS", "2PULG-LB", "UNIDAD", "BOLSA", "CAJA", "1/2PULG", "5KG", "100PCS", "20MTS", "3PULG"
        };

        // Arreglo de productos: [nombre, codigo, precio, stock, codigoProveedor]
        Object[][] productos = new Object[200][5];
        for (int i = 0; i < productos.length; i++) {
            String nombre = baseNombres[rand.nextInt(baseNombres.length)] + "-" + unidades[rand.nextInt(unidades.length)];
            int codigo = 2000 + i;
            double precio = Math.round((rand.nextDouble() * 95 + 5) * 100.0) / 100.0;
            int stock = rand.nextInt(500) + 1;
            int codigoProveedor = (int) proveedores[rand.nextInt(proveedores.length)][0];

            productos[i][0] = nombre;
            productos[i][1] = codigo;
            productos[i][2] = precio;
            productos[i][3] = stock;
            productos[i][4] = codigoProveedor;
        }
        
        // Mostrar primeros 10 proveedores
        System.out.println("PROVEEDORES:");
        for (int i = 0; i < proveedores.length; i++) {
            System.out.println("[" + proveedores[i][0] + ", " + proveedores[i][1] + ", " + proveedores[i][2] + "]");
        }

        // Mostrar primeros 15 productos
        System.out.println("\nPRODUCTOS:");
        for (int i = 0; i < productos.length; i++) {
            System.out.println("[" + productos[i][0] + ", " + productos[i][1] + ", Lps." + productos[i][2] + ", Stock: " + productos[i][3] + ", Prov: " + productos[i][4] + "]");
        }
    }
    
}
