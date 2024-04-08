package universidad.controladores;

import universidad.excepciones.EstudianteExcepciones.EstudianteYaExisteExcepcion;
import universidad.modelos.Curso;
import universidad.modelos.Estudiante;
import universidad.repositorios.CursoRepositorio;
import universidad.repositorios.EstudianteRepositorio;
import universidad.utilidades.Utilities;

public class EstudianteControlador {

  private EstudianteRepositorio estudianteRepositorio;
  private CursoRepositorio cursoRepositorio;

  public EstudianteControlador(
    EstudianteRepositorio estudianteRepositorio,
    CursoRepositorio cursoRepositorio
  ) {
    this.estudianteRepositorio = estudianteRepositorio;
    this.cursoRepositorio = cursoRepositorio;
  }

  /**
   * Agrega un nuevo estudiante al sistema.
   * Verifica primero si ya existe un estudiante con el mismo correo para evitar duplicados.
   * Si el estudiante ya existe, se lanza una excepción EstudianteYaExisteExcepcion.
   * Si no, el estudiante se agrega exitosamente y se imprime un mensaje de confirmación.
   */
  public void agregarEstudiante(String nombre, String correo) {
    try {
      // Generar un ID único para el estudiante
      String id = Utilities.generarIdUnico();

      if (estudianteRepositorio.existeEstudiantePorCorreo(correo)) {
        throw new EstudianteYaExisteExcepcion(
          "Ya existe un estudiante con el correo proporcionado."
        );
      }
      Estudiante estudiante = new Estudiante(id, nombre, correo);
      estudianteRepositorio.agregarEstudiante(estudiante);

      System.out.println("\nEstudiante agregado exitosamente.");
    } catch (EstudianteYaExisteExcepcion e) {
      System.out.println("\nError al agregar estudiante: " + e.getMessage());
    }
  }

  /**
   * Busca un estudiante por su nombre y lo imprime utilizando el método imprimirEstudiante.
   * Si no se encuentra el estudiante, se imprime un mensaje indicando que no se encontró.
   */
  public void buscarEstudiantePorNombre(String nombre) {
    Estudiante estudianteEncontrado = estudianteRepositorio.obtenerEstudiantePorNombre(
      nombre
    );

    if (estudianteEncontrado != null) {
      imprimirEstudiante(estudianteEncontrado);
    } else {
      System.out.println("No se encontró ningún estudiante con ese nombre.");
    }
  }

  /**
   * Busca un estudiante por su ID y lo imprime utilizando el método imprimirEstudiante.
   * Si no se encuentra el estudiante, se imprime un mensaje indicando que no se encontró.
   */
  public void buscarEstudiantePorId(String id) {
    Estudiante estudianteEncontrado = estudianteRepositorio.obtenerEstudiantePorId(
      id
    );

    if (estudianteEncontrado != null) {
      imprimirEstudiante(estudianteEncontrado);
    } else {
      System.out.println(
        "No se encontró ningún estudiante con ese numero de identificacion."
      );
    }
  }

  /**
   * Asigna un curso a un estudiante por nombre.
   * Se realiza la búsqueda del estudiante y del curso por sus nombres respectivos.
   * Si se encuentra tanto el estudiante como el curso, y el estudiante no está ya inscrito,
   * se procede a inscribir al estudiante en el curso y se imprime un mensaje de éxito.
   * En caso contrario, se imprime un mensaje adecuado según el caso de error encontrado.
   */
  public void asignarCurso(String nombreCurso, String nombreEstudiante) {
    Estudiante estudiante = estudianteRepositorio.obtenerEstudiantePorNombre(
      nombreEstudiante
    );

    if (estudiante == null) {
      System.out.println("\nNo se encontró ningún estudiante con ese nombre.");
      return;
    }

    Curso curso = cursoRepositorio.obtenerCursoPorNombre(nombreCurso);

    if (curso == null) {
      System.out.println("\nNo se encontró ningún curso con ese nombre.");
      return;
    }
    if (estudiante.estaInscrito(curso.getId())) {
      System.out.println("\nEl estudiante ya esta asignado a ese curso.");
      return;
    }

    estudiante.inscribirCurso(curso);
    System.out.println("\nEl estudiante se inscribió exitosamente");
  }

  /**
   * Imprime los detalles de un estudiante.
   * Muestra el ID, nombre y correo del estudiante pasado como parámetro.
   */
  public void imprimirEstudiante(Estudiante estudiante) {
    System.out.println("\nEstudiante encontrado:\n");
    System.out.println("ID: " + estudiante.getId());
    System.out.println("Nombre: " + estudiante.getNombre());
    System.out.println("Correo: " + estudiante.getCorreo());
  }

  /**
   * Imprime todos los estudiantes en el sistema
   */
  public void imprimirTodosLosEstudiantes() {
    estudianteRepositorio
      .obtenerTodosLosEstudiantes()
      .forEach(estudiante -> System.out.println(estudiante.getNombre()));
  }
}
