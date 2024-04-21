package labsim.politicas;

import java.util.List;

import labsim.entidades.Entidad;
import labsim.recursos.Servidor;

@FunctionalInterface
public interface EleccionServidor {

    Servidor seleccionServidor(List<Servidor> servidores, Entidad entidad);
}