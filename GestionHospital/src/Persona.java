/**
 * Constructor de la clase Persona.
 * * @author Juan Sebastian y victor
 * 
 * @version 1.0
 */
public abstract class Persona {

  /**
   * Nombre completo de la persona.
   */
  protected String nombre;

  /**
   * Documento Nacional de Identidad de la persona.
   */
  protected String DNI;

  /**
   * Edad de la persona en años.
   */
  protected int edad;

  /**
   * Género de la persona.
   */
  protected String genero;

  /*
   * @param nombre Nombre completo de la persona.
   * 
   * @param DNI Documento Nacional de Identidad.
   * 
   * @param edad Edad de la persona.
   * 
   * @param genero Género de la persona.
   */
  Persona(String nombre, String DNI, int edad, String genero) {
    this.nombre = nombre;
    this.DNI = DNI;
    this.edad = edad;
    this.genero = genero;
  }

  /**
   * Obtiene el nombre de la persona.
   * 
   * @return El nombre de la persona.
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Método abstracto que debe ser implementado por las clases hijas
   * para mostrar la información de la persona.
   * 
   * Cada subclase define su propia forma de presentar los datos.
   */
  public abstract void mostrarDatos();
}
