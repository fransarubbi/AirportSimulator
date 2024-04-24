package labsim.politicas;

import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;


public interface EleccionServidor {

    Servidor seleccionServidorAvanzado(List<Servidor> servidores, Entidad entidad);
    Servidor seleccionServidorEstandar(List<Servidor> servidores, Entidad entidad);
}