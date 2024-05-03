package labsim.recursos;

import java.util.Random;

/**
 * Clase que implementa la interface Randomizer.
 */
public class CustomRandomizer implements Randomizer{
    private Random random;

    /**
     * Constructor.
     */
    public CustomRandomizer(){
        this.random = new Random(System.currentTimeMillis());
    }

    /**
     * Overrides: Funcion en Randomizer. Retorna un numero random.
     * @return Rondom
     */
    @Override
    public double nextRandom(){
        return this.random.nextDouble();
    }
}
