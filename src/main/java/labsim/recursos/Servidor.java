package labsim.recursos;

import java.util.ArrayList;
import java.util.List;
import labsim.entidades.Entidad;

/**
 * Clase Abstracta con las funciones necesarias para controlar una Pista.
 */
public abstract class Servidor{

    private double durabilidad;

    private int id;   //Identificador del servidor
    private Entidad entidadActual;   //Entidad actual en el servidor
    private List<Cola> cola;   //Cola del servidor
    private ColaServidor administrador;   //administrador de la cola

    private double tiempoOcio = 0;
    private double tiempoMaxOcio = 0;
    private double tiempoInicioOcio = 0;
    private double tiempoFinOcio = 0;
    private double tiempoTotalOcio = 0;

    private int cantidadOcio = 0;
    private boolean disponible;
    private double tiempoMantenimiento = 0;


    /**
     * Constructor de un Servidor.
     * @param id
     * @param cola
     * @param administrador
     */
    public Servidor(int id, List<Cola> cola, ColaServidor administrador) {
        this.id = id;
        this.cola = cola;
        this.administrador = administrador;
        this.durabilidad = 3000;
        this.disponible = true;
    }

    /**
     * Funcion que retorna el id de un servidor.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Funcion que otorga un identificador a cada servidor.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Funcion que retorna la durabilidad de un servidor.
     * @return double
     */
    public double getDurabilidad() {
        return durabilidad;
    }

    /**
     * Funcion que decrementa la durabilidad de un servidor.
     * @param desgaste
     */
    public void setDurabilidad(double desgaste) {
        this.durabilidad = this.durabilidad - desgaste;
    }

    public void resetDurabilidad(){
        this.durabilidad = 3000;
    }

    /**
     * Funcion que retorna la entidad que esta asociada al servidor.
     * @return Entidad
     */
    public Entidad getEntidadActual() {
        return entidadActual;
    }

    /**
     * Funcion que asocia una Entidad X con el servidor.
     * @param entidadActual
     */
    public void setEntidadActual(Entidad entidadActual){  
        this.entidadActual = entidadActual;
    }

    /**
     * Funcion que retorna verdadero o falso en caso que el servidor este ocupado.
     * @return true or false
     */
    public boolean ocupado(){
        return this.entidadActual != null;
    }

    /**
     * Funcion que retorna verdadero o falso en caso que la cola del servidor este vacia
     * @return true or false
     */
    public boolean colaVacia(){
        return this.administrador.colaVacia(this.cola);
    }
    
    /**
     * Funcion que pone en cola una Entidad X.
     * @param entidad
     */
    public void ponerEnCola(Entidad entidad){ 
        this.administrador.ponerEnCola(this.cola, entidad);
    }

    /**
     * Funcion que retorna la Entidad en la cabeza de la cola.
     * @return Entidad
     */
    public Entidad quitarDeCola(){
        return this.administrador.quitarDeCola(this.cola);
    }

    /**
     * Funcion que retorna el tiempo de ocio total de la simulacion.
     * @return double
     */
    public double getTiempoOcio() {
        return tiempoOcio;
    }

    /**
     * Funcion que cuenta el ocio total de la simulacion.
     * @param inicioOcio
     * @param finOcio
     */
    public void setTiempoOcio(double inicioOcio, double finOcio) {
        this.tiempoOcio += finOcio - inicioOcio;
    }

    /**
     * Funcion que retorna el tiempo de ocio mas grande.
     * @return
     */
    public double getTiempoMaxOcio() {
        return tiempoMaxOcio;
    }

    /**
     * Funcion que busca el tiempo de ocio mas grande.
     * @param inicioOcio
     * @param finOcio
     */
    public void setTiempoMaxOcio(double inicioOcio, double finOcio) {
        double tiempoOcio = finOcio - inicioOcio;
        if(this.tiempoMaxOcio < tiempoOcio){
            this.tiempoMaxOcio = tiempoOcio;
        }
    }

