package labsim.entidades;
import labsim.eventos.Arribo;
import labsim.eventos.Evento;
import labsim.recursos.Servidor;
/**
 * Clase Abstracta
 */
public abstract class Entidad {
    
    private final int id;
    private double inicioEspera;
    private Evento arribo;
    private Servidor servidor;

    /**
     * Constructor que recibe un id
     * @param id
     */
    public Entidad(int id){
        this.id = id;
    }

    /**
     * Constructor que recibe un id y un Evento de Arribo
     * @param id
     * @param arribo
     */
    public Entidad(int id, Arribo arribo) {
        this.id = id;        
        this.arribo = arribo;
    }

    /**
     * Funcion que retorna el identificador de una Entidad X
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     * Funcion que retorna el servidor de una Entidad X
     * @return servidor
     */
    public Servidor getServidor() {
        return this.servidor;
    }

    /**
     * Funcion que modifica el servidor de una Entidad X
     * @param servidor
     */
    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    /**
     * Funcion que retorna un Evento de Arribo
     * @return arribo
     */
    public Evento getArribo() {
        return arribo;
    }

    /**
     * Funcion que modifica el Evento de Arribo de una Entidad X
     * @param arribo
     */
    public void setArribo(Evento arribo) {
        this.arribo = arribo;
    }

    /**
     * Funcion que recibe un tiempo T que indica el comienzo de espera de una Entidad X
     * @param inicioEspera
     */
    public void setInicioEspera(double inicioEspera) {
        this.inicioEspera = inicioEspera;
    }

    /**
     * Funcion que retorna un tiempo T que indica el tiempo en que empezo a esperar una Entidad X 
     * @return inicioEspera
     */
    public double getInicioEspera() {
        return inicioEspera;
    }

}

