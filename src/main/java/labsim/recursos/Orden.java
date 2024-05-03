package labsim.recursos;

import java.util.Comparator;
import labsim.eventos.Evento;

/**
 * Clase que compara el orden predefinido de los Eventos.
 */
public class Orden implements Comparator<Evento> {

    /**Overrides: Funcion en Comparator. Funcion que retorna el orden luego de comparar dos eventos que suceden en el mismo tiempo. 
     * @return int
     */
    @Override
    public int compare(Evento e1, Evento e2) {
        int ret = 0;
        if (e1.getClock() < e2.getClock()) {
            ret = -1;
        } else if (e1.getClock() > e2.getClock()) {
            ret = 1;
        } else if (e1.getOrden() < e2.getOrden()) {
            ret = -1;
        } else if (e1.getOrden() > e2.getOrden()) {
            ret = 1;
        }
        return ret;
    }
}
