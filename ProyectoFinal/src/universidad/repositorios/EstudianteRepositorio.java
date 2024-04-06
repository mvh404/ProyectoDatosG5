package universidad.repositorios;

import java.util.function.Predicate;
import universidad.modelos.Estudiante;
import universidad.utilidades.LinkList;

/**
 * Clase que representa el repositorio de estudiantes.
 * Este repositorio utiliza una lista enlazada para simular la persistencia de datos de estudiantes.
 */
public class EstudianteRepositorio {

  //Lista enlazada genérica que acepta objetos de tipo Estudiante.
  private LinkList<Estudiante> estudiantes;

  /**
   * Constructor del repositorio de estudiantes.
   * Inicializa la lista enlazada para almacenar los objetos Estudiante.
   */
  public EstudianteRepositorio() {
    this.estudiantes = new LinkList<>();
  }

  /**
   * Método para agregar un estudiante a la lista enlazada.
   */
  public void agregarEstudiante(Estudiante estudiante) {
    LinkList.insertNode(estudiantes, estudiante);
  }

  /**
   * Método para verificar si existe un estudiante con el correo dado.
   */
  public boolean existeEstudiantePorCorreo(String correo) {
    //byCorreo es la condición
    Predicate<Estudiante> byCorreo = estudiante ->
      estudiante.getCorreo().equals(correo);
    return estudiantes.exists(byCorreo);
  }

  /**
   * Método para devolver todos los estudiantes
   */
  public LinkList<Estudiante> obtenerTodosLosEstudiantes() {
    return estudiantes;
  }
}
