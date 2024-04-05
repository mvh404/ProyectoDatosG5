package universidad.repositorios;

import java.util.function.Predicate;
import universidad.modelos.Curso;
import universidad.modelos.Estudiante;
import universidad.utilidades.LinkList;

/**
 * Clase que representa el repositorio de cursos.
 * Este repositorio utiliza una lista enlazada para simular la persistencia de datos de cursos.
 */
public class CursoRepositorio {

  //Lista enlazada genérica que acepta objetos de tipo Curso.
  private LinkList<Curso> cursos;

  /**
   * Constructor del repositorio de cursos.
   * Inicializa la lista enlazada para almacenar los objetos Curso.
   */
  public CursoRepositorio() {
    this.cursos = new LinkList<>();
  }

  /**
   * Método para agregar un curso a la lista enlazada.
   */
  public void agregarCurso(Curso curso) {
    LinkList.insertNode(cursos, curso);
  }

  /**
   * Método para verificar si existe un curso con el id dado.
   */
  public boolean existeCursoPorId(String id) {
    //byId es la condición
    Predicate<Curso> byId = curso -> curso.getId().equals(id);
    return cursos.exists(byId);
  }

  /**
   * Método para devolver todos los cursos
   */
  public LinkList<Curso> obtenerTodosLosCursos() {
    return cursos;
  }
}
