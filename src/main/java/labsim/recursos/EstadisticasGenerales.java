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
    private List<Double> servidor1;
    private List<Double> servidor2;
    
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
    private double mediaServidor1;
    private double mediaServidor2;

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
    private double desviacionServidor1;
    private double desviacionServidor2;
    
    /**
     * Constructor de la Estadistica General.
     */
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
        servidor1 = new ArrayList<>();
        servidor2 = new ArrayList<>();
    }

    /**
     * Funcion que agrega cada resultado parcial de Aviones Arribados de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesArribados(double cantidad) {
        avionesArribados.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de Aviones Aterrizados de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesAterrizados(double cantidad) {
        avionesAterrizados.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Transito Total de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesTransitoTotal(double cantidad) {
        transitoTotal.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Transito Minimo de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesTransitoMin(double cantidad) {
        transitoMin.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Transito Maximo de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesTransitoMax(double cantidad) {
        transitoMax.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Espera Total de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesEsperaTotal(double cantidad) {
        esperaTotal.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Espera Minimo de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesEsperaMin(double cantidad) {
        esperaMin.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Espera Maximo de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesEsperaMax(double cantidad) {
        esperaMax.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Ocio Total de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesOcioTotal(double cantidad) {
        ocioTotal.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Ocio Minimo de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesOcioMin(double cantidad) {
        ocioMin.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Ocio Maximo de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesOcioMax(double cantidad) {
        ocioMax.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Cola Minima de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesColaMin(double cantidad) {
        colaMin.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Cola Maxima de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarAvionesColaMax(double cantidad) {
        colaMax.add(cantidad);
    }
    
    /**
     * Funcion que agrega cada resultado parcial de cantidad de Desgaste del Servidor 1 de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarDesgasteServidor1(double cantidad) {
        servidor1.add(cantidad);
    }

    /**
     * Funcion que agrega cada resultado parcial de cantidad de Desgaste del Servidor 2 de una Ejecucion en un ArrayList.
     * @param cantidad
     */
    public void agregarDesgasteServidor2(double cantidad) {
        servidor2.add(cantidad);
    }

    /**
     * Funcion que calcula la desviación estándar de un conjunto de datos.
     * @param datos
     * @param media
     * @return desviacion
     */
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

    /**
     * Funcion auxiliar para calcular la media de una lista.
     * @param lista
     * @return
     */
    private double calcularMedia(List<Double> lista) {
        int suma = 0;
        for (double cantidad : lista) {
            suma += cantidad;
        }
        return (double) suma / EJECUCIONES;
    }

    /**
     * Funcion que realiza el calculo de las estadísticas generales para varios conjuntos de datos.
     */
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
        this.mediaServidor1 = calcularMedia(this.servidor1);
        this.desviacionServidor1 = calcularDesviacion(this.servidor1, this.mediaServidor1);
        this.mediaServidor2 = calcularMedia(this.servidor2);
        this.desviacionServidor2 = calcularDesviacion(this.servidor2, this.mediaServidor2);
    }

    /**
     * Funcion que recolecta las Estadisticas de cada Ejecucion.
     * @param estadisticas
     */
    public void recolectarDatos(Estadisticas estadisticas) {
        agregarAvionesArribados(estadisticas.getCantidadAvionesArribados());
        agregarAvionesAterrizados(estadisticas.getCantidadAvionesAterrizados());
        agregarAvionesTransitoTotal(estadisticas.getTiempoTransito());
        agregarAvionesTransitoMin(estadisticas.getTiempoMinTransito());
        agregarAvionesTransitoMax(estadisticas.getTiempoMaxTransito());
        agregarAvionesEsperaTotal(estadisticas.getTiempoEspera());
        agregarAvionesEsperaMin(estadisticas.getTiempoMinEspera());
        agregarAvionesEsperaMax(estadisticas.getTiempoMaxEspera());
        agregarAvionesOcioTotal(estadisticas.getTiempoOcio());
        agregarAvionesOcioMin(estadisticas.getTiempoMinOcio());
        agregarAvionesOcioMax(estadisticas.getTiempoMaxOcio());
        agregarAvionesColaMin(estadisticas.getMinCola());
        agregarAvionesColaMax(estadisticas.getMaxCola());
        agregarDesgasteServidor1(estadisticas.getServidorDesgaste(0));
        agregarDesgasteServidor2(estadisticas.getServidorDesgaste(1));
    }

    /**
     * Funcion que retorna los datos en un intervalo con una certeza del 95%.
     */
    @Override
    public String toString() {
        double raiz = Math.sqrt(EJECUCIONES);
        StringBuilder sb = new StringBuilder();
        sb.append("Estadísticas Generales para ").append(EJECUCIONES).append(" ejecuciones con el 95% de certeza\n")
        .append("----------------------------------------------------\n")
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Aviones Arribados", mediaArribados - (1.96 * (desviacionArribados / raiz)), mediaArribados + (1.96 * (desviacionArribados / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Aviones Aterrizados", mediaAterrizados - (1.96 * (desviacionAterrizados / raiz)), mediaAterrizados + (1.96 * (desviacionAterrizados / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Tránsito", mediaTransitoTotal - (1.96 * (desviacionTransitoTotal / raiz)), mediaTransitoTotal + (1.96 * (desviacionTransitoTotal / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Tránsito Mínimo", mediaTransitoMin - (1.96 * (desviacionTransitoMin / raiz)), mediaTransitoMin + (1.96 * (desviacionTransitoMin / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Tránsito Máximo", mediaTransitoMax - (1.96 * (desviacionTransitoMax / raiz)), mediaTransitoMax + (1.96 * (desviacionTransitoMax / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Espera", mediaEsperaTotal - (1.96 * (desviacionEsperaTotal / raiz)), mediaEsperaTotal + (1.96 * (desviacionEsperaTotal / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Espera Mínimo", mediaEsperaMin - (1.96 * (desviacionEsperaMin / raiz)), mediaEsperaMin + (1.96 * (desviacionEsperaMin / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Espera Máximo", mediaEsperaMax - (1.96 * (desviacionEsperaMax / raiz)), mediaEsperaMax + (1.96 * (desviacionEsperaMax / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Ocio", mediaOcioTotal - (1.96 * (desviacionOcioTotal / raiz)), mediaOcioTotal + (1.96 * (desviacionOcioTotal / raiz))))
        .append(String.format("%-30s: (%.5f , %.5f)\n", "Total de Ocio Mínimo", mediaOcioMin - (1.96 * (desviacionOcioMin / raiz)), mediaOcioMin + (1.96 * (desviacionOcioMin / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Ocio Máximo", mediaOcioMax - (1.96 * (desviacionOcioMax / raiz)), mediaOcioMax + (1.96 * (desviacionOcioMax / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Cola Mínimo", mediaColaMin - (1.96 * (desviacionColaMin / raiz)), mediaColaMin + (1.96 * (desviacionColaMin / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Cola Máximo", mediaColaMax - (1.96 * (desviacionColaMax / raiz)), mediaColaMax + (1.96 * (desviacionColaMax / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Desgaste Servidor 1", mediaServidor1 - (1.96 * (desviacionServidor1 / raiz)), mediaServidor1 + (1.96 * (desviacionServidor1 / raiz))))
        .append(String.format("%-30s: (%.2f , %.2f)\n", "Total de Desgaste Servidor 2", mediaServidor2 - (1.96 * (desviacionServidor2 / raiz)), mediaServidor2 + (1.96 * (desviacionServidor2 / raiz))));
        return sb.toString();
    }    
}
