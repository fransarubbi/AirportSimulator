package labsim;

import javax.swing.SwingUtilities;
/**
 * Clase principal.
 */
public class App {


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
}