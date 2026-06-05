import java.util.HashMap;
import java.util.Map;

public class Directory extends FileSystemNode {
  private Map<String, FileSystemNode> childNodes;

  public Directory(String name, String path) {
    super(name, path, false);
    childNodes = new HashMap<>();
  }

  public void addNode(FileSystemNode node) {
    childNodes.put(node.getName(), node);
  }

  public void removeNode(String name) {
    if(childNodes.containsKey(name)) childNodes.remove(name);
    else System.out.println("INTERNAL ERROR");
  }

  @Override
  public FileSystemNode getChildNode(String name) {
    if(childNodes.containsKey(name)) return childNodes.get(name);
    System.out.println("No such child node exist.");
    return null;
  }
}
