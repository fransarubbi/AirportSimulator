package labsim.distribuciones;

import java.util.List;
import java.util.Random;

/**
 * Clase que utiliza el metodo de Aceptacion y Rechazo para obtener numeros aleatorios que responden a una Distribucion de Poisson
 */
public class DistribucionEmpiricaDiscreta {

    private Random random;

    /**
     * Constructor de la Distribucion Empirica Discreta. Inicializa el random.
     */
    public DistribucionEmpiricaDiscreta(){
        this.random = new Random(System.currentTimeMillis());
    }

    /**
     * Funcion que retorna un random que cumple con una distribucion empirica discreta dada.
     * @param empirica
     * @return random
     */
    public double getDistribucionEmpiricaDiscreta(List<Double> empirica){
        double valorAleatorio = random.nextDouble();
        for(int i = 0; i < empirica.size() ; i += 2){
            if(valorAleatorio < empirica.get(i)){
                return empirica.get(i+1);
            }
        }
        return 0;
    }
}

