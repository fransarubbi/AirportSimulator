package labsim.tablas;

import labsim.recursos.Randomizer;

/**
 * Clase Tabla de Salida que implementa la interface Tabla.
 */
public class TablaSalida implements Tabla{
    
    private Randomizer randomizer;

    /**
     * Constructor de la Tabla Salida. Recibe un randomizer.
     * @param randomizer
     */
    public TablaSalida(Randomizer randomizer){
        this.randomizer = randomizer;
    }

    /**
     * Funcion que retorna un valor aleatorio correspondiente a una distribucion uniforme entre 10 y 25.
     * Para ello hacemos uso de la tecnica de Transformada Inversa.
     * @param li
     * @param ls
     * @param random
     * @return double
     */
    public double uniforme(double li, double ls, double random){
        double result = li + (ls - li) * random;
        return result;
    }

    /**
     * Overrides: Funcion en Tabla. Genera el tiempo de la duracion de servicio con una distribucion uniforme(10,25).
     */
    @Override
    public double nextTime(double hora) {
        double r = this.randomizer.nextRandom();
        double ret;
        ret = uniforme(10,25, r);
        return ret + hora;
    }
}