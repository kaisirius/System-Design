public class App {
    public static void main(String[] args) throws Exception {
        RealVideoPlayerService real = new RealVideoPlayerService();
        IVideoPlayerService proxy = new ProxyVideoPlayerService(real);

        proxy.playVideo("premium", "hi lol");
    }
}
