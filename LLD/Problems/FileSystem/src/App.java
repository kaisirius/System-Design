import LLD.Problems.FileSystem.enums.FileType;

public class App {
    public static void main(String[] args) throws Exception {
        FileManager fileManager = new FileManager();

        boolean isValid = fileManager.checkValidPath("./a/b");
        if(!isValid) {
            System.out.println("Invalid path");
        }

        FileSystemNode file1 = new File("rootFile", "./", 32, "05-06-2026", "05-06-2026", FileType.TXT);
        fileManager.addFileSystemNode("./", file1);

        FileSystemNode directory1 = new Directory("a", "./");
        fileManager.addFileSystemNode("./", directory1);

        FileSystemNode file2 = new File("innerFile", "./a", 32, "05-06-2026", "05-06-2026", FileType.TXT);
        fileManager.addFileSystemNode("./a", file2);

        FileSystemNode directory2 = new Directory("b", "./a");
        fileManager.addFileSystemNode("./a", directory2);

        FileSystemNode file3 = new File("innerFileC", "./a/b", 32, "05-06-2026", "05-06-2026", FileType.TXT);
        fileManager.addFileSystemNode("./a/b", file3);


        isValid = fileManager.checkValidPath("./a/b/innerFileC");
        if(isValid) {
            System.out.println("So far yes it's a valid path");
        }

        fileManager.deleteFileSystemNode("./a", "b");

        isValid = fileManager.checkValidPath("./a/b/c");
        if(!isValid) {
            System.out.println("Invalid path");
        }

        fileManager.openFile("./a", "innerFile");

    }
}
