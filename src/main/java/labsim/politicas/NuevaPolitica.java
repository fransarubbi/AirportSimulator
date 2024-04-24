package labsim.politicas;

import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;

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
     * @return
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

    private Servidor servidorDesocupado(List<Servidor> servidores){
        for(Servidor servidor : servidores){
            if(!servidor.ocupado()){
                return servidor;
            }
        }
        return null;
    }
    
}
