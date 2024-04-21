package labsim.recursos;

import java.util.Comparator;
import labsim.eventos.Evento;

public class Orden implements Comparator<Evento> {

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
