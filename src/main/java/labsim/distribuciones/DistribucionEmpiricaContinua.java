package labsim.distribuciones;

import java.util.List;
import java.util.Random;

/**
 * Clase que utiliza el metodo de " __ " para obtener numeros aleatorios que responden a una Distribucion Empirica Continua
 */
public class DistribucionEmpiricaContinua {
    
    private Random random;

    /**
     * Constructor de la Distribucion Empirica Continua. Inicializa el random.
     */
    public DistribucionEmpiricaContinua() {
        this.random = new Random(System.currentTimeMillis());
    }

    /**
     * Funcion que retorna un random que cumple con una distribucion empirica continua dada.
     * @param empirica
     * @return random
     */
    public double getDistribucionEmpiricaContinua(List<Double> empirica) {
        double valorAleatorio = random.nextDouble();
        
        // Búsqueda del intervalo
        for (int i = 0; i < empirica.size(); i += 2) {
            if (valorAleatorio < empirica.get(i)) {
                // Interpolación lineal
                double x1 = empirica.get(i - 2); 
                double y1 = empirica.get(i - 1);
                double x2 = empirica.get(i);
                double y2 = empirica.get(i + 1);
                return y1 + (valorAleatorio - x1) * (y2 - y1) / (x2 - x1);
            }
        }
        return 0; // Valor por defecto si no se encuentra
    }
}