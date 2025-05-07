/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Arkoses_as
 */
public class AdminSerializacion {
    /**
     * Método utilizado para guardar un objeto serializable
     * @author OHernandez
     * @date 12Oct2017
     * @param objeto Objeto a guardar en el archivo
     * @param nombreArchivo Nombre del archivo
     */
    public static void serializacion(Object objeto, String nombreArchivo) {
        ObjectOutputStream salida=null;
        try {
            salida = new ObjectOutputStream(new FileOutputStream("Serializacion\\"+nombreArchivo));
            salida.writeObject(objeto);
            salida.close();
        } catch (Exception ex) {
            System.out.println("Error al guardar información en AdminSerializacion "+ex.getMessage());
        }
    }

    /**
     * Método para obtener un objeto serializado
     * @author OHernandez
     * @date 12Oct2017
     * @param nombreArchivo
     * @return El objeto obtenido del archivo
     */
    public static Object de_serealizacion(String nombreArchivo) {
        Object obj1=null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Serializacion\\"+nombreArchivo));
            obj1 = (Object) entrada.readObject();
            entrada.close();
        } catch (Exception ex) {
            System.out.println("Error al obtener objeto AdminSerializacion: "+ex.getMessage());
        }
         return obj1;
    }

    /**
     * Método para eliminar un archivo serializado
     * @param nombreArchivo Nombre del archivo a eliminar
     * @return true si se eliminó correctamente, false si no se pudo eliminar
     * @author AngelZavala & ChatGTP
     * @date 12abril2025
     */
    public static void eliminarArchivoSerializado(String nombreArchivo) {
        File archivo = new File("Serializacion\\" + nombreArchivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Archivo eliminado correctamente: " + nombreArchivo);
                
            } else {
                System.out.println("No se pudo eliminar el archivo: " + nombreArchivo);
            }
        } else {
            System.out.println("El archivo no existe: " + nombreArchivo);
        }
    }    

}
