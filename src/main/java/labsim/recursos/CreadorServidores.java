package labsim.recursos;

import java.util.ArrayList;
import java.util.List;

public class CreadorServidores {   //Clase utilizada para definir realidades, en este caso lo usamos para crear un servidor con una cola
                                   //pero puede usarse para despues crear otra realidad, como muchas colas por servidor

    public static Servidor servidores(){

        List<Cola> cola = new ArrayList<>();     //Crear cola del servidor
        cola.add(new ColaIndividual(1));      //Agregar a la cola la implementacion de la misma, con el id=1

        return new Pista(1, cola, new UnicaCola());  //retornar una pista con id=1 y su cola
    }

    public static List<Servidor> cincoServidoresCincoColas(){

        List<Servidor> servidores = new ArrayList<>();
        List<Cola> cola = new ArrayList<>();

        cola.add(new ColaIndividual(1));
        servidores.add(new Pista(1, cola, new UnicaCola()));

        return servidores;
    }
}
