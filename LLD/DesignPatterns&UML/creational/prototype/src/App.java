public class App {
    public static void main(String[] args) throws Exception {
        CharacterFactory factory = new CharacterFactory();
        Character ch1 = factory.withNewName("ch1");
        Character ch2 = factory.withNewName("ch2");

        if(ch1.equals(ch2)) System.out.println("same");
        else System.out.println("different");
    }
}
