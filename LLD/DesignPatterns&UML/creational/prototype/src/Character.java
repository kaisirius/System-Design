public class Character implements Cloneable {
  public String name;
  public int level;
  public int attackPower;

  public Character(String name, int level, int attackPower) {
    this.name = name;
    this.level = level;
    this.attackPower = attackPower;
  }

  public Character clone() throws CloneNotSupportedException {
    return (Character)super.clone();
  }
}
