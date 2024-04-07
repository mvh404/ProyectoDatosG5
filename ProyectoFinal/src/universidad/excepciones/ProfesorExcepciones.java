package universidad.excepciones;

public class ProfesorExcepciones {

  /**
   * Constructor privado para evitar la instanciación de la clase.
   * Al ser una clase de utilidad, no se espera que ProfesorExcepciones sea instanciada.
   */
  private ProfesorExcepciones() {
    throw new IllegalStateException("Clase de utilidad");
  }

  // Excepción para cuando un profesor ya existe.
  public static class ProfesorYaExisteExcepcion extends Exception {

    public ProfesorYaExisteExcepcion(String mensaje) {
      super(mensaje);
    }
  }
}
