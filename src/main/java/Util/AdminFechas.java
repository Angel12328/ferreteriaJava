package Util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class AdminFechas {
    
    /**
     * Obtiene fecha actual
     * @return 
     */
    public static String getFechaActualString() {
        Date fechaActual = new Date();
        SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return format2.format(fechaActual);
    }
     /**
     * Obtiene fecha actual
     * @return 
     */
    public static Date getFechaActual() {
        Date fechaActual = new Date();
        return fechaActual;
    }
    /**
     * Obtiene la hora Actual
     * @return 
     */
    public static String getHoraActual() {
        Date fechaActual = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        return format.format(fechaActual);
    }
/**
 * Agrega cantidad de doas a una fecha determinada
 * Si cantidadDias es negativo realizaro una resta
 * @param fecha
 * @param cantidadDias
 * @return 
 */
    public static java.sql.Date agregarDias(java.sql.Date fecha, int cantidadDias) {
        Calendar calendario = new GregorianCalendar();
        calendario.setTimeInMillis(fecha.getTime());
        calendario.add(Calendar.DATE, cantidadDias);
        return new java.sql.Date(calendario.getTimeInMillis());
    }
    /**
     * Realiza la resta entre dos fechas
     * @param fechaInicial
     * @param fechaFinal
     * @return Cantidad de dias
     */
    public static  int restarFechasDias(Date fechaInicial, Date fechaFinal) {
        long diferencia_ms=fechaFinal.getTime()-fechaInicial.getTime();
        double dias = Math.floor(diferencia_ms / (1000 * 60 * 60 * 24));
        return ((int) dias);
    }
    
    
    public static  int restarFechasHoras(Date fechaInicial, Date fechaFinal) {
        long diferencia_ms=fechaFinal.getTime()-fechaInicial.getTime();
        double horas = Math.floor(diferencia_ms / (1000 * 60 * 60));
        return ((int) horas);
    }
    /**
     * Realiza la resta entre dos fechas
     * @param fechaInicial
     * @param fechaFinal
     * @return Cantidad de aoos
     */
    public static  int restarFechasAnios(Date fechaInicial, Date fechaFinal) {
        int anios =restarFechasDias(fechaInicial,fechaFinal)/365;
        return ((int) anios);
    }
    /**
     * Convierte de String a fecha
     * @param fechaString
     * @return Date
     */
    public static java.util.Date stringToDate(String fechaString) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaResult = null;
        try {
            fechaResult = format.parse(fechaString);
            return fechaResult;
        } catch (ParseException ex) {
            System.out.println("Error "+ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }
    
    /**
     * Autora: Jennebier Esther Alvarado Lopez
     * Fecha: 03 de Agosto del 2020
     * Motodo para agregar doas a una fecha
     * @param fechaAModificar a la que se quiere sumar doas 
     * @param dias que se quieren sumar
     * @return la fecha modificada (tipo Date)
     */
    public static Date agregarDiasDate(Date fechaAModificar, int dias) {
    	//Usamos la clase Calendar (Abstracta)
    	Calendar calendar = Calendar.getInstance(); //Obtenemos una instancia
    	calendar.setTime(fechaAModificar);	//Establecemos la fecha que se pasa como parametro
    	calendar.add(Calendar.DAY_OF_YEAR, dias); //Usamos el motodo add de Calendar, en el primer parametro colocamos 
    	return calendar.getTime();				//el campo a modificar(Dias del aoo) y en el segundo parametro el valor a sumar
    	 //Por oltimo convertimos la instnacia calendar a tipo date con el motodo getTime().
    }	
}

