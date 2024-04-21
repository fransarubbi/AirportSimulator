package labsim.recursos;

import java.util.Random;

public class CustomRandomizer implements Randomizer{
    private Random random;

    public CustomRandomizer(){
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public double nextRandom(){
        return this.random.nextDouble();
    }
}
