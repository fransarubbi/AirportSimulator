package labsim.recursos;

/**
 * Interface que contiene el metodo nextRandom.
 */
@FunctionalInterface
public interface Randomizer {

    /**
     * Metodo que retorna un random.
     * @return random
     */
    double nextRandom();
}
