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
     * Obtiene el sintoma del paciente.
     * @return sintoma
     */
    public String getSintoma() {
        return sintoma;
    }

    /**
     * Muestra datos del paciente.
     */
    @Override
    public void mostrarDatos() {
        System.out.println("[Paciente] " + nombre +
                " EPS: " + eps +
                " Sintoma: " + sintoma);
    }

    /**
     * Verifica si el paciente puede pagar consulta.
     * @param costo valor de la consulta
     */
    public void pagarConsulta(double costo) {

        System.out.print("El paciente " + nombre +
                " intenta pagar $" + costo +
                ". Saldo actual $" + saldoDisponible + " Resultado: ");

        if (saldoDisponible >= costo) {
            saldoDisponible -= costo;
            System.out.println("Éxito");
        } else {
            System.out.println("Rechazado");
        }
    }
}
