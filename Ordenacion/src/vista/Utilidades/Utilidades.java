package vista.Utilidades;

import controlador.listas.ListaEnlazada;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Utilidades {
    public static ListaEnlazada<Integer> generarEnteros(){
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        
        for (int i = 0; i < 20000; i++) {
            lista.insertar(Integer.parseInt("" + Math.round(Math.random() / Math.random() * Math.random() * 1000)));
        }
        
        return lista;
    }
    
    public static Long[] tiempoTranscurrido(LocalTime horaInicio, LocalTime horaFin){
        Long [] tiempo = new Long[3];
        tiempo[0] = ChronoUnit.MINUTES.between(horaInicio, horaFin);
        tiempo[1] = ChronoUnit.SECONDS.between(horaInicio, horaFin);
        tiempo[2] = ChronoUnit.MILLIS.between(horaInicio, horaFin);

        return tiempo;
    }
}
