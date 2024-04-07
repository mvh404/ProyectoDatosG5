package universidad.utilidades;

import java.util.UUID;

public class Utilities {

  /**
   * Constructor privado para evitar la instanciación de la clase.
   * Al ser una clase de utilidad, no se espera que Utilities sea instanciada.
   */
  private Utilities() {
    throw new IllegalStateException("Clase de utilidad");
  }

  /**
   * Genera y devuelve un ID único.
   *
   */
  public static String generarIdUnico() {
    return UUID.randomUUID().toString();
  }
}
