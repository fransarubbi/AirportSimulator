package labsim.motor;

import labsim.entidades.Avion;
import labsim.entidades.Entidad;
import labsim.eventos.Arribo;
import labsim.eventos.FinSimulacion;
import labsim.recursos.Estadisticas;
import labsim.recursos.Randomizer;
import labsim.recursos.Servidor;
import labsim.tablas.TablaArribo;
import labsim.tablas.TablaSalida;

/**
 * Clase Simulacion que extiende de Motor.
 */
public class Simulacion extends Motor{
    
    private FEL fel;
    private Servidor servidor;
    private Estadisticas estadisticas;

    /**
     * Constructor de la Simulacion. Recibe el tiempo final de la simulacion, un servidor, las estadisticas y un randomizer.
     * En este constructor se crean e insertan los dos primeros casos del metodo de Bootstraping. Evento de Fin y Evento de Arribo en tiempo 0.
     * @param tiempoFinal
     * @param servidor
     * @param estadisticas
     * @param randomizer
     */
    public Simulacion(double tiempoFinal, Servidor servidor, Estadisticas estadisticas, Randomizer randomizer){
        this.fel = new FEL();
        this.fel.insert(new FinSimulacion(tiempoFinal, this, estadisticas));
        this.servidor = servidor;
        this.estadisticas = estadisticas;

        Entidad avion = new Avion(1);
        Arribo arribo = new Arribo(0, avion, new TablaArribo(randomizer), new TablaSalida(randomizer), estadisticas);
        avion.setArribo(arribo);
        fel.insert(arribo);
    }

    /**
     * Overrides: Funcion en Motor.
     */
    @Override
    public void correr() {
        while(!this.getFin()){
            this.fel.getProximo().planificador(this.fel, this.servidor);
        }
    }
}
