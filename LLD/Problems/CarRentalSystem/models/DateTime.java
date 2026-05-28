package LLD.Problems.CarRentalSystem.models;

public class DateTime {
  private String date; // DD-MM-YYYY
  private String time; // HH:MM:SSS (military timings)

  public DateTime(String date, String time) {
    this.date = date;
    this.time = time;
  }

  public String getDate() {
    return date;
  }

  public String getTime() {
    return time;
  }
}
