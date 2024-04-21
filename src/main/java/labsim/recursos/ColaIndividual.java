package labsim.recursos;

import java.util.ArrayList;
import java.util.List;

import labsim.entidades.Entidad;

public class ColaIndividual implements Cola{     //Implementa la cola del servidor, define los metodos de la interfaz

    private int id;
    private List<Entidad> cola;

    public ColaIndividual(int id){
        this.id = id;
        this.cola = new ArrayList<>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void ponerEnCola(Entidad entidad) {
        this.cola.add(entidad);
    }

    @Override
    public boolean estaVacia() {
        return this.cola.isEmpty();
    }

    @Override
    public Entidad verProximo() {
        return this.cola.get(0);
    }

    @Override
    public Entidad proximo() {
        return this.cola.remove(0);
    }
    
}
