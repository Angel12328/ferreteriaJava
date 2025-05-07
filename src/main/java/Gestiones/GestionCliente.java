/*Codigo creado por:
*Alumno: Bayron Alejandro Torres Valladares
*Cuenta: 20241900037
 */
package Gestiones;

import Clases.*;
import java.io.Serializable;
import java.util.LinkedList;

public class GestionCliente implements Serializable{
    
    //Definiendo la lista
    private LinkedList<Cliente> clientes = new LinkedList<>();
    
    public int buscarCliente(int codigo){
        int posicion=-1;
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getCodigo()==codigo){
                posicion=i;
                break;
            }
        }
        return posicion;
    }
    
    public Cliente BuscarClienteObjeto(int codigoC) {
        Cliente est = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (this.clientes.get(i).getCodigo() == codigoC) {
                est = this.clientes.get(i);
            }
        }
        return est;
    }
    
    public boolean agregarCliente(Cliente cliente) {
        
        if(buscarCliente(cliente.getCodigo())==-1){    
            clientes.add(cliente);
            return true;
        }else{
            return false;
        }
        
    }
    public Cliente getClienteByIndex(int indice){
        return clientes.get(indice);
    }
    
    //Hace uso del buscarPorCodigo para aplicar la modificacion 
    
    public boolean modificarCliente(Cliente clienteMod, int posicion ) {
		if(posicion<0 || posicion>clientes.size()) {
			return false;
		}else {
			int posicionEncontrada=buscarCliente(clienteMod.getCodigo());
			
			if(posicionEncontrada==-1 || posicionEncontrada==posicion ) {
				clientes.set(posicion, clienteMod);
				return true;
			}else {
				return false;
			}			
		}
	}
    
    //este es para la tabla del form
    
    public Object[][] getArrayGestion(){
        Object [][] array=new Object[this.clientes.size()][3];
        for(int i=0; i<clientes.size();i++){
            array[i][0]= clientes.get(i).getCodigo();
            array[i][1]= clientes.get(i).getNombre();
            array[i][2]= clientes.get(i).getTelefono();
            
        }
        return array;
    }
    
    public Cliente buscar(int codigoCliente) {
    	int posicion=buscarCliente(codigoCliente);
        if(posicion==-1){
            return null;
        }else{
            return clientes.get(posicion);
        }
    }


    public boolean eliminarCliente(int indice) {
		clientes.remove(indice);
                return true;
	}

    public String getInfoReporte() {
        String _resultado = "";
        for (int i = 0; i < clientes.size(); i++) {
            _resultado += clientes.get(i).toString() + "\n";
        }
        return _resultado;
    }
    
    public LinkedList<Cliente> getClientes() {
        return clientes;
    }
}
