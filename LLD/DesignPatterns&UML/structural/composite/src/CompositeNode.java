import java.util.ArrayList;
import java.util.List;

public class CompositeNode implements INode {
  public List<INode> children;

  public CompositeNode() {
    children = new ArrayList<>();
  }

  public void addChildren(INode node) {
    children.add(node);
  }

  public void removeChildren(INode node) {
    children.remove(node);
  }

  @Override 
  public void someOperation() {
    for(INode node: children) {
      node.someOperation();
    }
  }
}
