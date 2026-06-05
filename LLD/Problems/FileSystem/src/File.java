import LLD.Problems.FileSystem.enums.FileType;

public class File extends FileSystemNode {
  private int fileSize;
  private String dateModified;
  private String createdAt;
  private FileType type;

  public File(String name, String path, int size, String dateMod, String dateCreate, FileType type) {
    super(name, path, true);
    fileSize = size;
    dateModified = dateMod;
    createdAt = dateCreate;
    type = this.type;
  }

  // getters & setters 

  public void openFile() {
    System.out.println("Opening file : " + this.name);
  }

  @Override
  public void addNode(FileSystemNode node) {
    System.out.println("INVALID OPERATION ERROR: Can't add node inside a file node type.");
  }

  @Override
  public void removeNode(String name) {
    System.out.println("INVALID OPERATION ERROR: Can't remove node inside a file node type.");
  }

  @Override
  public FileSystemNode getChildNode(String name) {
    System.out.println("No such child node exist.");
    return null;
  }
}
