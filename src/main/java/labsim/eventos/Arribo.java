package labsim.eventos;

import java.util.ArrayList;
import java.util.List;

import labsim.distribuciones.DistribucionNormal;
import labsim.entidades.Avion;
import labsim.entidades.Entidad;
import labsim.motor.FEL;
import labsim.politicas.EleccionServidor;
import labsim.recursos.Estadisticas;
import labsim.recursos.Servidor;
import labsim.tablas.*;
/**
 * Clase Arribo que extiende de la Clase Abstracta Evento. 
 * En ella se planificaran los Eventos de Arribos, siguiendo con la logica del Bootstraping.
 */
public class Arribo extends Evento{

    private final double TAMANIOSIMULACION = 40320;
    private TablaSalida tablaSalida;
    private Estadisticas estadisticas;
    private EleccionServidor seleccion;
    
    /**
     * Constructor de Arribo. Recibe como parametro el tiempo de arribo, la entidad que arriba, el comportanmiento (Tabla), 
     * la duracion de servicios (para el caso especial de Bootstraping) y las estadisticas.
     * @param clock
     * @param entidad
     * @param tabla
     * @param tablaSalida
     * @param estadisticas
     */
    public Arribo(double clock, Entidad entidad, Tabla tabla, TablaSalida tablaSalida, Estadisticas estadisticas, EleccionServidor seleccion) {
        super(clock, entidad, 2, tabla);
        this.tablaSalida = tablaSalida;
        this.estadisticas = estadisticas;
        this.seleccion = seleccion;
    }

    /**
     * Funcion que retorna las estadisticas
     * @return estadisticas
     */
    public Estadisticas getEstadisticas(){
        return this.estadisticas;
    }

    /**
     * Funcion que modifica las estadisticas
     * @param estadisticas
     */
    public void setEstadisticas(Estadisticas estadisticas){
        this.estadisticas = estadisticas;
    }


    /**
     * Overrides: Funcion en Evento. Esta planifica el proximo Evento de Arribo. Contemplando el caso especial de Bootstraping.
     */
    @Override
    public void planificador(FEL fel, List<Servidor> servidores) {

        DistribucionNormal normal = new DistribucionNormal(5, 1);    //Instanciamos la dist. normal para el desgaste
        estadisticas.setCantidadAvionesArribados();      //Sumar uno a los aviones que arribaron
        
        ArrayList<Servidor> servers = new ArrayList<>();
        ArrayList<Servidor> serversNoDisp = new ArrayList<>();

        for(Servidor serv : servidores){
            if(serv.isDisponible() == false){
                if(serv.getTiempoMantenimiento() <= this.getClock()){
                    serv.resetDurabilidad();
                    serv.setDisponible(true);
                    servers.add(serv);
                }
                else{
                    serversNoDisp.add(serv);
                }
            }
            else{
                servers.add(serv);
            }
        }

        if(servers.size() > 0){
            Servidor servidor = this.seleccion.seleccionServidorAvanzado(servers, this.getEntidad(), this.getClock());   //Elegir el servidor optimo

            if(servidor.ocupado()){

                //El servidor esta ocupado, agregar avion a la cola
                servidor.ponerEnCola(this.getEntidad());
                estadisticas.setMaxCola(1);        //Incrementar contador de cola y verificar si es maximo
                estadisticas.setMinCola();               //Setear el minimo valor de cola
                this.getEntidad().setInicioEspera(this.getClock());

            }else{
            
                //El servidor esta desocupado, atender avion
                servidor.setEntidadActual(this.getEntidad());  //La entidad actual, pasa a ser atentida
                this.getEntidad().setServidor(servidor);      //Define el servidor que va a atender la entidad
            
                servidor.setTiempoFinOcio(this.getClock());  //Marcar fin de Ocio
                estadisticas.setCantidadOcio(servidor.getCantidadOcio());  //Contamos un ocio mas
            
                double tiempoInicioTransito = this.getClock();   //Obtener el tiempo que se inicia el transito
                double proximoTiempo = this.tablaSalida.nextTime(this.getClock());   //Calcular el tiempo de salida
                Salida salida = new Salida(proximoTiempo, this.getEntidad(), this.tablaSalida, this.estadisticas); //Creamos el Evento Salida
                fel.insert(salida);   //Insertar evento de salida en la fel

                estadisticas.setUltimaSalida(proximoTiempo);    //guarda el clock de la ultima salida para correguir el ocio de la simulacion
            
                estadisticas.setCantidadAvionesAterrizados();  //Sumar uno a los aviones que fueron aterrizados
                double desgaste = normal.getDistribucionNormal();
            
                servidor.setDurabilidad(desgaste);

                if(servidor.getDurabilidad() <= 5){    /*Si la durabilidad llego a 0 o un poco menos, no se puede seguir usando la pista, pasar a mantenimiento */
                    servidor.setDisponible(false);
                    servidor.setTiempoMantenimiento(this.getClock());
                }
                estadisticas.setServidoresDesgaste(servidores);
            
                if(proximoTiempo <= TAMANIOSIMULACION){ //Control
                    estadisticas.setCantidadAvionesTransito();
                    estadisticas.setTiempoTransito(proximoTiempo - tiempoInicioTransito);
                }
            
                estadisticas.setTiempoOcio(servidor.getTiempoFinOcio() - servidor.getTiempoInicioOcio()); //Sumamos el Ocio
                servidor.setTiempoTotalOcio(servidor.getTiempoFinOcio() - servidor.getTiempoInicioOcio());
        
            }
            Avion avion = new Avion(this.getEntidad().getId() + 1); //Instanciar una nueva entidad con un nuevo id (1+ que el anterior)
            double proximoTiempo = this.getTabla().nextTime(this.getClock());   //Calcular el tiempo de arribo proximo de forma aleatoria
            Arribo proximoArribo = new Arribo(proximoTiempo, avion, this.getTabla(), this.tablaSalida, this.estadisticas, this.seleccion);  //Crear un nuevo arribo
            avion.setArribo(proximoArribo);  //Asigna el evento de arribo al nuevo avion creado
        
            fel.insert(proximoArribo);   //Insertar evento de arribo en la fel
        }
        else{
            double proximoDisponible = serversNoDisp.get(0).getTiempoMantenimiento();
            for(Servidor serv : serversNoDisp){
                if(proximoDisponible > serv.getTiempoMantenimiento()){
                    proximoDisponible = serv.getTiempoMantenimiento();
                }
            }
            Avion avion = new Avion(this.getEntidad().getId() + 1); //Instanciar una nueva entidad con un nuevo id (1+ que el anterior)
            double proximoTiempo = this.getTabla().nextTime(proximoDisponible);   //Calcular el tiempo de arribo proximo de forma aleatoria
            Arribo proximoArribo = new Arribo(proximoTiempo, avion, this.getTabla(), this.tablaSalida, this.estadisticas, this.seleccion);  //Crear un nuevo arribo
            avion.setArribo(proximoArribo);  //Asigna el evento de arribo al nuevo avion creado
        
            fel.insert(proximoArribo);   //Insertar evento de arribo en la fel
        }
          
    }

    @Override
    public String toString() {
        return "Arribo de entidad con id: " + getEntidad().getId() + " en el tiempo: " + this.getClock() + "\n";
    }
}
