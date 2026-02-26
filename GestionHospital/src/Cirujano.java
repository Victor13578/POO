/**
 * Clase Cirujano que hereda de Medico e implementa ICirujano.
 */
public class Cirujano extends Medico implements ICirujano {

    private int numeroQuirofano;
    private boolean disponible;

    /**
     * Constructor del cirujano.
     */
    public Cirujano(String nombre, String DNI, int edad, String genero,
                    String especialidad, int numeroRegistro,
                    int numeroQuirofano, boolean disponible) {

        super(nombre, DNI, edad, genero, especialidad, numeroRegistro);
        this.numeroQuirofano = numeroQuirofano;
        this.disponible = disponible;
    }

    /**
     * Valida el estado del quirofano.
     * @return true si esta disponible
     */
    @Override
    public boolean validarQuirofano() {
        return disponible;
    }

    /**
     * Realiza operación según disponibilidad.
     */
    @Override
    public void realizarOperacion() {

        if (validarQuirofano()) {
            System.out.println("El cirujano " + nombre +
                    " realizó operación en quirófano " + numeroQuirofano);
        } else {
            System.out.println("El cirujano " + nombre +
                    " NO pudo operar. Quirófano ocupado.");
        }
    }
}
