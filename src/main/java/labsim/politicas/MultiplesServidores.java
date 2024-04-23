package labsim.politicas;


import java.util.ArrayList;
import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;

public class MultiplesServidores implements EleccionServidor{
    
    @Override
    public Servidor seleccionServidor(List<Servidor> servidores, Entidad entidad){

        /*Primero buscamos servidores disponibles */
        List<Servidor> disponible = disponible(servidores);

        /*Luego buscamos el servidor que esta desocupado*/
        if(disponible != null){
            Servidor libre = desocupado(disponible);
            if(libre != null){
                return libre;
            }
            else{    /*No tengo servidores libres, elijo el de cola mas corta */
                return seleccionarColaMasCorta(disponible);
            }
        }
        else{  /*No hay servidores disponibles debido al desgaste. Elegimos el que mejor condicion tenga */
            return noHayDisponible(servidores);
        }
    }


    private Servidor seleccionarColaMasCorta(List<Servidor> servidores) {

        Servidor eleccion = servidores.get(0);

        int longitudServidor = servidores.get(0).getCola().size();
        int i;

        for (i = 0; i < servidores.size(); i++) {
            if (longitudServidor >= servidores.get(i).getCola().size()) {
                eleccion = servidores.get(i);
                longitudServidor = servidores.get(i).getCola().size();
            }
        }

        //Sino, se termina retornando el primer servidor
        return eleccion;
    }


    private Servidor desocupado(List<Servidor> servidores){
        
        ArrayList<Servidor> candidatos = new ArrayList<>();  /*Puedo tener mas de un servidor libre*/

        for(Servidor servidor : servidores){
            if(!servidor.ocupado()){
                candidatos.add(servidor);
            }
        }

        if(candidatos.size() == 0){    /*No tengo servidores libres */
            return null;
        }
        else{
            /*Tengo servidores libres, elijo el servidor con mayor durabilidad */
            Servidor eleccion = candidatos.get(0);
            double durabilidad = candidatos.get(0).getDurabilidad();
            int i;

            for(i = 0; i < candidatos.size(); i++){
                if(durabilidad < candidatos.get(i).getDurabilidad()){
                    eleccion = candidatos.get(i);
                    durabilidad = candidatos.get(i).getDurabilidad();
                }
            }
            return eleccion;
        }
    }


    private List<Servidor> disponible(List<Servidor> servidores){
        
        List<Servidor> servidoresDisponibles = new ArrayList<>();

        for(Servidor servidor : servidores){
            if(servidor.isDisponible() == true){
                servidoresDisponibles.add(servidor);
            }
        }

        if(servidoresDisponibles.size() > 0){
            return servidoresDisponibles;
        }
        else{
            return null;
        }
    }


    private Servidor noHayDisponible(List<Servidor> servidores){

        Servidor eleccion = servidores.get(0);
        double durabilidad = servidores.get(0).getDurabilidad();
        int i;
        for(i = 0; i < servidores.size(); i++){
            if(durabilidad < servidores.get(i).getDurabilidad()){
                eleccion = servidores.get(i);
                durabilidad = servidores.get(i).getDurabilidad();
            }
        }
        return eleccion;
    }
}
