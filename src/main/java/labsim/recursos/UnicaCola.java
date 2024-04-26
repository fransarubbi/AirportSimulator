package labsim.recursos;

import java.util.List;

import labsim.entidades.Entidad;

public class UnicaCola implements ColaServidor {   //Clase que implementa la interfaz ColaServidor, para poder tener una unica cola por servidor
    @Override
    public boolean colaVacia(List<Cola> colas){
        return colas.get(0).estaVacia();
    }

    @Override
    public void ponerEnCola(List<Cola> colas, Entidad entidad){
        colas.get(0).ponerEnCola(entidad);
    }

    @Override
    public Entidad quitarDeCola(List<Cola> colas){
        return colas.get(0).proximo();
    }
}
