package labsim.recursos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase para implementar cada funcion con su desviacion y su media.
 */
public class EstadisticasGenerales {

    private final int EJECUCIONES = 50;

    private List<Double> avionesArribados;
    private List<Double> avionesAterrizados;
    private List<Double> transitoTotal;
    private List<Double> transitoMin;
    private List<Double> transitoMax;
    private List<Double> esperaTotal;
    private List<Double> esperaMin;
    private List<Double> esperaMax;
    private List<Double> ocioTotal;
    private List<Double> ocioMin;
    private List<Double> ocioMax;
    private List<Double> colaMin;
    private List<Double> colaMax;
    
    private double mediaArribados;
    private double mediaAterrizados;
    private double mediaTransitoTotal;
    private double mediaTransitoMin;
    private double mediaTransitoMax;    
    private double mediaEsperaTotal;
    private double mediaEsperaMin;
    private double mediaEsperaMax;   
    private double mediaOcioTotal;
    private double mediaOcioMin;
    private double mediaOcioMax;
    private double mediaColaMin;
    private double mediaColaMax;

    private double desviacionArribados;
    private double desviacionAterrizados;
    private double desviacionTransitoTotal;
    private double desviacionTransitoMin;
    private double desviacionTransitoMax;
    private double desviacionEsperaTotal;
    private double desviacionEsperaMin;
    private double desviacionEsperaMax;
    private double desviacionOcioTotal;
    private double desviacionOcioMin;
    private double desviacionOcioMax;    
    private double desviacionColaMin;
    private double desviacionColaMax;
    

    public EstadisticasGenerales() {
        avionesArribados = new ArrayList<>();
        avionesAterrizados = new ArrayList<>();
        transitoTotal = new ArrayList<>();
        transitoMin = new ArrayList<>();
        transitoMax = new ArrayList<>();        
        esperaTotal = new ArrayList<>();
        esperaMin = new ArrayList<>();
        esperaMax = new ArrayList<>();     
        ocioTotal = new ArrayList<>();
        ocioMin = new ArrayList<>();
        ocioMax = new ArrayList<>();
        colaMin = new ArrayList<>();
        colaMax = new ArrayList<>();
    }

    public void agregarAvionesArribados(double cantidad) {
        avionesArribados.add(cantidad);
    }

    public void agregarAvionesAterrizados(double cantidad) {
        avionesAterrizados.add(cantidad);
    }

    public void agregarAvionesTransitoTotal(double cantidad) {
        transitoTotal.add(cantidad);
    }

    public void agregarAvionesTransitoMin(double cantidad) {
        transitoMin.add(cantidad);
    }

    public void agregarAvionesTransitoMax(double cantidad) {
        transitoMax.add(cantidad);
    }

    public void agregarAvionesEsperaTotal(double cantidad) {
        esperaTotal.add(cantidad);
    }

    public void agregarAvionesEsperaMin(double cantidad) {
        esperaMin.add(cantidad);
    }

    public void agregarAvionesEsperaMax(double cantidad) {
        esperaMax.add(cantidad);
    }

    public void agregarAvionesOcioTotal(double cantidad) {
        ocioTotal.add(cantidad);
    }

    public void agregarAvionesOcioMin(double cantidad) {
        ocioMin.add(cantidad);
    }

    public void agregarAvionesOcioMax(double cantidad) {
        ocioMax.add(cantidad);
    }

    public void agregarAvionesColaMin(double cantidad) {
        colaMin.add(cantidad);
    }

    public void agregarAvionesColaMax(double cantidad) {
        colaMax.add(cantidad);
    }

    // Método para calcular la desviación estándar de un conjunto de datos
    public double calcularDesviacion(List<Double> datos, double media) {
        if (datos.isEmpty()) {
            return 0; // Manejar caso especial si no hay datos
        }

        // Calcular la suma de los cuadrados de las diferencias entre cada valor y la media
        double sumaDiferenciasCuadrado = 0;
        for (double cantidad : datos) {
            sumaDiferenciasCuadrado += Math.pow(cantidad - media, 2);
        }

        // Calcular la desviación estándar dividiendo la suma de los cuadrados por el número de elementos y tomando la raíz cuadrada
        double desviacion = Math.sqrt(sumaDiferenciasCuadrado / (EJECUCIONES - 1));

        return desviacion;
    }

    // Método auxiliar para calcular la media de una lista de enteros
    private double calcularMedia(List<Double> lista) {
        int suma = 0;
        for (double cantidad : lista) {
            suma += cantidad;
        }
        return (double) suma / EJECUCIONES;
    }

