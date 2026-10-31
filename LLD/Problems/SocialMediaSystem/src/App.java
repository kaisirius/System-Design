import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                System.out.println("Running: " + Thread.currentThread().getName());
            });
        }
        pool.shutdown();
    }
}
