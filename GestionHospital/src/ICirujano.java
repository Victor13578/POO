/*
 * interfaz que define el comportamiento de un cirujano en un hospital
 */
public interface ICirujano {
  // metodo que valida si el quirofano esta disponible para realizar la operacion
  boolean validarQuirofano();

  // metodo que realiza la operacion en el quirofano
  void realizarOperacion();
}
