package universidad.modelos;

import universidad.utilidades.LinkList;

public class Estudiante extends Persona {

  private LinkList<Curso> cursosInscritos;

  public Estudiante(String id, String nombre, String correo) {
    super(id, nombre, correo);
    this.cursosInscritos = new LinkList<>();
  }
  //Incribir el estudiante a un curso = inscribirCurso(Curso curso)

  public void inscribirCurso(Curso curso) {
    cursosInscritos = LinkList.insertNode(cursosInscritos,curso);
  }

  public boolean buscarCurso(Curso curso) {
    return cursosInscritos.exists(curso);
  }
}