package universidad.controladores;

import universidad.excepciones.CursoExcepciones.CursoYaExisteExcepcion;
import universidad.modelos.Curso;
import universidad.repositorios.CursoRepositorio;
import universidad.utilidades.Utilities;

public class CursoControlador {

  private CursoRepositorio repositorio;

  public CursoControlador() {
    this.repositorio = new CursoRepositorio();
  }

  /**
   * Agrega un nuevo curso al sistema.
   * Verifica primero si ya existe el curso con el mismo id para evitar duplicados.
   * Si el curso ya existe, se lanza una excepción CursoYaExisteExcepcion.
   * Si no, el curso se agrega exitosamente y se imprime un mensaje de confirmación.
   */
  public void agregarCurso(
    String nombre,
    String descripcion,
    String numeroGrupo
  ) {
    try {
      // Generar un ID único para el curso
      String id = Utilities.generarIdUnico();

      if (repositorio.existeCursoPorId(id)) {
        throw new CursoYaExisteExcepcion(
          "Ya existe un curso con el id proporcionado."
        );
      }
      Curso curso = new Curso(id, nombre, descripcion, numeroGrupo);
      repositorio.agregarCurso(curso);

      System.out.println("\nCurso agregado exitosamente.");
    } catch (CursoYaExisteExcepcion e) {
      System.out.println("\nError al agregar curso: " + e.getMessage());
    }
  }

  /**
   * Imprime todos los cursos en el sistema
   */
  public void imprimirTodosLosCursos() {
    repositorio
      .obtenerTodosLosCursos()
      .forEach(curso -> System.out.println(curso.getNombre()));
  }
}
