public class DoublyLinkedList<K,V> {
  private Node<K,V> head;
  private Node<K,V> tail;

  public DoublyLinkedList() {
    head = null;
    tail = null;
  }

  public void setHead(Node<K,V> head) {
    this.head = head;
  }

  public void setTail(Node<K,V> tail) {
    this.tail = tail;
  }

  public Node<K,V> getHead() {
    return head;
  }

  public Node<K,V> getTail() {
    return tail;
  }

  public void addFirst(Node<K,V> node) { // invoked for put 
    node.setPrev(null);
    node.setNext(head);
    if(head != null) { 
      head.setPrev(node);
    }
    else {
      tail = node;
    }
    head = node;
  }

  public void moveToFront(Node<K,V> node) { // invoked during get
    if(node.getKey() == head.getKey()) return;
    if(node.getKey() == tail.getKey()) {
      node.getPrev().setNext(null);
      tail = node.getPrev();
      addFirst(node);
    } else {
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        addFirst(node);
    }
  }

  public Node<K,V> removeLast() { // invoked when more than capacity
    Node<K, V> last = tail;
    if(tail.getPrev() != null) {
      tail.getPrev().setNext(null);
      tail = tail.getPrev();
    } else {
      head = null;
      tail = null; 
    }
    return last;
  }
}
