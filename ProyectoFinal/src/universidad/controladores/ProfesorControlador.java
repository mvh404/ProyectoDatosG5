package universidad.controladores;

import universidad.excepciones.ProfesorExcepciones.ProfesorYaExisteExcepcion;
import universidad.modelos.Profesor;
import universidad.repositorios.ProfesorRepositorio;
import universidad.utilidades.Utilities;

public class ProfesorControlador {

  private ProfesorRepositorio repositorio;

  public ProfesorControlador() {
    this.repositorio = new ProfesorRepositorio();
  }

  public void agregarProfesor(String nombre, String correo, String carnet) {
    try {
      // Generar un ID único para el estudiante
      String id = Utilities.generarIdUnico();

      if (repositorio.existeProfesorPorCarnet(correo)) {
        throw new ProfesorYaExisteExcepcion(
          "Ya existe un estudiante con el correo proporcionado."
        );
      }
      Profesor estudiante = new Profesor(id, nombre, correo, carnet);
      repositorio.agregarProfesor(estudiante);

      System.out.println("\nProfesor agregado exitosamente.");
    } catch (ProfesorYaExisteExcepcion e) {
      System.out.println("\nError al agregar estudiante: " + e.getMessage());
    }
  }

  public void imprimirTodosLosProfesores() {
    repositorio
      .obtenerTodosLosProfesores()
      .forEach(profesor -> System.out.println(profesor.getNombre()));
  }
}
