package domain;

/**
 * Interfaz que define el comportamiento básico de un hospital.
 * Esta interfaz forma parte de la capa de dominio (domain),
 * donde se modelan las reglas de negocio del sistema.
 */
public interface IHospital {

    /**
     * Inicia el día de operaciones del hospital.
     *
     * Este método puede incluir tareas como:
     * <ul>
     *     <li>Preparar el personal médico</li>
     *     <li>Inicializar salas y equipos</li>
     *     <li>Registrar apertura del sistema</li>
     * </ul>
     *
     * La implementación específica dependerá de la clase
     * que implemente esta interfaz.
     */
    void iniciarDia();
}