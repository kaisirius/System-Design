
public class App {
    public static void main(String[] args) throws Exception {
        UserProfile.UserProfileBuilder builder = new UserProfile.UserProfileBuilder();
        UserProfile profile = builder.withUsername("kaisirius").withEmail("xyZ@abc.in").withBio("hi lol").withPublicProfile().build();
        System.out.println(profile.bio);
        // only need to create builder once, can create another object after this
    }
}
