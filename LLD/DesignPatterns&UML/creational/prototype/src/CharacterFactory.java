public class CharacterFactory {
  private Character defaultCharac;

  public CharacterFactory() {
    defaultCharac = new Character("DEFAULT", 1, 5);
  }

  public Character withNewName(String name) throws CloneNotSupportedException {
    Character clonedCharacter = defaultCharac.clone();
    clonedCharacter.name = name;
    return clonedCharacter;
  } 
  // similarly you can have new level or new attackpower
}
