
public abstract class Persona {
  protected String nombre;
  protected String DNI;
  protected int edad;
  protected String genero;

  public Persona(String nombre, String DNI, int edad, String genero) {
    this.nombre = nombre;
    this.DNI = DNI;
    this.edad = edad;
    this.genero = genero;
  }

  public String getNombre() {
    return this.nombre;
  }

  public abstract void mostrarDatos();
}
