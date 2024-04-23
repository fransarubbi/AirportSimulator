package labsim.distribuciones;

import java.util.Random;

/**
 * Clase que utiliza el metodo de Aceptacion y Rechazo para obtener numeros aleatorios que responden a una Distribucion de Poisson
 */
public class DistribucionPoisson {

    private Random random;
    private double lambda;
    
    public DistribucionPoisson(double lambda) {
        this.lambda = lambda;
        this.random = new Random();
    }

    /**
     * Genera una variable aleatoria exponencial con parámetro lambda
     * @param lambda
     * @return Random
     */
    private double exponencial(double lambda) {
        return -Math.log(1 - random.nextDouble()) / lambda;
    }
    
    /**
     * Genera una variable aleatoria con distribución de Poisson
     * @param lambda
     * @return Random
     */
    public int getDistribucionPoisson() {
        double suma = 0;
        int cont = 0;
        
        while (suma <= 1) {
            suma += exponencial(this.lambda);
            cont++;
        }
        
        return cont - 1; // Restamos 1 porque el último evento que hace que la suma supere 1 no cuenta
    }
}
