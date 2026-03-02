package domain;

/**
 * Clase abstracta que representa una persona del hospital.
 * Es la clase padre para Medico y Paciente.
 * 
 * @author Victor
 * @version 1.0
 */
public abstract class Persona {

    protected String nombre;
    protected String DNI;
    protected int edad;
    protected String genero;

    /**
     * Constructor de la clase Persona.
     * @param nombre nombre de la persona
     * @param DNI documento de identidad
     * @param edad edad de la persona
     * @param genero genero de la persona
     */
    public Persona(String nombre, String DNI, int edad, String genero) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * Obtiene el nombre de la persona.
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el documento de identidad.
     * @return documento
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Obtiene la edad.
     * @return edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el genero.
     * @return genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Devuelve un resumen legible de la persona.
     * Método abstracto que debe implementarse en las clases hijas.
     *
     * @return texto de presentación
     */
    public abstract String resumenDatos();
}
