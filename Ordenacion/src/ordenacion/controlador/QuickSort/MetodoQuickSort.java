package ordenacion.controlador.QuickSort;

import ordenacion.controlador.Utilidades.Utiles;
import controlador.listas.ListaEnlazada;
import java.lang.reflect.Field;
import ordenacion.Excepciones.AtributoNoEncontradoException;

public class MetodoQuickSort<E> {
    public static Integer ASCENDENTE = 1;
    public static Integer DESCENDENTE = 2;
    
    public ListaEnlazada<E> quickSort(ListaEnlazada<E> a, String atributo, Integer orden) throws IllegalAccessException, AtributoNoEncontradoException, IllegalArgumentException{
        Class clazz = null;
        E []matriz = a.toArray();
        if (a.getTamanio() > 0) {
            clazz = (Class)a.getCabecera().getDato().getClass();
            Boolean isObject = Utiles.isObject(clazz);
            if (isObject) {
                matriz = quickSortObject(matriz, 0, matriz.length-1, orden, atributo);
            }else{
                if (Utiles.isNumber(clazz)) {
                    if (orden == DESCENDENTE) {
                        matriz = quickSortNumberDescendente(matriz, 0, matriz.length-1);
                    }else{
                        matriz = quickSortNumberAscendente(matriz, 0, matriz.length-1);
                    }
                }else{
                    if (orden == DESCENDENTE) {
                        matriz = quickSortStringDescendente(matriz, 0, matriz.length-1);
                    }else{
                        matriz = quickSortStringAscendente(matriz, 0, matriz.length-1);
                    }
                }
            }
        }
        a = a.toList(matriz);
        return a;
    }
    
    private E[] quickSortObject(E array[], Integer ini, Integer fin, Integer orden, String atributo) throws AtributoNoEncontradoException, IllegalArgumentException, IllegalAccessException{
        Class clazz = array[0].getClass();
        Field field = Utiles.obtenerAtributos(clazz, atributo);
        if (field == null) {
            throw new AtributoNoEncontradoException();
        }
        field.setAccessible(true);
        
        Object arrayAtributos[] = new Object[array.length];
        
        for (int i = 0; i < array.length; i++) {
            E dato = array[i];
            arrayAtributos[i] = field.get(dato);
        }
        
        if (orden == DESCENDENTE) {
            array = quickSortObjectDescendente(array, ini, fin, arrayAtributos);
        }else{
            array = quickSortObjectAscendente(array, ini, fin, arrayAtributos);
        }
        
        return array;
    }
    
