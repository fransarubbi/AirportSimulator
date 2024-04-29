package labsim.distribuciones;

import java.util.Random;

public class DistribucionTriangular {

    private double min;
    private double m;
    private double max;
    

    public DistribucionTriangular(double min, double m, double max) {
        this.min = min;
        this.m = m;
        this.max = max;
    }


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
