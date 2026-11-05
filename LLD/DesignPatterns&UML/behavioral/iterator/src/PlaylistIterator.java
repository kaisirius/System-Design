import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class PlaylistIterator implements Iterator<String> {
  protected List<String> playlist;
  protected int currentSong = 0;

  PlaylistIterator(List<String> songs) {
    playlist = songs;
  }
}
