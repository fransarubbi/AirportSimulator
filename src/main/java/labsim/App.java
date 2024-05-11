package labsim;

import javax.swing.SwingUtilities;

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
     * Funcion Principal (main)
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimulacionGUI gui = new SimulacionGUI();
            gui.setVisible(true);
        });
    }

    /**
     * Funcion que ejecuta la simulacion desde una interfaz grafica
     */
    private static void ejecutarSimulacion() {
        Estadisticas estadisticas = new Estadisticas();
        Motor motor = new Simulacion(TAMANIOSIMULACION, CreadorServidores.nServidoresUnicasColas(2), estadisticas, new CustomRandomizer(), new MultiplesServidores());
        motor.correr();

        System.out.println(estadisticas.toString(TAMANIOSIMULACION));
    }
}