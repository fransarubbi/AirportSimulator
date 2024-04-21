package labsim.recursos;

import java.util.List;

public class Pista extends Servidor{

    public Pista(int id, List<Cola> cola, ColaServidor administrador) {
        super(id, cola, administrador);
    }
}
