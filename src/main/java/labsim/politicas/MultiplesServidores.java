package labsim.politicas;


import java.util.ArrayList;
import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;

/**
 * Clase que implementa la interface EleccionServidor.
 */
public class MultiplesServidores implements EleccionServidor{
    
    /*
     * Politica inventada nuestra.
     * Función que implementa una lógica avanzada para seleccionar un servidor para atender una entidad, 
     * considerando la disponibilidad de servidores, su ocupación, la longitud de sus colas y su condición general.
     */
    @Override
    public Servidor seleccionServidorAvanzado(List<Servidor> servidores, Entidad entidad){

        /*Primero buscamos servidores disponibles */
        List<Servidor> disponible = disponible(servidores);

        /*Luego buscamos el servidor que esta desocupado*/
        if(disponible != null){
            Servidor libre = desocupado(disponible);
            if(libre != null){
                return libre;
            }
            else{    /*No tengo servidores libres, elijo el de cola mas corta */
                return seleccionarColaMasCorta(disponible);
            }
        }
        else{  /*No hay servidores disponibles debido al desgaste. Elegimos el que mejor condicion tenga */
            return noHayDisponible(servidores);
        }
    }


    /**
     * Funcion que retorna el servidor con la cola mas corta o en caso de que todas tenga la misma longitud, retorna el servidor por defecto 1.
     * @param servidores
     * @return servidor
     */
    private Servidor seleccionarColaMasCorta(List<Servidor> servidores) {

        Servidor eleccion = servidores.get(0);

        int longitudServidor = servidores.get(0).getCola().size();
        int i;

        for (i = 0; i < servidores.size(); i++) {
            if (longitudServidor >= servidores.get(i).getCola().size()) {
                eleccion = servidores.get(i);
                longitudServidor = servidores.get(i).getCola().size();
            }
        }

        //Sino, se termina retornando el primer servidor
        return eleccion;
    }

    /**
     * Funcion que retorna un servidor que este desocupado. En caso que no haya retorna null.
     * @param servidores
     * @return Servidor
     */
    private Servidor desocupado(List<Servidor> servidores){
        
        ArrayList<Servidor> candidatos = new ArrayList<>();  /*Puedo tener mas de un servidor libre*/

        for(Servidor servidor : servidores){
            if(!servidor.ocupado()){
                candidatos.add(servidor);
            }
        }

        if(candidatos.size() == 0){    /*No tengo servidores libres */
            return null;
        }
        else{
            /*Tengo servidores libres, elijo el servidor con mayor durabilidad */
            Servidor eleccion = candidatos.get(0);
            double durabilidad = candidatos.get(0).getDurabilidad();
            int i;

            for(i = 0; i < candidatos.size(); i++){
                if(durabilidad < candidatos.get(i).getDurabilidad()){
                    eleccion = candidatos.get(i);
                    durabilidad = candidatos.get(i).getDurabilidad();
                }
            }
            return eleccion;
        }
    }

    /**
     * Funcion que retorna una lista de servidores que estan disponibles en la simulacion. En caso que haya disponible retorna null.
     * @param servidores
     * @return servidores
     */
    private List<Servidor> disponible(List<Servidor> servidores){
        
        List<Servidor> servidoresDisponibles = new ArrayList<>();

        for(Servidor servidor : servidores){
            if(servidor.isDisponible() == true){
                servidoresDisponibles.add(servidor);
            }
        }

        if(servidoresDisponibles.size() > 0){
            return servidoresDisponibles;
        }
        else{
            return null;
        }
    }

    /**
     * Funcion que busca y retorna el servidor con la mayor durabilidad o en su defecto el primero.
     * @param servidores
     * @return servidor
     */
    private Servidor noHayDisponible(List<Servidor> servidores){

        Servidor eleccion = servidores.get(0);
        double durabilidad = servidores.get(0).getDurabilidad();
        int i;
        for(i = 0; i < servidores.size(); i++){
            if(durabilidad < servidores.get(i).getDurabilidad()){
                eleccion = servidores.get(i);
                durabilidad = servidores.get(i).getDurabilidad();
            }
        }
        return eleccion;
    }
    
    /*
     * /**
     * Overrides: Implementacion de seleccionServidor de EleccionServidor.
     * Esta Funcion retorna un servidor desocupado o bien retorna el servidor con la cola mas corta.
     * @param servidores
     * @param entidad
     * @return servidor
     */
    @Override
    public Servidor seleccionServidorEstandar(List<Servidor> servidores, Entidad entidad) {
        /*Primero buscamos servidores disponibles */
        Servidor desocupado = servidorDesocupado(servidores);

        /*Luego buscamos el servidor que está desocupado*/
        if (desocupado == null) {
            return seleccionarColaMasCorta(servidores);
        } else {  
            return desocupado;
        }
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
