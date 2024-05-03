package labsim;

import labsim.motor.Motor;
import labsim.motor.Simulacion;
import labsim.politicas.MultiplesServidores;
import labsim.recursos.*;
/**
 * Clase principal.
 */
public class App {

    private static final float TAMANIOSIMULACION = 40320;

    /**
     * Funcion main. Genera una simulacion parando los recursos necesarios y luego imprimiendo los resultados obtenidos (Estadisticas).
     * @param args
     */
    public static void main(String[] args) {

        Estadisticas estadisticas = new Estadisticas();
        Motor motor = new Simulacion(TAMANIOSIMULACION, CreadorServidores.nServidoresUnicasColas(5), estadisticas, new CustomRandomizer(), new MultiplesServidores());
        motor.correr();

        System.out.println(estadisticas.toString(TAMANIOSIMULACION));
    }
}