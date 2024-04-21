package labsim.motor;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import labsim.eventos.Evento;
import labsim.recursos.Orden;

/**
 * Clase Future Events List. 
 */
public class FEL {
    private List<Evento> fel;
    private Orden orden;

    /**
     * Constructor de la FEL. Esta es implementada como un ArrayList.
     */
    public FEL() {
        this.fel = new ArrayList<>();
        this.orden = new Orden();
    }

    /**
     * Funcion que inserta en la FEL un evento E.
     * @param evento
     */
    public void insert(Evento evento) {
        this.fel.add(evento); 
        this.fel.sort(this.orden);     
    }

    /**
     * Funcio que retorna el elemento en la Lista en el indice 0. Es decir, retorna la cabeza de la Lista. Esta funcion hace una evocacion destructiva.
     * @return proximoEvento
     */
    public Evento getProximo() {
        return this.fel.remove(0);
    }

    /**
     * Funcion que controla si la FEL esta vacia.
     * @return true or false
     */
    public boolean estaVacia(){
        return this.fel.isEmpty();
    }

    /**
     * Funcion que retorna el tamaño de la FEL.
     * @return tamanio
     */
    public int tamano(){
        return this.fel.size();
    }

    @Override
    public String toString(){
        String informacion;
        informacion = "----------------- FEL --------------\n";
        Iterator<Evento> iterator = this.fel.iterator();

        while(iterator.hasNext()){
            informacion += iterator.next().toString() + "\n";
        }
        informacion += "\n\n";
        return informacion;
    }
}