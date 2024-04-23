package labsim.eventos;

import java.util.List;

import labsim.entidades.Entidad;
import labsim.motor.FEL;
import labsim.recursos.Estadisticas;
import labsim.recursos.Servidor;
import labsim.tablas.TablaSalida;

/**
 * Clase Salida que extiende de la Clase Abstracta Evento. 
 * En ella se planificaran los Eventos de Salidas, siguiendo con la logica del Bootstraping.
 */
public class Salida extends Evento{

    private final double TAMANIOSIMULACION = 40320;
    private Estadisticas estadisticas;

    /**
     * Constructor del Evento Salida. Recibe un tiempo de salida de la Entidad X, su comportamiento (Tabla) y las estadisticas
     * @param clock
     * @param entidad
     * @param tabla
     * @param estadisticas
     */
    public Salida(double clock, Entidad entidad, TablaSalida tabla, Estadisticas estadisticas) {
        super(clock, entidad, 0, tabla);
        this.estadisticas = estadisticas;
    }

    /**
     * Overrides: Funcion en Evento. Esta planifica el proximo Evento de Salida.
     */
    @Override
    public void planificador(FEL fel, List<Servidor> servidores) {

        Servidor servidor = this.getEntidad().getServidor();

        if(!servidor.colaVacia()){  //Si la cola no esta vacia, hay entidades en espera

            Entidad entidad = servidor.quitarDeCola();  //Sacar entidad de la cola
            servidor.setEntidadActual(entidad);         //Asignar al servidor para que se atienda
            entidad.setServidor(servidor);              //Asignar servidor a la entidad
            estadisticas.setMaxCola(-1);
            estadisticas.setCantidadEspera();           //Sumar uno a los aviones que estan en espera
            estadisticas.setTiempoEspera(this.getClock() - entidad.getInicioEspera());  //Suma tiempo de espera entidad X

            double proximoTiempo = this.getTabla().nextTime(this.getClock());  //Calcular el tiempo de salida
            Salida salida = new Salida(proximoTiempo, servidor.getEntidadActual(), (TablaSalida)this.getTabla(), this.estadisticas);  //Crear nueva salida
            fel.insert(salida);   //Insertar evento de salida en la fel

            estadisticas.setUltimaSalida(proximoTiempo);    //guarda el clock de la ultima salida para correguir el ocio de la simulacion
            
            estadisticas.setCantidadAvionesAterrizados();    //Sumar uno a los aviones que aterrizaron    
            double tiempoArribo = entidad.getInicioEspera();     //Recupero el tiempo de llegada de la entidad en cuestion

            if(proximoTiempo <= TAMANIOSIMULACION){ //Control
                estadisticas.setCantidadAvionesTransito();
                estadisticas.setTiempoTransito(proximoTiempo - tiempoArribo);
            }
        }
        else{    //No hay entidades en espera, se asigna null
            servidor.setEntidadActual(null);
            this.getEntidad().setServidor(null);
            servidor.setTiempoInicioOcio(this.getClock());
            servidor.setCantidadOcio();
        }

    }

    @Override
    public String toString(){
        String informacion;
        informacion = "Fin de servicio. Entidad ID: " + getEntidad().getId() + " Clock: " + this.getClock();
        return informacion;
    }
}
