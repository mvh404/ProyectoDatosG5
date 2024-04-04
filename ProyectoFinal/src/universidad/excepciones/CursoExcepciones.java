package universidad.excepciones;

public class CursoExcepciones {

  /**
   * Constructor privado para evitar la instanciación de la clase.
   * Al ser una clase de utilidad, no se espera que CursoExcepciones sea instanciada.
   */
  private CursoExcepciones() {
    throw new IllegalStateException("Clase de utilidad");
  }

  // Excepción para cuando un curso ya existe.
  public static class CursoYaExisteExcepcion extends Exception {

    public CursoYaExisteExcepcion(String mensaje) {
      super(mensaje);
    }
  }
}
