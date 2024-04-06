package universidad.utilidades;

public class Node<T> {

  T data;
  Node<T> next;

  //Constructor para crear un nuevo nodo
  //Next inicializado como nulo
  Node(T data) {
    this.data = data;
    next = null;
  }
}
