package labsim.recursos;

import java.util.List;
import labsim.entidades.Entidad;

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


    public Servidor(int id, List<Cola> cola, ColaServidor administrador) {
        this.id = id;
        this.cola = cola;
        this.administrador = administrador;
        this.durabilidad = 3000;
        this.disponible = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDurabilidad() {
        return durabilidad;
    }

    public void setDurabilidad(double desgaste) {
        this.durabilidad = this.durabilidad - desgaste;
    }

    public Entidad getEntidadActual() {
        return entidadActual;
    }

    public void setEntidadActual(Entidad entidadActual){  //Cargar una entidad
        this.entidadActual = entidadActual;
    }

    public boolean ocupado(){    //Pregunta si esta ocupado el servidor
        return this.entidadActual != null;
    }

    public boolean colaVacia(){  //Pregunta si la cola esta vacia
        return this.administrador.colaVacia(this.cola);
    }
    
    public void ponerEnCola(Entidad entidad){  //Poner entidad en la cola, ya que el servidor esta ocupado
        this.administrador.ponerEnCola(this.cola, entidad);
    }

    public Entidad quitarDeCola(){   //Quitar entidad de la cola para ser atendida
        return this.administrador.quitarDeCola(this.cola);
    }

    public double getTiempoOcio() {
        return tiempoOcio;
    }

    public void setTiempoOcio(double inicioOcio, double finOcio) {
        this.tiempoOcio += finOcio - inicioOcio;
    }

    public double getTiempoMaxOcio() {
        return tiempoMaxOcio;
    }

    public void setTiempoMaxOcio(double inicioOcio, double finOcio) {
        double tiempoOcio = finOcio - inicioOcio;
        if(this.tiempoMaxOcio < tiempoOcio){
            this.tiempoMaxOcio = tiempoOcio;
        }
    }

    public double getTiempoInicioOcio() {
        return tiempoInicioOcio;
    }

    public void setTiempoInicioOcio(double tiempoInicioOcio) {
        this.tiempoInicioOcio = tiempoInicioOcio;
    }

    public double getTiempoFinOcio() {
        return tiempoFinOcio;
    }

    public void setTiempoFinOcio(double tiempoFinOcio) {
        this.tiempoFinOcio = tiempoFinOcio;
    }

    public int getCantidadOcio() {
        return cantidadOcio;
    }

    public void setCantidadOcio() {
        this.cantidadOcio++;
    }

    public double getTiempoTotalOcio() {
        return tiempoTotalOcio;
    }

    public void setTiempoTotalOcio(double tiempoTotalOcio) {
        this.tiempoTotalOcio += tiempoTotalOcio;
    }

    public List<Cola> getCola() {
        return cola;
    }

    public void setCola(List<Cola> cola) {
        this.cola = cola;
    }

    public ColaServidor getAdministrador() {
        return administrador;
    }

    public void setAdministrador(ColaServidor administrador) {
        this.administrador = administrador;
    }

    public void setTiempoOcio(double tiempoOcio) {
        this.tiempoOcio = tiempoOcio;
    }

    public void setTiempoMaxOcio(double tiempoMaxOcio) {
        this.tiempoMaxOcio = tiempoMaxOcio;
    }

    public void setCantidadOcio(int cantidadOcio) {
        this.cantidadOcio = cantidadOcio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
