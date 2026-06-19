package LLD.Problems.LinkedInSystem.models;

import java.beans.Expression;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Experience {
  private String company;
  private String designation;
  private LocalDate startDate;
  private LocalDate endDate;

  public Experience(String company, String designation, LocalDate start, LocalDate end) {
    this.company = company;
    this.designation = designation;
    startDate = start;
    endDate = end;
  }

  public String getCompany() {
    return company;
  }

  public String getDesignation() {
    return designation;
  }

  public LocalDate getStartDate() {
    return startDate;
  }
  
  public LocalDate getEndDate() {
    return endDate;
  }
  // SETTERS so on

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
    if(!(o instanceof Experience)) return false;
    Experience exp = (Experience)o;
    return (exp.company == this.company && exp.endDate == this.endDate && exp.startDate == this.startDate && exp.designation == this.designation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, endDate, startDate, designation);
  }
}
