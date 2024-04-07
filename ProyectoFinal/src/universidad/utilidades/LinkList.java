package universidad.utilidades;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LinkList<T> {

  Node<T> head;

  public static <T> LinkList<T> insertNode(LinkList<T> list, T data) {
    Node<T> newNode = new Node<>(data);

    if (list.head == null) {
      list.head = newNode;
    } else {
      Node<T> currentNode = list.head;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
      }

      currentNode.next = newNode;
    }

    return list;
  }

  public static <T> LinkList<T> deleteAllNodesWithKey(LinkList<T> list, T key) {
    Node<T> currentNode = list.head;
    Node<T> previous = currentNode;

    if (currentNode != null && currentNode.data == key) {
      list.head = currentNode.next;
      currentNode = currentNode.next;
    }

    while (currentNode != null) {
      if (currentNode.data == key) {
        previous.next = currentNode.next;
        currentNode = previous;
      } else {
        previous = currentNode;
        currentNode = currentNode.next;
      }
    }

    return list;
  }

  // Método para buscar un elemento basado en una condición.
  // Ventaja es que funciona para cualquier objeto y no necesitamos agregar getters acá.
  // Predicate define un único método abstracto llamado test, que toma un argumento de tipo T y retorna un booleano.
  public boolean exists(Predicate<T> condition) {
    Node<T> current = head;
    while (current != null) {
      if (condition.test(current.data)) {
        return true;
      }
      current = current.next;
    }
    return false;
  }
  

  /*copia de exists que recibe un objeto y devuelve
    true o false si ese objeto ya esta en la lista */
  public boolean exists(T data) {

    Node<T> current = head;

    while (current != null) {
      if (current.data == data) {
        return true;
      }
      current = current.next;
    }

    return false;
  }

  /**
   * Itera sobre todos los elementos de la lista enlazada y ejecuta una acción específica en cada uno de ellos.
   * Acepta un Consumer<T> como parámetro, que representa una operación que se aplicará a cada elemento
   *
   **/
  public void forEach(Consumer<T> action) {
    Node<T> current = head;
    while (current != null) {
      action.accept(current.data);
      current = current.next;
    }
  }
}
