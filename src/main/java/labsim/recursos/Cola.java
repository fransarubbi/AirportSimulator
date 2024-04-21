package labsim.recursos;

import labsim.entidades.Entidad;

public interface Cola {    //Interfaz para poder definir el comportamiento de la cola
    int getId();    //Devuelve el identificador de la cola (si despues tenemos muchas colas, sera util)
    void ponerEnCola(Entidad entidad);  //Carga entidad en la cola
    boolean estaVacia();    //Pregunta si la cola esta vacia
    Entidad verProximo();   //Devuelve la proxima entidad pero sin sacarla de la cola (no evoca destructivamente)
    Entidad proximo();      //Devuelve la proxima entidad y la elimina (evocacion destructiva)
}
