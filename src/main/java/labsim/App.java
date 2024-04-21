package labsim;

import java.util.List;
import labsim.motor.Motor;
import labsim.motor.Simulacion;
import labsim.recursos.*;
/**
 * Funcion que contiene una lista de servidores y el tamaño de una simulacion.
 */
public class App {

    private static final float TAMANIOSIMULACION = 40320;
    public static List<Servidor> servidores;

    /**
     * Funcion main. Genera una simulacion parando los recursos necesarios y luego imprimiendo los resultados obtenidos (Estadisticas).
     * @param args
     */
    public static void main(String[] args) {

        Estadisticas estadisticas = new Estadisticas();
        Motor motor = new Simulacion(TAMANIOSIMULACION, CreadorServidores.servidores(), estadisticas, new CustomRandomizer());
        motor.correr();

        System.out.println(estadisticas.toString(TAMANIOSIMULACION));
    }
}