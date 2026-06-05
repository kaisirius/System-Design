public abstract class FileSystemNode {
  protected String name;
  protected String path;
  protected boolean isFile;

  protected FileSystemNode(String name, String path, boolean isFile) {
    this.name = name;
    this.path = path;
    this.isFile = isFile;
  }

  public abstract void addNode(FileSystemNode node);
  public abstract void removeNode(String name);
  public abstract FileSystemNode getChildNode(String name);
  

  public String getName() {
    return name;
  }

  public String getPath() {
    return path;
  }

  public boolean isFile() {
    return isFile;
  }

  public void setName(String newName) {
    name = newName;
  }

  public void setPath(String newPath) {
    path = newPath;
  }
}
