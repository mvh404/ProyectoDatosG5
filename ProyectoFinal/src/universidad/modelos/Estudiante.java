package universidad.modelos;

import java.util.function.Predicate;
import universidad.utilidades.LinkList;

public class Estudiante extends Persona {

  private LinkList<Curso> cursosInscritos;

  public Estudiante(String id, String nombre, String correo) {
    super(id, nombre, correo);
    this.cursosInscritos = new LinkList<>();
  }

  //Incribir el estudiante a un curso
  public void inscribirCurso(Curso curso) {
    cursosInscritos = LinkList.insertNode(cursosInscritos, curso);
  }

  public boolean estaInscrito(String id) {
    //byId es la condición
    Predicate<Curso> byId = curso -> curso.getId() == id;
    return cursosInscritos.exists(byId);
  }
}
