package labsim.recursos;

import java.util.List;
import java.util.Random;
import labsim.entidades.Entidad;

public abstract class Servidor{
    
    private Random random;
    private double durabilidad;

    private int id;   //Identificador del servidor
    private Entidad entidadActual;   //Entidad actual en el servidor
    private List<Cola> cola;   //Cola del servidor
    private ColaServidor administrador;   //administrador de la cola

    private double tiempoOcio = 0;
    private double tiempoMaxOcio = 0;
    private double tiempoInicioOcio = 0;
    private double tiempoFinOcio = 0;
    private int cantidadOcio = 0;

    public Servidor(int id, List<Cola> cola, ColaServidor administrador) {
        this.id = id;
        this.cola = cola;
        this.administrador = administrador;
        this.durabilidad = 3000;
        this.random = new Random(System.currentTimeMillis());
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

    public void setDurabilidad(double durabilidad) {
        this.durabilidad -= normal(5,1);
    }

    public double normal(double mu, double var){
        double z = 0;
        for(int i = 0; i < 12; i++){
            z += random.nextDouble();
        }
        z = (z - 6)/var;
        return (z * var) + mu;
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
}
