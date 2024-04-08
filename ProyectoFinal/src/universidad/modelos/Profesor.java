package universidad.modelos;

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
  //Asignar curso a un profesor = asignarCurso(Curso curso)
}
