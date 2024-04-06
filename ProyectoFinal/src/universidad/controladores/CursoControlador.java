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

  public void imprimirTodosLosCursos() {
    repositorio
      .obtenerTodosLosCursos()
      .forEach(curso -> System.out.println(curso.getNombre()));
  }
}
