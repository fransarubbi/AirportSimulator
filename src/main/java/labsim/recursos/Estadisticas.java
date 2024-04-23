package labsim.recursos;

import java.util.ArrayList;
import java.util.List;

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
    private double tiempoMaxOcio;

    private double tiempoTransito; 
    private double tiempoMinTransito;
    private double tiempoMedTransito;
    private double tiempoMaxTransito;

    private double ultimaSalida;    //Almacena el clock de la ultima salida para correguir el ocio

    private int maxCola;  //maxima longitud de la cola del servidor
    private int minCola;  //minima longitud de la cola del servidor
    private int contador; //lleva el estado actual del servidor


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
        this.tiempoTransito = 0;
        this.tiempoMinTransito = 10000;
        this.tiempoMedTransito = 0;
        this.tiempoMaxTransito = 0;
        this.maxCola = 0;
        this.minCola = 10000;
        this.contador = 0;
        this.servidoresDesgaste = new ArrayList<>();
    }
    
    /*Contadores */
    public void setCantidadAvionesArribados() {
        cantidadAvionesArribados++;
    }

    public int getCantidadAvionesArribados() {
        return cantidadAvionesArribados;
    }

    public void setCantidadAvionesAterrizados() {
        cantidadAvionesAterrizados++;
    }

    public int getCantidadAvionesAterrizados() {
        return cantidadAvionesAterrizados;
    }

    public void setCantidadAvionesTransito() {
        this.cantidadAvionesTransito++;
    } 

    public int getCantidadAvionesTransito() {
        return cantidadAvionesTransito;
    }

    /*Funciones para la Espera */
    public void setInicioEspera(double inicioEspera) {
        this.inicioEspera = inicioEspera;
    }
    
    public double getInicioEspera() {
        return inicioEspera;
    }

    public void setFinEspera(double finEspera) {
        this.finEspera = finEspera;
    }

    public double getFinEspera() {
        return finEspera;
    }

    public void setCantidadEspera() {
        cantidadEspera++;        
    }

    public int getCantidadEspera() {
        return cantidadEspera;
    }

    public void setTiempoEspera(double tiempoEspera) {
        this.tiempoEspera += tiempoEspera;
        this.setTiempoMinEspera(tiempoEspera);
        this.setTiempoMaxEspera(tiempoEspera);
    }
    
    public double getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoMinEspera(double tiempoEspera) {
        if((this.tiempoMinEspera > tiempoEspera) && (tiempoEspera != 0)){
            this.tiempoMinEspera = tiempoEspera;
        }
    }

    public double getTiempoMinEspera() {
        return tiempoMinEspera;
    }

    public void setTiempoMaxEspera(double tiempoEspera){
        if(this.tiempoMaxEspera < tiempoEspera){
            tiempoMaxEspera = tiempoEspera;
        }
    }

    public double getTiempoMaxEspera() {
        return tiempoMaxEspera;
    }

    /*Funciones para el Ocio */ 
    public void setCantidadOcio(int cantidadOcio) {
        this.cantidadOcio = cantidadOcio;
    }

    public int getCantidadOcio() {
        return cantidadOcio;
    }

    public void setTiempoOcio(double tiempoOcio) {
        this.tiempoOcio += tiempoOcio;
        this.setTiempoMinOcio(tiempoOcio);
        this.setTiempoMaxOcio(tiempoOcio);
    }

    public double getTiempoOcio() {
        return tiempoOcio;
    }
    
    public void setTiempoMinOcio(double tiempoOcio){
        if((this.tiempoMinOcio > tiempoOcio) && (tiempoOcio != 0)){
            this.tiempoMinOcio = tiempoOcio;
        }
    }

    public double getTiempoMinOcio() {
        return tiempoMinOcio;
    }

    public void setTiempoMaxOcio(double tiempoOcio){
        if(this.tiempoMaxOcio < tiempoOcio){
            this.tiempoMaxOcio = tiempoOcio;
        }
    }

    public double getTiempoMaxOcio() {
        return tiempoMaxOcio;
    }

    /*Funciones para el Transito */
    public void setTiempoTransito(double tiempoTransito) {
        this.tiempoTransito += tiempoTransito;
        this.setTiempoMinTransito(tiempoTransito);
        this.setTiempoMaxTransito(tiempoTransito);
    }

    public double getTiempoTransito() {
        return tiempoTransito;
    }
    
    public void setTiempoMinTransito(double tiempoTransito) {
        if((this.tiempoMinTransito > tiempoTransito) && (tiempoTransito != 0)){
            this.tiempoMinTransito = tiempoTransito;
        }
    }

    public double getTiempoMinTransito() {
        return tiempoMinTransito;
    }

    public void setTiempoMaxTransito(double tiempoTransito) {
        if(this.tiempoMaxTransito < tiempoTransito){
            this.tiempoMaxTransito = tiempoTransito;
        }
    }

    public double getTiempoMaxTransito() {
        return tiempoMaxTransito;
    }

    /*Funciones para la Cola */
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

    public int getMaxCola() {
        return maxCola;
    }

    public void setMinCola() {
        if((this.contador < minCola) && this.contador != 0){
            this.minCola = this.contador;
        }
    }

    public int getMinCola() {
        return minCola;
    }

    /*Funciones para controlar el Ocio Final */
    public double getUltimaSalida() {
        return ultimaSalida;
    }

    public void setUltimaSalida(double ultimaSalida) {
        this.ultimaSalida = ultimaSalida;
    }
    

    /*Funcion para guardar el desgaste */
    public List<Servidor> getServidoresDesgaste() {
        return servidoresDesgaste;
    }

    public void setServidoresDesgaste(List<Servidor> servidoresDesgaste) {
        this.servidoresDesgaste = servidoresDesgaste;
    }


    public String toString(float tiempoFinal){

        tiempoMedTransito = tiempoTransito/cantidadAvionesTransito;
        tiempoMedEspera = tiempoEspera/cantidadEspera;
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

        String informacion = "\n|--------------------------------------------------------------|"
                           + "\n                        ESTADISTICAS                            "
                           + "\n|--------------------------------------------------------------|"
                           + "\n              Cantidad total de arribo               | " + cantidadAvionesArribados
                           + "\n              Cantidad total de aterrizajes          | " + cantidadAvionesAterrizados
                           + "\n|--------------------------------------------------------------|"
                           + "\n              Tiempo total de espera                 | " + tiempoEspera
                           + "\n              Tiempo minimo de espera                | " + tiempoMinEspera
                           + "\n              Tiempo medio de espera                 | " + tiempoMedEspera
                           + "\n              Tiempo maximo de espera                | " + tiempoMaxEspera
                           + "\n|--------------------------------------------------------------|"
                           + "\n              Tiempo total de transito               | " + tiempoTransito
                           + "\n              Tiempo minimo de transito              | " + tiempoMinTransito
                           + "\n              Tiempo medio de transito               | " + tiempoMedTransito
                           + "\n              Tiempo maximo de transito              | " + tiempoMaxTransito
                           + "\n|--------------------------------------------------------------|"
                           + "\n              Tiempo total de ocio                   | " + tiempoOcio
                           + "\n              Tiempo minimo de ocio                  | " + tiempoMinOcio
                           + "\n              Tiempo maximo de ocio                  | " + tiempoMaxOcio
                           + "\n    Porcentaje de ocio respecto a la simulacion      | " + porcentajeOcio + " %" 
                           + "\n|--------------------------------------------------------------|"
                           + "\n              Desgaste pista 1:                      | " + servidoresDesgaste.get(0).getDurabilidad()
                           + "\n              Desgaste pista 2:                      | " + servidoresDesgaste.get(1).getDurabilidad()
                           + "\n              Desgaste pista 3:                      | " + servidoresDesgaste.get(2).getDurabilidad()
                           + "\n              Desgaste pista 4:                      | " + servidoresDesgaste.get(3).getDurabilidad()
                           + "\n              Desgaste pista 5:                      | " + servidoresDesgaste.get(4).getDurabilidad()
                           + "\n|--------------------------------------------------------------|"
                           + "\n          Tamano maximo de la cola de espera         | " + maxCola
                           + "\n          Tamano minimo de la cola de espera         | " + minCola
                           + "\n|--------------------------------------------------------------|";
        return informacion;
    }
}