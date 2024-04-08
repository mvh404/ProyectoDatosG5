package universidad.utilidades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import universidad.controladores.CajasControlador;
import universidad.controladores.CursoControlador;
import universidad.controladores.EstudianteControlador;
import universidad.controladores.ProfesorControlador;
import universidad.repositorios.CajasRepositorio;
import universidad.repositorios.CursoRepositorio;
import universidad.repositorios.EstudianteRepositorio;
import universidad.repositorios.ProfesorRepositorio;

public class Menu {

  //Intancias de repertorios
  private static final CursoRepositorio cursoRepositorio = new CursoRepositorio();
  private static final EstudianteRepositorio estudianteRepositorio = new EstudianteRepositorio();
  private static final ProfesorRepositorio profesorRepositorio = new ProfesorRepositorio();
  private static final CajasRepositorio cajasRepositorio = new CajasRepositorio();

  //Instancias de controladores
  private static final CursoControlador cursoControlador = new CursoControlador(
    cursoRepositorio
  );
  private static final CajasControlador cajaControlador = new CajasControlador(
    cajasRepositorio
  );
  private static final EstudianteControlador estudianteControlador = new EstudianteControlador(
    estudianteRepositorio,
    cursoRepositorio
  );
  private static final ProfesorControlador profesorControlador = new ProfesorControlador(
    profesorRepositorio,
    cursoRepositorio
  );

  // Buffer para leer la entrada del usuario desde la consola.
  private static final BufferedReader reader = new BufferedReader(
    new InputStreamReader(System.in)
  );

  // Un divisor para mejorar la visualización del menú en la consola.
  private static String divisor =
    "\n------------------------------------------\n";

  /**
   * Constructor privado para evitar la instanciación de la clase.
   * Al ser una clase de utilidad, no se espera que Menu sea instanciada.
   */
  private Menu() {
    throw new IllegalStateException("Clase de utilidad");
  }

