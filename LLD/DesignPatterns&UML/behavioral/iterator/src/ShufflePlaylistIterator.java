import java.util.List;

public class ShufflePlaylistIterator extends PlaylistIterator {

  public ShufflePlaylistIterator(List<String> songs) {
    super(songs);
    shuffle();
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

  public void shuffle() {
    //shuffling logic of playlist
  }
}
