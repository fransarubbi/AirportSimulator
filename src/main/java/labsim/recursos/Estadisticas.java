package labsim.recursos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que controla todas las estadisticas que se generan durante la simulacion.
 */
public class Estadisticas {

    private List<Servidor> servidoresDesgaste;
    private int cantidadAvionesArribados;
    private int cantidadAvionesAterrizados;
    private int cantidadAvionesTransito;
    private int cantidadEspera;
    private int cantidadOcio;

    private double inicioEspera;
    private double finEspera;    
    private double tiempoEspera;
    private double tiempoMinEspera;
    private double tiempoMedEspera;
    private double tiempoMaxEspera;

    private double tiempoOcio;
    private double tiempoMinOcio;
    private double tiempoMedOcio;
    private double tiempoMaxOcio;

    private double tiempoTransito; 
    private double tiempoMinTransito;
    private double tiempoMedTransito;
    private double tiempoMaxTransito;

    private double ultimaSalida;    //Almacena el clock de la ultima salida para correguir el ocio

    private int maxCola;  //maxima longitud de la cola del servidor
    private int minCola;  //minima longitud de la cola del servidor
    private int contador; //lleva el estado actual del servidor

    /**
     * Constructor que inicializa todos los valores.
     */
    public Estadisticas() {
        this.cantidadAvionesArribados = 0;
        this.cantidadAvionesAterrizados = 0;
        this.cantidadAvionesTransito = 0;
        this.inicioEspera = 0;
        this.finEspera = 0;
        this.cantidadEspera = 0;
        this.tiempoEspera = 0;
        this.tiempoMinEspera = 10000;
        this.tiempoMedEspera = 0;
        this.tiempoMaxEspera = 0;
        this.tiempoOcio = 0;
        this.cantidadOcio = 0;
        this.tiempoMinOcio = 10000;
        this.tiempoMaxOcio = 0;
        this.tiempoMedOcio = 0;
        this.tiempoTransito = 0;
        this.tiempoMinTransito = 10000;
        this.tiempoMedTransito = 0;
        this.tiempoMaxTransito = 0;
        this.maxCola = 0;
        this.minCola = 10000;
        this.contador = 0;
        this.servidoresDesgaste = new ArrayList<>();
    }
    
    /**
     * Funcion que cuenta la cantidad de aviones que han arribado.
     */
    public void setCantidadAvionesArribados() {
        cantidadAvionesArribados++;
    }

    /**
     * Funcion que retorna la cantidad de aviones que han arribado.
     * @return int
     */
    public int getCantidadAvionesArribados() {
        return cantidadAvionesArribados;
    }

    /**
     * Funcion que cuenta la cantidad de aviones que han aterrizado.
     */
    public void setCantidadAvionesAterrizados() {
        cantidadAvionesAterrizados++;
    }

    /**
     * Funcion que retorna la cantidad de aviones que han arribado.
     * @return int
     */
    public int getCantidadAvionesAterrizados() {
        return cantidadAvionesAterrizados;
    }

    /**
     * Funcion que cuenta la cantidad de aviones que se han ido de la simulacion.
     */
    public void setCantidadAvionesTransito() {
        this.cantidadAvionesTransito++;
    } 

    /**
     * Funcion que retorna la cantidad de aviones que se han ido de la simulacion.
     * @return int
     */
    public int getCantidadAvionesTransito() {
        return cantidadAvionesTransito;
    }

    /**
     * Funcion que inicializa la espera.
     * @param inicioEspera
     */
    public void setInicioEspera(double inicioEspera) {
        this.inicioEspera = inicioEspera;
    }
    
    /**
     * Funcion que retorna el tiempo en que comenzo una espera.
     * @return double
     */
    public double getInicioEspera() {
        return inicioEspera;
    }

    /**
     * Funcion que marca el fin de espera.
     * @param finEspera
     */
    public void setFinEspera(double finEspera) {
        this.finEspera = finEspera;
    }

    /**
     * Funcion que retorna el fin de espera.
     * @return
     */
    public double getFinEspera() {
        return finEspera;
    }

    /**
     * Funcion que cuenta la cantidad de aviones que han esperado.
     */
    public void setCantidadEspera() {
        cantidadEspera++;        
    }

    /**
     * Funcion que retorna la cantidad de aviones que han esperado.
     * @return int
     */
    public int getCantidadEspera() {
        return cantidadEspera;
    }

