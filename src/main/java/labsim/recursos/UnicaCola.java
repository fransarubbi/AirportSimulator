package labsim.recursos;

import java.util.List;

import labsim.entidades.Entidad;

/**
 * Clase que implementa la interfaz ColaServidor, para poder tener una unica cola por servidor
 */
public class UnicaCola implements ColaServidor {  

    /**
     * Overrides: Funcion en ColaServidor. Funcion que retorna verdadero o falso en caso que la cola este vacia.
     * @return true or false
     */
    @Override
    public boolean colaVacia(List<Cola> colas){
        return colas.get(0).estaVacia();
    }

    /**
     * Overrides: Funcion en ColaServidor. Funcion que pone en cola una Entidad X en la cola.
     */
    @Override
    public void ponerEnCola(List<Cola> colas, Entidad entidad){
        colas.get(0).ponerEnCola(entidad);
    }

    /**
     * Overrides: Funcion en ColaServidor. Funcion que retorna la proxima Entidad.
     * @return Entidad
     */
    @Override
    public Entidad quitarDeCola(List<Cola> colas){
        return colas.get(0).proximo();
    }
}
