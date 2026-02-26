import java.util.ArrayList;

/**
 * Clase que representa un médico del hospital.
 */
public class Medico extends Persona {

    protected String especialidad;
    protected int numeroRegistro;
    protected ArrayList<Paciente> listaPacientes;

    /**
     * Constructor del medico.
     */
    public Medico(String nombre, String DNI, int edad, String genero,
                  String especialidad, int numeroRegistro) {

        super(nombre, DNI, edad, genero);
        this.especialidad = especialidad;
        this.numeroRegistro = numeroRegistro;
        this.listaPacientes = new ArrayList<>();
    }

    /**
     * Agrega un paciente a la lista.
     * @param p paciente
     */
    public void agregarPaciente(Paciente p) {
        listaPacientes.add(p);
    }

    /**
     * Muestra datos del medico.
     */
    @Override
    public void mostrarDatos() {
        System.out.println("[Medico] " + nombre +
                " Especialidad: " + especialidad);
    }

    /**
     * Revisa pacientes asignados.
     */
    public void revisarPacientes() {
        System.out.println("\nDr. " + nombre + " revisando pacientes:");
        for (Paciente p : listaPacientes) {
            System.out.println("- " + p.getNombre());
        }
    }

    /**
     * Asigna prioridad segun sintoma.
     * @param sintoma sintoma del paciente
     * @return nivel de prioridad
     */
    public String asignarPrioridad(String sintoma) {

        switch (sintoma.toLowerCase()) {
            case "infarto":
                return "ALTA";
            case "fiebre":
                return "MEDIA";
            case "dolor":
                return "BAJA";
            default:
                return "GENERAL";
        }
    }
}
