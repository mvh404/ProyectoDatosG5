package universidad.repositorios;

import java.util.function.Predicate;

import universidad.excepciones.CajasExcepciones.ColaVaciaExcepcion;
import universidad.modelos.Persona;
import universidad.utilidades.LinkList;
import universidad.utilidades.Node;

public class CajasRepositorio {
  // Lista enlazada genérica que acepta objetos de tipo Curso.
  private LinkList<Persona> cola;

  public CajasRepositorio() {
    this.cola = new LinkList<>();
  }

  public void agregarAcola(Persona persona) {
    LinkList.insertNode(cola, persona);
  }

  public String atendercola() throws ColaVaciaExcepcion {
    if (!cola.isEmpty()) {

      Node<Persona> persona = this.cola.getFirstNode();
      this.cola.deleteFirstNode();
      return persona.data.getnombre();
    } else {
      throw new ColaVaciaExcepcion("No puede quitar elemento de una cola vacia");
    }
  }

    /**
   * Método para verificar si existe la persona en la cola.
   */
  public boolean existePorId(int id) {
    //byId es la condición
    Predicate<Persona> byId = persona -> persona.getid() == id;
    return cola.exists(byId);
  }
    /**
   * Método para obtener a la persona para atender
   */
  public Persona personaParaAtender() throws ColaVaciaExcepcion {
    if (!cola.isEmpty()) {
      return this.cola.getFirstNode().data;
    } else {
    throw new ColaVaciaExcepcion("No hay nadie en la cola");
  }
  }
}
