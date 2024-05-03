package labsim.recursos;

import java.util.ArrayList;
import java.util.List;

import labsim.entidades.Entidad;

/**
 * Clase que implementa la cola del servidor, define los metodos de la interfaz. 
 */
public class ColaIndividual implements Cola{

    private int id;
    private List<Entidad> cola;

    /**
     * Constructor de Cola Individual para cada Pista.
     * @param id
     */
    public ColaIndividual(int id){
        this.id = id;
        this.cola = new ArrayList<>();
    }

    /**
     * Overrides: Funcion en Cola. Retorna el identificador de la cola.
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Overrides: Funcion en Cola. Coloca en espera una Entidad X.
     * @param Entidad
     */
    @Override
    public void ponerEnCola(Entidad entidad) {
        this.cola.add(entidad);
    }

    /**
     * Overrides: Funcion en Cola. Retorna verdadero o falso si la cola esta vacia.
     * @return true or false
     */
    @Override
    public boolean estaVacia() {
        return this.cola.isEmpty();
    }

    /**
     * Overrides: Funcion en Cola. Retorna la Entidad que esta en la cabeza de la Cola.
     * @return Entidad
     */
    @Override
    public Entidad verProximo() {
        return this.cola.get(0);
    }

    /**
     * Overrides: Funcion en Cola. Retorna y elimina la Entidad que esta en la cabeza de la Cola.
     * @return Entidad 
     */
    @Override
    public Entidad proximo() {
        return this.cola.remove(0);
    }
    
}
