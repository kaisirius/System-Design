import java.util.InputMismatchException;

public class UserProfile {
  private String username = null;
  private String email = null;
  public String bio = ""; // keeping this public for demo(App.java) purpose
  private boolean publicProfileVisibility = false;
  private String phoneNo = "";

  private UserProfile(String username, String email) throws InputMismatchException {
    if(username == null || email == null) {
      throw new InputMismatchException();
    } 
    this.username = username;
    this.email = email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public void setPublicProfileVisibility(boolean visbility) {
    this.publicProfileVisibility = visbility;
  }

  // builder
  public static class UserProfileBuilder {
    private String _username = null;
    private String _email = null;
    private String _bio = "";
    private boolean _publicProfileVisibility = false;
    private String _phoneNo = "";

    public UserProfileBuilder withUsername(String _username) {
      this._username = _username;
      return this;
    }

    public UserProfileBuilder withEmail(String _email) {
      this._email = _email;
      return this;
    }

    public UserProfileBuilder withPhoneNo(String _phoneNo) {
      this._phoneNo = _phoneNo;
      return this;
    }

    public UserProfileBuilder withBio(String _bio) {
      this._bio = _bio;
      return this;
    }

    public UserProfileBuilder withPublicProfile() {
      this._publicProfileVisibility = true;
      return this;
    }

    public UserProfile build() {
      try {
        UserProfile profile = new UserProfile(_username, _email);
        profile.bio = _bio;
        profile.phoneNo = _phoneNo;
        profile.publicProfileVisibility = _publicProfileVisibility;

        return profile;
      } catch(InputMismatchException err) {
        System.out.println("User profile builer failed to build profile");
        return null;
      } 
      
    }
  }
}
