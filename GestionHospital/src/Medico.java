import java.util.ArrayList;

public class Medico extends Persona {
  protected String especialidad;
  protected int numeroRegistro;
  protected ArrayList<Paciente> listaPacientes;

  public Medico(String nombre, String DNI, int edad, String genero, String especialidad, int numeroRegistro) {
    super(nombre, DNI, edad, genero);
    this.especialidad = especialidad;
    this.numeroRegistro = numeroRegistro;
    this.listaPacientes = new ArrayList();
  }

  public void agregarPaciente(Paciente p) {
    this.listaPacientes.add(p);
  }

  public void mostrarDatos() {
    System.out.println("[Medico] " + this.nombre + " Especialidad: " + this.especialidad);
  }

  public void revisarPacientes() {
    System.out.println("\nDr. " + this.nombre + " revisando pacientes:");

    for (Paciente p : this.listaPacientes) {
      System.out.println("- " + p.getNombre());
    }

  }

  public String asignarPrioridad(String sintoma) {
    switch (sintoma.toLowerCase()) {
      case "infarto" -> {
        return "ALTA";
      }
      case "fiebre" -> {
        return "MEDIA";
      }
      case "dolor" -> {
        return "BAJA";
      }
      default -> {
        return "GENERAL";
      }
    }
  }
}
