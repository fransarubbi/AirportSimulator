package labsim.distribuciones;

import java.util.Random;


public class DistribucionNormal {

    private double media;
    private double desviacionEstandar;
    private Random random;

    public DistribucionNormal(double media, double desviacionEstandar){
        this.media = media;
        this.desviacionEstandar = desviacionEstandar;
        this.random = new Random();
    }

    public double getDistribucionNormal(){
        
        int n = 12, i;  //Número n de variables aleatorias a convolucionar
        double suma = 0;   //Variable de suma

        for (i = 0; i < n; i++) {    //Sumar 12 numeros aleatorios entre 0 y 1
            suma += random.nextDouble();
        }

        double zEstandar = suma - 6;
        double varianza = Math.sqrt(desviacionEstandar);
        double y = zEstandar*varianza + media;

        //Escalamos y trasladamos los números aleatorios generados para que sigan la distribución normal
        return media + desviacionEstandar * y;
    }
}