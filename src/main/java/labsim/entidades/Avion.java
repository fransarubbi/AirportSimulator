package labsim.entidades;

import labsim.eventos.Arribo;
/**
 * Esta Clase crea instancias de Aviones y hereda de Entidad
 */
public class Avion extends Entidad { 
    public Avion (int id, Arribo arribo){
        super(id, arribo);
    }
    /**
     * Este constructor recibe un parametro entero que identificara a cada Entidad (Avion)
     * @param id
     */
    public Avion(int id){
        super(id);
    }
}
