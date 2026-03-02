package domain;

/**
 * Interfaz que define comportamiento de un cirujano.
 */
public interface ICirujano {

    /**
     * Valida disponibilidad del quirofano.
     * @return true si esta disponible
     */
    boolean validarQuirofano();

    /**
     * Realiza la operación.
     *
     * @return true si la operación pudo realizarse
     */
    boolean realizarOperacion();
}