    /**
     * Funcion que cuenta la cantidad de espera que hay durante la simulacion.
     * @param tiempoEspera
     */
    public void setTiempoEspera(double tiempoEspera) {
        this.tiempoEspera += tiempoEspera;
        this.setTiempoMinEspera(tiempoEspera);
        this.setTiempoMaxEspera(tiempoEspera);
    }
    
    /**
     * Funcion que retorna la cantidad de espera en total.
     * @return double
     */
    public double getTiempoEspera() {
        return tiempoEspera;
    }

    /**
     * Funcion que busca el tiempo de espera mas pequeño distinto de cero.
     * @param tiempoEspera
     */
    public void setTiempoMinEspera(double tiempoEspera) {
        if((this.tiempoMinEspera > tiempoEspera) && (tiempoEspera != 0)){
            this.tiempoMinEspera = tiempoEspera;
        }
    }

    /**
     * Funcion que retorna el tiempo de espera mas pequeño.
     * @return double
     */
    public double getTiempoMinEspera() {
        return tiempoMinEspera;
    }

    /**
     * Funcion que busca el tiempo de espera mas grande.
     * @param tiempoEspera
     */
    public void setTiempoMaxEspera(double tiempoEspera){
        if(this.tiempoMaxEspera < tiempoEspera){
            tiempoMaxEspera = tiempoEspera;
        }
    }

    /**
     * Funcion que retorna el tiempo de espera mas grande.
     * @return double
     */
    public double getTiempoMaxEspera() {
        return tiempoMaxEspera;
    }

    /**
     * Funcion que cuenta la cantidad de veces que hubo ocio.
     * @param cantidadOcio
     */
    public void setCantidadOcio(int cantidadOcio) {
        this.cantidadOcio = cantidadOcio;
    }

    /**
     * Funcion que retorna la cantidad de veces que hubo ocio.
     * @return int
     */
    public int getCantidadOcio() {
        return cantidadOcio;
    }

    /**
     * Funcion que cuenta la cantidad de ocio total de la simulacion.
     * @param tiempoOcio
     */
    public void setTiempoOcio(double tiempoOcio) {
        this.tiempoOcio += tiempoOcio;
        this.setTiempoMinOcio(tiempoOcio);
        this.setTiempoMaxOcio(tiempoOcio);
    }

    /**
     * Funcion que retorna la cantidad de ocio total de la simulacion.
     * @return double
     */
    public double getTiempoOcio() {
        return tiempoOcio;
    }
    
    /**
     * Funcion que busca el tiempo de ocio mas pequeño.
     * @param tiempoOcio
     */
    public void setTiempoMinOcio(double tiempoOcio){
        if((this.tiempoMinOcio > tiempoOcio) && (tiempoOcio != 0)){
            this.tiempoMinOcio = tiempoOcio;
        }
    }

    /**
     * Funcion que retorna el tiempo de ocio mas pequeño.
     * @return double
     */
    public double getTiempoMinOcio() {
        return tiempoMinOcio;
    }

    /**
     * Funcion que busca el tiempo de ocio mas grande.
     * @param tiempoOcio
     */
    public void setTiempoMaxOcio(double tiempoOcio){
        if(this.tiempoMaxOcio < tiempoOcio){
            this.tiempoMaxOcio = tiempoOcio;
        }
    }

    /**
     * Funcion que retorna el tiempo de ocio mas grande.
     * @return double
     */
    public double getTiempoMaxOcio() {
        return tiempoMaxOcio;
    }

    /**
     * Funcion que cuenta la cantidad de transito total durante la simulacion.
     * @param tiempoTransito
     */
    public void setTiempoTransito(double tiempoTransito) {
        this.tiempoTransito += tiempoTransito;
        this.setTiempoMinTransito(tiempoTransito);
        this.setTiempoMaxTransito(tiempoTransito);
    }

    /**
     * Funcion que retorna el tiempo de transito total.
     * @return double
     */
    public double getTiempoTransito() {
        return tiempoTransito;
    }
    
    /**
     * Funcion que busca el tiempo de transito mas pequeño.
     * @param tiempoTransito
     */
    public void setTiempoMinTransito(double tiempoTransito) {
        if((this.tiempoMinTransito > tiempoTransito) && (tiempoTransito != 0)){
            this.tiempoMinTransito = tiempoTransito;
        }
    }

    /**
     * Funcion que retorna el tiempo de transito mas pequeño.
     * @return double
     */
    public double getTiempoMinTransito() {
        return tiempoMinTransito;
    }

