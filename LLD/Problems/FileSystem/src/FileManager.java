public class FileManager {
  // too lazy to make it singleton, refer other ques where I have made such classes singleton 
  private FileSystemNode root;

  public FileManager() {
    root = new Directory("home", ".");
  }

  public void addFileSystemNode(String path, FileSystemNode node) {
    if(checkValidPath(path)) {
      FileSystemNode lastNode = getLastNode(path);
      lastNode.addNode(node);
    } else {
      System.out.println("INVALID PATH ERROR: No such file or directory exists.");
    }
  }

  public void deleteFileSystemNode(String path, String name) {
    if(checkValidPath(path)) {
      FileSystemNode lastNode = getLastNode(path);
      lastNode.removeNode(name);
    } else {
      System.out.println("INVALID PATH ERROR: No such file or directory exists.");
    }

  }

  public void openFile(String path, String name) {
    if(checkValidPath(path)) {
      FileSystemNode lastNode = getLastNode(path);
      Directory directoryNode = (Directory)lastNode;
      FileSystemNode fileNode = directoryNode.getChildNode(name);
      File file = (File)fileNode;

      file.openFile();
    } else {
      System.out.println("INVALID PATH ERROR: No such file or directory exists.");
    }

  }

  private FileSystemNode getLastNode(String path) {
    String[] nodeNameList = path.split("/");
    

    FileSystemNode curr = root;

    for(int i = 1; i < nodeNameList.length; i++) {
      curr = curr.getChildNode(nodeNameList[i]);
    }

    return curr;
  }

  public boolean checkValidPath(String path) {

    String[] nodeNameList = path.split("/");
  
    FileSystemNode curr = root;

    for(int i = 1; i < nodeNameList.length; i++) {
      // System.out.println(nodeNameList[i] + " + " + curr.getName());
      curr = curr.getChildNode(nodeNameList[i]);
      if(curr == null) {
        return false;
      }
    }

    return true;
  }
 
}
