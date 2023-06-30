package ordenacion;

import controlador.listas.ListaEnlazada;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import ordenacion.Excepciones.AtributoNoEncontradoException;
import ordenacion.controlador.MergeSort.MetodoMergeSort;
import vista.Utilidades.Utilidades;

public class Ordenacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LocalTime tiempoInicio = LocalTime.now();
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        lista.insertar(8);
        lista.insertar(3);
        lista.insertar(6);
        lista.insertar(0);
        lista.insertar(-9);
        lista.insertar(85);
        lista.insertar(20);
        lista.insertar(2);
        lista.insertar(67);
        lista.insertar(30);

//        ListaEnlazada<String> lista = new ListaEnlazada<>();
//        lista.insertar("ab");
//        lista.insertar("iusdfv");
//        lista.insertar("ad");
//        lista.insertar("dn");
//        lista.insertar("uclql");
//        lista.insertar("spcnw");
//        lista.insertar("voNw");
//        lista.insertar("ciiwbo");

//        ListaEnlazada<Float> lista = new ListaEnlazada<>();
//        lista.insertar(1.2f);
//        lista.insertar(1.3f);
//        lista.insertar(5.4f);
//        lista.insertar(29.8f);
//        lista.insertar(-19.6f);
//
//        ListaEnlazada<Double> lista = new ListaEnlazada<>();
//        lista.insertar(1.2);
//        lista.insertar(1.3);
//        lista.insertar(5.4);
//        lista.insertar(29.8);
//        lista.insertar(-19.6);
        
        MetodoMergeSort mgs = new MetodoMergeSort();
        try {
            lista = mgs.mergeSort(lista, null, MetodoMergeSort.DESCENDENTE);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ordenacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AtributoNoEncontradoException ex) {
            Logger.getLogger(Ordenacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Ordenacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        lista.imprimir();
        
        Long [] tiempos = Utilidades.tiempoTranscurrido(tiempoInicio, LocalTime.now());
        String tiempo = "";
        for (int i = 0; i < tiempos.length; i++) {
            switch (i) {
                case 0: tiempo = "minutos: " + tiempos[i] + " ";
                    continue;
                case 1: tiempo = tiempo + "segundos: " + tiempos[i] + " ";
                    continue;
                case 2: tiempo = tiempo + "milisegundos: " + tiempos[i] + " ";
                    continue;
                default: break;
            }
        }
        System.out.println(tiempo);
    }
    
}
