package universidad;

import java.io.IOException;
import universidad.utilidades.Menu;

public class AplicacionUniversidad {

  public static void main(String[] args) throws IOException {
    System.out.println("\nBienvenido al Sistema de Gestión de la Universidad");

    try {
      Menu.mostrarMenuPrincipal();
    } catch (IOException e) {
      System.out.println(
        "Error: Hubo un problema al mostrar el menú principal. Por favor, inténtelo de nuevo más tarde."
      );
    }
  }
}
