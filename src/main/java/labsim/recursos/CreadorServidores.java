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


    public static List<Servidor> nServidoresyColas(int n, int y){
        
        List<Servidor> servidores = new ArrayList<>();
        List<Cola> cola = new ArrayList<>();

        for(int j = 0; j < y; j++){
            cola.add(new ColaIndividual(j+1));
        }

        for(int i = 0; i < n; i++){
            Servidor servidor = new Pista(i+1, cola, new MultiplesColas());
            servidores.add(servidor);
        }

        return servidores;
    }
}
