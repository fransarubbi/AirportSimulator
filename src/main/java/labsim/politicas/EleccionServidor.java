package labsim.politicas;

import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;

/**
 * Interface con distintas politicas.
 */
public interface EleccionServidor {

    Servidor seleccionServidorAvanzado(List<Servidor> servidores, Entidad entidad, double clock);
    Servidor seleccionServidorEstandar(List<Servidor> servidores, Entidad entidad);
}