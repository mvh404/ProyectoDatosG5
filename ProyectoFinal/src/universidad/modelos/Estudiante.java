package universidad.modelos;

import universidad.utilidades.LinkList;

public class Estudiante extends Persona {

  private LinkList<Curso> cursosInscritos;

  public Estudiante(String id, String nombre, String correo) {
    super(id, nombre, correo);
    this.cursosInscritos = new LinkList<>();
  }
  //Incribir el estudiante a un curso = inscribirCurso(Curso curso)

  // public void agregarCurso(Curso curso) {
  //   LinkList.insertNode(cursosInscritos,curso);
  // }
}