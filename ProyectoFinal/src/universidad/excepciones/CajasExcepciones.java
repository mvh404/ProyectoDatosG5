package universidad.excepciones;

public class CajasExcepciones {
    
  /**
   * Constructor privado para evitar la instanciación de la clase.
   * Al ser una clase de utilidad, no se espera que CajasExcepciones sea instanciada.
   */
  private CajasExcepciones() {
    throw new IllegalStateException("Clase de utilidad");
  }

  // Excepción para cuando eliminen de una cola vacia.
  public static class ColaVaciaExcepcion extends Exception {

    public ColaVaciaExcepcion(String mensaje) {
      super(mensaje);
    }
  }

    // Excepción para se quiera agregar la misma persona en la cola.
    public static class PersonaEnColaExcepcion extends Exception {

        public PersonaEnColaExcepcion(String mensaje) {
          super(mensaje);
        }
      }
}
