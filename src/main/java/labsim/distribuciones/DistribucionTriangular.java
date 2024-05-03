package labsim.distribuciones;

import java.util.Random;

/**
 * Clase que utiliza el metodo de "_ _ _" para obtener numeros aleatorios que responden a una Distribucion de Poisson.
 */
public class DistribucionTriangular {

    private double min;
    private double m;
    private double max;
    
    /**
     * Constructor de la Distribucion Empirica Discreta. Inicializa el random.
     * @param min
     * @param m
     * @param max
     */
    public DistribucionTriangular(double min, double m, double max) {
        this.min = min;
        this.m = m;
        this.max = max;
    }

    /**
     * Funcion que retorna un random que cumple con una Distribucion Triangular. 
     * @return random
     */
    public double getDistribucionTriangular(){
        Random rand = new Random();
        double numeroRand = rand.nextDouble();
        double puntoQuiebre = (m - min) / (max - min);
        
        if (numeroRand <= puntoQuiebre) {
            return min + Math.sqrt(numeroRand * (max - min) * (m - min));
        } else {
            return max - Math.sqrt((1 - numeroRand) * (max - min) * (max - m));
        }
    }
}
