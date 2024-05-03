package labsim.recursos;

import java.util.List;
import labsim.entidades.Entidad;

/**
 * Interface para poder manipular la cola del servidor.
 */
public interface ColaServidor {   //
    
    boolean colaVacia(List<Cola> cola);
    void ponerEnCola(List<Cola> cola, Entidad entidad);
    Entidad quitarDeCola(List<Cola> cola);
}
