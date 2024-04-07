package universidad.modelos;

public class Persona {

  private String id;
  private String nombre;
  private String correo;

    public Persona(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
  }
  
  public Persona(String id, String nombre, String correo) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
  }

  // Getters
  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getCorreo() {
    return correo;
  }

  //Setters
  public void setId(String id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }
}
