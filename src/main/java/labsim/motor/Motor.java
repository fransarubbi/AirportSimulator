package labsim.motor;

/**
 * Clase Abstracta. Motor de la Simulacion.
 */
public abstract class Motor {

    private boolean fin = false;

    /**
     * Funcion que retorna verdadero o false en case de estar en el final de la simulacion.
     * @return true or false
     */
    public boolean getFin(){
        return this.fin;
    }

    /**
     * Funcion que modifica la variable fin de False a Verdadera.
     */
    public void setFin() {
        this.fin = true;
    }

    /**
     * Funcion Abstracta.
     */
    public abstract void correr();

}