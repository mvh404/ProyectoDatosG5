package universidad.repositorios;

import java.util.function.Predicate;
import universidad.modelos.Profesor;
import universidad.utilidades.LinkList;

/**
 * Clase que representa el repositorio de profesores.
 * Este repositorio utiliza una lista enlazada para simular la persistencia de datos de profesores.
 */
public class ProfesorRepositorio {

  //Lista enlazada genérica que acepta objetos de tipo Profesor.
  private LinkList<Profesor> profesores;

  /**
   * Constructor del repositorio de profesores.
   * Inicializa la lista enlazada para almacenar los objetos Profesor.
   */
  public ProfesorRepositorio() {
    this.profesores = new LinkList<>();
  }

   /**
   * Constructor del repositorio de profesores.
   * Usada para buscar profesores por nombre.
   */
  public ProfesorRepositorio(LinkList<Profesor> profesores) {
    this.profesores = profesores;
  }


  /**
   * Método para agregar un profesor a la lista enlazada.
   */
  public void agregarProfesor(Profesor profesor) {
    LinkList.insertNode(profesores, profesor);
  }

  /**
   * Método para verificar si existe un profesor con el carnet dado.
   */
  public boolean existeProfesorPorCarnet(String carnet) {
    //byCarnet es la condición
    Predicate<Profesor> byCarnet = profesor ->
      profesor.getCarnet().equals(carnet);
    return profesores.exists(byCarnet);
  }

  /**
   * Método para devolver todos los profesores
   */
  public LinkList<Profesor> obtenerTodosLosProfesores() {
    return profesores;
  }

  /*
   * Metodo para devolver profesores por su nombre
   */
  public Profesor obtenerProfesorPorNombre(String nombre) {
        // Método forEach de LinkList para iterar sobre los elementos de la lista.
        // Se le pasa un Consumer que busca el profesor por nombre.
        Predicate<Profesor> byNombre = profesor -> profesor.getNombre().equals(nombre);
        Profesor[] profesorEncontrado = new Profesor[1]; // Array para almacenar el profesor encontrado
        profesores.forEach(profesor -> {
            if (byNombre.test(profesor)) {
                profesorEncontrado[0] = profesor;
            }
        });
        return profesorEncontrado[0]; // Devuelve el profesor encontrado
    }
}
