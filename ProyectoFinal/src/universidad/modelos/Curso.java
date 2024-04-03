package universidad.modelos;

public class Curso {

  private String id;
  private String nombre;
  private String descripcion;
  private String numeroGrupo;

  public Curso(
    String id,
    String nombre,
    String descripcion,
    String numeroGrupo
  ) {
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.numeroGrupo = numeroGrupo;
  }

  // Getters
  public String getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public String getNumeroGrupo() {
    return numeroGrupo;
  }

  //Setters
  public void setId(String id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public void setNumeroGrupo(String numeroGrupo) {
    this.numeroGrupo = numeroGrupo;
  }
}
