package universidad.controladores;

import universidad.excepciones.CursoExcepciones.CursoYaExisteExcepcion;
import universidad.modelos.Curso;
import universidad.repositorios.CursoRepositorio;

public class CursoControlador {

  private CursoRepositorio repositorio;

  public CursoControlador() {
    this.repositorio = new CursoRepositorio();
  }

  public void agregarCurso(
    String id,
    String nombre,
    String descripcion,
    String numeroGrupo
  ) {
    try {
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
}
