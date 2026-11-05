import java.util.ArrayList;
import java.util.List;

public class NormalIterator extends PlaylistIterator {

  public NormalIterator(List<String> songs) {
    super(songs);
  }

  @Override 
  public boolean hasNext() {
    return (currentSong < playlist.size());
  }

  @Override 
  public String next() {
    return playlist.get(currentSong++);
  }

  @Override 
  public void remove() {
    playlist.remove(currentSong--);
  }
}
