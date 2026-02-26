
/*
 * @author: JuanSebastians
 * class Cirujano que hereda de Medico e implementa la interfaz ICirujano.
 * 
 */
public class Cirujano extends Medico implements ICirujano {
  private int numeroQuirofano;
  private boolean disponible;

  public Cirujano(String nombre, String DNI, int edad, String genero, String especialidad, int numeroRegistro,
      int numeroQuirofano, boolean disponible) {
    super(nombre, DNI, edad, genero, especialidad, numeroRegistro);
    this.numeroQuirofano = numeroQuirofano;
    this.disponible = disponible;
  }

  public boolean validarQuirofano() {
    return this.disponible;
  }

  public void realizarOperacion() {
    if (this.validarQuirofano()) {
      System.out.println("El cirujano " + this.nombre + " realizó operación en quirófano " + this.numeroQuirofano);
    } else {
      System.out.println("El cirujano " + this.nombre + " NO pudo operar. Quirófano ocupado.");
    }

  }
}
