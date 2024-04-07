package universidad.controladores;

import universidad.excepciones.EstudianteExcepciones.EstudianteYaExisteExcepcion;
import universidad.modelos.Estudiante;
import universidad.modelos.Profesor;
import universidad.repositorios.EstudianteRepositorio;
import universidad.utilidades.Utilities;

public class EstudianteControlador {

  private EstudianteRepositorio repositorio;

  public EstudianteControlador() {
    this.repositorio = new EstudianteRepositorio();
  }

  public void agregarEstudiante(String nombre, String correo) {
    try {
      // Generar un ID único para el estudiante
      String id = Utilities.generarIdUnico();

      if (repositorio.existeEstudiantePorCorreo(correo)) {
        throw new EstudianteYaExisteExcepcion(
          "Ya existe un estudiante con el correo proporcionado."
        );
      }
      Estudiante estudiante = new Estudiante(id, nombre, correo);
      repositorio.agregarEstudiante(estudiante);

      System.out.println("\nEstudiante agregado exitosamente.");
    } catch (EstudianteYaExisteExcepcion e) {
      System.out.println("\nError al agregar estudiante: " + e.getMessage());
    }
  }

  public void imprimirTodosLosEstudiantes() {
    repositorio
      .obtenerTodosLosEstudiantes()
      .forEach(estudiante -> System.out.println(estudiante.getNombre()));
  }

  public void buscarEstudiantePorNombre(String nombre) {
    Estudiante estudianteEncontrado = repositorio.obtenerEstudiantePorNombre(
      nombre
    );

    if (estudianteEncontrado != null) {
      imprimirEstudiante(estudianteEncontrado);
    } else {
      System.out.println("\nNo se encontró ningún estudiante con ese nombre.");
    }
  }

  public void buscarEstudiantePorId(String id) {
    Estudiante estudianteEncontrado = repositorio.obtenerEstudiantePorId(id);

    if (estudianteEncontrado != null) {
      imprimirEstudiante(estudianteEncontrado);
    } else {
      System.out.println("\nNo se encontró ningún estudiante con ese id.");
    }
  }

  public void imprimirEstudiante(Estudiante estudiante) {
    System.out.println("\nEstudiante encontrado:\n");
    System.out.println("ID: " + estudiante.getId());
    System.out.println("Nombre: " + estudiante.getNombre());
    System.out.println("Correo: " + estudiante.getCorreo());
  }
}
