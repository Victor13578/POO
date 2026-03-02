package domain;

/**
 * Clase que representa un paciente del hospital.
 */
public class Paciente extends Persona {

    private String numeroHistorial;
    private String eps;
    private double saldoDisponible;
    private String sintoma;

    /**
     * Constructor de Paciente.
     */
    public Paciente(String nombre, String DNI, int edad, String genero,
                    String numeroHistorial, String eps,
                    double saldoDisponible, String sintoma) {

        super(nombre, DNI, edad, genero);
        this.numeroHistorial = numeroHistorial;
        this.eps = eps;
        this.saldoDisponible = saldoDisponible;
        this.sintoma = sintoma;
    }

    /**
     * Obtiene la EPS del paciente.
     * @return eps
     */
    public String getEps() {
        return eps;
    }

    /**
     * Obtiene el numero de historial clinico.
     * @return historial
     */
    public String getNumeroHistorial() {
        return numeroHistorial;
    }

    /**
     * Obtiene el sintoma del paciente.
     * @return sintoma
     */
    public String getSintoma() {
        return sintoma;
    }

    @Override
    public String resumenDatos() {
        return "[Paciente] " + nombre + " EPS: " + eps + " Sintoma: " + sintoma;
    }

    /**
     * Obtiene el saldo disponible para pagos.
     *
     * @return saldo del paciente
     */
    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * Verifica si el paciente puede pagar consulta.
     *
     * @param costo valor de la consulta
     * @return true si el pago fue exitoso
     */
    public boolean pagarConsulta(double costo) {
        if (saldoDisponible >= costo) {
            saldoDisponible -= costo;
            return true;
        }
        return false;
    }
}
