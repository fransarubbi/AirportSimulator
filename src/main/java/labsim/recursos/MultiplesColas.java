package labsim.recursos;

import java.util.List;

import labsim.entidades.Entidad;

public class MultiplesColas implements ColaServidor{
    
    @Override
    public boolean colaVacia(List<Cola> colas, int i){
        return colas.get(i).estaVacia();
    }

    @Override
    public void ponerEnCola(List<Cola> colas, Entidad entidad, int i){
        colas.get(i).ponerEnCola(entidad);
    }

    @Override
    public Entidad quitarDeCola(List<Cola> colas, int i){
        return colas.get(i).proximo();
    }
}
