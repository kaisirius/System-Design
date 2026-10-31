public class App {
    public static void main(String[] args) throws Exception {
        // this pattern is like a tree basically 
        INode nodeA1 =  new SimpleNodeA();
        INode nodeB = new SimpleNodeB();
        INode nodeA2 = new SimpleNodeA();

        CompositeNode root = new CompositeNode();
        root.addChildren(nodeA1);
        root.addChildren(nodeB);
        root.addChildren(nodeA2);
        root.someOperation();
    }
}
