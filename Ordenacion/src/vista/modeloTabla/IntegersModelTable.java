package vista.modeloTabla;

import controlador.listas.Exepciones.ListaVaciaException;
import controlador.listas.Exepciones.PosicionNoEncontradaException;
import controlador.listas.ListaEnlazada;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class IntegersModelTable extends AbstractTableModel{
    private ListaEnlazada<Integer> lista = new ListaEnlazada<>();

    public ListaEnlazada<Integer> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Integer> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getColumnCount(){
        return 1;
    }
    
    @Override 
    public int getRowCount(){
        return lista.getTamanio();
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Dato";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Integer i = null;
        try {
            i = lista.obtener(rowIndex);
        } catch (ListaVaciaException ex) {
            Logger.getLogger(IntegersModelTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionNoEncontradaException ex) {
            Logger.getLogger(IntegersModelTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch(columnIndex){
            case 0:
                return (i != null) ? i : "No definido";
            default:
                return null;
        }
    }
}