    public void calcularEstadisticasGeneral(){
        this.mediaArribados = calcularMedia(this.avionesArribados);
        this.desviacionArribados = calcularDesviacion(this.avionesArribados, this.mediaArribados);
        this.mediaAterrizados = calcularMedia(this.avionesAterrizados);
        this.desviacionAterrizados = calcularDesviacion(this.avionesAterrizados, this.mediaAterrizados);
        this.mediaTransitoTotal = calcularMedia(this.transitoTotal);
        this.desviacionTransitoTotal = calcularDesviacion(this.transitoTotal, this.mediaTransitoTotal);
        this.mediaTransitoMin = calcularMedia(this.transitoMin);
        this.desviacionTransitoMin = calcularDesviacion(this.transitoMin, this.mediaTransitoMin);
        this.mediaTransitoMax = calcularMedia(this.transitoMax);
        this.desviacionTransitoMax = calcularDesviacion(this.transitoMax, this.mediaTransitoMax);        
        this.mediaEsperaTotal = calcularMedia(this.esperaTotal);
        this.desviacionEsperaTotal = calcularDesviacion(this.esperaTotal, this.mediaEsperaTotal);
        this.mediaEsperaMin = calcularMedia(this.esperaMin);
        this.desviacionEsperaMin = calcularDesviacion(this.esperaMin, this.mediaEsperaMin);
        this.mediaEsperaMax = calcularMedia(this.esperaMax);
        this.desviacionEsperaMax = calcularDesviacion(this.esperaMax, this.mediaEsperaMax);       
        this.mediaOcioTotal = calcularMedia(this.ocioTotal);
        this.desviacionOcioTotal = calcularDesviacion(this.ocioTotal, this.mediaOcioTotal);
        this.mediaOcioMin = calcularMedia(this.ocioMin);
        this.desviacionOcioMin = calcularDesviacion(this.ocioMin, this.mediaOcioMin);
        this.mediaOcioMax = calcularMedia(this.ocioMax);
        this.desviacionOcioMax = calcularDesviacion(this.ocioMax, this.mediaOcioMax);
        this.mediaColaMin = calcularMedia(this.colaMin);
        this.desviacionColaMin = calcularDesviacion(this.colaMin, this.mediaColaMin);
        this.mediaColaMax = calcularMedia(this.colaMax);
        this.desviacionColaMax = calcularDesviacion(this.colaMax, this.mediaColaMax);
    }

    @Override
    public String toString() {
        double raiz = Math.sqrt(EJECUCIONES);
        return "Estadisticas Generales para "+EJECUCIONES+" ejecuciones con el 95% de certeza"
                +"\nAviones Arribados = (" + (mediaArribados - (1.96*(desviacionArribados/raiz))) +" , " + (mediaArribados + (1.96*(desviacionArribados/raiz))) +")"
                +"\nAviones Aterrizados = (" + (mediaAterrizados - (1.96*(desviacionAterrizados/raiz))) +" , " + (mediaAterrizados + (1.96*(desviacionAterrizados/raiz))) +")"
                +"\nTotal de Transito = (" + (mediaTransitoTotal - (1.96*(desviacionTransitoTotal/raiz))) +" , " + (mediaTransitoTotal + (1.96*(desviacionTransitoTotal/raiz))) +")"
                +"\nTotal de Transito Minimo = (" + (mediaTransitoMin - (1.96*(desviacionTransitoMin/raiz))) +" , " + (mediaTransitoMin + (1.96*(desviacionTransitoMin/raiz))) +")"
                +"\nTotal de Transito Maximo = (" + (mediaTransitoMax - (1.96*(desviacionTransitoMax/raiz))) +" , " + (mediaTransitoMax + (1.96*(desviacionTransitoMax/raiz))) +")"
                +"\nTotal de Espera = (" + (mediaEsperaTotal - (1.96*(desviacionEsperaTotal/raiz))) +" , " + (mediaEsperaTotal + (1.96*(desviacionEsperaTotal/raiz))) +")"
                +"\nTotal de Espera Minimo = (" + (mediaEsperaMin - (1.96*(desviacionEsperaMin/raiz))) +" , " + (mediaEsperaMin + (1.96*(desviacionEsperaMin/raiz))) +")"
                +"\nTotal de Espera Maximo = (" + (mediaEsperaMax - (1.96*(desviacionEsperaMax/raiz))) +" , " + (mediaEsperaMax + (1.96*(desviacionEsperaMax/raiz))) +")"
                +"\nTotal de Ocio = (" + (mediaOcioTotal - (1.96*(desviacionOcioTotal/raiz))) +" , " + (mediaOcioTotal + (1.96*(desviacionOcioTotal/raiz))) +")"
                +"\nTotal de Ocio Minimo = (" + (mediaOcioMin - (1.96*(desviacionOcioMin/raiz))) +" , " + (mediaOcioMin + (1.96*(desviacionOcioMin/raiz))) +")"
                +"\nTotal de Ocio Maximo = (" + (mediaOcioMax - (1.96*(desviacionOcioMax/raiz))) +" , " + (mediaOcioMax + (1.96*(desviacionOcioMax/raiz))) +")"
                +"\nTotal de Cola Minimo = (" + (mediaColaMin - (1.96*(desviacionColaMin/raiz))) +" , " + (mediaColaMin + (1.96*(desviacionColaMin/raiz))) +")"
                +"\nTotal de Cola Maximo = (" + (mediaColaMax - (1.96*(desviacionColaMax/raiz))) +" , " + (mediaColaMax + (1.96*(desviacionColaMax/raiz))) +")";
    }
}
