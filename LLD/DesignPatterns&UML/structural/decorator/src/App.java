public class App {
    public static void main(String[] args) throws Exception {
        ICoffee coffee = new Mocha();
        coffee.printDescription();

        coffee = new CaramelDecorator(coffee);
        coffee.printDescription();

        coffee = new WhipCreamDecorator(coffee);
        coffee.printDescription();
    }
}
