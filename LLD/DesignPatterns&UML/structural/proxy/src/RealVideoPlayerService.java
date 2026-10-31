public class RealVideoPlayerService implements IVideoPlayerService {
  @Override 
  public void playVideo(String userType, String videoName) {
    System.out.println("Playing video: " + videoName + " for user type: " + userType);
  } 
}
