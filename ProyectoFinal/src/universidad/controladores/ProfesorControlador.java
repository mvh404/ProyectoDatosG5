package universidad.controladores;

import universidad.excepciones.ProfesorExcepciones.ProfesorYaExisteExcepcion;
import universidad.modelos.Curso;
import universidad.modelos.Profesor;
import universidad.repositorios.CursoRepositorio;
import universidad.repositorios.ProfesorRepositorio;
import universidad.utilidades.Utilities;

public class ProfesorControlador {

  private ProfesorRepositorio profesorRepositorio;
  private CursoRepositorio cursoRepositorio;

  public ProfesorControlador(
    ProfesorRepositorio profesorRepositorio,
    CursoRepositorio cursoRepositorio
  ) {
    this.profesorRepositorio = profesorRepositorio;
    this.cursoRepositorio = cursoRepositorio;
  }

  /**
   * Agrega un nuevo profesor al sistema.
   * Verifica primero si ya existe un profesor con el mismo carnet para evitar duplicados.
   * Si el profesor ya existe, se lanza una excepción ProfesorYaExisteExcepcion.
   * Si no, el profesor se agrega exitosamente y se imprime un mensaje de confirmación.
   */
  public void agregarProfesor(String nombre, String correo, String carnet) {
    try {
      // Generar un ID único para el profesor
      String id = Utilities.generarIdUnico();

      if (profesorRepositorio.existeProfesorPorCarnet(correo)) {
        throw new ProfesorYaExisteExcepcion(
          "Ya existe un profesor con el correo proporcionado."
        );
      }
      Profesor profesor = new Profesor(id, nombre, correo, carnet);
      profesorRepositorio.agregarProfesor(profesor);

      System.out.println("\nProfesor agregado exitosamente.");
    } catch (ProfesorYaExisteExcepcion e) {
      System.out.println("\nError al agregar profesor: " + e.getMessage());
    }
  }

  /**
   * Busca un profesor por su nombre y lo imprime utilizando el método imprimirProfesor.
   * Si no se encuentra el profesor, se imprime un mensaje indicando que no se encontró.
   */
  public void buscarProfesorPorNombre(String nombre) {
    Profesor profesorEncontrado = profesorRepositorio.obtenerProfesorPorNombre(
      nombre
    );
    if (profesorEncontrado != null) {
      imprimirProfesor(profesorEncontrado);
    } else {
      System.out.println("No se encontró ningún profesor con ese nombre.");
    }
  }

  /**
   * Asigna un curso a un profesor por nombre.
   * Se realiza la búsqueda del profesor y del curso por sus nombres respectivos.
   * Si se encuentra tanto el profesor como el curso, y el profesor no está ya inscrito,
   * se procede a inscribir al profesor en el curso y se imprime un mensaje de éxito.
   * En caso contrario, se imprime un mensaje adecuado según el caso de error encontrado.
   */
  public void asignarCurso(String nombreCurso, String nombreProfesor) {
    Profesor profesor = profesorRepositorio.obtenerProfesorPorNombre(
      nombreProfesor
    );

    if (profesor == null) {
      System.out.println("\nNo se encontró ningún profesor con ese nombre.");
      return;
    }

    Curso curso = cursoRepositorio.obtenerCursoPorNombre(nombreCurso);

    if (curso == null) {
      System.out.println("\nNo se encontró ningún curso con ese nombre.");
      return;
    }
    if (profesor.estaAsignado(curso.getId())) {
      System.out.println("\nEl profesor ya esta asignado a ese curso.");
      return;
    }

    profesor.asignarCurso(curso);
    System.out.println("\nEl profesor fue asignado exitosamente");
  }

  /**
   * Imprime los detalles de un profesor.
   * Muestra el ID, nombre y correo del profesor pasado como parámetro.
   */
  public void imprimirProfesor(Profesor profesor) {
    System.out.println("\nProfesor encontrado:\n");
    System.out.println("ID: " + profesor.getId());
    System.out.println("Nombre: " + profesor.getNombre());
    System.out.println("Correo: " + profesor.getCorreo());
    System.out.println("Carnet: " + profesor.getCarnet());
  }

  /**
   * Imprime todos los profesores en el sistema
   */
  public void imprimirTodosLosProfesores() {
    profesorRepositorio
      .obtenerTodosLosProfesores()
      .forEach(profesor -> System.out.println(profesor.getNombre()));
  }
}
