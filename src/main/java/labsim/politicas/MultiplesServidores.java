package labsim.politicas;


import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;

public class MultiplesServidores implements EleccionServidor{
    
    @Override
    public Servidor seleccionServidor(List<Servidor> servidores, Entidad entidad){

        //Primero buscamos el servidor que esta desocupado
        Servidor libre = desocupado(servidores);
        if(libre != null){
            return libre;
        }
        
        //No se retorno ninguno desocupado, entonces tenemos que elegir el de la cola mas corta
        return seleccionarColaMasCorta(servidores);
    }


    private Servidor seleccionarColaMasCorta(List<Servidor> servidores) {

        Servidor eleccion = servidores.get(0);

        int longitudServidor = servidores.get(0).getCola().size();
        int i = 0;

        for (i = 0; i < servidores.size() - 1; i++) {
            if (longitudServidor > servidores.get(i).getCola().size()) {
                eleccion = servidores.get(i);
                longitudServidor = servidores.get(i).getCola().size();
            }
        }

        //Sino, se termina retornando el primer servidor
        return eleccion;
    }


    private Servidor desocupado(List<Servidor> servidores){
        
        for(Servidor servidor : servidores){
            if(!servidor.ocupado()){
                return servidor;
            }
        }
        return null;
    }
}
