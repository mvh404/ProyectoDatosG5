package universidad.modelos;

import java.util.function.Predicate;
import universidad.utilidades.LinkList;

public class Profesor extends Persona {

  private LinkList<Curso> cursosAsignados;
  private String carnet;

  public Profesor(String id, String nombre, String correo, String carnet) {
    super(id, nombre, correo);
    this.carnet = carnet;
    this.cursosAsignados = new LinkList<>();
  }

  //Getters
  public String getCarnet() {
    return carnet;
  }

  //Setters
  public void setCarnet(String carnet) {
    this.carnet = carnet;
  }

  //Asignar el profesor a un curso
  public void asignarCurso(Curso curso) {
    cursosAsignados = LinkList.insertNode(cursosAsignados, curso);
  }

  public boolean estaAsignado(String id) {
    //byId es la condición
    Predicate<Curso> byId = curso -> curso.getId() == id;
    return cursosAsignados.exists(byId);
  }
}
