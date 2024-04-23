package labsim.recursos;

import java.util.ArrayList;
import java.util.List;

public class CreadorServidores {   //Clase utilizada para definir realidades, en este caso lo usamos para crear un servidor con una cola
                                   //pero puede usarse para despues crear otra realidad, como muchas colas por servidor

    /**
     * Funcion que retonar un servidor
     * @return 1 servidor
     */
    public static Servidor servidores(){

        List<Cola> cola = new ArrayList<>();     //Crear cola del servidor
        cola.add(new ColaIndividual(1));      //Agregar a la cola la implementacion de la misma, con el id=1

        return new Pista(1, cola, new UnicaCola());  //retornar una pista con id=1 y su cola
    }

    /**
     * Funcion que retorna una lista de servidores con sus respectivas colas individuales
     * @param n
     * @return n servidores
     */
    public static List<Servidor> nServidoresUnicasColas(int n){

        List<Servidor> servidores = new ArrayList<>();
        List<Cola> cola = new ArrayList<>();
        cola.add(new ColaIndividual(1));

        for(int i = 0; i < n; i++){
            Servidor servidor = new Pista(i+1, cola, new UnicaCola());
            servidores.add(servidor);
        }

        return servidores;
    }
}
