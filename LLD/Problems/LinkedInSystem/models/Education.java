package LLD.Problems.LinkedInSystem.models;

import java.util.Objects;

public class Education {
  private String institution;
  private String certification;
  private double grade;
  private int startYr;
  private int endYr;

  public Education(String inst, String cert, double cg, int start, int end) {
    institution = inst;
    certification = cert;
    grade = cg;
    startYr = start;
    endYr = end;
  }

  public String getInstitution() {
    return institution;
  }

  public String getCertification() {
    return certification;
  }

  public double getGrade() {
    return grade;
  }

  public int getStartYr() {
    return startYr;
  }

  public int getEndYr() {
    return endYr;
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Education)) return false;
    Education edu = (Education)o;
    return (edu.certification == this.certification && edu.endYr == this.endYr && edu.startYr == this.startYr && edu.institution == this.institution && edu.grade == this.grade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(certification, startYr, endYr, institution, grade);
  }
}