    private E[] quickSortObjectAscendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if(ini < fin){
            Integer posPivote;
            posPivote = ubicarPivoteObjectAscendente(array, ini, fin, arrayAtributos);
            array = quickSortObjectAscendente(array, ini, posPivote-1, arrayAtributos);
            array = quickSortObjectAscendente(array, posPivote+1, fin, arrayAtributos);
        }
        return array;
    }
    
    private Integer ubicarPivoteObjectAscendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if (Utiles.isNumber(arrayAtributos[0].getClass())) {
            while (ini < fin) {
                while(((Number)arrayAtributos[fin]).doubleValue() >= ((Number)arrayAtributos[ini]).doubleValue() && ini < fin){
                    fin--;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);

                while(((Number)arrayAtributos[ini]).doubleValue() <= ((Number)arrayAtributos[fin]).doubleValue() && ini < fin){
                    ini++;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }else{
            while (ini < fin) {
                Integer valoresIni[] = Utiles.valorLetrasString(arrayAtributos[ini].toString());
                Integer valoresFin[] = Utiles.valorLetrasString(arrayAtributos[fin].toString());

                while(valoresFin[0] >= valoresIni[0] && ini < fin){
                    fin--;
                    valoresFin = Utiles.valorLetrasString(arrayAtributos[fin].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
                Integer aux[] = valoresFin;
                valoresFin = valoresIni;
                valoresIni = aux;

                while(valoresIni[0] <= valoresFin[0] && ini < fin){
                    ini++;
                    valoresIni = Utiles.valorLetrasString(arrayAtributos[ini].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }
        return ini;
    }
    
    private E[] quickSortObjectDescendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if(ini < fin){
            Integer posPivote;
            posPivote = ubicarPivoteObjectDescendente(array, ini, fin, arrayAtributos);
            array = quickSortObjectDescendente(array, ini, posPivote-1, arrayAtributos);
            array = quickSortObjectDescendente(array, posPivote+1, fin, arrayAtributos);
        }
        return array;
    }
    
    private Integer ubicarPivoteObjectDescendente(E array[], Integer ini, Integer fin, Object arrayAtributos[]){
        if (Utiles.isNumber(arrayAtributos[0].getClass())) {
            while (ini < fin) {
                while(((Number)arrayAtributos[fin]).doubleValue() <= ((Number)arrayAtributos[ini]).doubleValue() && ini < fin){
                    fin--;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);

                while(((Number)arrayAtributos[ini]).doubleValue() >= ((Number)arrayAtributos[fin]).doubleValue() && ini < fin){
                    ini++;
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }else{
            while (ini < fin) {
                Integer valoresIni[] = Utiles.valorLetrasString(arrayAtributos[ini].toString());
                Integer valoresFin[] = Utiles.valorLetrasString(arrayAtributos[fin].toString());

                while(valoresFin[0] <= valoresIni[0] && ini < fin){
                    fin--;
                    valoresFin = Utiles.valorLetrasString(arrayAtributos[fin].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
                Integer aux[] = valoresFin;
                valoresFin = valoresIni;
                valoresIni = aux;

                while(valoresIni[0] >= valoresFin[0] && ini < fin){
                    ini++;
                    valoresIni = Utiles.valorLetrasString(arrayAtributos[ini].toString());
                }
                array = intercambiarDatos(array, ini, fin);
                arrayAtributos = intercambiarDatosObject(arrayAtributos, ini, fin);
            }
        }
        return ini;
    }    
    
    private static Object[] intercambiarDatosObject(Object array[], Integer ini, Integer fin){
        Object aux = array[fin];
        array[fin] = array [ini];
        array[ini] = aux;
        return array;
    }
    
    private E[] intercambiarDatos(E array[], Integer ini, Integer fin){
        E aux = array[fin];
        array[fin] = array [ini];
        array[ini] = aux;
        return array;
    }
    
    private E[] quickSortNumberAscendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteNumberAscendente(array, ini, fin);
            array = quickSortNumberAscendente(array, ini, posPivote-1);
            array = quickSortNumberAscendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteNumberAscendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            while(((Number)array[fin]).doubleValue() >= ((Number)array[ini]).doubleValue() && ini < fin){
                fin--;
            }
            array = intercambiarDatos(array, ini, fin);
            
            while(((Number)array[ini]).doubleValue() <= ((Number)array[fin]).doubleValue() && ini < fin){
                ini++;
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
    
    private E[] quickSortNumberDescendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteNumberDescendente(array, ini, fin);
            array = quickSortNumberDescendente(array, ini, posPivote-1);
            array = quickSortNumberDescendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteNumberDescendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            while(((Number)array[fin]).doubleValue() <= ((Number)array[ini]).doubleValue() && ini < fin){
                fin--;
            }
            array = intercambiarDatos(array, ini, fin);
            
            while(((Number)array[ini]).doubleValue() >= ((Number)array[fin]).doubleValue() && ini < fin){
                ini++;
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
    
    private E[] quickSortStringAscendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteStringAscendente(array, ini, fin);
            array = quickSortStringAscendente(array, ini, posPivote-1);
            array = quickSortStringAscendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteStringAscendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            Integer valoresIni[] = Utiles.valorLetrasString(array[ini].toString());
            Integer valoresFin[] = Utiles.valorLetrasString(array[fin].toString());
            
            while(valoresFin[0] >= valoresIni[0] && ini < fin){
                fin--;
                valoresFin = Utiles.valorLetrasString(array[fin].toString());
            }
            array = intercambiarDatos(array, ini, fin);
            Integer aux[] = valoresFin;
            valoresFin = valoresIni;
            valoresIni = aux;
            
            while(valoresIni[0] <= valoresFin[0] && ini < fin){
                ini++;
                valoresIni = Utiles.valorLetrasString(array[ini].toString());
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
    
    private E[] quickSortStringDescendente(E array[], Integer ini, Integer fin){
        if (ini < fin) {
            Integer posPivote;
            posPivote = UbicarPivoteStringDescendente(array, ini, fin);
            array = quickSortStringDescendente(array, ini, posPivote-1);
            array = quickSortStringDescendente(array, posPivote+1, fin);
        }
        return array;
    }
    
    private Integer UbicarPivoteStringDescendente(E array[], Integer ini, Integer fin){
        while (ini < fin) {
            Integer valoresIni[] = Utiles.valorLetrasString(array[ini].toString());
            Integer valoresFin[] = Utiles.valorLetrasString(array[fin].toString());
           
            while(valoresFin[0] <= valoresIni[0] && ini < fin){
                fin--;
                valoresFin = Utiles.valorLetrasString(array[fin].toString());
            }
            array = intercambiarDatos(array, ini, fin);
            Integer aux[] = valoresFin;
            valoresFin = valoresIni;
            valoresIni = aux;
            
            while(valoresIni[0] >= valoresFin[0] && ini < fin){
                ini++;
                valoresIni = Utiles.valorLetrasString(array[ini].toString());
            }
            array = intercambiarDatos(array, ini, fin);
        }
        return ini;
    }
}
