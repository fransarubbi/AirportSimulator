package labsim.distribuciones;

import java.util.Random;

/**
 * Clase que utiliza el metodo de Convolucion para obtener numeros aleatorios que responden a una Distribucion Normal
 */
public class DistribucionNormal {

    private double media;
    private double desviacionEstandar;
    private Random random;

    /**
     * Constructor de la Distribucion Normal.
     * @param media
     * @param desviacionEstandar
     */
    public DistribucionNormal(double media, double desviacionEstandar){
        this.media = media;
        this.desviacionEstandar = desviacionEstandar;
        this.random = new Random();
    }

    /**
     * Funcion que retorna un random que cumple con una distribucion normal. 
     * @return random
     */
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
        return y;
    }
}