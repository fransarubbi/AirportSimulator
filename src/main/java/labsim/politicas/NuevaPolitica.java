package labsim.politicas;

import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;
/**
 * Clase que implementa la siguiente politica:
 * A cada avión que llega al espacio aéreo del aeropuerto, en caso de no disponer de pista
 * libre, se le asignará la pista con la cola más corta, o bien la primera si todas tienen la misma
 * longitud.
 */
public class NuevaPolitica implements EleccionServidor{
    
    /**
     * Overrides: Implementacion de seleccionServidor de EleccionServidor.
     * Esta Funcion retorna un servidor desocupado o bien retorna el servidor con la cola mas corta.
     * @param servidores
     * @param entidad
     * @return servidor
     */
    @Override
    public Servidor seleccionServidor(List<Servidor> servidores, Entidad entidad) {
         /*Primero buscamos servidores disponibles */
        Servidor  desocupado = servidorDesocupado(servidores);

        /*Luego buscamos el servidor que está desocupado*/
        if (desocupado == null) {
            return seleccionarColaMasCorta(servidores);
        } else {  /*No hay servidores disponibles, elegimos el de cola más corta */
            return desocupado;
        }
    }

    /**
     * Funcion que retorna el servidor con la cola mas corta o en caso de que todas tenga la misma longitud, retorna el servidor por defecto 1.
     * @param servidores
     * @return servidor
     */
    private Servidor seleccionarColaMasCorta(List<Servidor> servidores) {
        Servidor eleccion = servidores.get(0);

        int longitudCola = servidores.get(0).getCola().size();

        for (int i = 1; i < servidores.size(); i++) {
            int longitudActual = servidores.get(i).getCola().size();
            if (longitudActual < longitudCola) {
                eleccion = servidores.get(i);
                longitudCola = longitudActual;
            }
        }

        return eleccion;
    }

    /**
     * Funcion que retorna el primer servidor que encuentre desocupado. En caso que no haya servidor desocupado retorna null.
     * @param servidores
     * @return servidor or null
     */
    private Servidor servidorDesocupado(List<Servidor> servidores){
        for(Servidor servidor : servidores){
            if(!servidor.ocupado()){
                return servidor;
            }
        }
        return null;
    }
    
}
