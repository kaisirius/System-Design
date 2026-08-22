import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLD.Problems.LibraryManagementSystem.enums.ItemType;
import LLD.Problems.LibraryManagementSystem.factory.ItemFactory;
import LLD.Problems.LibraryManagementSystem.models.ItemCopy;
import LLD.Problems.LibraryManagementSystem.models.LibraryItem;
import LLD.Problems.LibraryManagementSystem.models.Member;
import LLD.Problems.LibraryManagementSystem.strategy.SearchStrategy;

public class LibraryManagementSystem {
  private static final LibraryManagementSystem INSTANCE = new LibraryManagementSystem();
  private final Map<String, LibraryItem> catalog = new HashMap<>();
  private final Map<String, Member> members = new HashMap<>();
  private final Map<String, ItemCopy> copies = new HashMap<>();

  private LibraryManagementSystem() {}
  public static LibraryManagementSystem getInstance() { return INSTANCE; }
  
  // --- Item Management ---
  public List<ItemCopy> addItem(ItemType type, String title, String author, int numCopies) {
    List<ItemCopy> bookCopies = new ArrayList<>();
    LibraryItem item = ItemFactory.createItem(type, title, author);
    catalog.put(item.getId(), item);
    for (int i = 0; i < numCopies; i++) {
        // String copyId = id + "-c" + (i + 1);
        ItemCopy copy = new ItemCopy(item);
        copies.put(copy.getId(), copy);
        bookCopies.add(copy);
        item.addCopy(copy);
    }
    System.out.println("Added " + numCopies + " copies of '" + title + "'");
    return bookCopies;
  }

  // --- User Management ---
  public Member addMember(String name) {
    Member member = new Member(name);
    members.put(member.getId(), member);
    return member;
  }

  // --- Core Actions ---
  public void checkout(String memberId, String copyId) {
    Member member = members.get(memberId);
    ItemCopy copy = copies.get(copyId);
    if (member != null && copy != null) {
        copy.checkout(member);
    } else {
        System.out.println("Error: Invalid member or copy ID.");
    }
  }

  public void returnItem(String copyId) {
    ItemCopy copy = copies.get(copyId);
    if (copy != null) {
        copy.returnItem();
    } else {
        System.out.println("Error: Invalid copy ID.");
    }
  }

  public void placeHold(String memberId, LibraryItem item) { // NOTE : **give me hold on any copy of that item** 
    Member member = members.get(memberId);
    if (member != null && item != null) {
        // Place hold on any copy that is checked out
        item.getCopies().stream()
                .filter(c -> !c.isAvailable())
                .findFirst()
                .ifPresent(copy -> copy.hold(member));
    }
  }

  // --- Search (Using Strategy Pattern) ---
  public List<LibraryItem> search(String query, SearchStrategy strategy) {
    return strategy.search(new ArrayList<>(catalog.values()), query);
  }

  public void printCatalog() {
    System.out.println("\n--- Library Catalog ---");
    catalog.values().forEach(item -> System.out.printf("ID: %s, Title: %s, Author/Publisher: %s, Available: %d\n",
            item.getId(), item.getTitle(), item.getAuthorOrPublisher(), item.getAvailableCopyCount()));
    System.out.println("-----------------------\n");
  }
}
