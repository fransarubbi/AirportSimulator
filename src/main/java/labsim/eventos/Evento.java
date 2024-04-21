package labsim.eventos;


import java.util.List;

import labsim.entidades.Entidad;
import labsim.motor.FEL;
import labsim.recursos.Servidor;
import labsim.tablas.Tabla;

/**
 * Clase Abstracta
 */
public abstract class Evento {

    private double clock;
    private final Entidad entidad;
    private int orden;
    private final Tabla tabla;

    /**
     * Funcion Abstracta. Recibe una FEL (Future Events List) y un Servidor.
     * @param fel
     * @param servidor
     */
    public abstract void planificador(FEL fel, List<Servidor> servidor);

    /**
     * Constructor de Evento. Recibe un tiempo, una entidad, y ademas, el orden y el comportamiento del Evento.
     * @param clock
     * @param entidad
     * @param orden
     * @param tabla
     */
    public Evento(double clock, Entidad entidad, int orden, Tabla tabla) {
        this.clock = clock;
        this.entidad = entidad;
        this.orden = orden;
        this.tabla = tabla;
    }

    /**
     * Funcion que retorna el tiempo T.
     * @return clock
     */
    public double getClock() {
        return clock;
    }

    /**
     * Funcion que retorna la Entidad X.
     * @return entidad
     */
    public Entidad getEntidad() {
        return entidad;
    }

    /**
     * Funcion que retorna el Orden de un Evento E.
     * @return orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * Funcion que retorna el comprtamiento de un Evento E.
     * @return tabla
     */
    public Tabla getTabla() {
        return tabla;
    }

    /**
     * Funcion que modifica el tiempo.
     * @param clock
     */
    public void setClock(double clock) {
        this.clock = clock;
    }

    /**
     * Funcion que retorna verdadero o falso dependiendo si un Evento1 es igual a otro Evento2. Funcion utilizada en AppTest.
     * @param obj
     * @return true or false
     */
    public boolean iguales(Object obj) {  //metodo usado solo en el AppTest
        
        Evento evento = (Evento) obj;
        if (Double.compare(evento.getClock(), this.getClock()) != 0){ 
            return false;
        }
        if (evento.getEntidad().getId() != this.getEntidad().getId()){  
            return false;
        }
        return true;
    }
}