  /**
   * Muestra el menú principal y maneja la navegación entre los distintos menús de la aplicación.
   * Este método actúa como el punto de entrada para las interacciones del usuario con el menú.
   */
  public static void mostrarMenuPrincipal() throws IOException {
    boolean salir = false;

    while (!salir) {
      imprimirMenuPrincipal();

      try {
        //Opción elegida por el usuario
        int opcion = Integer.parseInt(reader.readLine());

        switch (opcion) {
          case 1:
            mostrarMenuGestion();
            break;
          case 2:
            mostrarMenuSistemaDeCajas();
            break;
          case 3:
            System.out.println("Saliendo del sistema...");
            salir = true;
            break;
          default:
            System.out.println("\"Opción no válida. Intente nuevamente.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Por favor, introduce un número válido.");
      }
    }
  }

  /**
   * Imprime las opciones del menú principal.
   */
  private static void imprimirMenuPrincipal() {
    System.out.println(divisor);
    System.out.println("Menú Principal:\n");
    System.out.println("1. Gestión de cursos, estudiantes y profesores");
    System.out.println("2. Sistema de cajas");
    System.out.println("3. Salir");
    System.out.println(divisor);
    System.out.println("Selecciona una opción del menú:");
  }

  /**
   * Muestra el menú de gestión y maneja las acciones relacionadas con la gestión
   * de cursos, estudiantes y profesores.
   */
  private static void mostrarMenuGestion() throws IOException {
    boolean volver = false;

    while (!volver) {
      imprimirMenuGestion();

      try {
        int opcion = Integer.parseInt(reader.readLine());

        switch (opcion) {
          case 1:
            crearCurso(reader);
            break;
          case 2:
            crearEstudiante(reader);
            break;
          case 3:
            asignarCursoAEstudiante(reader);
            break;
          case 4:
            buscarEstudianteId(reader);
            break;
          case 5:
            buscarEstudianteNombre(reader);
            break;
          case 6:
            crearProfesor(reader);
            break;
          case 7:
            asignarCursoAProfesor(reader);
            break;
          case 8:
            buscarProfesorNombre(reader);
            break;
          case 9:
            System.out.println("Volviendo al menú principal...");
            volver = true;
            break;
          default:
            System.out.println("Opción no válida, intenta de nuevo.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Por favor, introduce un número válido.");
      }
    }
  }

  /**
   * Imprime las opciones del menú de gestión.
   */
  private static void imprimirMenuGestion() {
    System.out.println(divisor);
    System.out.println("Gestión de Cursos, Estudiantes y Profesores:\n");
    System.out.println("1. Crear curso");
    System.out.println("2. Crear estudiante");
    System.out.println("3. Asignar curso a estudiante");
    System.out.println("4. Buscar estudiante por id");
    System.out.println("5. Buscar estudiante por nombre");
    System.out.println("6. Crear profesor");
    System.out.println("7. Asignar curso a profesor");
    System.out.println("8. Buscar profesor por nombre");
    System.out.println("9. Volver");
    System.out.println(divisor);
    System.out.println("Escribe una de las opciones:");
  }

  /**
   * Muestra el menú del sistema de cajas y maneja las acciones relacionadas.
   */
  private static void mostrarMenuSistemaDeCajas() throws IOException {
    //Leer texto desde la consola
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in)
    );
    boolean volver = false;

    while (!volver) {
      imprimirMenuSistemaDeCajas();

      try {
        int opcion = Integer.parseInt(reader.readLine());

        switch (opcion) {
          case 1:
            agregarAcola(reader);
            break;
          case 2:
            MenuAtencion(reader);
            break;
          case 3:
            System.out.println("Volviendo al menú principal...");
            volver = true;
            break;
          default:
            System.out.println("Opción no válida, intenta de nuevo.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Por favor, introduce un número válido.");
      }
    }
  }

  /**
   * Imprime las opciones del menú del sistema de cajas.
   */
  private static void imprimirMenuSistemaDeCajas() {
    System.out.println(divisor);
    System.out.println("Sistema de cajas:\n");
    System.out.println("1. Ingresar persona a la cola");
    System.out.println("2. Atender a la siguiente persona");
    System.out.println("3. Volver");
    System.out.println(divisor);
    System.out.println("Escribe una de las opciones:");
  }

  /**
   * Imprime las opciones del menú del sistema de cajas.
   * @throws IOException
   */
  private static void MenuAtencion(BufferedReader reader) throws IOException {
    String persona = cajaControlador.personaParaAtender();
    if (persona != null) {
      System.out.println(divisor);
      System.out.println("La persona a anteder es: " + persona);
      System.out.println("Opciones de atención de persona:\n");
      System.out.println("1. Atender persona");
      System.out.println("2. Cancelar");
      System.out.println(divisor);
      System.out.println("Escribe una de las opciones:");

      boolean volver = false;

      while (!volver) {
        try {
          int opcion = Integer.parseInt(reader.readLine());

          switch (opcion) {
            case 1:
              cajaControlador.atenderCola();
              volver = true;
              break;
            case 2:
              System.out.println("Cancelando...");
              volver = true;
              break;
            default:
              System.out.println("Opción no válida, intenta de nuevo.");
          }
        } catch (NumberFormatException e) {
          System.out.println("Por favor, introduce un número válido.");
        }
      }
    }
  }

  /**
   * 1- Crear Curso
   */
  private static void crearCurso(BufferedReader reader) throws IOException {
    System.out.print("Ingrese el nombre del curso: ");
    String nombre = reader.readLine();

    System.out.print("Ingrese la descripción del curso: ");
    String descripcion = reader.readLine();

    System.out.print("Ingrese el número de grupo del curso: ");
    String numeroGrupo = reader.readLine();

    cursoControlador.agregarCurso(nombre, descripcion, numeroGrupo);

    System.out.print("\nCursos en el sistema: \n\n");
    cursoControlador.imprimirTodosLosCursos();
  }

  /**
   * 2- Crear Estudiante
   */
  private static void crearEstudiante(BufferedReader reader)
    throws IOException {
    System.out.print("Ingrese el nombre del estudiante: ");
    String nombre = reader.readLine();

    System.out.print("Ingrese el correo del estudiante: ");
    String correo = reader.readLine();

    estudianteControlador.agregarEstudiante(nombre, correo);

    System.out.print("\nEstudiantes en el sistema: \n\n");
    estudianteControlador.imprimirTodosLosEstudiantes();
  }

  /**
   * 3- Asignar curso a estudiante por nombre
   */
  private static void asignarCursoAEstudiante(BufferedReader reader)
    throws IOException {
    System.out.print("Ingrese el nombre del estudiante: ");
    String nombreEstudiante = reader.readLine();

    System.out.print("Ingrese el nombre del curso: ");
    String nombreCurso = reader.readLine();

    estudianteControlador.asignarCurso(nombreCurso, nombreEstudiante);
  }

  /*
   * 4- Buscar estudiante por su ID
   */
  private static void buscarEstudianteId(BufferedReader reader)
    throws IOException {
    System.out.println("Ingrese el id del estudiante a buscar: ");
    String id = reader.readLine();

    estudianteControlador.buscarEstudiantePorId(id);
  }

  /*
   * 5- Buscar estudiante por su nombre
   */
  private static void buscarEstudianteNombre(BufferedReader reader)
    throws IOException {
    System.out.println("Ingrese el nombre del estudiante a buscar: ");
    String nombre = reader.readLine();
    estudianteControlador.buscarEstudiantePorNombre(nombre);
  }

  /**
   * 6- Crear Profesor
   */
  private static void crearProfesor(BufferedReader reader) throws IOException {
    System.out.print("Ingrese el nombre del profesor: ");
    String nombre = reader.readLine();

    System.out.print("Ingrese el correo del profesor: ");
    String correo = reader.readLine();

    System.out.print("Ingrese el carnet del profesor: ");
    String carnet = reader.readLine();

    profesorControlador.agregarProfesor(nombre, correo, carnet);

    System.out.print("\nProfesores en el sistema: \n\n");
    profesorControlador.imprimirTodosLosProfesores();
  }

  /**
   * 7- Asignar curso a profesor
   */
  private static void asignarCursoAProfesor(BufferedReader reader)
    throws IOException {
    System.out.print("Ingrese el nombre del profesor: ");
    String nombreProfesor = reader.readLine();

    System.out.print("Ingrese el nombre del curso: ");
    String nombreCurso = reader.readLine();

    profesorControlador.asignarCurso(nombreCurso, nombreProfesor);
  }

  /*
   * 8- Buscar profesor por su nombre
   */
  private static void buscarProfesorNombre(BufferedReader reader)
    throws IOException {
    System.out.println("Ingrese el nombre del profesor a buscar: ");
    String nombre = reader.readLine();

    profesorControlador.buscarProfesorPorNombre(nombre);
  }

  /**
   * 9- Agregar persona a cola
   */
  private static void agregarAcola(BufferedReader reader) throws IOException {
    System.out.print("Ingrese el id de la persona: ");
    String id = reader.readLine();

    System.out.print("Ingrese el nombre de la persona: ");
    String nombre = reader.readLine();

    cajaControlador.agregarPersona(id, nombre);
  }
}
