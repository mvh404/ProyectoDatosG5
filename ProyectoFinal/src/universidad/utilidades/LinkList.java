package universidad.utilidades;

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
}
