package labsim;

import labsim.motor.Motor;
import labsim.motor.Simulacion;
import labsim.politicas.MultiplesServidores;
import labsim.recursos.CreadorServidores;
import labsim.recursos.CustomRandomizer;
import labsim.recursos.Estadisticas;
import labsim.recursos.EstadisticasGenerales;
/**
 * Clase principal.
 */
public class App {

    private static final float TAMANIOSIMULACION = 40320;

    /**
     * Funcion Principal (main)
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        EstadisticasGenerales estadisticasGenerales = new EstadisticasGenerales();
        // Ejecuta 50 veces la simulacion con distintas semillas
        while (i<50) {
            Estadisticas estadisticas = new Estadisticas();
            Motor motor = new Simulacion(TAMANIOSIMULACION, CreadorServidores.nServidoresUnicasColas(2), estadisticas, new CustomRandomizer(), new MultiplesServidores());    
            motor.correr();
            i++;
            System.out.println("\nEjecucion Numero: "+ i +"\n\n");
            System.out.println(estadisticas.toString(TAMANIOSIMULACION)+"\n"); 
            estadisticasGenerales.recolectarDatos(estadisticas);
        }
        estadisticasGenerales.calcularEstadisticasGeneral();
        System.out.println(estadisticasGenerales.toString());
    }
}