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
      // Generar un ID único para el profesor
      String id = Utilities.generarIdUnico();

      if (repositorio.existeProfesorPorCarnet(correo)) {
        throw new ProfesorYaExisteExcepcion(
          "Ya existe un profesor con el correo proporcionado."
        );
      }
      Profesor profesor = new Profesor(id, nombre, correo, carnet);
      repositorio.agregarProfesor(profesor);

      System.out.println("\nProfesor agregado exitosamente.");
    } catch (ProfesorYaExisteExcepcion e) {
      System.out.println("\nError al agregar profesor: " + e.getMessage());
    }
  }

  public void imprimirTodosLosProfesores() {
    repositorio
      .obtenerTodosLosProfesores()
      .forEach(profesor -> System.out.println(profesor.getNombre()));
  }

  public void buscarProfesorPorNombre(String nombre) {
    Profesor profesorEncontrado = repositorio.obtenerProfesorPorNombre(nombre);

    if (profesorEncontrado != null) {
      imprimirProfesor(profesorEncontrado);
    } else {
      System.out.println("\nNo se encontró ningún profesor con ese nombre.");
    }
  }

  public void imprimirProfesor(Profesor profesor) {
    System.out.println("\nProfesor encontrado:\n");
    System.out.println("ID: " + profesor.getId());
    System.out.println("Nombre: " + profesor.getNombre());
    System.out.println("Correo: " + profesor.getCorreo());
    System.out.println("Carnet: " + profesor.getCarnet());
  }
}
