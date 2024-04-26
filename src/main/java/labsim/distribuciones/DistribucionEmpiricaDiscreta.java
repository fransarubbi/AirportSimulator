package labsim.distribuciones;

import java.util.List;
import java.util.Random;

public class DistribucionEmpiricaDiscreta {

    private Random random;

    public DistribucionEmpiricaDiscreta(){
        this.random = new Random(System.currentTimeMillis());
    }

    public double getDistribucionEmpiricaDiscreta(List<Double> empirica){
        double valorAleatorio = random.nextDouble();
        for(int i = 0; i < empirica.size() ; i += 2){
            if(valorAleatorio < empirica.get(i)){
                return empirica.get(i+1);
            }
        }
        return 0;
    }
}

