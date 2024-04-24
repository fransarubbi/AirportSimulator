package labsim.distribuciones;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DistribucionEmpiricaDiscreta {

    private Map<Double, Integer> empirica;
    private Random random;

    public DistribucionEmpiricaDiscreta() {
        this.random = new Random(System.currentTimeMillis());
        this.empirica = new HashMap<>();
    }

    public int getDistribucionEmpiricaDiscreta(Map<Double, Integer> hashMap){
        this.empirica = hashMap;
        int valor = random.nextInt();
        int ret = 0;
        for (Map.Entry<Double, Integer> entry : this.empirica.entrySet()) {
            if (valor < entry.getKey()) {
                ret = entry.getValue(); 
            }
        }
        return ret;
    }

}