    /**
     * Funcion que busca el tiempo de transito mas grande.
     * @param tiempoTransito
     */
    public void setTiempoMaxTransito(double tiempoTransito) {
        if(this.tiempoMaxTransito < tiempoTransito){
            this.tiempoMaxTransito = tiempoTransito;
        }
    }

    /**
     * Funcion que retorna el tiempo de transito mas grande.
     * @return double
     */
    public double getTiempoMaxTransito() {
        return tiempoMaxTransito;
    }

    /**
     * Funcion que indica el tamaño de la cola
     * @param accion
     */
    public void setMaxCola(int accion) {
        if(accion == 1){
            this.contador++;   //Si le pasamos 1, incrementar contador de elementos en cola
        }
        if(accion == -1){
            this.contador--;   //Si le pasamos -1, decrementar contador de elementos en cola
        }
        if(this.contador > this.maxCola){   //Si el contador llego a una cantidad superior a maxCola, asignarselo
            this.maxCola = this.contador;
        }
    }

    /**
     * Funcion que retorna el tamaño maximo de la cola.
     * @return int
     */
    public int getMaxCola() {
        return maxCola;
    }

    /**
     * Funcion que busca el tamaño de cola mas pequeño.
     */
    public void setMinCola() {
        if((this.contador < minCola) && this.contador != 0){
            this.minCola = this.contador;
        }
    }

    /**
     * Funcion que retorna el tamaño de cola mas pequeño.
     * @return int
     */
    public int getMinCola() {
        return minCola;
    }

    /**
     * Funcion que almacena el ultimo tiempo de salida.
     * @return double
     */
    public double getUltimaSalida() {
        return ultimaSalida;
    }

    /**
     * Funcion que actualiza el tiempo de la ultima salida.
     * @param ultimaSalida
     */
    public void setUltimaSalida(double ultimaSalida) {
        this.ultimaSalida = ultimaSalida;
    }
    
    /**
     * Funcion que retorna el desgaste de todos los servidores.
     * @return lista de servidores
     */
    public List<Servidor> getServidoresDesgaste() {
        return servidoresDesgaste;
    }

    /**
     * Funcion que modifica el desgaste de almacenado.
     * @param servidoresDesgaste
     */
    public void setServidoresDesgaste(List<Servidor> servidoresDesgaste) {
        this.servidoresDesgaste = servidoresDesgaste;
    }

    /**
     * Funcion que retorna el desgaste de un servidor pedido por parametro.
     * @param i
     * @return desgaste
     */
    public double getServidorDesgaste(int i){
        return servidoresDesgaste.get(i).getDurabilidad();
    }

