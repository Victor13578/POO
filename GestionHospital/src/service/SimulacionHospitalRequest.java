package service;

/**
 * DTO de entrada para ejecutar una simulación del hospital.
 */
public class SimulacionHospitalRequest {

    private final String nombreMedico;
    private final String especialidad;
    private final String nombreCirujano;
    private final String nombrePaciente;
    private final String eps;
    private final double saldo;
    private final String sintoma;

    /**
     * Crea una solicitud con los datos necesarios para la simulación.
     *
     * @param nombreMedico nombre del médico
     * @param especialidad especialidad del médico
     * @param nombreCirujano nombre del cirujano
     * @param nombrePaciente nombre del paciente
     * @param eps EPS del paciente
     * @param saldo saldo disponible del paciente
     * @param sintoma síntoma principal del paciente
     */
    public SimulacionHospitalRequest(String nombreMedico, String especialidad, String nombreCirujano,
                                     String nombrePaciente, String eps, double saldo, String sintoma) {
        this.nombreMedico = nombreMedico;
        this.especialidad = especialidad;
        this.nombreCirujano = nombreCirujano;
        this.nombrePaciente = nombrePaciente;
        this.eps = eps;
        this.saldo = saldo;
        this.sintoma = sintoma;
    }

    /**
     * @return nombre del médico
     */
    public String getNombreMedico() {
        return nombreMedico;
    }

    /**
     * @return especialidad del médico
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @return nombre del cirujano
     */
    public String getNombreCirujano() {
        return nombreCirujano;
    }

    /**
     * @return nombre del paciente
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * @return EPS del paciente
     */
    public String getEps() {
        return eps;
    }

    /**
     * @return saldo disponible del paciente
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @return síntoma del paciente
     */
    public String getSintoma() {
        return sintoma;
    }
}
