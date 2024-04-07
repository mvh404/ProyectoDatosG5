package universidad.controladores;

import universidad.excepciones.CajasExcepciones.ColaVaciaExcepcion;
import universidad.excepciones.CajasExcepciones.PersonaEnColaExcepcion;
import universidad.modelos.Persona;
import universidad.repositorios.CajasRepositorio;

public class CajasControlador {

    private CajasRepositorio repositorio;

  public CajasControlador() {
    this.repositorio = new CajasRepositorio();
  }
  public void atenderCola() {
    try {
      String personaAtendida =  repositorio.atendercola();

      System.out.println("\nPersona atendida: " + personaAtendida);
    } catch (ColaVaciaExcepcion e) {
      System.out.println("\nError al atender: " + e.getMessage());
    }
  }
  public String personaParaAtender()  {
    try{
      Persona persona =  repositorio.personaParaAtender();
      return persona.getnombre();
    }
    catch(ColaVaciaExcepcion e) {
      System.out.println("\nError al atender: " + e.getMessage());
    }
    return null;
      
  }

    public void agregarPersona(
    int id,
    String nombre
  ) {
    try {
      if (repositorio.existePorId(id)) {
        throw new PersonaEnColaExcepcion(
          "Ya esta la persona en la cola"
        );
      }

      Persona persona = new Persona(id, nombre);
      repositorio.agregarAcola(persona);

      System.out.println("\nPersona en cola para ser atendida");
    } catch (PersonaEnColaExcepcion e) {
      System.out.println("\nError al agregar a la persona en la cola: " + e.getMessage());
    }
  }
}