    /**
     * Funcion que genera el informe general de toda la simulacion.
     * @param tiempoFinal
     * @return reporte
     */ 
    public String toString(float tiempoFinal){

        tiempoMedTransito = tiempoTransito/cantidadAvionesTransito;
        tiempoMedEspera = tiempoEspera/cantidadAvionesArribados;
        double tiempoMedEsperaExtra = tiempoEspera/cantidadOcio;
        tiempoMedOcio = tiempoOcio/servidoresDesgaste.size();
        double porcentajeOcio = (tiempoOcio/tiempoFinal) * 100;

        if(tiempoMinEspera == 10000){
            tiempoMinEspera = 0;
            tiempoMedEspera = 0;
        }
        if(tiempoMinOcio == 10000){
            tiempoMinOcio = 0;
        }
        if(minCola == 10000){
            minCola = 0;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("\n|----------------------------------------------------------------|")
        .append("\n|                         ESTADISTICAS                           |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %d", "Cantidad total de arribo", cantidadAvionesArribados))
        .append(String.format("\n| %-62s | %d", "Cantidad total de aterrizajes", cantidadAvionesAterrizados))
        .append("\n|----------------------------------------------------------------|")
        .append("\n|                      ESTADISTICAS ESPERA                       |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %.2f", "Tiempo total de espera", tiempoEspera))
        .append(String.format("\n| %-62s | %.2f", "Tiempo mínimo de espera", tiempoMinEspera))
        .append(String.format("\n| %-62s | %.2f", "Tiempo medio de espera", tiempoMedEspera))
        .append(String.format("\n| %-62s | %.2f", "Tiempo medio de espera, en situación de espera", tiempoMedEsperaExtra))
        .append(String.format("\n| %-62s | %.2f", "Tiempo máximo de espera", tiempoMaxEspera))
        .append("\n|----------------------------------------------------------------|")
        .append("\n|                      ESTADISTICAS TRANSITO                     |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %.2f", "Tiempo total de tránsito", tiempoTransito))
        .append(String.format("\n| %-62s | %.2f", "Tiempo mínimo de tránsito", tiempoMinTransito))
        .append(String.format("\n| %-62s | %.2f", "Tiempo medio de tránsito", tiempoMedTransito))
        .append(String.format("\n| %-62s | %.2f", "Tiempo máximo de tránsito", tiempoMaxTransito))
        .append("\n|----------------------------------------------------------------|")
        .append("\n|                      ESTADISTICAS OCIO                         |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %.2f", "Tiempo total de ocio", tiempoOcio))
        .append(String.format("\n| %-62s | %.2f", "Tiempo mínimo de ocio", tiempoMinOcio))
        .append(String.format("\n| %-62s | %.2f", "Tiempo medio de ocio", tiempoMedOcio))
        .append(String.format("\n| %-62s | %.2f", "Tiempo máximo de ocio", tiempoMaxOcio))
        .append("\n|----------------------------------------------------------------|")
        .append("\n|                 ESTADISTICAS OCIO SERVIDORES                   |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %.2f", "Tiempo total ocio servidor 1", servidoresDesgaste.get(0).getTiempoTotalOcio()))
        .append(String.format("\n| %-62s | %.2f", "Tiempo total ocio servidor 2", servidoresDesgaste.get(1).getTiempoTotalOcio()))
        //.append(String.format("\n| %-62s | %.2f", "Tiempo total ocio servidor 3", servidoresDesgaste.get(2).getTiempoTotalOcio()))
        //.append(String.format("\n| %-62s | %.2f", "Tiempo total ocio servidor 4", servidoresDesgaste.get(3).getTiempoTotalOcio()))
        //.append(String.format("\n| %-62s | %.2f", "Tiempo total ocio servidor 5", servidoresDesgaste.get(4).getTiempoTotalOcio()))
        .append(String.format("\n| %-62s | %.2f %%", "Porcentaje de ocio respecto a la simulación", porcentajeOcio))
        .append("\n|----------------------------------------------------------------|")
        .append("\n|               ESTADISTICAS TIEMPO DE USO SERVIDORES            |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %.2f", "Tiempo total ocupado servidor 1", tiempoFinal - servidoresDesgaste.get(0).getTiempoTotalOcio()))
        .append(String.format("\n| %-62s | %.2f", "Tiempo total ocupado servidor 2", tiempoFinal - servidoresDesgaste.get(1).getTiempoTotalOcio()))
        //.append(String.format("\n| %-62s | %.2f", "Tiempo total ocupado servidor 3", tiempoFinal - servidoresDesgaste.get(2).getTiempoTotalOcio()))
        //.append(String.format("\n| %-62s | %.2f", "Tiempo total ocupado servidor 4", tiempoFinal - servidoresDesgaste.get(3).getTiempoTotalOcio()))
        //.append(String.format("\n| %-62s | %.2f", "Tiempo total ocupado servidor 5", tiempoFinal - servidoresDesgaste.get(4).getTiempoTotalOcio()))
        .append("\n|----------------------------------------------------------------|")
        .append("\n|             ESTADISTICAS DESGASTE SERVIDORES                   |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %.2f", "Desgaste servidor 1", servidoresDesgaste.get(0).getDurabilidad()))
        .append(String.format("\n| %-62s | %.2f", "Desgaste servidor 2", servidoresDesgaste.get(1).getDurabilidad()))
        //.append(String.format("\n| %-62s | %.2f", "Desgaste servidor 3", servidoresDesgaste.get(2).getDurabilidad()))
        //.append(String.format("\n| %-62s | %.2f", "Desgaste servidor 4", servidoresDesgaste.get(3).getDurabilidad()))
        //.append(String.format("\n| %-62s | %.2f", "Desgaste servidor 5", servidoresDesgaste.get(4).getDurabilidad()))
        .append("\n|----------------------------------------------------------------|")
        .append("\n|                ESTADISTICAS COLA ESPERA                        |")
        .append("\n|----------------------------------------------------------------|")
        .append(String.format("\n| %-62s | %d", "Tamaño máximo de la cola de espera", maxCola))
        .append(String.format("\n| %-62s | %d", "Tamaño mínimo de la cola de espera", minCola))
        .append("\n|----------------------------------------------------------------|");
        return sb.toString();
    }
}