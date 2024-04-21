package labsim.tablas;

import labsim.recursos.Randomizer;

/**
 * Clase Tabla de Arribo que implementa la interface Tabla.
 */
public class TablaArribo implements Tabla{
    
    private Randomizer randomizer;

    /**
     * Constructor de la Tabla Arribo. Recibe un randomizer.
     * @param randomizer
     */
    public TablaArribo(Randomizer randomizer){
        this.randomizer = randomizer;
    }

    /**
     * Funcion que retorna verdadero o falso en caso de que la hora este entre la hora pico [9, 13] o [20, 23].
     * @param hora
     * @return true or false
     */
    public boolean horaPico(double hora){
        hora = hora % 1440;
        return (hora >= 540 && hora <= 780) || (hora >= 1200 && hora <= 1380); //devuelve true si esta en hora pico, sino false
    }

    /**
     * Funcion que retorna un valor aleatorio correspondiente a una distribucion exponencial con mu igual a 9 o 15.
     * Para ello hacemos uso de la tecnica de Transformada Inversa.
     * @param uniformRandom
     * @param mu
     * @return double
     */
    public double exponencial(double random, double mu) {
        return -mu * Math.log(1 - random);
    }

    /**
     * Overrides: Funcion en Tabla. Genera el tiempo entre Arribos con distribucion Exponencial con media 9 o 15.
     */
    @Override
    public double nextTime(double hora) {
        double r = this.randomizer.nextRandom();
        double ret;
        if(horaPico(hora)){
            ret = exponencial(r,9);
        }else{
            ret = exponencial(r,15);
        }
        return ret;
    }
}