    /**
     * Funcion que retorna el tiempo de inicio de ocio del servidor.
     * @return double
     */
    public double getTiempoInicioOcio() {
        return tiempoInicioOcio;
    }

    /**
     * Funcion que marca el inicio de ocio del servidor.
     * @param tiempoInicioOcio
     */
    public void setTiempoInicioOcio(double tiempoInicioOcio) {
        this.tiempoInicioOcio = tiempoInicioOcio;
    }

    /**
     * Funcion que retorna el fin de ocio del servidor.
     * @return double
     */
    public double getTiempoFinOcio() {
        return tiempoFinOcio;
    }

    /**
     * Funcion que marca el fin de ocio del servidor.
     * @param tiempoFinOcio
     */
    public void setTiempoFinOcio(double tiempoFinOcio) {
        this.tiempoFinOcio = tiempoFinOcio;
    }

    /**
     * Funcion que retorna la cantidad de veces que el servidor tuvo ocio.
     * @return int
     */
    public int getCantidadOcio() {
        return cantidadOcio;
    }

    /**
     * Funcion que cuenta la cantidad de veces que el servidor tuvo ocio.
     */
    public void setCantidadOcio() {
        this.cantidadOcio++;
    }

    /**
     * Funcion que retorna el tiempo total de ocio de la simulacion.
     * @return double
     */
    public double getTiempoTotalOcio() {
        return tiempoTotalOcio;
    }

    /**
     * Funcion que cuenta el tiempo total de ocio de la simulacion.
     * @param tiempoTotalOcio
     */
    public void setTiempoTotalOcio(double tiempoTotalOcio) {
        this.tiempoTotalOcio += tiempoTotalOcio;
    }

    /**
     * Funcion que retorna la cola del servidor.
     * @return cola
     */
    public List<Cola> getCola() {
        return cola;
    }

    /**
     * Funcion que modifica la ccla del servidor.
     * @param cola
     */
    public void setCola(List<Cola> cola) {
        this.cola = cola;
    }

    /**
     * Funcion que retorna el administrador de la cola del servidor.
     * @return administrador
     */
    public ColaServidor getAdministrador() {
        return administrador;
    }

    /**
     * Funcion que asocia un administrador al servidor.
     * @param administrador
     */
    public void setAdministrador(ColaServidor administrador) {
        this.administrador = administrador;
    }

    /**
     * Funcion que cuenta el tiempo de ocio en la simulacion.
     * @param tiempoOcio
     */
    public void setTiempoOcio(double tiempoOcio) {
        this.tiempoOcio = tiempoOcio;
    }

    /**
     * Funcion que busca el tiempo de ocio mas grande.
     * @param tiempoMaxOcio
     */
    public void setTiempoMaxOcio(double tiempoMaxOcio) {
        this.tiempoMaxOcio = tiempoMaxOcio;
    }

    /**
     * Funcion que cuenta la cantidad de veces que el servidor tuvo ocio.
     * @param cantidadOcio
     */
    public void setCantidadOcio(int cantidadOcio) {
        this.cantidadOcio = cantidadOcio;
    }

    /**
     * Funcion que determina si el servidor esta disponible.
     * @param disponible
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Funcion que retorna verdadero o falso dependiendo la disponibilidad del servidor.
     * @return true or false
     */
    public boolean isDisponible() {
        return disponible;
    }

    public double getTiempoMantenimiento() {
        return tiempoMantenimiento;
    }

    public void setTiempoMantenimiento(double tiempoMantenimiento) {
        this.tiempoMantenimiento = tiempoMantenimiento + 7200;    /*7200 son 5 dias */
    }

    public ArrayList<Servidor> getServidoresDisponibles(ArrayList<Servidor> servidores, double clock){
        
        ArrayList<Servidor> servers = new ArrayList<>();

        for(Servidor servidor : servidores){
            if(servidor.isDisponible() == false){
                if(servidor.getTiempoMantenimiento() >= clock){
                    servers.add(servidor);
                }
            }
            else{
                servers.add(servidor);
            }
        }
        return servers;
    }
}
