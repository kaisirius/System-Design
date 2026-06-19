package LLD.Problems.LinkedInSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Profile {
  private String summary;
  private List<Education> educations;
  private List<Experience> experiences;

  public Profile() {
    summary = "";
    educations = new ArrayList<>();
    experiences = new ArrayList<>();
  }

  public void addEducation(Education education) {
    educations.add(education);
  }

  public void removeEducation(Education education) {
    educations.remove(education);
  }

  public void addExperience(Experience experience) {
    experiences.add(experience);
  }

  public void removeExperience(Experience experience) {
    experiences.remove(experience);
  }
}
