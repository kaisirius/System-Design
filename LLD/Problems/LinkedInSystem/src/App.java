import java.util.List;

import LLD.Problems.LinkedInSystem.models.Account;
import LLD.Problems.LinkedInSystem.models.LinkedInSystem;
import LLD.Problems.LinkedInSystem.models.Post;

public class App {
    public static void main(String[] args) throws Exception {
        LinkedInSystem system = new LinkedInSystem();

        String id1 = system.createAccount("gurt", "bhondu1@gmail.com");
        String id2 = system.createAccount("garvit", "bhondu2@gmail.com");

        String postId = system.createPost(id1, "Learning LLD");
        system.likePost(postId, id2);

        Account gurtAccount_test = system.getAccount(id1);
        List<Post> posts_test = gurtAccount_test.getAllPosts();
        System.out.println("Post content: " + posts_test.get(0).getContent());

        String connectionId = system.sendConnection(id1, id2);
        system.acceptConnection(connectionId);

        Account gurtAccount = system.getAccount(id1);
        gurtAccount.removePost(system.getPost(postId));
        List<Post> posts = gurtAccount.getAllPosts();
        System.out.println(posts);
    }
}
