package labsim.recursos;

import java.util.List;
import labsim.entidades.Entidad;

public interface ColaServidor {   //Interfaz para poder manipular la cola del servidor
    
    boolean colaVacia(List<Cola> cola);
    void ponerEnCola(List<Cola> cola, Entidad entidad);
    Entidad quitarDeCola(List<Cola> cola);
}
