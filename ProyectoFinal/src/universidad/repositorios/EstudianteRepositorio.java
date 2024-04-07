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

  public boolean existeEstudiantePorid(int id){
    Predicate<Estudiante> byId = estudiante ->
    estudiante.getId().equals(id);
  return estudiantes.exists(byId);
  }
  public boolean existeEstudiantePorNombre(String nombre){
    Predicate<Estudiante> byNombre = estudiante ->
    estudiante.getNombre().equals(nombre);
  return estudiantes.exists(byNombre);
  }

  /**
   * Método para devolver todos los estudiantes
   */
  public LinkList<Estudiante> obtenerTodosLosEstudiantes() {
    return estudiantes;
  }

  /*
   * Funcion para buscar estudiante por su nombre
   */

   public Estudiante obtenerEstudiantePorNombre(String nombre) {
    Predicate<Estudiante> byNombre = estudiante -> estudiante.getNombre().equals(nombre);
    Estudiante[] estudianteEncontrado = new Estudiante[1]; // Array de una sola posición para almacenar el estudiante encontrado

    estudiantes.forEach(estudiante -> {
        if (byNombre.test(estudiante)) {
            estudianteEncontrado[0] = estudiante; // Almacena el estudiante encontrado
        }
    });

    return estudianteEncontrado[0]; // Devuelve el estudiante encontrado (o null si no se encontró ninguno)
}
}
