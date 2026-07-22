import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {
  private int capacity;
  private Map<K, Node<K,V>> map;
  private DoublyLinkedList<K,V> dll;

  public LRUCache(int cap) {
    capacity = cap;
    map = new HashMap<>();
    dll = new DoublyLinkedList<K,V>();
  }

  public V get(K key) {
    if(map.containsKey(key)) {

      dll.moveToFront(map.get(key));
      return map.get(key).getValue();

    } else {
      System.out.println("Invalid key");
      return null;
    }
  }

  public void put(K key, V value) {
    if(map.containsKey(key)) {
      System.out.println("Key already exists");
      return;
    }
    if(map.size() == capacity) {
      Node<K,V> last = dll.removeLast();
      map.remove(last.getKey());
    } 
    Node<K,V> node = new Node<>(key, value);
    map.put(key, node);
    dll.addFirst(node);
  }

  public void printCache() {
    for(Map.Entry<K, Node<K,V>> ele: map.entrySet()) {
      System.out.println(ele.getKey() + " " + ele.getValue().getValue());
    }
  }
}
