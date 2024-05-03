package labsim.recursos;

import java.util.List;

/**
 * Clase que extiende de Servidor e implementa todas sus funciones.
 */
public class Pista extends Servidor{

    /**
     * Constructor de Pista.
     * @param id
     * @param cola
     * @param administrador
     */
    public Pista(int id, List<Cola> cola, ColaServidor administrador) {
        super(id, cola, administrador);
    }
}
