package universidad.excepciones;

public class EstudianteExcepciones {

  /**
   * Constructor privado para evitar la instanciación de la clase.
   * Al ser una clase de utilidad, no se espera que EstudianteExcepciones sea instanciada.
   */
  private EstudianteExcepciones() {
    throw new IllegalStateException("Clase de utilidad");
  }

  // Excepción para cuando un estudiante ya existe.
  public static class EstudianteYaExisteExcepcion extends Exception {

    public EstudianteYaExisteExcepcion(String mensaje) {
      super(mensaje);
    }
  }

  public static class EstudianteNoExisteException extends Exception{
    public EstudianteNoExisteException(String mensaje){
      super(mensaje);
    }
  }
}
