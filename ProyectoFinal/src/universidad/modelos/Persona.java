package universidad.modelos;

public class Persona {
  private int id;
  private String nombre;

  public Persona(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }

  // Getters
  public int getid(){
    return this.id;
  }

  public String getnombre(){
    return this.nombre;
  }

  // Setters
  public void setid(int id){
   this.id = id;
  }

  public void setnombre(String nombre){
    this.nombre = nombre;
  }
}
