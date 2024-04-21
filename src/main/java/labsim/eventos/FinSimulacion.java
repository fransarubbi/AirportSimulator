package labsim.eventos;

import labsim.motor.FEL;
import labsim.motor.Motor;
import labsim.motor.Simulacion;
import labsim.recursos.Estadisticas;
import labsim.recursos.Servidor;

/**
 * Clase FinSimulacion que extiende de la Clase Abstracta Evento. 
 * En ella se planificara el Evento de Fin de Simulacion.
 */
public class FinSimulacion extends Evento{

    private Motor motor;
    private Estadisticas estadisticas;

    /**
     * Constructor del Evento de Fin de Simulacion. Recibe el tiempo final de Simulacion, ademas recibe el motor y las estadisticas de la misma.
     * @param tiempoFinal
     * @param motor
     * @param estadisticas
     */
    public FinSimulacion(double tiempoFinal, Simulacion motor, Estadisticas estadisticas) {
        super(tiempoFinal,null,1,null);
        this.motor = motor;
        this.estadisticas = estadisticas;
    }

    /**
     * Overrides: Funcion en Evento. Esta planifica el proximo Evento de Fin de Simulacion. Corriguiendo el Ocio
     */
    @Override
    public void planificador(FEL fel, Servidor servidor) {
        this.motor.setFin();        
        if(estadisticas.getUltimaSalida() < this.getClock()){
            estadisticas.setTiempoOcio(this.getClock() - estadisticas.getUltimaSalida());
        }
        
    }

    @Override
    public String toString(){
        String informacion;
        informacion = "Fin simulacion - Clock: " + this.getClock();
        return informacion;
    }
}
