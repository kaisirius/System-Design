public abstract class ICoffee {
  protected String name;
  protected int basePrice;

  public ICoffee(String name) {
    this.name = name;
    basePrice = 80;
  }

  public abstract String getName();
  public abstract int getPrice();

  public void printDescription() {
    System.out.println("Coffee: " + getName() + ", Total Price: " + getPrice());
  }
}
