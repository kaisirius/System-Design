public class App {
    public static void main(String[] args) throws Exception {
        LRUCache<Integer, String> cache = new LRUCache<>(4);
        // edge case
        cache.get(1);

        cache.put(1, "hi-1");
        cache.printCache();
        System.out.println("-------------");

        cache.put(2, "hi-2");
        cache.printCache();
        System.out.println("-------------");

        cache.put(3, "hi-3");
        cache.printCache();
        System.out.println("-------------");

        cache.put(4, "hi-4");
        cache.printCache();
        System.out.println("-------------");

        System.out.println(cache.get(1)); // so that 2 gets removed

        cache.put(5, "hi-5");
        cache.printCache();
        System.out.println("-------------");
    }
}
