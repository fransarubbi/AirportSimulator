package labsim.tablas;

/**
 * Interface que contiene el metodo nextTime.
 */
@FunctionalInterface
public interface Tabla {

    /**
     * Calcula un lapso de tiempo
     * 
     * @return tiempo
     */
    double nextTime(double hora);
}
